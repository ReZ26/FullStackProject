# Personal Task Manager

A fullstack web application for managing personal tasks, built with **Spring Boot** (Java, MySQL) for the backend and **React** for the frontend.

---

## Features
- User registration and login (JWT authentication)
- Add, edit, delete, and mark tasks as complete
- Each user has their own task list

---

## Project Structure

```
personal-task-manager/
├── backend/      # Spring Boot app
└── frontend/     # React app
```

---

## Prerequisites
- **Java 17+**
- **Node.js 18+** and **npm**
- **MySQL** (local or remote)
- (Optional) **Git** for version control

---

## Backend Setup (Spring Boot)

1. **Configure MySQL**
   - Start your MySQL server (locally or use a remote instance).
   - Create a database:
     ```sql
     CREATE DATABASE task_manager;
     ```
   - Update `backend/src/main/resources/application.properties` with your DB credentials:
     ```properties
     spring.datasource.username=YOUR_DB_USER
     spring.datasource.password=YOUR_DB_PASSWORD
     spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
     ```

2. **Build and Run Backend**
   ```bash
   cd backend
   ./mvnw spring-boot:run
   # or if you have Maven installed
   mvn spring-boot:run
   ```
   The backend will start on [http://localhost:8080](http://localhost:8080).

---

## Frontend Setup (React)

1. **Install dependencies**
   ```bash
   cd frontend
   npm install
   ```

2. **Run the frontend**
   ```bash
   npm start
   ```
   The frontend will start on [http://localhost:3000](http://localhost:3000).

---

## Usage
- Register a new user.
- Log in with your credentials.
- Add, edit, delete, and mark tasks as complete.

---

## Deploying Remotely

### **Backend (Spring Boot)**
- Deploy to any Java-supporting cloud (Heroku, Render, AWS, etc.).
- Set environment variables for DB credentials and JWT secret.
- Update `application.properties` to use your remote MySQL instance.
- Make sure to allow CORS for your frontend domain.

### **Frontend (React)**
- Build the frontend:
  ```bash
  npm run build
  ```
- Deploy the `build/` folder to Netlify, Vercel, or any static hosting.
- Update the API URL in `frontend/src/api.js` to point to your deployed backend.

---

## Pushing to GitHub

1. **Initialize git and commit:**
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   ```
2. **Create a new repo on GitHub** and follow their instructions to push:
   ```bash
   git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
   git branch -M main
   git push -u origin main
   ```

---

## Environment Variables (Production)
- Set DB credentials and JWT secret as environment variables or in a secure config.
- Never commit real passwords or secrets to your repo.

---

## Troubleshooting
- **CORS errors:** Make sure CORS is enabled in backend controllers for your frontend domain.
- **Port conflicts:** Change the default ports in `application.properties` or React's `package.json` if needed.
- **Database connection issues:** Double-check your DB credentials and network access.

---

## License
MIT 