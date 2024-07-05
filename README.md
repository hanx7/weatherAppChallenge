# WeatherApp

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
