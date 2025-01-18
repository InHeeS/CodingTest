-- 코드를 입력하세요
SELECT
    YEAR(os.sales_date) as year,
    MONTH(os.sales_date) as month,
    ui.gender,
    count(distinct ui.user_id) as users
from online_sale os
join user_info ui
on os.user_id = ui.user_id
where ui.gender is not null
group by 
    YEAR(os.sales_date), MONTH(os.sales_date), ui.gender
order by
    year(os.sales_date),
    month(os.sales_date),
    ui.gender