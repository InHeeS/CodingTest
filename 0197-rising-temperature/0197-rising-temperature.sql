select today.id as id
from Weather as today
    inner join Weather as yesterday on DATE_ADD(yesterday.recordDate, INTERVAL 1 DAY ) = today.recordDate
where today.temperature > yesterday.temperature