import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Navbar from './components/Navbar';
import Footer from './components/Footer';

import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';
import Profile from './pages/Profile';
import Recommendations from './pages/Recommendations';
import MentorList from './pages/MentorList';
import BookAppointment from './pages/BookAppointment';

function App() {
  return (
    <>
      <Navbar />

      <div className="container">
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/recommendations" element={<Recommendations />} />
          <Route path="/mentors" element={<MentorList />} />
          <Route path="/book-appointment" element={<BookAppointment />} />
        </Routes>
      </div>

      <Footer />
    </>
  );
}

export default App;