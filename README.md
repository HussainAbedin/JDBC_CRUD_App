# JDBC CRUD Application

This is a **Java-based JDBC CRUD Application** developed using the **layered architecture** approach. It allows users to perform Create, Read, Update, and Delete operations on a database with clean separation of concerns.

## 🔧 Key Features

- ✅ **Layered Architecture**  
  The project follows a layered design pattern with clear separation between:
  - **DAO (Data Access Object) Layer**
  - **Service Layer**
  - **Presentation Layer**

- ✅ **Singleton Design Pattern**  
  Singleton pattern is used for object creation where applicable, ensuring that only one instance of a particular class is created (e.g., for DB connections or service objects).

- ✅ **DTO (Data Transfer Object)**  
  DTO classes are used to carry data between layers, making the app clean and scalable.

## 🗃️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL / Any relational database
- Layered Design Pattern
- Singleton Pattern
- DTO Pattern

## 📁 Project Structure
```text
src/
└── in.hello
    ├── controller
    │   └── TestApp.java                    # Entry point / Controller
    ├── dto
    │   └── Student.java                    # DTO for student entity
    ├── persistence
    │   ├── StudentDao.java                 # DAO interface
    │   └── StudentDaoImpl.java             # DAO implementation
    ├── daoFactory
    │   └── StudentDaoFactory.java          # Singleton factory for DAO
    ├── service
    │   ├── StudentService.java             # Service interface
    │   └── StudentServiceImpl.java         # Service implementation
    ├── daoService
    │   └── StudentServiceFactory.java      # Singleton factory for Service
    ├── Util
    │   └── JdbcUtil.java                   # DB Utility (Singleton for Connection)
mysql/
└── application.properties                  # DB config (if used)

```
 Features
Layered Architecture
Separation of concerns is maintained by organizing the project into:

Controller Layer (TestApp.java)

Service Layer

DAO Layer

DTO Layer

Utility Layer

Singleton Pattern
Factories and DB utility use the Singleton pattern to ensure single instance management.

DTO Pattern
Student.java acts as a Data Transfer Object to move data cleanly across layers.

CRUD Operations
The application supports:
Insert a student
Display all students
Update student details
Delete a student by ID

💻 Technologies Used
Java 8

JDBC

MySQL (or any relational DB)

Eclipse IDE

Design Patterns: Singleton, DTO

Maven/Manual JARs (as applicable)

🛠️ Setup and Run
Clone the repository:
git clone https://github.com/HussainAbedin/JDBC_CRUD_App.git
Open in Eclipse or your preferred Java IDE.

Configure MySQL DB:

Create a student table.
Update credentials in JdbcUtil.java or application.properties.

Run the application:
Execute TestApp.java to interact via console-based UI.
