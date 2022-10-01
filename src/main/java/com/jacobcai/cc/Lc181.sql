DROP TABLE IF EXISTS Employee;
Create table Employee
(
    id        int,
    name      varchar(255),
    salary    int,
    managerId int
);
insert into Employee (id, name, salary, managerId)
values ('1', 'Joe', '70000', '3');
insert into Employee (id, name, salary, managerId)
values ('2', 'Henry', '80000', '4');
insert into Employee (id, name, salary, managerId)
values ('3', 'Sam', '60000', Null);
insert into Employee (id, name, salary, managerId)
values ('4', 'Max', '90000', Null);

select E1.name as Employee
from Employee E1
         inner join Employee E2
                    on E1.ManagerId = E2.Id
                        and E1.Salary > E2.Salary;