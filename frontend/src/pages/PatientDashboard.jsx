import Sidebar from "../components/Sidebar";
import DashboardCard from "../components/DashboardCard";

export default function PatientDashboard({ goals = [] }) {
  return (
    <div className="dashboard-layout">
      <Sidebar />

      <div className="dashboard-content">
        <h1>Welcome Back 👋</h1>

        {/* GOALS SECTION */}
        <h2 className="section-title">My Health Goals</h2>

        {goals.length === 0 ? (
          <p style={{ color: "#64748b", marginBottom: "30px" }}>
            No goals added yet. Go to the Goals section to create one.
          </p>
        ) : (
          <div className="card-grid">
            {goals.map((goal, index) => (
              <DashboardCard
                key={index}
                title={goal.name}
                value={goal.current || 0}
                target={goal.target}
                unit={goal.unit}
              />
            ))}
          </div>
        )}

        {/* METRICS SECTION */}
        <h2 className="section-title">Today’s Summary</h2>

        <div className="card-grid">
          <DashboardCard title="Steps" value="3620" target="6000" unit="steps" />
          <DashboardCard title="Active Time" value="56" target="60" unit="mins" />
          <DashboardCard title="Sleep" value="6.5" target="8" unit="hrs" />
        </div>
      </div>
    </div>
  );
}
