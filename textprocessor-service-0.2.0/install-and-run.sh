#!/bin/bash

apt-get update  
apt-get install --yes openjdk-8-jre-headless  

wget https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/SimpleTextProcessor-0.2.0.jar  
wget https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/config.yml  
wget https://github.com/F7502/textprocessor-service/releases/download/v0.2.0/textprocessor  

mv textprocessor /etc/init.d/  
chmod +x /etc/init.d/textprocessor  
update-rc.d textprocessor defaults  

/etc/init.d/textprocessor start