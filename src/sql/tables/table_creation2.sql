
/*==============================================================*/
/* DBMS name:      Sybase AS Anywhere 9                         */
/* Created on:     1/15/2005 11:50:04 AM                        */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_ORDER_EX_REFERENCE_EXPENSES') then
    alter table order_expenses
       delete foreign key FK_ORDER_EX_REFERENCE_EXPENSES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDER_EX_REFERENCE_ORDERS') then
    alter table order_expenses
       delete foreign key FK_ORDER_EX_REFERENCE_ORDERS
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='oe_ndx_1'
     and t.table_name='order_expenses'
) then
   drop index order_expenses.oe_ndx_1
end if;

if exists(
   select 1 from sys.systable 
   where table_name='expenses'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table expenses
end if;

if exists(
   select 1 from sys.systable 
   where table_name='order_expenses'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table order_expenses
end if;

/*==============================================================*/
/* Table: expenses                                              */
/*==============================================================*/
create table expenses 
(
    id                   integer                        not null default autoincrement,
    description          varchar(30),
    active               smallint,
    date_created         timestamp,
    date_updated         timestamp,
    user_id              varchar(10),
    constraint PK_EXPENSES primary key (id)
);

/*==============================================================*/
/* Table: order_expenses                                        */
/*==============================================================*/
create table order_expenses 
(
    id                   integer                        not null default autoincrement,
    order_id             integer                        not null,
    expense_id           integer                        not null,
    description          varchar(80),
    amount               numeric(9, 2),
    date_created         timestamp,
    date_updated         timestamp,
    user_id              varchar(10),
    constraint PK_ORDER_EXPENSES primary key (id)
);

/*==============================================================*/
/* Index: oe_ndx_1                                              */
/*==============================================================*/
create  index oe_ndx_1 on order_expenses (
order_id ASC,
expense_id ASC
);

alter table order_expenses
   add constraint FK_ORDER_EX_REFERENCE_EXPENSES foreign key (expense_id)
      references expenses (id)
      on update restrict
      on delete restrict;

alter table order_expenses
   add constraint FK_ORDER_EX_REFERENCE_ORDERS foreign key (order_id)
      references orders (id)
      on update restrict
      on delete restrict;

CREATE TABLE "DBA"."TIME_ZONE" (
    "time_zone_id"                   int NOT NULL DEFAULT autoincrement
   ,"descr"                          varchar(35) NULL
   ,CONSTRAINT "PK_TIME_ZONE" PRIMARY KEY ("time_zone_id") 
)
go


CREATE UNIQUE INDEX "TIME_ZONE_PK" ON "DBA"."TIME_ZONE"
    ( "time_zone_id" )
go


CREATE TABLE "DBA"."CITY_TYPE" (
    "city_type_id"                   varchar(1) NOT NULL
   ,"descr"                          varchar(35) NULL
   ,CONSTRAINT "PK_CITY_TYPE" PRIMARY KEY ("city_type_id") 
)
go

GRANT SELECT,INSERT,DELETE,UPDATE,REFERENCES ON "DBA"."CITY_TYPE" TO "contacts_user" 
go


CREATE UNIQUE INDEX "CITY_TYPE_PK" ON "DBA"."CITY_TYPE"
    ( "city_type_id" )
go

CREATE TABLE "DBA"."ZIPCODE" (
    "zip_id"                         int NOT NULL
   ,"zip"                            int NULL
   ,"city"                           varchar(35) NULL
   ,"state"                          varchar(15) NULL
   ,"area_code"                      varchar(20) NULL
   ,"city_alias_name"                varchar(35) NULL
   ,"city_alias_abbr"                varchar(13) NULL
   ,"city_type_id"                   varchar(1) NULL
   ,"county_name"                    varchar(25) NULL
   ,"county_fips"                    varchar(3) NULL
   ,"time_zone_id"                   int NULL
   ,"day_light_saving"               varchar(1) NULL CONSTRAINT "CKC_DAY_LIGHT_SAVING_ZIPCODE" check(day_light_saving is null or(day_light_saving in( 'Y','N') ))
   ,"latitude"                       numeric(11,6) NULL
   ,"longitude"                      numeric(11,6) NULL
   ,"elevation"                      numeric(11,6) NULL
   ,"msa"                            numeric(11,6) NULL
   ,"pmsa"                           numeric(11,6) NULL
   ,"cbsa"                           numeric(11,6) NULL
   ,"cbsa_div"                       numeric(11,6) NULL
   ,"persons_per_household"          numeric(11,6) NULL
   ,"zipcode_population"             numeric(11,4) NULL
   ,"counties_area"                  numeric(11,4) NULL
   ,"households_per_zipcode"         numeric(11,1) NULL
   ,"white_population"               numeric(15,1) NULL
   ,"black_population"               numeric(15,1) NULL
   ,"hispanic_population"            numeric(15,1) NULL
   ,"income_per_household"           numeric(15,1) NULL
   ,"average_house_value"            numeric(15,1) NULL
   ,CONSTRAINT "PK_ZIPCODE" PRIMARY KEY ("zip_id") 
)
go


ALTER TABLE "DBA"."ZIPCODE"
    ADD FOREIGN KEY "FK_ZIPCODE_REF_52725_TIME_ZON" ("time_zone_id")
    REFERENCES "DBA"."TIME_ZONE" ("time_zone_id")
    
go

ALTER TABLE "DBA"."ZIPCODE"
    ADD FOREIGN KEY "FK_ZIPCODE_REF_52735_CITY_TYP" ("city_type_id")
    REFERENCES "DBA"."CITY_TYPE" ("city_type_id")
    
go

CREATE UNIQUE INDEX "ZIPCODE_PK" ON "DBA"."ZIPCODE"
    ( "zip_id" )
go

CREATE INDEX "REF_52735_FK" ON "DBA"."ZIPCODE"
    ( "city_type_id" )
go

CREATE INDEX "REF_52725_FK" ON "DBA"."ZIPCODE"
    ( "time_zone_id" )
go


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  function:    sumExpenses
%  arguments:   integer  aorder_id
%  returns:     numeric
%  description: Adds up all expenses(+/-) for an order and returns the total transaction amount to the caller.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

create function sumExpenses(aorder_id integer) returns numeric(11,2)

begin
   declare tot  numeric(11,2);

   if aorder_id is null or aorder_id <= 0 then
     return 0;
   end if;

   set tot = 0;

   select sum(amount)
     into tot
     from order_expenses
     where order_id = aorder_id;
		
   return ifNull(tot, 0, tot);
end;

commit work
go
