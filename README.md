
# University Management System (UMS)

## Introduction

Hello all,

Welcome to the University Management System (UMS) project! This project is built entirely in Java and designed for administrative use only. The system features a clear and user-friendly GUI, also built with Java. The data is loaded from and saved to files (courses, students, users, etc.) in .dat format using streams, ensuring all your actions are securely stored and retrieved.

## Features

### Student Management
- **Add Student**: Checks if the student already exists based on SSN number before adding.
- **View and Edit Student Information**.
- **Remove Student**.

### Course Management
- **Add Course**: Adds a new course unless the course code already exists in the data file/ArrayList.
- **Remove Course**.
- **View Course Information**.

### Course-Student Actions
- **Add/Remove Student to/from a Course Section**.
- **Transfer Student from One Course Section to Another**.

### Grades
- **Fill Grades**: Enter grades for students in a course section through a pop-up loop for each student.
- **View Grades**: Display grades for students in a course section through a pop-up loop.

### Security
- **Change Password**.
- **Change Username**.

## Setup and Usage

1. **Download and Open the Project**:
   - Preferred IDE: NetBeans.
   
2. **Run the System**:
   - Navigate to the `src` folder.
   - Run the system from the class `runUMS.java`.
   
3. **Login**:
   - You will see the login page.
   - Enter the username and password (Username: `admin` | Password: `Admin@123`).
   - If you forget the credentials, you can find them in the `credentials.txt` file.
   
4. **Main Page**:
   - After logging in, you will be directed to the main page where you can perform all available actions.
   
5. **Closing the System**:
   - Click the close button on the top right corner to close the system.
   
## Note

The `ums/University Management System` folder contains all necessary files, classes, and packages for the project. Ensure you have a Java compiler installed, with NetBeans being the preferred IDE for running this project.

---
