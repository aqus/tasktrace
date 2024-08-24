# About the Tasktrace application
Task management system. The application allows to create tasks, assign them to users and track their progress.

## Features
- Create new task
- Assign task to user
- Track progress of the task
- Move task to different statuses
- Attach files to a task

## Services
- API Gateway
- Discovery Service (Eureka)
- Task Service
- User Service
- File Storage Service

## Storage
- PostgreSQL for storing tasks, users and file metadata
- MinIO (AWS S3 compatible) for file storage

## Authentication & authorization
- Keycloak for JWT token based authentication

## Technologies used
- Spring Boot
- Spring Data JPA
- Spring Security
- Eureka Discovery
- OpenFeign
- Hibernate
- MinIO Client
- Keycloak
