FROM ubuntu:20.04


RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME

RUN apt-get install -y iputils-ping

RUN apt -y install maven

ADD textprocessor-service-0.2.0 /textprocessor-service-0.2.0

WORKDIR "/textprocessor-service-0.2.0"

RUN mvn clean install

CMD java -jar target/SimpleTextProcessor-0.2.0.jar server config.yml
