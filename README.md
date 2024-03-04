# Technical Documentation: Spring CRUD API
## Overview
This technical documentation outlines the structure, functionality, and usage of a Spring-based CRUD (Create, Read, Update, Delete) API for managing employee data.

## Project Structure

The project consists of several Java classes organized into packages:

1. **com.khaing.CRUDdemo.DAO**: Contains the data access object interface for managing Employee entities.
   
   - **EmployeeRepo**: Interface extending JpaRepository to handle CRUD operations for Employee entities.

2. **com.khaing.CRUDdemo.entity**: Contains the Employee entity class.

   - **Employee**: Entity class representing an employee with attributes such as id, firstName, lastName, and email.

3. **com.khaing.CRUDdemo.Rest**: Contains RESTful controllers for handling HTTP requests related to employee data.

   - **EmployeeRest**: Controller class defining endpoints for CRUD operations on employee data.

4. **com.khaing.CRUDdemo**: Contains the main application class.

   - **CruDdemoApplication**: Main class with the SpringApplication configuration.(run this java alone)

## API Endpoints

The API exposes the following endpoints for managing employee data:

- `GET /api/employees`: Retrieve a list of all employees.
- `GET /api/employees/{employeeId}`: Retrieve details of a specific employee by ID.
- `POST /api/employees`: Create a new employee.
- `PUT /api/employees`: Update an existing employee.
- `DELETE /api/employees/{id}`: Delete an employee by ID.

## Request and Response Formats

### GET /api/employees

- *Request*: None
- **Response**: List of Employee objects in JSON format.

### GET /api/employees/{employeeId}

- **Request**: Employee ID as a path variable.
- **Response**: Details of the employee with the specified ID in JSON format.

### POST /api/employees

- **Request**: JSON representation of the new employee object.
- **Response**: Details of the newly created employee in JSON format.

### PUT /api/employees

- **Request**: JSON representation of the updated employee object.
- **Response**: Details of the updated employee in JSON format.

### DELETE /api/employees/{id}

- **Request**: Employee ID as a path variable.
- **Response**: Status message indicating the deletion operation's success.

## Error Handling

- If an employee with a specified ID is not found, a RuntimeException is thrown with an appropriate error message.
- Error responses are returned with appropriate HTTP status codes.

## Usage

1. Start the application by running the `CruDdemoApplication` class.
2. Access the API endpoints using an HTTP client (e.g., cURL, Postman).
3. Send requests to the appropriate endpoints to perform CRUD operations on employee data.

## Dependencies

- Spring Boot: Framework for creating stand-alone, production-grade Spring-based applications.
- Spring Data JPA: Part of the larger Spring Data project that makes it easier to implement JPA-based repositories.
- Jakarta Persistence API: A set of classes and interfaces that define the Jakarta Persistence API.
  
## Conclusion

This technical documentation provides an overview of the Spring CRUD API for managing employee data. It outlines the project structure, API endpoints, request, and response formats, error handling, and usage instructions.

---

