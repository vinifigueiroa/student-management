# student-management
UoPeople Programming Assignment (CS1102)
---

## Assignment Description
This assignment will assess your skills and knowledge in utilizing static methods and variables to solve programming problems.

For this assignment, you are tasked with developing a Student Record Management System in Java for a university. The system should provide administrators with the ability to manage student records effectively. It should allow administrators to add new students, update student information, and view student details. The project should emphasize the use of appropriate access modifiers (public, private, protected) to control access to class members.

---

### **Requirements:**

---

**Student Class:**

- The Student class should have private instance variables to store student information such as **name, ID, age, and grade.**
- Use appropriate access modifiers and provide public getter and setter methods for accessing and updating student information.

**Student Management Class:**

- The Student Management class should have private static variables to store a list of students and the total number of students.
- Use appropriate access modifiers to control access to the variables.
- Implement static methods to add new students, update student information, and retrieve student details.
- The addStudent method should accept parameters for student information and create a new Student object. It should add the student to the list of students and update the total number of students.
- The updateStudent method should accept a student ID and new information for the student. It should locate the student in the list and update the student's information accordingly.
- The getStudentDetails method should accept a student ID and return the details of the corresponding student.

**Administrator Interface:**

- Develop an interactive command-line interface for administrators to interact with the Student Record Management System.
- Display a menu with options to add a new student, update student information, and view student details.
- Prompt the administrator for necessary inputs and call the appropriate methods in the StudentManagement class to perform the requested operations.
- Implement error handling to handle cases where the student ID is not found or invalid inputs are provided.

**Documentation**:

- Provide comprehensive documentation for the project, explaining the purpose and usage of each class, method, and variable.
- Describe the access modifiers used in the project and their significance in controlling access to class members.
- Include instructions for running the program and interacting with the administrator interface.

---

**You will be accessed based on the following criteria:**

---

- Student Update – It allows administrators to modify and update student information such as name, age, and grade, ensuring accurate and up-to-date records for effective student record management.
- Student Management – It enables administrators to efficiently handle student records by providing functionality to add new students, update their information, and retrieve student details, ensuring effective organization and maintenance of student records.
- Administrator Interface – It offers a user-friendly command-line interface for administrators to interact with the system, providing a menu-driven approach to perform tasks such as adding new students, updating student information, and viewing student details, enhancing administrative control and ease of use.
- Documentation – It provides comprehensive explanations of the purpose, usage, and functionality of each class, method, and variable, aiding in understanding and maintaining the system. It also includes details about access modifiers used and their significance in controlling access to class members, ensuring clarity, and facilitating future development.
