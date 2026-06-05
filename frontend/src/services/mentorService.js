import axios from 'axios';

const API_BASE_URL = '/api';

const getRecommendations = (userId) =>
  axios.get(`${API_BASE_URL}/recommend/${userId}`);

const getAllMentors = () => axios.get(`${API_BASE_URL}/mentors`);
const getMentorsByCity = (city) =>
  axios.get(`${API_BASE_URL}/mentors/${encodeURIComponent(city)}`);

const mentorService = {
  getRecommendations,
  getAllMentors,
  getMentorsByCity,
};

export default mentorService;
