DROP TABLE IF EXISTS Seat;
Create table Seat
(
    id      int,
    student varchar(255)
);
insert into Seat (id, student)
values ('1', 'Abbot');
insert into Seat (id, student)
values ('2', 'Doris');
insert into Seat (id, student)
values ('3', 'Emerson');
insert into Seat (id, student)
values ('4', 'Green');
insert into Seat (id, student)
values ('5', 'Jeames');

select *
from Seat;

# 1
select row_number() over (order by (id + 1 - 2 * ((id & 1) ^ 1))) as id,
       student
from Seat;

# 2
select row_number() over (order by ((id + 1) ^ 1 - 1)) as id,
       student
from Seat;

# 3
select s1.id,
       coalesce(s2.student, s1.student) as student
from Seat s1
         left join Seat s2
                   on ((s1.id + 1) ^ 1) - 1 = s2.id
order by s1.id;

# select *
# from Seat s1
#          left join Seat s2
#                    on ((s1.id + 1) ^ 1) - 1 = s2.id
# order by s1.id;