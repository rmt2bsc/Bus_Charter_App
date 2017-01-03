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

LOAD TABLE "DBA"."TIME_ZONE" ("time_zone_id","descr")
    FROM 'C:/ProjectServer/BusCharter/Data/sql/timezone/694.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'windows-1252'
go

commit work
go
