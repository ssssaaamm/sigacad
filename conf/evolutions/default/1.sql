# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table reprobados (
  id                            bigserial not null,
  carrera                       varchar(255),
  materia                       varchar(255),
  ano                           integer,
  ciclo                         integer,
  reprobados                    integer,
  constraint pk_reprobados primary key (id)
);

create table examenrepetidos (
  id                            bigserial not null,
  carrera                       varchar(255),
  materia                       varchar(255),
  ano                           integer,
  ciclo                         integer,
  evaluaciones                  integer,
  repetidos                     integer,
  constraint pk_examenrepetidos primary key (id)
);

create table retirados (
  id                            bigserial not null,
  carrera                       varchar(255),
  fecha                         timestamptz,
  retirados                     integer,
  constraint pk_retirados primary key (id)
);

create table egresados (
  id                            bigserial not null,
  carrera                       varchar(255),
  promocion                     integer,
  promedio                      integer,
  constraint pk_egresados primary key (id)
);

create table materiasrepetidas (
  id                            bigserial not null,
  carrera                       varchar(255),
  ano                           integer,
  ciclo                         integer,
  materia                       varchar(255),
  reinscritos                   integer,
  constraint pk_materiasrepetidas primary key (id)
);

create table materiasretiradas (
  id                            bigserial not null,
  materia                       varchar(255),
  retiros                       integer,
  constraint pk_materiasretiradas primary key (id)
);

create table bajorendimiento (
  id                            bigserial not null,
  carrera                       varchar(255),
  ano                           integer,
  alumno                        varchar(255),
  carne                         varchar(255),
  media_ciclo                   float,
  cum                           float,
  constraint pk_bajorendimiento primary key (id)
);

create table aprobadosreprobados (
  id                            bigserial not null,
  carrera                       varchar(255),
  ano                           integer,
  ciclo                         integer,
  docente                       varchar(255),
  materia                       varchar(255),
  aprobados                     integer,
  reprobados                    integer,
  constraint pk_aprobadosreprobados primary key (id)
);

create table pera (
  id                            bigserial not null,
  carrera                       varchar(255),
  alumno                        varchar(255),
  carne                         varchar(255),
  cum                           float,
  constraint pk_pera primary key (id)
);

create table aptitud (
  id                            bigserial not null,
  ano                           integer,
  carrera_origen                varchar(255),
  carrera_solicitada            varchar(255),
  alumno                        varchar(255),
  carne                         varchar(255),
  constraint pk_aptitud primary key (id)
);

create table electiva (
  id                            bigserial not null,
  ano                           integer,
  carrera                       varchar(255),
  ciclo                         integer,
  materia                       varchar(255),
  poblacion                     integer,
  constraint pk_electiva primary key (id)
);

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

drop table if exists reprobados cascade;

drop table if exists examenrepetidos cascade;

drop table if exists retirados cascade;

drop table if exists egresados cascade;

drop table if exists materiasrepetidas cascade;

drop table if exists materiasretiradas cascade;

drop table if exists bajorendimiento cascade;

drop table if exists aprobadosreprobados cascade;

drop table if exists pera cascade;

drop table if exists aptitud cascade;

drop table if exists electiva cascade;

drop table if exists tipo_usuario cascade;

drop table if exists usuario cascade;

