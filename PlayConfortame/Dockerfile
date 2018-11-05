FROM ubuntu
RUN apt-get update
RUN apt-get install -y software-properties-common
RUN add-apt-repository ppa:linuxuprising/java
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN mkdir Arquivos
ENV PROJECT_HOME Arquivos
COPY ./play-java-confortame $PROJECT_HOME
RUN chmod 777 -R $PROJECT_HOME
WORKDIR $PROJECT_HOME
RUN chmod +x sbt