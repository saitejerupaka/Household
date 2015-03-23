use householdreminder;
alter table item
change column UpdatedOn UpdatedOn TimeStamp NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP