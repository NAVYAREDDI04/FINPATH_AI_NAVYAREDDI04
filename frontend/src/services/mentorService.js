import axios from 'axios';

const getRecommendations = (userId) =>
  axios.get(`http://localhost:8080/api/recommend/${userId}`);

const getAllMentors = () => axios.get('http://localhost:8080/api/distributors');

const mentorService = {
  getRecommendations,
  getAllMentors,
};

export default mentorService;
