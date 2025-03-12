# Weather App using Java

A weather app that shows the weather of a city

- Frontend: HTML, CSS, JS
- Backend: Java Spring Boot
- External API - Openweather

A Dockerfile is also provided for you to deploy it in a container.

## Project setup

Clone the repo in your system:

`git clone https://github.com/ShivangDholaria/Weather-App.git`

Navigate into the directory and update the `api.key` value in `application.properties` file with your OpenWeather API and run the following:

`mvnw spring-boot:run`

Make sure to add you API Key for the OpenWeather API in the `application.properties` file so that your app runs perfectly.

To implement a complete CICD solution in AWS, [visit here!](https://github.com/ShivangDholaria/CICD/tree/main/CICD%20Pipeline%20for%20weather%20App)

## CI/CD Pipeline Setup using Github Actions

The CI/CD pipeline is defined in the `.github/workflows/cicd-pipeline.yml` file. It consists of three stages:

1. **Stage 1 - Repo Checkout**: This stage checks out the repository and uploads the source code as an artifact.
2. **Stage 2 - Code Building**: This stage sets up Java, downloads the source code artifact, builds the code using Maven, and uploads the build output as an artifact.
3. **Stage 3 - Upload Artifact**: This stage downloads the build output artifact and finalizes the upload step.

## Docker Setup

The Docker setup is defined in the `Dockerfile`. It consists of two stages:

1. **Stage 1 - Build the application**: This stage uses a Maven image to build the application.
2. **Stage 2 - Create a minimal runtime image**: This stage uses a minimal JRE image to create a runtime image for the application.

## How the Application Works

The application provides a single endpoint `/weather` that accepts a `city` parameter and returns the weather information for the specified city. The weather information is fetched from the OpenWeather API.

### Endpoints

- **GET /weather**: Returns the weather information for the specified city.

### Expected Responses

The response contains the following information:

- **City**: The name of the city.
- **Country**: The country code of the city.
- **Weather Description**: A description of the weather.
- **Temperature**: The temperature in Celsius.
- **Humidity**: The humidity percentage.
- **Wind Speed**: The wind speed in meters per second.

## Note

Make sure to update the `api.key` value in `src/main/resources/application.properties` with your OpenWeather API key.
