select
    ii.item_id,
    ii.item_name,
    ii.rarity
from item_info ii
left join item_tree t on ii.item_id = t.parent_item_id
where t.parent_item_id is null
order by ii.item_id desc