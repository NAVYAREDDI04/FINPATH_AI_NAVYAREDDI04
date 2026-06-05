import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../assets/logo.png';
import './Navbar.css';

function Navbar() {
  return (
    <div className="navbar">
      <div className="logo-section">
        <img src={logo} alt="FinWise AI logo" className="logo" />
        <span>FinWise AI</span>
      </div>
      <div className="nav-links">
        <Link to="/dashboard">Dashboard</Link>
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link>
        <Link to="/recommendations">Recommendations</Link>
        <Link to="/mentors">Mentors</Link>
      </div>
    </div>
  );
}

export default Navbar;
