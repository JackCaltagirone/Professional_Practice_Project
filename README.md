# Professional Practice in It Project
## A student DataBase Interface for schools
###### Jack Caltagirone - G00349976  ,  Laura Flaherty - 

###### Intro:
  We first came up with the project idea after my, jacks, uncle told me about the problem they were having at their school where they were trying to get a databases UI that teachers could log on it and change student details. 
  When paired up with Laura I suggested this idea and we both agreed. I had has very simple base to work off that just added to a SQL database so from that spawned this project.
  
###### Using the Program

  When running, the log In screen will be shown first. Use `admin` for the user and `password`  for the password. This will bring you to the Student page. 
  In the student page you will have a list of students. This list comes straight from the SQL database and is not hardcoded or stored on the device. There are 6 coloums with information on each student. SID is the student number, followed by name, address, date of birth, year/class, and special Needs. There is also a `Delete` button at the end of each students row. Clicking this will delete the student from the database permanently. There are two buttons at the bottom. `Add Student` and `Grades`.
  
AddStudent: 
  In the addStudent page, the user is prompted with 6 input boxes. Each corresponding with one if the columns of information on the previous screen. A user may add a student through this page. 
  The user merely add the user details consisting of a student number prefixed with `G00` followed by any 6 digits, the students name, address, date of birth formatted for mySQL in the sequence yyyy-mm-dd, student class/year and the students special needs if any. Once these details are entered the user may click `Add` to create the student, or 'cancel' to cancel 
  
Grades: 
  The grades page will bring the user to a table much like the students table, but will hold each students grades. The grades page has a list of students who have actual grades in their subjects. A newly created student will not show up here as no one as entered grades for that student. To add grades for a student, simply click the `Add Grades` button. This will bring up a screen with various inputs to fill in. 
  If a student is created, the student ID must be put in the grades table to add the grades. EG if you add a student with the student number g00123456, in the grades table you must add a grade with the sid equaling g00123456. 
Once this student is created it will show up in the grades table.

###### Code Run through.
Note: I'll only be running through one of the com packages, as they all have the same set up of a constructor, controller and DAO.  The description can be applied to any of the three java packages.
Also Note: All the unobivious code blocks have comments to explain what each block does. This will be a brief summary of the packages.

Basically how the package operates is we have 3 classes. A constructor, a controller and a DAO.

The constructor creates an object, in this case we'll say student. A simple constructor of setters and getters, empty constructor and a constructor filled with parameters.

The controller, Which acts as the bridge between the user and the database. It uses the user selection to selection which method to use. The controller takes the  information from the object, and passes it through to the DAO.

The DAO. This takes the information given to it by the controller and passes that information to and from the SQL database. It can take the information from existing students in the SQL table, give that information to the constructor, which then outputs that info to the user.

A single transaction when the application is run would be as follows:
Student object is created.
The load students method in the StudentController then runs. This calls the getAllStudents() from the DAO.
The GetAllStudents() method will run and search the Student database table for all information on the students and returns information.
That information is then passed through the Controller and out to the screen via the XHTML files.

Another example of how the three classes interact would be for inserting a student into the table.
If the user were to add a student through the interface, the button has the action `#{studentController.addStudent(student)}`. This piece of code Calls the StudentController Class, and the addStudent() method with the parameter of the student the they just created.
The addStudent then calls the `insertStudent(s)` method with the parameter again being the student just created.
In the Insert Student. A few variables are set to take in and store the information about the student just created.
That information is then compiled into a string and that string is sent and ran on the SQL server. The string is a query that creates a student with that information on the table, thus creating the student and have that students information available to anyone also using the program.






