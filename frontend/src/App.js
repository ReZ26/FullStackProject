import React, { useState } from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Register from "./components/Register";
import Login from "./components/Login";
import TaskList from "./components/TaskList";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("token"));

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => {
    localStorage.removeItem("token");
    setIsLoggedIn(false);
  };

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/register" element={<Register onRegister={() => {}} />} />
        <Route path="/login" element={<Login onLogin={handleLogin} />} />
        <Route path="/tasks" element={isLoggedIn ? <TaskList onLogout={handleLogout} /> : <Navigate to="/login" />} />
        <Route path="*" element={<Navigate to={isLoggedIn ? "/tasks" : "/login"} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App; 