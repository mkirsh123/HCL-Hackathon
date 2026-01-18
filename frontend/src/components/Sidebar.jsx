import { Link } from "react-router-dom";
import "./Sidebar.css";

export default function Sidebar() {
  return (
    <div className="sidebar">
      <h2>MediMonitor</h2>

      <ul>
        <li>
          <Link to="/patient">Dashboard</Link>
        </li>

        <li>
          <Link to="/patient/goals">Goals</Link>
        </li>

        <li>
          <Link to="/patient/profile">My Profile</Link>
        </li>
      </ul>
    </div>
  );
}
