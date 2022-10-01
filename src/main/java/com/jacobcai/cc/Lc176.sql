DROP TABLE IF EXISTS Employee;
Create table Employee
(
    id     int,
    salary int
);
insert into Employee (id, salary)
values ('1', '100');
insert into Employee (id, salary)
values ('2', '200');
insert into Employee (id, salary)
values ('3', '300');

# 1
select (select distinct salary
        from Employee
        order by salary desc
        limit 1 offset 1) as SecondHighestSalary;

# 2
select ifnull((select distinct salary
               from Employee
               order by salary desc
               limit 1 offset 1),
              null) as SecondHighestSalary;