/**
  This script is for updating existing customer's databases to be compatible 
  with the new Java implementation of the Bus Charter software package.
/*

ALTER TABLE client
add comments VARCHAR(250) NULL;

ALTER TABLE quote
add instructions VARCHAR(5000) NULL;

ALTER TABLE bus_detail
add instructions VARCHAR(5000) NULL;

update client set comments = comments.comment_text
from client
  inner join comments on comments.comment_id = client.comment_id;


update quote set instructions = comments.comment_text
from quote
  inner join comments on comments.comment_id = quote.special_instructions;

update bus_detail set instructions = comments.comment_text
from bus_detail
  inner join comments on comments.comment_id = bus_detail.special_instructions;


-- Add logic to remove table city_code
-- Add logic to remove table comments
-- Add logic to create and import data into tables city_type, timezone, and zipcode
-- Add logic to alter business table:
    1.  add column addr_line_1 varchar 50
    2.  add column addr_line_2 varchar 50
    3.  add column addr_line_3 varchar 50
    4.  add column zip_id integer foreign key to zipcode table
    5.  remove column, comment_id and its index
    
-- Add logic to alter client table:    
    1.  change column contact_zip to contact_zip_id integer and change as a foreign key to zipcode.
    2.  change column billing_zip to billing_zip_id integer and change as a foreign key to zipcode.
    3.  remove column contact_city and its indexes.
    4.  remove column billing_city and its indexes.
    5.  remove column contact_state and its indexes.
    6.  remove column billing_state and its indexes.
    7.  remove column, comment_id and its index.
    
-- Run SQL statement to convert actual zip code values in contact_zip_id and billing_zip_id columns of the client table to zip id's:
	update client 
	  set contact_zip_id = (select first zip_id from zipcode where zip = convert(integer, substring(convert(varchar, client.contact_zip_id), 1, 5)) order by zip_id),
	      billing_zip_id = (select first zip_id from zipcode where zip = convert(integer, substring(convert(varchar, client.billing_zip_id), 1, 5)) order by zip_id)
    
-- Query to check the zip_id conversion:
    select contact_zip_id, a.zip, billing_zip_id, b.zip
      from client, zipcode a, zipcode b
     where client.contact_zip_id = a.zip_id
       and client.billing_zip_id = b.zip_id
       
--  Modify table, orders, by changing the data type of column, min_hour_factor to integer.
    Update min_hour_factor with the folliwng SQL update to apply the proper code id.  Current systems are hard coded as a 5 hour minimum.

	 update orders 
	    set min_hour_factor = 227 
	    where min_hour_factor = 5       
       
-- Add All views       
    
