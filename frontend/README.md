# FinWise AI Frontend

This React frontend connects to the Spring Boot backend running on `http://localhost:8080`.

## Setup

1. Open a terminal in `frontend`
2. Run `npm install`
3. Run `npm start`

## Running the Backend

From the Spring Boot backend folder (`springboot-services/auth-service`):

```bash
mvn spring-boot:run
```

Then open `http://localhost:8080`

## Available Pages

- `/login` - Login page
- `/register` - User registration
- `/dashboard` - Dashboard home
- `/profile` - View and update user profile
- `/recommendations` - Recommended mentors list
- `/mentors` - Mentor directory
- `/book-appointment` - Book an appointment with a mentor

## Backend Endpoints Used

- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/user/profile`
- `PUT /api/user/profile`
- `GET /api/recommend/{userId}`
- `GET /api/distributors`
- `GET /api/distributors/location/{location}`
- `POST /api/appointments/book`

## Notes

- The app stores JWT in `localStorage` at `token` after login.
- Protected profile and appointment routes use the stored token for authorization.
- Update `frontend/src/services/*` if backend URLs change.
