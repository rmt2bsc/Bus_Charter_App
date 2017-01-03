--
-- This command file reloads a database that was unloaded using "dbunload".
--
-- (Version:  12.0.0.2483)
--



-------------------------------------------------
--   Reload column statistics
-------------------------------------------------


-------------------------------------------------
--   Reload data
-------------------------------------------------

LOAD TABLE "DBA"."CITY_TYPE" ("city_type_id","descr")
    FROM 'C:/ProjectServer/BusCharter/Data/sql/citytype/688.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'windows-1252'
go

commit work
go
