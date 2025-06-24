# Spring Boot 3 Batch CSV Processor Example

This is a simple Spring Boot application that demonstrates how to process CSV file using Spring batch. It provides endpoint for invoking batch job to process sample CSV file provided in resources.

## Features

- **CSV File Processing**: Process sample CSV file through a REST endpoint for processing.
- **Data Persistence**: Persist processed data into an H2 in-memory database using JPA.
- **Custom Data Processor**: Modify data before persisting it using a custom ItemProcessor.
- **Job Listener**: Log messages before and after the job process using a JobExecutionListener.
- **Easy Configuration**: Configure input/output paths, database properties, and batch job settings in the `application.properties` file.
- **Dynamic Chunk Processing**: Process data in chunks to handle large files efficiently.


## Technologies Used

- Java
- Spring Boot
- Spring Batch
- Spring Data JPA
- H2 Database

## Prerequisites

- Java 17 or higher installed on your machine
- Maven installed on your machine

## Getting Started

1. Clone this repository to your local machine:

```
git clone https://github.com/harshrp/springboot3-batch-csv-processor.git
```

2. Navigate to the project directory:

```
cd springboot3-batch-csv-processor
```

3. Build the project using Maven:

```
mvn clean package
```

4. Run the application:

- **Using maven** <br/>``` mvn spring-boot:run```

- **From jar file**
  Create a jar file using '**mvn clean install**' command and then execute
  <br/>```java -jar target/<jar_filename>.jar```
- **Directly from IDE**
  <br/>```Right click on BatchCsvProcessorApplication.java and click on 'Run' option```
  <br/><br/>

5. Once the application is running, you can access the endpoints using a REST client or any HTTP client library.

## API Endpoints

### Dynamic Logging Level Adjustment

- **URL:** `/api/v1/processCustomer`
- **Method:** `GET`
- **Description:** Endpoint to process sample CSV file provided in resources.

## Configuration

- The H2 in-memory database is used for demonstration purposes. You can switch to another database by configuring the `application.properties` file accordingly.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
