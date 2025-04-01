# Task Tracker

Task Tracker is a Spring Boot application for managing tasks and task lists. It provides RESTful APIs to create, update, delete, and retrieve tasks and task lists.

## Features

- Create, update, delete, and retrieve tasks
- Create, update, delete, and retrieve task lists
- Validation for request data
- Exception handling for invalid requests

## Technologies Used

- Java
- Spring Boot
- Maven
- Lombok
- JPA/Hibernate
- H2 Database (for development and testing)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/marc-bhunu/task-tracker.git
    cd task-tracker
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### Running Tests

To run the tests, use the following command:
```sh
mvn test

API Endpoints
Task Endpoints
Create Task


POST /api/v1/task
Request Body:


{
    "title": "New Task",
    "description": "This is a new task description",
    "dueDate": "2023-12-31T23:59:59",
    "completedAt": "2024-01-01T23:59:59",
    "status": "OPEN",
    "taskPriority": "HIGH"
}
Update Task


PUT /api/v1/task/{id}
Request Body:


{
    "title": "Updated Task",
    "description": "This is an updated task description",
    "dueDate": "2023-12-31T23:59:59",
    "completedAt": "2024-01-01T23:59:59",
    "status": "IN_PROGRESS",
    "taskPriority": "MEDIUM"
}
Delete Task


DELETE /api/v1/task/{id}
Get Tasks by Task List ID


GET /api/v1/task/{taskListId}
Task List Endpoints
Create Task List


POST /api/v1/tasks-list
Request Body:


{
    "name": "New Task List"
}
Delete Task List


DELETE /api/v1/tasks-list/{id}
Get All Task Lists


GET /api/v1/tasks-list
