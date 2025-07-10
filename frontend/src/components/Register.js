import React, { useState } from "react";
import { register } from "../api";

export default function Register({ onRegister }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [msg, setMsg] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await register(username, password);
      setMsg("Registration successful! Please login.");
      onRegister();
    } catch (err) {
      setMsg("Registration failed.");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <input value={username} onChange={e => setUsername(e.target.value)} placeholder="Username" required />
      <input type="password" value={password} onChange={e => setPassword(e.target.value)} placeholder="Password" required />
      <button type="submit">Register</button>
      <div>{msg}</div>
    </form>
  );
} 