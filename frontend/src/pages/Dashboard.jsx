import React from 'react';
import './Dashboard.css';

function Dashboard() {
  return (
    <div className="dashboard">
      <div className="hero-card">
        <h1>📊 Investment Dashboard</h1>
        <p>Welcome to FinWise AI - Smart Investment Guidance Platform</p>
      </div>

      <div className="market-cards">
        <div className="card green">
          <h3>NIFTY 50</h3>
          <p>22,450 ▲ +1.2%</p>
        </div>
        <div className="card red">
          <h3>SENSEX</h3>
          <p>73,100 ▼ -0.5%</p>
        </div>
        <div className="card maroon">
          <h3>Mutual Funds</h3>
          <p>Stable Growth</p>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
