SELECT 
    category,
    price as max_price,
    product_name 
from
    food_product fp
where
    category in ('과자', '국', '김치', '식용유')
    and price = (
        select max(fp2.price)
        from food_product fp2
        where fp2.category = fp.category
    )
    
order by 
    price desc