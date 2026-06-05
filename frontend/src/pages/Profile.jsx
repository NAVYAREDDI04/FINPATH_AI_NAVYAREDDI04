import { useEffect, useState } from 'react';
import authService from '../services/authService';

function Profile() {
  const [profile, setProfile] = useState(null);
  const [form, setForm] = useState({ name: '', profession: '', location: '', experienceLevel: '' });

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        const response = await authService.getProfile();
        setProfile(response.data);
        setForm({
          name: response.data.name || '',
          profession: response.data.profession || '',
          location: response.data.location || '',
          experienceLevel: response.data.experienceLevel || ''
        });
      } catch (error) {
        console.error(error);
      }
    };
    fetchProfile();
  }, []);

  const updateProfile = async () => {
    try {
      const response = await authService.updateProfile(form);
      setProfile(response.data);
      alert('Profile updated successfully');
    } catch (error) {
      alert('Update failed');
    }
  };

  if (!profile) return <div className="card"><p>Loading profile...</p></div>;

  return (
    <div className="card">
      <h2>Profile</h2>
      <input placeholder="Name" value={form.name} onChange={(e) => setForm({ ...form, name: e.target.value })} />
      <input placeholder="Profession" value={form.profession} onChange={(e) => setForm({ ...form, profession: e.target.value })} />
      <input placeholder="Location" value={form.location} onChange={(e) => setForm({ ...form, location: e.target.value })} />
      <select value={form.experienceLevel} onChange={(e) => setForm({ ...form, experienceLevel: e.target.value })}>
        <option value="">Select Experience Level</option>
        <option>Beginner</option>
        <option>Intermediate</option>
        <option>Advanced</option>
      </select>
      <button onClick={updateProfile}>Update Profile</button>
    </div>
  );
}

export default Profile;
