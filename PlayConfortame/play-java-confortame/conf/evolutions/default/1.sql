# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table funeraria (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  cnpj                          varchar(255),
  telefone                      varchar(255),
  endereco                      varchar(255),
  cep                           varchar(255),
  estado                        varchar(255),
  cidade                        varchar(255),
  email                         varchar(255),
  cremacao                      boolean,
  sepultamento                  boolean,
  coroa_de_flores               boolean,
  constraint pk_funeraria primary key (id)
);

create table pacote (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  urnas                         integer not null,
  coroa_flores                  integer not null,
  transmissao_web               boolean,
  buffet                        boolean,
  outros                        varchar(255),
  translado_nacional            boolean,
  translado_internacional       boolean,
  valor_pacote                  double,
  descricao                     varchar(255),
  constraint pk_pacote primary key (id)
);

create table pedido (
  id                            bigint auto_increment not null,
  orcamento                     double,
  localizacao_origem            varchar(255),
  localizacao_destino           varchar(255),
  opcao_urna                    varchar(255),
  opcao_coroa                   varchar(255),
  outros                        varchar(255),
  constraint pk_pedido primary key (id)
);


# --- !Downs

drop table if exists funeraria;

drop table if exists pacote;

drop table if exists pedido;

