use householdreminder;
alter table category
change column UpdatedOn UpdatedOn TimeStamp NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP