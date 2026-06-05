import { useState, useEffect } from 'react';
import mentorService from '../services/mentorService';
import axios from 'axios';

function BookAppointment() {
  const [mentors, setMentors] = useState([]);
  const [mentorId, setMentorId] = useState('');
  const [scheduledDate, setScheduledDate] = useState('');

  useEffect(() => {
    const fetchMentors = async () => {
      try {
        const response = await mentorService.getAllMentors();
        setMentors(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchMentors();
  }, []);

  const bookAppointment = async () => {
    try {
      await axios.post(
        'http://localhost:8080/api/appointments/book',
        { mentorId: Number(mentorId), scheduledDate },
        { headers: { Authorization: `Bearer ${localStorage.getItem('token')}` } }
      );
      alert('Appointment booked successfully');
    } catch (error) {
      alert('Appointment booking failed');
    }
  };

  return (
    <div className="card">
      <h2>Book Appointment</h2>
      <select value={mentorId} onChange={(e) => setMentorId(e.target.value)}>
        <option value="">Select Mentor</option>
        {mentors.map((mentor) => (
          <option key={mentor.id} value={mentor.id}>
            {mentor.name} - {mentor.location}
          </option>
        ))}
      </select>
      <input type="datetime-local" value={scheduledDate} onChange={(e) => setScheduledDate(e.target.value)} />
      <button onClick={bookAppointment}>Book Appointment</button>
    </div>
  );
}

export default BookAppointment;
