# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  customer_id                   bigint auto_increment not null,
  customer_name                 varchar(255),
  email_id                      varchar(255),
  mobile_number                 varchar(255),
  constraint pk_customer primary key (customer_id)
);

create table item_order (
  order_id                      bigint auto_increment not null,
  order_status                  varchar(255),
  customer_id                   bigint,
  order_created_date            timestamp,
  order_modified_date           timestamp,
  order_amount                  varchar(255),
  payment_mode                  varchar(255),
  payment_status                varchar(255),
  constraint pk_item_order primary key (order_id)
);

create table order_product_map (
  order_product_map_id          bigint auto_increment not null,
  order_id                      bigint,
  product_id                    bigint,
  product_quantity              bigint,
  total_amount                  varchar(255),
  constraint pk_order_product_map primary key (order_product_map_id)
);

create table product (
  product_id                    bigint auto_increment not null,
  product_name                  varchar(255),
  product_description           varchar(255),
  product_category              varchar(255),
  tax_percentage                varchar(255),
  product_quantity              bigint,
  product_price                 varchar(255),
  status                        varchar(255),
  created_date                  timestamp,
  constraint pk_product primary key (product_id)
);

create table retailer (
  retailer_id                   bigint auto_increment not null,
  retailer_name                 varchar(255),
  retailer_email_id             varchar(255),
  retailer_mobile_number        varchar(255),
  constraint pk_retailer primary key (retailer_id)
);

create table retailer_product_map (
  retailer_product_map_id       bigint auto_increment not null,
  retailer_id                   bigint,
  product_id                    bigint,
  retailer_base_price           varchar(255),
  discount                      varchar(255),
  quantity                      bigint,
  constraint pk_retailer_product_map primary key (retailer_product_map_id)
);

create index ix_item_order_customer_id on item_order (customer_id);
alter table item_order add constraint fk_item_order_customer_id foreign key (customer_id) references customer (customer_id) on delete restrict on update restrict;

create index ix_order_product_map_order_id on order_product_map (order_id);
alter table order_product_map add constraint fk_order_product_map_order_id foreign key (order_id) references item_order (order_id) on delete restrict on update restrict;

create index ix_order_product_map_product_id on order_product_map (product_id);
alter table order_product_map add constraint fk_order_product_map_product_id foreign key (product_id) references product (product_id) on delete restrict on update restrict;

create index ix_retailer_product_map_retailer_id on retailer_product_map (retailer_id);
alter table retailer_product_map add constraint fk_retailer_product_map_retailer_id foreign key (retailer_id) references retailer (retailer_id) on delete restrict on update restrict;

create index ix_retailer_product_map_product_id on retailer_product_map (product_id);
alter table retailer_product_map add constraint fk_retailer_product_map_product_id foreign key (product_id) references product (product_id) on delete restrict on update restrict;


# --- !Downs

alter table item_order drop constraint if exists fk_item_order_customer_id;
drop index if exists ix_item_order_customer_id;

alter table order_product_map drop constraint if exists fk_order_product_map_order_id;
drop index if exists ix_order_product_map_order_id;

alter table order_product_map drop constraint if exists fk_order_product_map_product_id;
drop index if exists ix_order_product_map_product_id;

alter table retailer_product_map drop constraint if exists fk_retailer_product_map_retailer_id;
drop index if exists ix_retailer_product_map_retailer_id;

alter table retailer_product_map drop constraint if exists fk_retailer_product_map_product_id;
drop index if exists ix_retailer_product_map_product_id;

drop table if exists customer;

drop table if exists item_order;

drop table if exists order_product_map;

drop table if exists product;

drop table if exists retailer;

drop table if exists retailer_product_map;

