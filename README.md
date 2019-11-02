# MonthlyAttrInterview

This project is based on the Spring Boot project and uses these packages :

Java 1.8
Maven
Spring Core
Spring JDBC
Spring Rest
Spring Batch


DataBase:
MySQL

This application read the  data from database and validate the data based in written logic and update database for that its using spring batch job which run every 3 hours based on  cron expression in code.
We can run this job manually using given rest api.

To download the project
git clone https://github.com/manojsen64/MonthlyAttrInterview.git

Instruction to run application:
1. make sure 1.8 should be running in your machine
2. should have mysql database running in your machine(change database string mentioned in application.properties file as per your database configuration)
3. create table(MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW) if not present in your database with some sample data

#To Create Table

DROP TABLE IF EXISTS MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW;
CREATE TABLE MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW (
  nvic varchar(255) DEFAULT NULL,
  old_new_flag varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  family varchar(255) DEFAULT NULL,
  year varchar(255) DEFAULT NULL,
  bodystyle varchar(255) DEFAULT NULL,
  country text,
  turbo text,
  fuel text,
  drive text,
  valid_data int(5) DEFAULT NULL,
  ID int(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (ID)
) 
#MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW

insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('330416','OLD','125cc','2016','Minibike','AUS','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('330416','NEW','125cc','2016','Minibike','AUS','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('33KM18','OLD','800cc','2015','DUAL','ITA','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('33KM18','NEW','800cc','2015','DUAL','ITA','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('7JV15F','NEW','847cc','2018','TOURER','GBRITAIN','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('7JV15F','OLD','847cc','2018','TOURER','GBR','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('70GU18','NEW','1745cc','2018','CRUISER','JPN','N','A','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('70GU18','OLD','1745cc','2018','CRUISER','JPN','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('90PIM19','NEW','1262cc','2019','Road','USA','NNN','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('00IM19','OLD','1262cc','2019','Road','USA','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('9PDT18','NEW','649cc','2018','CRUISER','JAPAN','N','P','RWD',1,0);
insert into MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW values('9PDT18','OLD','649cc','2018','CRUISER','JPN','N','P','RWD',1,0);



4. build the project using below command
   mvn clean install

5. to run the application 
     mvn spring-boot:run  
     
6. use below url to access the job
    http://localhost:7788/invokejob
    
    (replace port if you changing in application.properties file)
    
 Sample Response :
 
      Batch job has been invoked with status : COMPLETED
      
 For any query write to msmanojsen91@gmail.com