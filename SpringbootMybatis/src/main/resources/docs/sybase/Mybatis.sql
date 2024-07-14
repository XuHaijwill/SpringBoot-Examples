if exists ( select 1 from sysobjects where name = 'student')
drop table student
    go

CREATE TABLE testdb.dbo.student (
                                    id bigint primary key not null ,
                                    age int NULL,
                                    name varchar(255) NULL,
                                    create_date_time datetime NULL,
                                    create_user_id bigint NULL,
                                    create_user_name varchar(255) NULL,
                                    update_date_time datetime NULL
)

select * from student