import { useEffect, useState } from 'react';
import mentorService from '../services/mentorService';
import authService from '../services/authService';

function Recommendations() {
  const [mentors, setMentors] = useState([]);
  const [location, setLocation] = useState('');

  useEffect(() => {
    const fetchMentors = async () => {
      try {
        const profileResponse = await authService.getProfile();
        const userLocation = profileResponse.data.location || profileResponse.data.city || '';
        setLocation(userLocation);
        if (userLocation) {
          const response = await mentorService.getMentorsByCity(userLocation);
          setMentors(response.data);
        } else {
          const response = await mentorService.getAllMentors();
          setMentors(response.data);
        }
      } catch (error) {
        console.error(error);
      }
    };
    fetchMentors();
  }, []);

  return (
    <div>
      <h2>Recommended Mentors {location ? `Near ${location}` : ''}</h2>
      {mentors.map((mentor) => (
        <div className="card" key={mentor.id}>
          <h3>{mentor.name}</h3>
          <p>Qualification: {mentor.qualification}</p>
          <p>Experience: {mentor.experienceYears} Years</p>
          <p>Clients Mentored: {mentor.clientsUnder}</p>
          <p>Rating: {mentor.rating} / 5</p>
          <p>Location: {mentor.city}</p>
        </div>
      ))}
    </div>
  );
}

export default Recommendations;
