create table USER_INFO(
U_EMAIL varchar(100),
U_PW varchar(100) not null,
U_NAME varchar(100) not null,
U_NICK varchar(100) not null,
 constraint  USER_INFO_U_EMAIL_PK primary key(U_EMAIL)
);


select * from USER_INFO;

drop table USER_INFO;