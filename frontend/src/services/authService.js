import axios from 'axios';

const API_URL = 'http://localhost:8081/api/auth';
const AUTH_BASE_URL = 'http://localhost:8081/api';

const login = (credentials) => axios.post(`${API_URL}/login`, credentials);
const register = (user) => axios.post(`${API_URL}/register`, user);
const getProfile = () =>
  axios.get(`${AUTH_BASE_URL}/user/profile`, {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  });
const updateProfile = (profile) =>
  axios.put(`${AUTH_BASE_URL}/user/profile`, profile, {
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
