Create table If Not Exists Weather
(
    id          int,
    recordDate  date,
    temperature int
);
Truncate table Weather;
insert into Weather (id, recordDate, temperature)
values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature)
values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature)
values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature)
values ('4', '2015-01-04', '30');

# 1
select a.id
from weather as a
         join weather as b
              on datediff(a.recordDate, b.recordDate) = 1
where a.temperature > b.temperature;

# 2
select a.id
from weather a,
     weather b
where datediff(a.recordDate, b.recordDate) = 1
  and a.temperature > b.temperature;

# 3
select b.id
from weather a,
     weather b
where date_add(a.recordDate, interval 1 day) = b.recordDate
  and a.temperature < b.temperature
