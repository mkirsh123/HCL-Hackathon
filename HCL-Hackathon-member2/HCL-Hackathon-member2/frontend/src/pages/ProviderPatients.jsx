import ProviderSidebar from "../components/ProviderSidebar";
import "./ProviderPatients.css";

const patients = [
  { 
    name: "Patient A", 
    status: "Stable", 
    goals: "Completed",
    appointment: "20 Jan 2026"
  },
  { 
    name: "Patient B", 
    status: "Needs Follow-up", 
    goals: "Pending",
    appointment: "19 Jan 2026"
  },
  { 
    name: "Patient C", 
    status: "Critical", 
    goals: "In Progress",
    appointment: "18 Jan 2026"
  },
];

export default function ProviderPatients() {
  return (
    <div className="dashboard-layout">
      <ProviderSidebar />

      <div className="dashboard-content">
        <h1>Patients</h1>

        <div className="patients-grid">
          {patients.map((p, i) => (
            <div key={i} className="patient-card">
              <h3>{p.name}</h3>
              <p><strong>Status:</strong> {p.status}</p>
              <p><strong>Goals:</strong> {p.goals}</p>
              <p><strong>Next Appointment:</strong> {p.appointment}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
