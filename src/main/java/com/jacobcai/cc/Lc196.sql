Create table If Not Exists Person
(
    Id    int,
    Email varchar(255)
);
Truncate table Person;
insert into Person (id, email)
values ('1', 'john@example.com');
insert into Person (id, email)
values ('2', 'bob@example.com');
insert into Person (id, email)
values ('3', 'john@example.com');

# 1
delete p1
from Person p1,
     Person p2
where p1.Email = p2.Email
  and p1.Id > p2.Id;

# 2
delete
from Person
where Id not in
      (select Id
       from (select min(Id) as Id
             from Person
             group by Email) as tmp); -- 需要为临时表