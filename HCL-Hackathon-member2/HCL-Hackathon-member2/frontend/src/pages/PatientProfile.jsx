import Sidebar from "../components/Sidebar";
import "../components/DashboardCard.css";


export default function PatientProfile() {
  return (
    <div className="dashboard-layout">
      <Sidebar />

      <div className="dashboard-content">
        <h1>My Profile 👤</h1>

        {/* USER INFO */}
        <div className="profile-card">
          <h2>Personal Information</h2>
          <p><strong>Name:</strong> Uday Babu</p>
          <p><strong>Age:</strong> 21</p>
          <p><strong>Email:</strong> uday@gmail.com</p>
          <p><strong>Phone:</strong> +91 98765 43210</p>
          <p><strong>Health Condition:</strong> Normal</p>

          <button className="edit-btn">Edit Profile</button>
        </div>

        {/* APPOINTMENT */}
        <div className="profile-card">
          <h2>Next Appointment</h2>
          <p><strong>Doctor:</strong> Dr. Ramesh</p>
          <p><strong>Date:</strong> 20 Jan 2026</p>
          <p><strong>Time:</strong> 10:30 AM</p>
          <p><strong>Mode:</strong> Online Consultation</p>

          <button className="edit-btn">Reschedule</button>
        </div>
      </div>
    </div>
  );
}
