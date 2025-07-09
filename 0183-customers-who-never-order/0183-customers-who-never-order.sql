select c.name as Customers
from Customers as c
    left join Orders as o on c.id = o.Customerid
where o.id is NULL