import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import authService from '../services/authService';

function Register() {
  const [user, setUser] = useState({
    name: '',
    email: '',
    password: '',
    profession: '',
    location: '',
    experienceLevel: ''
  });
  const navigate = useNavigate();

  const registerUser = async () => {
    try {
      const response = await authService.register(user);
      alert(response.data?.message || 'Registration Successful');
      navigate('/login');
    } catch (error) {
      const message = error?.response?.data?.message || error?.message || 'Registration Failed';
      alert(message);
    }
  };

  return (
    <div className="card">
      <h2>Register</h2>
      <input placeholder="Name" onChange={(e) => setUser({ ...user, name: e.target.value })} />
      <input placeholder="Email" onChange={(e) => setUser({ ...user, email: e.target.value })} />
      <input type="password" placeholder="Password" onChange={(e) => setUser({ ...user, password: e.target.value })} />
      <select onChange={(e) => setUser({ ...user, profession: e.target.value })}>
        <option value="">Select Profession</option>
        <option>Student</option>
        <option>Employee</option>
      </select>
      <input placeholder="Location" onChange={(e) => setUser({ ...user, location: e.target.value })} />
      <select onChange={(e) => setUser({ ...user, experienceLevel: e.target.value })}>
        <option value="">Select Experience Level</option>
        <option>Beginner</option>
        <option>Intermediate</option>
        <option>Advanced</option>
      </select>
      <button onClick={registerUser}>Register</button>
    </div>
  );
}

export default Register;
