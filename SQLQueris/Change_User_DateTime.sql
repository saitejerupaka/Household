use householdreminder;
alter table user
change column UpdatedOn UpdatedOn TimeStamp NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP