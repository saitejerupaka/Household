Use householdreminder;
create table if not exists Category
(
 CategoryId int not null auto_increment,
 CategoryName nvarchar(300),
 UserId int not null,
 UpdatedOn datetime,
 primary key(CategoryId),
 foreign key(UserId) References user(UserId)
)