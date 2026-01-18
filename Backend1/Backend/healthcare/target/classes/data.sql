-- Enable UUID generation (PostgreSQL)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =========================
-- PROVIDER INFO
-- =========================
CREATE TABLE IF NOT EXISTS providerinfo (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    specialty VARCHAR(255) NOT NULL,
    contact_info VARCHAR(255) NOT NULL
);

-- =========================
-- USER INFO
-- =========================
CREATE TABLE IF NOT EXISTS userinfo (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    provider_id UUID NOT NULL,

    CONSTRAINT fk_user_provider
        FOREIGN KEY (provider_id)
        REFERENCES providerinfo(id)
        ON DELETE RESTRICT
);

-- =========================
-- USER GOALS (1–1 with userinfo)
-- Shared Primary Key
-- =========================
CREATE TABLE IF NOT EXISTS usergoals (
    id UUID PRIMARY KEY,
    daily_step_goal INT NOT NULL,
    active_time_goal INT NOT NULL,
    sleeptime INT NOT NULL,

    CONSTRAINT fk_goals_user
        FOREIGN KEY (id)
        REFERENCES userinfo(id)
        ON DELETE CASCADE
);

-- =========================
-- PROVIDER APPOINTMENTS
-- =========================
CREATE TABLE IF NOT EXISTS providerappointment (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    provider_id UUID NOT NULL,
    user_id UUID NOT NULL,
    providerappointmentdate DATE NOT NULL,

    CONSTRAINT fk_appt_provider
        FOREIGN KEY (provider_id)
        REFERENCES providerinfo(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_appt_user
        FOREIGN KEY (user_id)
        REFERENCES userinfo(id)
        ON DELETE CASCADE
);

-- =========================
-- TIP OF THE DAY
-- =========================
CREATE TABLE IF NOT EXISTS tipofday (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tip_content VARCHAR(255) NOT NULL
);

-- ======================================================
-- INSERT DEFAULT DATA (UUID SAFE)
-- ======================================================

-- ---------- PROVIDER ----------
INSERT INTO providerinfo (id, name, specialty, contact_info)
SELECT
    '11111111-1111-1111-1111-111111111111',
    'Dr. Smith',
    'Cardiology',
    'smith@hospital.com'
WHERE NOT EXISTS (
    SELECT 1 FROM providerinfo WHERE id = '11111111-1111-1111-1111-111111111111'
);

-- ---------- USER ----------
INSERT INTO userinfo (
    id,
    name,
    email,
    phone_number,
    date_of_birth,
    provider_id
)
SELECT
    '22222222-2222-2222-2222-222222222222',
    'John Doe',
    'john@example.com',
    '9999999999',
    '1995-01-01',
    '11111111-1111-1111-1111-111111111111'
WHERE NOT EXISTS (
    SELECT 1 FROM userinfo WHERE id = '22222222-2222-2222-2222-222222222222'
);

-- ---------- USER GOALS (SHARED PK) ----------
INSERT INTO usergoals (
    id,
    daily_step_goal,
    active_time_goal,
    sleeptime
)
SELECT
    '22222222-2222-2222-2222-222222222222',
    10000,
    60,
    8
WHERE EXISTS (
    SELECT 1 FROM userinfo WHERE id = '22222222-2222-2222-2222-222222222222'
)
AND NOT EXISTS (
    SELECT 1 FROM usergoals WHERE id = '22222222-2222-2222-2222-222222222222'
);

-- ---------- PROVIDER APPOINTMENT ----------
INSERT INTO providerappointment (
    provider_id,
    user_id,
    providerappointmentdate
)
SELECT
    '11111111-1111-1111-1111-111111111111',
    '22222222-2222-2222-2222-222222222222',
    '2026-01-20'
WHERE NOT EXISTS (
    SELECT 1 FROM providerappointment
    WHERE provider_id = '11111111-1111-1111-1111-111111111111'
      AND user_id = '22222222-2222-2222-2222-222222222222'
      AND providerappointmentdate = '2026-01-20'
);

-- ---------- TIP ----------
INSERT INTO tipofday (tip_content)
SELECT 'Drink at least 2 liters of water daily'
WHERE NOT EXISTS (
    SELECT 1 FROM tipofday
    WHERE tip_content = 'Drink at least 2 liters of water daily'
);
