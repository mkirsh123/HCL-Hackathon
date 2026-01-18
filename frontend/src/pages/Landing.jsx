import Navbar from "../components/Navbar";
import "./Landing.css";

export default function Landing() {
  return (
    <>
      <Navbar />

      {/* Hero / About Section */}
      <section id="home" className="hero-section">
        <div className="hero-left">
          <img src="/hero.jpeg" alt="Healthcare" />
        </div>

        <div className="hero-right">
          <h1>About MediMonitor</h1>
          <p>
            MediMonitor is a smart healthcare monitoring platform that helps
            patients track daily wellness activities like steps, sleep, and
            active time, while enabling healthcare providers to monitor patient
            compliance and health progress.
          </p>

          <p>
            Our goal is to promote preventive care and healthy living through
            simple, digital, and accessible tools.
          </p>
        </div>
      </section>

      {/* Health Awareness Section */}
      <section id="health" className="health-section">
        <h2>Health Awareness</h2>
        <p className="health-desc">
          Stay informed with preventive care tips, healthy lifestyle guidance,
          and important health updates to improve your overall well-being.
        </p>

        <div className="health-cards">
          <div className="health-card">
            <h3>Preventive Care</h3>
            <p>
              Regular health check-ups and early detection help prevent serious
              illnesses.
            </p>
          </div>

          <div className="health-card">
            <h3>Healthy Lifestyle</h3>
            <p>
              Balanced diet, regular exercise, and proper sleep improve overall
              health.
            </p>
          </div>

          <div className="health-card">
            <h3>Mental Well-being</h3>
            <p>
              Stress management and mindfulness are important for mental health.
            </p>
          </div>

          <div className="health-card">
            <h3>Digital Monitoring</h3>
            <p>
              Track your health data digitally to stay informed and motivated.
            </p>
          </div>
        </div>
      </section>

      {/* Feature Highlights Section */}
      <section className="features-section">
        <h2>Why Choose MediMonitor?</h2>

        <div className="features-grid">
          <div className="feature-card">
            <h3>Smart Tracking</h3>
            <p>Monitor steps, sleep, and activity in one place.</p>
          </div>

          <div className="feature-card">
            <h3>Doctor Access</h3>
            <p>Healthcare providers can track patient compliance.</p>
          </div>

          <div className="feature-card">
            <h3>Preventive Care</h3>
            <p>Stay ahead with early health awareness.</p>
          </div>

          <div className="feature-card">
            <h3>Secure Platform</h3>
            <p>Your data is protected with secure access.</p>
          </div>
        </div>
      </section>

      {/* How It Works Section */}
      <section className="workflow-section">
        <h2>How MediMonitor Works</h2>

        <div className="workflow-steps">
          <div>1️⃣ Register & Login</div>
          <div>2️⃣ Track Health Data</div>
          <div>3️⃣ Set Goals</div>
          <div>4️⃣ Doctor Monitors Progress</div>
        </div>
      </section>

      {/* Services Section */}
<section id="services" className="services-section">
  <h2>Our Services</h2>

  <div className="services-grid">
    <div className="service-card">
      <h3>Wellness Tracking</h3>
      <p>Track daily steps, sleep, and activity in one place.</p>
    </div>

    <div className="service-card">
      <h3>Health Goals</h3>
      <p>Set personalized goals to improve your lifestyle.</p>
    </div>

    <div className="service-card">
      <h3>Doctor Dashboard</h3>
      <p>Providers monitor patient progress and compliance.</p>
    </div>

    <div className="service-card">
      <h3>Reminders & Alerts</h3>
      <p>Never miss medications or health routines.</p>
    </div>

    <div className="service-card">
      <h3>Preventive Care</h3>
      <p>Stay informed with health awareness content.</p>
    </div>
  </div>
</section>


      {/* Call To Action Section */}
      <section className="cta-section">
        <h2>Start Your Health Journey Today</h2>
        <p>Join MediMonitor and take control of your well-being.</p>
        <a href="/patient" className="cta-btn">Get Started</a>
      </section>

      {/* Support Section */}
<section id="support" className="support-section">
  <h2>Need Help? We’re Here for You</h2>
  <p className="support-desc">
    Our support team is available 24/7 to assist patients and healthcare
    providers with any questions or technical issues.
  </p>

  <div className="support-cards">
    <div className="support-card">
      <h3>📞 Customer Care</h3>
      <p>+91 81436 01974</p>
    </div>

    <div className="support-card">
      <h3>📧 Email Support</h3>
      <p>customercare@medimonitor.com</p>
    </div>
  </div>
</section>

    </>
  );
}
