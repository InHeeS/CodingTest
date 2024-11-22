select
    distinct(d.id),
    d.email,
    d.first_name,
    d.last_name
from developers d
# 공통 비트 확인, 2 ^ x로 표현되어 있기 떄문이다. skillcodes table code => 1000 (o), 1001(x)
join skillcodes s on (d.skill_code & s.code) > 0
where s.name in('Python', 'C#')
order by d.id