import axios from 'axios';

const API_URL = 'http://localhost:8081/api/distributors';

const getDistributorsByCity = (city) =>
  axios.get(`${API_URL}/${encodeURIComponent(city)}`);

const distributorService = {
  getDistributorsByCity,
};

export default distributorService;
