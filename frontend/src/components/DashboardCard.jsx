import "./DashboardCard.css";

export default function DashboardCard({ title, value, unit, target }) {
  const percent = target ? Math.min((value / target) * 100, 100) : 0;

  return (
    <div className="dashboard-card">
      <h3>{title}</h3>

      {target ? (
        <p className="value">
          {value} / {target} <span>{unit}</span>
        </p>
      ) : (
        <p className="value">
          {value} <span>{unit}</span>
        </p>
      )}

      {target && (
        <div className="progress-bar">
          <div
            className="progress-fill"
            style={{ width: `${percent}%` }}
          ></div>
        </div>
      )}
    </div>
  );
}
