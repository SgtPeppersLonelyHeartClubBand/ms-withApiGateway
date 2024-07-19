# Microservices API Gateway

This project demonstrates a microservices architecture with an API Gateway, Order Service, and Customer Service. The services are containerized using Docker and managed with Docker Compose.

## Prerequisites

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

## Project Structure

/my-microservices-project
|-- api-gateway
| |-- Dockerfile
| |-- pom.xml
| -- src | -- main
| -- java | -- com
| -- api | -- ApiGatewayApplication.java
| -- resources | -- application.yml
|-- customer-service
| |-- Dockerfile
| |-- pom.xml
| -- src | -- main
| -- java | -- com
| -- customer | -- CustomerServiceApplication.java
| -- resources | -- application.yml
|-- order-service
| |-- Dockerfile
| |-- pom.xml
| -- src | -- main
| -- java | -- com
| -- order | -- OrderServiceApplication.java
| -- resources | -- application.yml
`-- docker-compose.yml


## Build and Run

### untuk order service dan customer service harus dijalankan terpisah dari service api gateway

### Step 1: Clone the Repository

```sh
git clone https://github.com/SgtPeppersLonelyHeartClubBand/apiGateway-microservice.git
cd your-repo-name
```

### Step 2: Build the Services
```sh
docker-compose up --build
```

### Step 3: Access the Services
```sh
Once the services are up and running, you can access them via the API Gateway:

API Gateway: http://localhost:8080

Customer Service:
Create Customer: POST http://localhost:8080/api/customers/
Get Customer by ID: GET http://localhost:8080/api/customers/{id}
Check Customer Exists: GET http://localhost:8080/api/customers/exists/{id}

Order Service:
Create Order: POST http://localhost:8080/api/orders/
Get Order by ID: GET http://localhost:8080/api/orders/{id}

Postman Collection
A Postman collection is provided to test the API endpoints. You can import the collection into Postman using the following steps:

Open Postman.
Click on "Import" in the top left corner.
Select the provided JSON file and click "Import".
json


{
  "info": {
    "name": "Microservices API Gateway",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Customer Service",
      "item": [
        {
          "name": "Create Customer",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n    \"name\": \"John Doe\",\n    \"email\": \"john.doe@example.com\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/api/customers/",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "api",
                "customers"
              ]
            }
          }
        },
        {
          "name": "Get Customer by ID",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/customers/{id}",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "api",
                "customers",
                "{id}"
              ],
              "variable": [
                {
                  "key": "id",
                  "value": "1"
                }
              ]
            }
          }
        },
        {
          "name": "Check Customer Exists",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/customers/exists/{id}",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "api",
                "customers",
                "exists",
                "{id}"
              ],
              "variable": [
                {
                  "key": "id",
                  "value": "1"
                }
              ]
            }
          }
        }
      ]
    },
    {
      "name": "Order Service",
      "item": [
        {
          "name": "Create Order",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n    \"customerId\": 1,\n    \"orderDate\": \"2024-06-21\",\n    \"status\": \"NEW\",\n    \"total\": 100.0\n}"
            },
            "url": {
              "raw": "http://localhost:8080/api/orders/",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "api",
                "orders"
              ]
            }
          }
        },
        {
          "name": "Get Order by ID",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/orders/{id}",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "api",
                "orders",
                "{id}"
              ],
              "variable": [
                {
                  "key": "id",
                  "value": "1"
                }
              ]
            }
          }
        }
      ]
    }
  ]
}

```
