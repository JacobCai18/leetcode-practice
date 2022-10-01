DROP TABLE IF EXISTS Person;
Create table Person
(
    personId  int,
    firstName varchar(255),
    lastName  varchar(255)
);
DROP TABLE IF EXISTS Address;
Create table Address
(
    addressId int,
    personId  int,
    city      varchar(255),
    state     varchar(255)
);
insert into Person (personId, lastName, firstName)
values ('1', 'Wang', 'Allen');
insert into Person (personId, lastName, firstName)
values ('2', 'Alice', 'Bob');
insert into Address (addressId, personId, city, state)
values ('1', '2', 'New York City', 'New York');
insert into Address (addressId, personId, city, state)
values ('2', '3', 'Leetcode', 'California');

select lastName, firstName, city, state
from Person p
         left join Address a on p.personId = a.personId;