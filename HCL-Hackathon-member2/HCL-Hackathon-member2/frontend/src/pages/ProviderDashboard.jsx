import ProviderSidebar from "../components/ProviderSidebar";
import DashboardCard from "../components/DashboardCard";
import "./ProviderDashboard.css";

export default function ProviderDashboard() {
  return (
    <div className="dashboard-layout">
      <ProviderSidebar />

      <div className="dashboard-content">
        <h1>Provider Dashboard</h1>

        <div className="card-grid">
          <DashboardCard title="Patient Status" value="Stable" />
          <DashboardCard title="Goals Met" value="Yes" />
          <DashboardCard title="Compliance" value="Good" />
        </div>

        <div className="provider-info">
          <h3>Today's Patient Overview</h3>
          <ul>
            <li>Patient A – Goals Met</li>
            <li>Patient B – Needs Follow-up</li>
            <li>Patient C – Stable</li>
          </ul>
        </div>
      </div>
    </div>
  );
}
