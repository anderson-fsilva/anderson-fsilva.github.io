FROM ubuntu
RUN apt-get update
RUN apt-get install -y software-properties-common
RUN add-apt-repository ppa:linuxuprising/java
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
ENV PROJECT_HOME Arquivos
ENV SERVICE1 ServicoCadastro
RUN mkdir $PROJECT_HOME
RUN cd $PROJECT_HOME
RUN mkdir $SERVICE1
RUN cd ..
COPY ./$SERVICE1 $PROJECT_HOME/$SERVICE1
RUN chmod 777 -R $PROJECT_HOME
WORKDIR $PROJECT_HOME