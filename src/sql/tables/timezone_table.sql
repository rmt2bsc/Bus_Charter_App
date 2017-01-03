

CREATE TABLE "DBA"."TIME_ZONE" (
    "time_zone_id"                   int NOT NULL DEFAULT autoincrement
   ,"descr"                          varchar(35) NULL
   ,CONSTRAINT "PK_TIME_ZONE" PRIMARY KEY ("time_zone_id") 
)
go


CREATE UNIQUE INDEX "TIME_ZONE_PK" ON "DBA"."TIME_ZONE"
    ( "time_zone_id" )
go


