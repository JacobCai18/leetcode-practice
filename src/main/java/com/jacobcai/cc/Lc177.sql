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

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
    RETURN (
        # Write your MySQL query statement below.
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT N, 1);
END