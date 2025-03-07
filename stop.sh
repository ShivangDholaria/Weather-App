#!/bin/bash

# Stopping existing continer if running
set -e

containerid=`docker ps | awk -F "" '{print $1}'`
docker rm -f $containerid