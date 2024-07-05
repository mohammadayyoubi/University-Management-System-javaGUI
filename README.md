Hello all...

Introduction:
This is a full java project, it's topic is UMS system but it is for admin use only (not for student use).
The GUI is very clear and freindly using, and it is built up by java also.
The data of the system is load up from files (courses, student, user...) in which there are .dat file.
same on close, all the data of the system and action you have done on the system will be also save on that file. (stream)

To open and Try:
1. Download the project, and open it (prefferd to open on netbeans)
2. open src folder run system from class "runUMS.java"
3. You will see the login page, enter the username and password (username: admin | password: Admin@123)
4. You will see the main page, and you can do all the action you want.
5. To close the system, click on the close button on the top right corner.
6. If you forgot the username and pass you can find them on txt file



Functions you can do (Description): 

Student management:
- add student to system (of course it will check first if the student already exist depanding on SSN number)
- you can view and change info of the student
- remove student

Course management:
- add course to the system (if the course code already exist in the data file / arrayist after upload it will note add the course)
- remove course
- view course info

Course-Student action:
- add / remove student to a course section
- move student from course section to another

Grades:
- fill grade of the student in a course section, by pop-up loop each contain the name of the student and a text input to enter the grade
- view the grades of the students in a course section (by for loop pop-up each contain the name of the student and it's grade)

security:
- change password 
- change username

Note:
The folder above (ums/University Management System) contain all the files - classes - packages of the project
in order to run the project you need java compiler - prefferd netbeans
