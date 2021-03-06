# graphql-demo

Tutorial by: https://www.udemy.com/course/graphql-with-java-spring-boot-query-mutation-schema-resolver-edge-jpa/learn/lecture/27295602#overview

## Getting started

* The application shows how to work with graphql
* Ensure you have installed the below applications

  |Application| Version |
  |---------|------------|
  |JDK| \>= 8   |


## Accessing the application
Once you run the application, on your browser enter either \
http://localhost:8084/altair  \
or \
http://localhost:8084/graphiql

the 

### Query
````json
query ($studentId : Float, $courseNameFilter : [CourseNameFilter]) {
    getStudent(studentId: $studentId) {
        id
        fullName
        studentCourses (courseNameFilter : $courseNameFilter) {
            course {
                id
                code
                name
            }
        }
    }
}

Variables            
{
    "studentId" : 1,
    "courseNameFilter" : ["CCC_001", "CCC_002"]
}
````

### Mutation
````json
mutation createStudent ($createStudentRequest : CreateStudentRequest, $courseNameFilter : [CourseNameFilter]) {
  createStudent(createStudentRequest: $createStudentRequest) {
    id
    firstName
    lastName
    dob
    address
    fullName
    studentCourses (courseNameFilter : $courseNameFilter) {
      id
      course {
        id
        code
        name
      }
      active
    } 
  }
}
   
Variables                
{
   "createStudentRequest" : {
     "firstName": "Sandra",
     "lastName": "Bullock",
     "dob": "1989-10-11",
     "address": "8th Street",
     "enrolCourses": [
        {"course": "CCC_001"},
        {"course": "HIV_003"},
        {"course":"CCC_002"}
     ]
   },
   "courseNameFilter":["CCC_001","HIV_003"]
}
````

happy coding 