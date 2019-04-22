# Proefessional Practice in It Project
## A student DataBase Interface for schools
###### Jack Caltagirone - G00349976  ,  Laura Flaherty - 

###### Intro:
  We first came up with the project idea after my, jacks, uncle told me about the problem they were having at their school where they were trying to get a databases UI that teachers could log on it and chage student details. 
  When paired up with laura i suggested this idea and we both agreed. I had has very simple base to work off that just added to a sql database so from that spawned this project.
  
###### Using the Program

  When running, the log In screen will be showen first. Use `admin` for the user and `password`  for the password. this will bring you to the Student page. 
  In the student page you will have a list of students. this list comes straight from the SQL database and is not hardcoded or stored on the device. There are 6 coloums with information on each student. SID is the student number, followed by name, address, date of birth, year/class, and special Needs. There is also a `Delete` button at the end of each students row. clicking this will delete the student from the database permanently. There are two buttons at the bottom. `Add Student` and `Add Grades`.
  
AddStudent: In the addStudent page, the user is prompted with 6 input boxes. each corresponding with one if the columns of information on the previous screen. a user may add a student through this page. the user merely add the user details consisting of a student number prefixed with `G00` followed by any 6 digits, the students name, address, date of birth formatted for mySQL in the sequence yyyy-mm-dd, student class/year and the students specail needs if any. once these details are entered the user may click `Add` to create the student, or 'cancel' to cancel 
  
AddGrade: 
