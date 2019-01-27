
# --- !Ups

insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL_ID,MOBILE_NUMBER) values(1,'vikas','vksaran843@gmail.com','7210943727');
insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL_ID,MOBILE_NUMBER) values(2,'rahul','rahul.kumar@gmail.com','9876543210');
insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL_ID,MOBILE_NUMBER) values(3,'ramesh','ramesh.s@gmail.com','4526179876');
insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL_ID,MOBILE_NUMBER) values(4,'ankit','ankit.sharma@gmail.com','9812763450');


# --- !Downs

delete from CUSTOMER;

