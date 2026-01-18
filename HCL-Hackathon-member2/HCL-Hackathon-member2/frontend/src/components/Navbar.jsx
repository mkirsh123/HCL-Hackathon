import "./Navbar.css";

export default function Navbar() {
  return (
    <nav className="navbar">
      <h2 className="logo">MediMonitor</h2>

      <div className="nav-links">
        <a href="#home">Home</a>
        <a href="#health">Health Info</a>
        <a href="#services">Services</a>
        <a href="#support">Support</a>
        <a href="/login" className="login-btn">Login</a>
      </div>
    </nav>
  );
}
