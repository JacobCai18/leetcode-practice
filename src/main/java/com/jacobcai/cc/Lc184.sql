DROP TABLE IF EXISTS Employee;
Create table Employee
(
    id           int,
    name         varchar(255),
    salary       int,
    departmentId int
);
DROP TABLE IF EXISTS Department;
Create table Department
(
    id   int,
    name varchar(255)
);
insert into Employee (id, name, salary, departmentId)
values ('1', 'Joe', '70000', '1');
insert into Employee (id, name, salary, departmentId)
values ('2', 'Jim', '90000', '1');
insert into Employee (id, name, salary, departmentId)
values ('3', 'Henry', '80000', '2');
insert into Employee (id, name, salary, departmentId)
values ('4', 'Sam', '60000', '2');
insert into Employee (id, name, salary, departmentId)
values ('5', 'Max', '90000', '1');
insert into Department (id, name)
values ('1', 'IT');
insert into Department (id, name)
values ('2', 'Sales');

select D.name as Department, E.name as Employee, Salary
from Employee E
         inner join Department D
                    on E.departmentId = D.id
where (E.departmentId, Salary)
          in (select departmentId, max(Salary) -- 每个部门中的最高薪资
              from Employee
              group by departmentId);