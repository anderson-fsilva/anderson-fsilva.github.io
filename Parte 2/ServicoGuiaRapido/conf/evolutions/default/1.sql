# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cliente (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  constraint pk_cliente primary key (id)
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
  id_cliente                    integer not null,
  orcamento                     double,
  localizacao_origem            varchar(255),
  localizacao_destino           varchar(255),
  opcao_urna                    varchar(255),
  opcao_coroa                   varchar(255),
  outros                        varchar(255),
  constraint pk_pedido primary key (id)
);


# --- !Downs

drop table if exists cliente;

drop table if exists pacote;

drop table if exists pedido;

