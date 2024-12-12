select fi.id, fni.fish_name, fi.length
from fish_info fi
join fish_name_info fni on fi.fish_type = fni.fish_type
where
    fi.length = (select max(length) 
                 from fish_info
                 where fish_type = fi.fish_type
                )
order by fi.id