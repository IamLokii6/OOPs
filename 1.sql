use 2336db;

  CREATE TABLE emp (
  `EmpId` INT  NOT NULL,
  `Firstname` VARCHAR(45) NULL,
  `MiddleInitial` VARCHAR(45) NULL,
  `Lastname` VARCHAR(45) NULL,
  `Streetaddress` VARCHAR(45) NULL,
  `City` VARCHAR(45) NULL,
  `State` VARCHAR(45) NULL,
  `Zipcode` VARCHAR(45) NULL,
  `PhoneNo` VARCHAR(45) NULL,
  `Emailid` VARCHAR(45) NULL,
  PRIMARY KEY (`EmpId`));
  
   CREATE TABLE Trainer(
  `TrainerId` INT  NOT NULL,
  `Orgnld` VARCHAR(45) NULL,
  `Lastname` VARCHAR(45) NULL,
  `FirstName` VARCHAR(45) NULL,
  `MiddleInit` VARCHAR(45) NULL,
  `Position` VARCHAR(45) NULL,
  `Telephone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`TrainerId`));
  
   CREATE TABLE Session(
   `Orgnld` VARCHAR(45) NULL,
  `SessionId` INT  NOT NULL,
  `Title` VARCHAR(45) NULL,
  `Description` VARCHAR(45) NULL,
  `Credits` VARCHAR(45) NULL,
  `Additional_Fees` VARCHAR(45) NULL,
  PRIMARY KEY (`SessionId`));
  
  CREATE TABLE Organization(
  `Orgnld` INT  NOT NULL,
  `OrgnName` VARCHAR(45) NULL,
  `Description` VARCHAR(45) NULL,
  `HOD_Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Orgnld`));
  
  
  INSERT INTO employee value(1,'loki','x','y','abc','xyz','aa','123','111');
  
INSERT INTO employee(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (3, 'John', 'Doe', 'Beach Road', 'Goa', 'Goa', '403001', '9876543210');
INSERT INTO employee(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (4, 'Jane', 'Smith', 'Coconut Avenue', 'Goa', 'Goa', '403002', '9998887776');

INSERT INTO employee(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (5, 'Alice', 'Johnson', 'Sunset Boulevard', 'Goa', 'Goa', '403003', '8765432109');

INSERT INTO employee(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (6, 'Bob', 'Anderson', 'Palm Street', 'Goa', 'Goa', '403004', '9876549876');

INSERT INTO employee(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (7, 'Eva', 'Martinez', 'Seaside Avenue', 'Goa', 'Goa', '403005', '8889993333');  
  
  select * from 2336db.employee;
  
  select * from employee where State = 'Goa' order by Lastname,Firstname;
  
  
  INSERT INTO emp(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo, EmailId) 
VALUES (3, 'John', 'Doe', 'Beach Road', 'Goa', 'Goa', '403001', '9876543210', 'john.doe@example.com');

INSERT INTO emp(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (4, 'Jane', 'Smith', 'Coconut Avenue', 'Goa', 'Goa', '403002', '9998887776');

INSERT INTO emp(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo, EmailId) 
VALUES (5, 'Alice', 'Johnson', 'Sunset Boulevard', 'Goa', 'Goa', '403003', '8765432109', 'alice.johnson@example.com');

INSERT INTO emp(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (6, 'Bob', 'Anderson', 'Palm Street', 'Goa', 'Goa', '403004', '9876549876');

INSERT INTO emp(EmpId, FirstName, LastName, StreetAddress, City, State, Zipcode, PhoneNo) 
VALUES (7, 'Eva', 'Martinez', 'Seaside Avenue', 'Goa', 'Goa', '403005', '8889993333');

 select * from 2336db.emp;
 
  select * from employee where State = 'Goa' order by Lastname,Firstname;
  
  select * from emp where City='Goa' and EmailId is null;
  
  select concat(LastName,',',FirstName) as Name from emp;
  
  INSERT INTO Session (Orgnld, SessionId, Title, Description, Credits, Additional_Fees)
VALUES ('Org1', 1, 'Introduction to SQL', 'Basic SQL concepts and queries', '3', '$50');

INSERT INTO Session (Orgnld, SessionId, Title, Description, Credits, Additional_Fees)
VALUES ('Org2', 2, 'Data Analysis with Python', 'Using Python for data analysis tasks', '4', '$75');

INSERT INTO Session (Orgnld, SessionId, Title, Description, Credits, Additional_Fees)
VALUES ('Org3', 3, 'Machine Learning Fundamentals', 'Introduction to machine learning algorithms', '5', '$100');

INSERT INTO Session (Orgnld, SessionId, Title, Description, Credits, Additional_Fees)
VALUES ('Org4', 4, 'Web Development Basics', 'Fundamental concepts of web development', '3', '$50');

alter table session add constraint chk_credits check (Credits>=4 and Credits<=10);
select * from session;

select *from emp;

select substring(State,1,3) from emp;

select concat(substring(title,4,3),'xxx') as Title from session;

select Title from session where length(Title>=3);

select count(*) as degree from information_schema.columns where table_name ='emp';

select count(*) as cardinality from emp;

INSERT INTO trainer (TrainerId, Lastname, FirstName, MiddleInit, Position, Telephone, Email)
VALUES (1, 'Smith', 'John', 'M', 'Senior Trainer', '123-456-7890', 'john.smith@example.com');

INSERT INTO trainer (TrainerId, Lastname, FirstName, MiddleInit, Position, Telephone, Email)
VALUES (2, 'Johnson', 'Emily', 'A', 'Lead Trainer', '987-654-3210', 'emily.johnson@example.com');

INSERT INTO trainer (TrainerId, Lastname, FirstName, MiddleInit, Position, Telephone, Email)
VALUES (3, 'Garcia', 'Michael', 'R', 'Trainer', '555-555-5555', 'michael.garcia@example.com');

INSERT INTO trainer (TrainerId, Lastname, FirstName, MiddleInit, Position, Telephone, Email)
VALUES (4, 'Brown', 'Sarah', 'J', 'Junior Trainer', '111-222-3333', 'sarah.brown@example.com');


select concat(upper(substring(FirstName,1,1)),Lower(substring(FirstName,2))) as FirstName,
concat(upper(substring(Lastname,1,1)),lower(substring(Lastname,2))) as Lastname from trainer;

alter table trainer add gender char(2);
select * from trainer;
update trainer set gender ='ml' where FirstName = 'Smith';
update trainer set gender ='Fl' where FirstName = 'Brown';

create table session_copy as select * from session;
desc session_copy;
department
create database resturant;