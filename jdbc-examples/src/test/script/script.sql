
select * from address a where a.user_id='1283960607856160768'


select * from address a,user u
where a.user_id=u.id and a.id='2222';


select * from user u join address a
on u.id=a.user_id

select u.id as user_id,u.name,count(a.user_id) as count from user u join address a
on u.id=a.user_id
group by u.id
order by count desc;

select u.id as user_id,u.name,count(a.user_id) as count from user u join address a
                                                                         on u.id=a.user_id
group by u.id
order by count desc;
select u.id as user_id,u.name,count(a.user_id) as count from user u join address a
                                                                         on u.id=a.user_id