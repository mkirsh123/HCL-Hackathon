import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Landing from "./pages/Landing";

import PatientDashboard from "./pages/PatientDashboard";
import PatientGoals from "./pages/PatientGoals";
import PatientProfile from "./pages/PatientProfile";

import ProviderDashboard from "./pages/ProviderDashboard";
import ProviderPatients from "./pages/ProviderPatients";
import ProviderReports from "./pages/ProviderReports";

function App() {
  const [goals, setGoals] = useState([]);

  return (
    <BrowserRouter>
      <Routes>

        {/* Landing */}
        <Route path="/" element={<Landing />} />

        {/* Patient Routes */}
        <Route path="/patient" element={<PatientDashboard goals={goals} />} />
        <Route path="/patient/goals" element={<PatientGoals setGoals={setGoals} />} />
        <Route path="/patient/profile" element={<PatientProfile />} />

        {/* Provider Routes */}
        <Route path="/provider" element={<ProviderDashboard />} />
        <Route path="/provider/patients" element={<ProviderPatients />} />
        <Route path="/provider/reports" element={<ProviderReports />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;
