select hd.dept_id, hd.dept_name_en, round(avg(he.sal)) as avg_sal
from hr_department hd
join hr_employees he on hd.dept_id = he.dept_id
group by hd.dept_name_en, hd.dept_id
order by avg_sal desc