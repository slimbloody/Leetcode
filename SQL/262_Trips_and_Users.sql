select
	t.Request_at as Day,
	round(
		sum(
			case
				when t.status != 'completed' then 1
				else 0
			end
		) / count(t.Request_at), 2
	) as 'Cancellation Rate'
from
  (select
    *
  from
    Trips as t1
  inner join
    Users as u1
  on
    u1.Users_Id=t1.Client_Id
  	and u1.Banned = 'No'
  ) t
where t.Request_at between '2013-10-01' and '2013-10-03'
group by Day
order by Day;
