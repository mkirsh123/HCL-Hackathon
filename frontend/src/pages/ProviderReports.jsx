import ProviderSidebar from "../components/ProviderSidebar";
import "./ProviderReports.css";

const reports = [
  {
    patient: "Patient A",
    date: "18 Jan 2026",
    status: "Stable",
    summary: "Goals met, normal vitals",
  },
  {
    patient: "Patient B",
    date: "18 Jan 2026",
    status: "Needs Follow-up",
    summary: "Low activity, poor sleep",
  },
  {
    patient: "Patient C",
    date: "17 Jan 2026",
    status: "Critical",
    summary: "High BP, missed medication",
  },
];

export default function ProviderReports() {
  return (
    <div className="dashboard-layout">
      <ProviderSidebar />

      <div className="dashboard-content">
        <h1>Reports</h1>

        <div className="reports-table">
          <table>
            <thead>
              <tr>
                <th>Patient</th>
                <th>Date</th>
                <th>Status</th>
                <th>Summary</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              {reports.map((r, i) => (
                <tr key={i}>
                  <td>{r.patient}</td>
                  <td>{r.date}</td>
                  <td className={`status ${r.status.replace(" ", "-")}`}>
                    {r.status}
                  </td>
                  <td>{r.summary}</td>
                  <td>
                    <button className="view-btn">View</button>
                    <button className="download-btn">Download</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
