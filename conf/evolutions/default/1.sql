# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tipo_usuario (
  id                            bigserial not null,
  codigo                        integer,
  nombre                        varchar(255),
  descripcion                   varchar(255),
  constraint pk_tipo_usuario primary key (id)
);

create table usuario (
  id                            bigserial not null,
  nombre                        varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  tipo_id                       bigint,
  constraint pk_usuario primary key (id)
);

alter table usuario add constraint fk_usuario_tipo_id foreign key (tipo_id) references tipo_usuario (id) on delete restrict on update restrict;
create index ix_usuario_tipo_id on usuario (tipo_id);


# --- !Downs

alter table if exists usuario drop constraint if exists fk_usuario_tipo_id;
drop index if exists ix_usuario_tipo_id;

drop table if exists tipo_usuario cascade;

drop table if exists usuario cascade;

