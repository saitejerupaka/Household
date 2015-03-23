use householdreminder;
create table if not exists Item
(
  ItemId int not null auto_increment,
  ItemName nvarchar(300),
  CategoryId int not null,
  Quantity int,
  IsBought bit,
  UpdatedOn datetime,
  Primary key(ItemId),
  Foreign Key(CategoryId) References category(CategoryId)
)