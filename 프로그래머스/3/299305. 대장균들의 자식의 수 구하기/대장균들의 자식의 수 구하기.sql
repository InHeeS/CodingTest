select 
    e.id,
    coalesce(count(c.parent_id)) as child_count
from ecoli_data e
left join ecoli_data c on e.id = c.parent_id
group by e.id
order by e.id