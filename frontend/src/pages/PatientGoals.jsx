import { useState } from "react";
import Sidebar from "../components/Sidebar";
import "../components/DashboardCard.css";



export default function PatientGoals({ setGoals }) {
  const [goalName, setGoalName] = useState("");
  const [goalTarget, setGoalTarget] = useState("");

  const addGoal = () => {
    if (!goalName || !goalTarget) return;

    setGoals((prev) => [
      ...prev,
      { name: goalName, target: goalTarget }
    ]);

    setGoalName("");
    setGoalTarget("");
  };

  return (
    <div className="dashboard-layout">
      <Sidebar />

      <div className="dashboard-content">
        <h1>Set Your Goals 🎯</h1>

        <div className="goal-form">
          <input
            type="text"
            placeholder="Goal Name (e.g., Steps)"
            value={goalName}
            onChange={(e) => setGoalName(e.target.value)}
          />

          <input
            type="text"
            placeholder="Target (e.g., 6000 steps)"
            value={goalTarget}
            onChange={(e) => setGoalTarget(e.target.value)}
          />

          <button onClick={addGoal}>Add Goal</button>
        </div>
      </div>
    </div>
  );
}
