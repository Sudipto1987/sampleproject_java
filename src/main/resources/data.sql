drop table account;

CREATE TABLE `account` (
  `account_number` int(20) NOT NULL,
  PRIMARY KEY (`account_number`)  
  
) ;

insert into account(account_number) values (10001);
insert into account(account_number) values (10002);


drop table user_request;


CREATE TABLE `user_request` (
  `request_id` int(11) NOT NULL ,
  `request_date` DATE DEFAULT NULL,
  `submitted_by` varchar(45) DEFAULT NULL,
  `action_taken` varchar(45) DEFAULT NULL,  
  `account_number` int(11),
   PRIMARY KEY (`request_id`)
   
);

insert into user_request(request_id,request_date,submitted_by,action_taken,account_number) values (200,sysdate,'Rahul','Approve',10001);
insert into user_request(request_id,request_date,submitted_by,action_taken,account_number) values (201,sysdate,'Sachin','Reject',10002);
insert into user_request(request_id,request_date,submitted_by,action_taken,account_number) values (202,sysdate,'Sehwag','Approve',10002);
