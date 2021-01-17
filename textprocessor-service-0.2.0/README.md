# SimpleTextProcessor

A simple REST service that takes a string and returns the processed string. Currently, the service only appends some text to the string and returns something like `'[processed by <serviceID>] - <original string>'`.

How to start the SimpleTextProcessor application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/SimpleTextProcessor-0.2.0.jar server config.yml`
3. To check that your application is running, POST a string to `http://localhost/api`

Processing Latency
---

The service can be configured to include a latency when processing text. The default latency is 0 (no latency). Setting the latency is done like that:

`curl -X POST http://localhost:8081/tasks/latency?latencyMs=500`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

For simply checking if the service is running, you can use the url `http://localhost:8081/ping`

Install and run on Ubuntu
---

Tested with Ubuntu Server 16.04 LTS on AWS EC2. During the installation, the service will be configured to automatically start during system boot.

```
wget -qO- https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/install-and-run.sh | sudo bash
```

or

```
sudo apt-get update  
sudo apt-get install --yes openjdk-8-jre-headless  
wget https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/SimpleTextProcessor-0.2.0.jar  
wget https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/config.yml  
wget https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/textprocessor  
sudo mv textprocessor /etc/init.d/  
sudo chmod +x /etc/init.d/textprocessor  
sudo update-rc.d textprocessor defaults  
sudo /etc/init.d/textprocessor start  
```