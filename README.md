# InvestBridge AI

A comprehensive microservices-based platform for investment bridging with AI capabilities.

## Project Structure

```
investbridge-ai/
├── springboot-services/     # Java/Spring Boot microservices
│   ├── auth-service/        # Authentication & Authorization service
│   └── user-service/        # User management service
│
├── node-services/           # Node.js microservices
│   ├── ai-service/          # AI/ML service
│   └── notification-service/ # Notification & Messaging service
│
├── database/                # Database schemas and migrations
│
├── docs/                    # Documentation
│
└── postman/                 # Postman collections and environments
```

## Getting Started

### Prerequisites
- Java 11+ (for Spring Boot services)
- Node.js 14+ (for Node services)
- Docker & Docker Compose
- Maven (for Spring Boot)
- npm/yarn (for Node services)

### Installation

1. Clone the repository
2. Navigate to each service directory
3. Follow service-specific setup instructions in their README files

## Services

### Spring Boot Services
- **auth-service**: Handles authentication and authorization
- **user-service**: Manages user data and profiles

### Node Services
- **ai-service**: AI/ML functionality and model inference
- **notification-service**: Email, SMS, and push notifications

## Documentation

See the `/docs` directory for detailed documentation on:
- Architecture
- API specifications
- Setup guides
- Deployment instructions

## Contributing

Please refer to CONTRIBUTING.md for guidelines.

## License

All rights reserved.
