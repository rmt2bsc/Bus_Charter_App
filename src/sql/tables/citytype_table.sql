
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

commit
go

