
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

commit work
go
