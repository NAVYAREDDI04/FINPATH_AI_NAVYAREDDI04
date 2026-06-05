import { NavLink } from 'react-router-dom';

function Navbar() {
  return (
    <div className="navbar">
      <NavLink to="/dashboard" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>
        FinWise AI
      </NavLink>
      <NavLink to="/login" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>
        Login
      </NavLink>
      <NavLink to="/register" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>
        Register
      </NavLink>
      <NavLink to="/profile" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>
        Profile
      </NavLink>
      <NavLink to="/recommendations" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>
        Recommendations
      </NavLink>
      <NavLink to="/mentors" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>
        Mentors
      </NavLink>
      <NavLink to="/book-appointment" style={{ color: 'white', textDecoration: 'none' }}>
        Book Appointment
      </NavLink>
    </div>
  );
}

export default Navbar;
