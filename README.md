# Weather App 

A weather app that shows the weather of entered city

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

To implement a complete CICD solution, [visit here!](https://github.com/ShivangDholaria/CICD/tree/main/CICD%20Pipeline%20for%20weather%20App)

## Docker Deployment

To deploy the application in a Docker container, follow these steps:

1. Build the Docker image:
   ```
   docker build -t weather-app .
   ```

2. Run the Docker container:
   ```
   docker run -p 8001:8001 weather-app
   ```

## Setting up OpenWeather API Key

To set up the OpenWeather API key, update the `api.key` value in the `src/main/resources/application.properties` file with your OpenWeather API key.

## CI/CD Pipeline Configuration for Github Actions

The CI/CD pipeline configuration for Github Actions is defined in the `.github/workflows/cicd-pipeline.yml` file. This pipeline includes stages for checking out the repository, building the code, and uploading artifacts.

## AWS CodeBuild and CodeDeploy Integration

The `buildspec.yml` and `appspec.yml` files are used for AWS CodeBuild and CodeDeploy integration. These files define the build and deployment specifications for the application.

## Managing Docker Container

The `start.sh` and `stop.sh` scripts are provided for managing the Docker container. Use `start.sh` to start the container and `stop.sh` to stop it.
