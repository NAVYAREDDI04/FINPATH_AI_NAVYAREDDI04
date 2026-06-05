import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';

const login = (credentials) => axios.post(`${API_URL}/login`, credentials);
const register = (user) => axios.post(`${API_URL}/register`, user);
const getProfile = () =>
  axios.get('http://localhost:8080/api/user/profile', {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  });
const updateProfile = (profile) =>
  axios.put('http://localhost:8080/api/user/profile', profile, {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  });

const authService = {
  login,
  register,
  getProfile,
  updateProfile,
};

export default authService;
