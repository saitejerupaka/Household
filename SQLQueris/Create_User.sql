Use householdreminder;
create table  IF NOT EXISTS User 
(UserId int primary key  not null auto_increment,
 FirstName varchar(300),
 LastName varchar(300),
 Email varchar(500),
 UserPassword nvarchar(500) not null,
 UpdatedOn datetime)
 
 