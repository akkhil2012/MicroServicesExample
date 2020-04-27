DROP TABLE BRS.USER;

CREATE TABLE BRS.USER (
  user_id INTEGER NOT NULL  PRIMARY KEY,
  username VARCHAR(25) NOT NULL,
  password VARCHAR(25) NOT NULL,
  email VARCHAR(25) DEFAULT NULL,
  status  smallint  DEFAULT 0,
  isAdmin smallint  DEFAULT 0,
  ticket_id VARCHAR(25) default 0
);


drop table BRS.user_ticket;

-- the ticket must have a corresponding User
create table BRS.user_ticket(
  ticket_id integer NOT NULL PRIMARY KEY,
  bus_number integer NOT NULL,
  user_id INTEGER NOT NULL,
  bus_id integer NOT NULL,
  seat_id integer NOT NULL,
  ticket_issue_status VARCHAR(10),
  constraint bus_ticket_fkey FOREIGN KEY  (user_id) 
  references BRS.USER (user_id) 
			 on delete restrict 
);

DROP TABLE BRS.ticket_details;

create table BRS.ticket_details(
  ticket_id integer NOT NULL PRIMARY KEY,
  ticket_valid VARCHAR(25) NOT NULL,
  origin VARCHAR(25) NOT NULL,
  destination VARCHAR(25) NOT NULL,
  no_of_passangers integer,
  constraint user_ticket_details_fkey FOREIGN KEY (ticket_id) 
  references BRS.user_ticket(ticket_id) 
			 on delete restrict 
);









drop table BRS.bus_details;

create table BRS.bus_details(
 bus_number integer NOT NULL  PRIMARY KEY,
 ticket_id integer NOT NULL,
 source_station VARCHAR(25) NOT NULL,
 destination_station VARCHAR(25) NOT NULL,
 constraint bus_dtls_ticket_fKey FOREIGN KEY(ticket_id) 
 references BRS.user_ticket (ticket_id) 
			 on delete restrict 
);


create table BRS.Payment_DETAILS(
  booking_id integer NOT NULL PRIMARY KEY,
  paymnent_mode varchar(20) NOT NULL,
  paymnent_status varchar(20) NOT NULL,
  fare_ammount integer NOT NULL,
  constraint bus_dtls_ticket_fKey FOREIGN KEY(booking_id) 
  references BRS.user_ticket (ticket_id) 
			 on delete restrict 
);



drop table  brs.bus_category;


create table BRS.bus_category(
  bus_id integer NOT NULL PRIMARY KEY,
  bus_category varchar(10) DEFAULT 'NORMAL',
  constraint bus_category_fKey FOREIGN KEY(bus_id) 
  references BRS.bus_details(bus_number) 
			 on delete restrict 
)



-------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>









