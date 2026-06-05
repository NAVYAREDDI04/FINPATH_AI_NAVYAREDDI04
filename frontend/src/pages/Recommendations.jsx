import { useEffect, useState } from 'react';
import mentorService from '../services/mentorService';

function Recommendations() {
  const [mentors, setMentors] = useState([]);

  useEffect(() => {
    const fetchMentors = async () => {
      try {
        const response = await mentorService.getRecommendations(1);
        setMentors(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchMentors();
  }, []);

  return (
    <div>
      <h2>Recommended Mentors</h2>
      {mentors.map((mentor) => (
        <div className="card" key={mentor.id}>
          <h3>{mentor.name}</h3>
          <p>Qualification: {mentor.qualification}</p>
          <p>Experience: {mentor.experienceYears} Years</p>
        </div>
      ))}
    </div>
  );
}

export default Recommendations;
