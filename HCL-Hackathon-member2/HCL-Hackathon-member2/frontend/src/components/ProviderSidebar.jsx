import { Link } from "react-router-dom";
import "./Sidebar.css";

export default function ProviderSidebar() {
  return (
    <div className="sidebar">
      <h2>MediMonitor</h2>
      <ul>
        <li><Link to="/provider">Dashboard</Link></li>
        <li><Link to="/provider/patients">Patients</Link></li>
        <li><Link to="/provider/reports">Reports</Link></li>

      </ul>
    </div>
  );
}
