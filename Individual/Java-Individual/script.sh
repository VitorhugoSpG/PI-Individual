#!/bin/bash

PURPLE='0;35'
NC='\033[0m' 
VERSAO=11

N=`id -un`

echo  "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7) Olá $N, serei seu assistente para preparação do ambiente!;"

sleep 2

sudo apt update && sudo apt upgrade -y
clear

echo  "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Verificando se você possui o Java instalado...;"

sleep 2

java -version

if [ $? = 0 ]
	then
		echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Você já tem o java instalado!!!;"
	else
		echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Não foi identificado nenhuma versão do Java instalado!;"
		echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Gostaria de instalar agora mesmo (S/N)?;"
		
		read get
		
	if [ \"$get\" == \"s\" ];
	
		then
		sudo apt install openjdk-17-jre -y
		clear
	fi
fi

cd ~/Desktop

mkdir Clear

cd ./Clear

wget -c https://raw.githubusercontent.com/NathanBin/java-autotech/main/clean/clean.sh

cd ~/Desktop

mkdir Logs

cd ./Logs

mkdir RegistrosAntigos

cd ~/Desktop

#Docker

docker --version

clear

if [ $? = 0 ]
	then
		echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Você já tem o Docker instalado!!!;"
	else
		echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Não foi identificado nenhuma versão do Docker instalado!;"
		echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7)  Gostaria de instalar agora mesmo (S/N)?;"
		
		read get
		
	if [ \"$get\" == \"s\" ];
	
		then
		sudo apt install docker.io
		clear
	fi
fi

echo  "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7) Preparando ambiente Docker...;"

sleep 2

sudo systemctl start docker

sudo systemctl enable docker

sudo docker pull mysql:5.7

sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

sudo apt install docker-compose

cd ~/Downloads

ls | grep "docker-compose.yml"

if [ $? = 0 ]
	then
		rm -f "docker-compose.yml"
		wget -c https://raw.githubusercontent.com/NathanBin/java-autotech/main/docker-compose.yml
	else
		wget -c https://raw.githubusercontent.com/NathanBin/java-autotech/main/docker-compose.yml

fi

mkdir dump

cd ./dump

wget -c https://raw.githubusercontent.com/NathanBin/java-autotech/main/dump/databaseAutotech.sql

cd ~/Downloads

sudo docker-compose up -d

clear

echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7) Preparando aplicação JAR...;"

sleep 2

ls | grep "index-1.0-SNAPSHOT-jar-with-dependencies.jar"

if [ $? = 0 ]
	then
		rm -f "index-1.0-SNAPSHOT-jar-with-dependencies.jar"
		wget -c github.com/NathanBin/java-autotech/raw/main/index/target/index-1.0-SNAPSHOT-jar-with-dependencies.jar
	else
		wget -c github.com/NathanBin/java-autotech/raw/main/index/target/index-1.0-SNAPSHOT-jar-with-dependencies.jar

fi

echo "alias start='cd ~/Downloads; sudo docker start AutotechDB; java -jar index-1.0-SNAPSHOT-jar-with-dependencies.jar'">>$HOME/.bash_aliases

cd $HOME; source .bash_aliases

clear

echo "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7) Preparando ambiente Bleachbit...;"

sleep 2

bleachbit -v

if [ $? = 0 ]
	then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Você já tem o Bleachbit instalado!!!;"
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Não foi identificado nenhuma versão do Bleachbit instalado!;"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Gostaria de instalar agora mesmo (S/N)?;"
		
		read res
	
	if [ \"$res\" == \"s\" ];
	
		then
		sudo apt install bleachbit -y
		clear
	fi
fi

echo  "$(tput setaf 10)[Bot AutoTech]:$(tput setaf 7) Ambiente configurado, para iniciar a aplicação basta digitar 'start';"

sleep 3
