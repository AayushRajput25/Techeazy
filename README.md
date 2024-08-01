# Assignment for TechEazy
# Tech Stack

 - Java spring boot (v 3.3.2)
 - jdk version 21
 - H2 in memory database

# About

This Assignment is a **backend** application where a user can signup as admin and student . Admin can update edit its own details , delete itself , create now subjects , edit subjects delete subjects and view all students. Student can edit itself , delete itself , view all available subjects, enroll into subjects , get all enrolled subjects and unenroll the specific enrolled subject.

## Installation 

 1. Clone the repository in your system.
 2. Import the Spring boot application in your IDE.
 3. Run the application,
 4. To access the Database use h2-console (http://localhost:8080/h2-console)
 5. Test all the API provided by Postman

## API list and testing Instructions 

 1. **API for User**
	 1. To signup as student.
	 - URL- http://localhost:8080/user/student_signup (Post)
	 - json body -
		 {
			"name":  "Student1",
			"city":  "City1",
			"dateOfBirth":  "1988-05-05 ",
			"phone":  "12367895",
			"gender":  "Male",
			"email":  "student1@gmail.com",
			"password":  "12345",
			"role":  "Student"
			}
	2. To signup as Admin
	- URL - http://localhost:8080/user/admin_signup (Post)
	- json body -
		 {
			"name":  "Admin1",
			"city":  "City1",
			"dateOfBirth":  "1988-05-05 ",
			"phone":  "12367895",
			"gender":  "Male",
			"email":  "admin1@gmail.com",
			"password":  "admin",
			"role":  "admin"
			}
	 3. Signin
	 - URL - http://localhost:8080/user/signin (Post)
	 - json body-
		  {
		  "email":  "admin1@gmail.com",
		  "password":  "admin"
		  }

2. **API for Admin**
	1. Edit Admin Details
	- URL - http://localhost:8080/admin/{AdminId} (Put)
	- json body - 
		 {
			"name":  "newAdmin1",
			"city":  "newCity1",
			"dateOfBirth":  "1988-05-05 ",
			"phone":  "12367895",
			"gender":  "Male",
			}			
	2. Delete Admin
	- URL - http://localhost:8080/admin/{AdminId} (Delete)
	3. Create Subject
	- URL- http://localhost:8080/admin/addSubject (Post)
	- json body-
		{
		"name"  :  "Subject1"
		}
	4. Edit Subject
	- URL - http://localhost:8080/admin/editSubject/{SubjectId} (Put)
	- json body-
		{
		"name"  :  "Subject2"
		}
	5. Delete Subject
	- URL - http://localhost:8080/admin/deleteSubject/{SubjectId} (Delete)
	6. Get all students
	- URL - http://localhost:8080/admin/student (Get)
	
3. API for Student
	1. Edit Student Details
	- URL - http://localhost:8080/student/{studentId} (Put)
	- json body - 
		 {
			"name":  "newStudent1",
			"city":  "newCity1",
			"dateOfBirth":  "1988-05-05 ",
			"phone":  "12367895",
			"gender":  "Male",
			}
	2. Delete Student
	- URL - http://localhost:8080/student/{studentId} (Delete)
	3. Get All Subjects
	- URL - http://localhost:8080/student/subject (Get)
	4. Enroll into Subject 
	- URL - http://localhost:8080/student/enroll/{studentId}/{SubjectId} (Post)
	5. Get all enrolled subjects
	- URL - http://localhost:8080/student/enroll/{studentId} (Get)
	6. Unenroll from Subject 
	- URL - http://localhost:8080/student/enroll/{EnrollmentId} (Delete)

## Security
    - Role based security - **Admin** Role and **Student** Role 
    - Student can access all student API endpoints to access Jwt token will be generated on login as student
        - ** Header**
            - Key - Authorization
            - Value - Bearer {JWT TOKEN}



```

