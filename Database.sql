CREATE DATABASE daBase;
use daBase;

CREATE TABLE Player2 (
		ID int,
        Name varchar(255),
        Age int,
        Server varchar(255)
);

insert into Player2(ID, Name, Age, Server) values (0, "Mithos", 20, "Melon");
insert into Player2(ID, Name, Age, Server) values (1, "Mithos2", 30, "Sandia");

select * from Player2;