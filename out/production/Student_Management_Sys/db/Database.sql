Create Database ijse;

create table student(
  Student_id varchar(10) PRIMARY KEY ,
  Student_name varchar(10),
  email  varchar(20),
  contact varchar(10),
  address varchar(20),
  nic varchar(45)

  );


  create table teacher(
                        Teacher_id varchar(10) PRIMARY KEY ,
                        name varchar(10),
                        nic varchar(45),
                        contact varchar(10),
                        address varchar(20)


);

create table subject(
                        subject_id varchar(10) PRIMARY KEY ,
                        name varchar(10),
                        credit double,
                        Teacher_id varchar(20) ,
                        FOREIGN KEY (Teacher_id) REFERENCES teacher(Teacher_id)



);

create table course(
                        course_id varchar(10) PRIMARY KEY ,
                        course_name varchar(10),
                        cost double,
                        duration varchar(20),
                        subject_id varchar(10) ,
                        FOREIGN KEY (subject_id) REFERENCES subject(subject_id)



);

create table intake(
                       intake_id varchar(10) PRIMARY KEY ,
                       start_date date,
                       intakecol varchar(20),
                       description varchar(20),

                       course_id varchar(10) ,
                       FOREIGN KEY (course_id) REFERENCES course(course_id)



);

create table Registration(
                       registration_id varchar(10) PRIMARY KEY ,
                       reg_date date,

                       student_id varchar(10),

                       intake_id varchar(10) ,
                       FOREIGN KEY (student_id) REFERENCES student(Student_id),
                       FOREIGN KEY (intake_id) REFERENCES intake(intake_id)



);


create table Payment(
                             payment_id varchar(10) PRIMARY KEY ,
                             date date,
                             cost double,
                             registration_id varchar(10),


                             FOREIGN KEY (registration_id) REFERENCES registration(registration_id)




);