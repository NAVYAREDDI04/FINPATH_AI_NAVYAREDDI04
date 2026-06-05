import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import authService from '../services/authService';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const loginUser = async () => {
    try {
      const response = await authService.login({ email, password });
      localStorage.setItem('token', response.data.token);
      alert('Login Successful');
      navigate('/dashboard');
    } catch (error) {
      alert('Invalid Credentials');
    }
  };

  return (
    <div className="card">
      <h2>Login</h2>
      <input type="email" placeholder="Enter Email" onChange={(e) => setEmail(e.target.value)} />
      <input type="password" placeholder="Enter Password" onChange={(e) => setPassword(e.target.value)} />
      <button onClick={loginUser}>Login</button>
    </div>
  );
}

export default Login;
