#!/bin/bash


docker pull solopwnr/weather-app:latest


docker run -d -p 8001:8001 solopwnr/weather-app:latest