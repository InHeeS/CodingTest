-- 코드를 입력하세요
SELECT
    c.car_id,
    c.car_type,
    floor(c.daily_fee * (1 - d.discount_rate / 100) * 30) as fee
from 
    CAR_RENTAL_COMPANY_CAR c
left join 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on 
    c.car_id = h.car_id and (h.start_date <= "2022-11-30" and h.end_date >= "2022-11-01")

join 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
on 
    c.car_type = d.car_type and d.duration_type = '30일 이상'
where
    c.car_type in ('세단', 'SUV')
    and h.history_id is null
    and floor(c.daily_fee * (1 - d.discount_rate / 100) * 30) between 500000 and 1999999
    
    
order by
    fee desc,
    c.car_type,
    c.car_id desc
    