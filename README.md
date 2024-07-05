
# WeatherApp
 
WeatherApp is a Java Spring Boot application that could retrieves weather information from the OpenWeatherMap API based on geographic coordinates. It includes endpoints to fetch current weather data of a city and perform a health check of the application.


### Explanation

- **Main Entry Points**: Describes the key endpoints (`/weather` and `/healthcheck`) that users can interact with in the WeatherApp.
- **Features**: retrieves weather information and perform a health check of the application

## Folder structure

The project is structured into several key components:


- **Main Source (`src/main/java/com/example/WeatherApp/`)**:
  - **`GlobalExceptionHandler.java`**: Handles exceptions globally for the application, ensuring consistent error handling across different components.
  - **`LocationNotFoundException.java`**: Custom exception class used when a specified location is not found during weather data retrieval.

- **Controller Layer**: The `WeatherController` handles incoming HTTP requests and delegates business logic to the `WeatherService`.
- **Service Layer**: The `WeatherService` interacts with the OpenWeatherMap API to fetch weather data based on provided coordinates.
- **Testing Strategy**: Unit tests are implemented using JUnit and Mockito to ensure the correctness of endpoint behavior and service interactions.

```
weatherAppChallenge/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── WeatherApp/
│   │   │               ├── GlobalExceptionHandler.java
│   │   │               ├── LocationNotFoundException.java
│   │   │               ├── WeatherAppApplication.java
│   │   │               ├── WeatherController.java
│   │   │               └── WeatherService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── WeatherApp/
│                       └── WeatherControllerTest.java
├── .mvn/
│   └── wrapper/
│       ├── maven-wrapper.jar
│       ├── maven-wrapper.properties
│       └── MavenWrapperDownloader.java
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```


## Setup Instructions

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/hanx7/weatherAppChallenge.git
    cd weatherAppChallenge
    ```

2. **Update the Configuration**:
    Open `src/main/resources/application.properties` and replace `YOUR_API_KEY_HERE` with your actual OpenWeatherMap API key.

    ```properties
    # OpenWeatherMap API Key
    weather.api.key=YOUR_API_KEY_HERE

    # Other configurations can go here
    ```

3. **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```

## Example `application.properties`

Here's an example of what your `application.properties` file might look like:

```properties
# OpenWeatherMap API Key
weather.api.key=b73e58bb600488b1ffc0ebb7ecb0b93f

# Other configurations can go here
```

4. **Run Unit Tests**:
    To run the unit tests for the application, use the following command:

    ```bash
    ./mvnw test
    ```

    This command runs all the unit tests defined in the project.


## License

This project is licensed under the MIT License.

