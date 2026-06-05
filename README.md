# FINPATH_AI_NAVYAREDDI04

AI-Powered Investment Learning, Risk Assessment, Portfolio Management and Mentor Matching Platform for Students and Beginner Investors.

## Project Structure

- `auth-service/`: Spring Boot backend for authentication, profile management, recommendations, mentor requests, and appointments.
- `frontend/`: React frontend for login, registration, profile, recommendations, mentor listing, and booking appointments.
- `docs/`: Documentation and design notes.
- `database/`: Database scripts and schema support.

## Setup

### Backend
1. Open a terminal in `springboot-services/auth-service`
2. Run `./mvnw spring-boot:run`
3. Backend starts on `http://localhost:8080`

### Frontend
1. Open a terminal in `frontend`
2. Run `npm install`
3. Run `npm start`
4. Frontend runs on `http://localhost:3000`

## Features

- User registration and login with JWT
- User profile view and update
- Distributor and mentor recommendation
- Mentor request submission
- Appointment booking
- CORS enabled for React frontend integration

## Notes

- The frontend stores the JWT token in `localStorage`.
- Backend CORS is configured for `http://localhost:3000`.

