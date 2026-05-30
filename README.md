# 🏥 Patient Scheduler – Full Stack Spring Boot DevOps Project

A production-ready Patient Appointment Management System built using **Java 17, Spring Boot 4, MySQL, Docker, Nginx, and GitHub Actions**. This project demonstrates modern backend development practices along with containerization, reverse proxy configuration, automated CI/CD pipelines, and cloud-ready deployment architecture.

---

## 🚀 Project Overview

Patient Scheduler is a healthcare appointment management application that enables efficient scheduling and management of patient appointments. The system is designed using a scalable multi-container architecture and follows industry-standard DevOps practices for development, deployment, and maintenance.

The project showcases practical experience in:

* Backend development with Spring Boot
* Database integration using MySQL
* Containerization with Docker
* Service orchestration using Docker Compose
* Reverse proxy setup using Nginx
* CI/CD automation with GitHub Actions
* Production-ready application deployment

---

## 🏗️ System Architecture

text
Client Browser
      │
      ▼
Nginx Reverse Proxy
      │
      ▼
Spring Boot Application
      │
      ▼
MySQL Database

### Architecture Components

* **Nginx** handles incoming HTTP requests and forwards them to the application.
* **Spring Boot** provides REST APIs and business logic.
* **MySQL** stores patient and appointment data.
* **Docker Compose** manages all services in a unified environment.

---

## 🛠️ Technology Stack

| Category             | Technology                  |
| -------------------- | --------------------------- |
| Programming Language | Java 17                     |
| Framework            | Spring Boot 4.0.6           |
| ORM                  | Spring Data JPA / Hibernate |
| Database             | MySQL 8                     |
| Build Tool           | Maven                       |
| Containerization     | Docker                      |
| Orchestration        | Docker Compose              |
| Reverse Proxy        | Nginx                       |
| CI/CD                | GitHub Actions              |
| Version Control      | Git & GitHub                |
| Deployment           | Cloud Ready                 |

---

## ✨ Features

### Appointment Management

* Create patient appointments
* View appointment records
* Cancel appointments
* Store appointment information in MySQL

### Backend Features

* RESTful API architecture
* Spring Data JPA integration
* Environment-based configuration
* Production profile support

### DevOps Features

* Multi-stage Docker build
* Docker Compose orchestration
* Nginx reverse proxy configuration
* Automated GitHub Actions workflow
* Containerized application deployment

---

## 📂 Project Structure

text
patient-scheduler/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │
│   └── test/
│
├── nginx/
│   └── default.conf
│
├── .github/
│   └── workflows/
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── .env.example
├── README.md
└── .gitignore

---

## ⚙️ Local Setup

### Prerequisites

Ensure the following tools are installed:

* Java 17
* Maven
* Docker
* Docker Compose
* Git

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/patient-scheduler.git
cd patient-scheduler
```

### Start Application

```bash
docker compose up --build -d
```

### Verify Running Containers

```bash
docker ps
```

### Access Application

```text
http://localhost
```

---

## 🔄 CI/CD Pipeline

The project includes a GitHub Actions workflow that automatically executes on every push to the main branch.

### Pipeline Workflow

1. Checkout source code
2. Build project using Maven
3. Run automated tests
4. Build Docker image
5. Validate build artifacts
6. Prepare deployment-ready container image

---

## 🐳 Docker Implementation

### Multi-Stage Docker Build

Benefits:

* Smaller image size
* Faster deployments
* Better security
* Clean separation of build and runtime environments

### Services Managed by Docker Compose

* Spring Boot Application
* MySQL Database
* Nginx Reverse Proxy

---

## 🔒 Security & Configuration

* Environment variables managed externally
* Sensitive credentials excluded from GitHub
* Production profile support
* Isolated container networking
* Reverse proxy layer for improved security

---

## 📚 What I Learned

Through this project, I gained hands-on experience with:

* Spring Boot Application Development
* REST API Design
* Database Management with MySQL
* Docker & Docker Compose
* Nginx Configuration
* GitHub Actions CI/CD
* Environment Variable Management
* Production Deployment Concepts
* DevOps Fundamentals

---

## 🚀 Future Enhancements

* JWT Authentication
* Spring Security Integration
* Role-Based Access Control (RBAC)
* Swagger/OpenAPI Documentation
* Email Notifications
* Monitoring with Prometheus & Grafana
* Kubernetes Deployment
* Cloud Infrastructure Automation

---

## 👨‍💻 Author

**Abhishek Kumar**

Java Full Stack Developer

* GitHub: https://github.com/abhishekkr9808
* LinkedIn: https://www.linkedin.com/in/abhishek9808/
* Email: [abhishekkr9808@gmail.com](mailto:abhishekkr9808@gmail.com)

---

⭐ If you found this project useful, consider giving it a star on GitHub.
