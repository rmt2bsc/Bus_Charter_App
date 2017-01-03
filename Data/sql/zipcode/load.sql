--
-- This command file reloads a database that was unloaded using "dbunload".
--
-- (Version:  12.0.0.2483)
--



-------------------------------------------------
--   Reload column statistics
-------------------------------------------------

if db_property('PageSize') >= 4096 then 
    LOAD STATISTICS "DBA"."ZIPCODE"."zip" 
	65, 2.01273069251E-5, 5, 1, 
	0x108e511200000000,
	0x00000000
end if
go

if db_property('PageSize') >= 4096 and
   db_property('Collation') = '1252LATIN1' then 
    LOAD STATISTICS "DBA"."ZIPCODE"."city_type_id" 
	65, -1, 5, 1, 
	0x0000000000000000,
	0xf0b87237
end if
go

if db_property('PageSize') >= 4096 then 
    LOAD STATISTICS "DBA"."ZIPCODE"."time_zone_id" 
	64, -1, 22, 7, 
	0x00000000000008400000000000001040000000000000144000000000000018400000000000001c4000000000000020408542a15028142240,
	0xe8372b3c0000203d0000d03e0000b83e0000b03d0000b03d0000803c
end if
go


-------------------------------------------------
--   Reload data
-------------------------------------------------

LOAD TABLE "DBA"."ZIPCODE" ("zip_id","zip","city","state","area_code","city_alias_name","city_alias_abbr","city_type_id","county_name","county_fips","time_zone_id","day_light_saving","latitude","longitude","elevation","msa","pmsa","cbsa","cbsa_div","persons_per_household","zipcode_population","counties_area","households_per_zipcode","white_population","black_population","hispanic_population","income_per_household","average_house_value")
    FROM 'C:/ProjectServer/BusCharter/Data/sql/zipcode/696.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'windows-1252'
go

commit work
go
