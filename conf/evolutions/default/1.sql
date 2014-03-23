# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bill (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_bill primary key (id))
;

create table member (
  id                        bigint not null,
  name                      varchar(255),
  money                     float,
  bill_id                   bigint,
  constraint pk_member primary key (id))
;

create table record (
  id                        bigint not null,
  bill_id                   bigint,
  payer                     varchar(255),
  cost                      integer,
  subject                   varchar(255),
  date                      date,
  constraint pk_record primary key (id))
;

create sequence bill_seq;

create sequence member_seq;

create sequence record_seq;

alter table member add constraint fk_member_bill_1 foreign key (bill_id) references bill (id) on delete restrict on update restrict;
create index ix_member_bill_1 on member (bill_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists bill;

drop table if exists member;

drop table if exists record;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists bill_seq;

drop sequence if exists member_seq;

drop sequence if exists record_seq;

