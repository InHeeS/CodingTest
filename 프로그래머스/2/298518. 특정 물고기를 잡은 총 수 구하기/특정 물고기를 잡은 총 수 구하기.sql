select count(*) as FISH_COUNT
from fish_info fi
join FISH_NAME_INFO fni on fi.fish_type = fni.fish_type
where fni.fish_name in ('BASS', 'SNAPPER')