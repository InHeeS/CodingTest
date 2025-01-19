select
    e.emp_no,
    e.emp_name,
    case
        when avg(g.score) >= 96  then 'S'
        when avg(g.score) >= 90  then 'A'
        when avg(g.score) >= 80  then 'B'
        else 'C'
    end as grade,
    case
        when avg(g.score) >= 96 then e.sal * 0.20
        when avg(g.score) >= 90 then e.sal * 0.15
        when avg(g.score) >= 80 then e.sal * 0.10
        else 0
    end as bonus
from HR_EMPLOYEES e
join hr_grade g
on e.emp_no = g.emp_no
where g.year = 2022
group by e.emp_no, e.emp_name, e.sal
order by e.emp_no 

