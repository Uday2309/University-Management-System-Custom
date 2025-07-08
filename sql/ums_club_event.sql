CREATE TABLE clubs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  faculty_incharge VARCHAR(100)
);

CREATE TABLE events (
  id INT AUTO_INCREMENT PRIMARY KEY,
  club_id INT,
  name VARCHAR(100),
  event_date DATE,
  venue VARCHAR(100),
  description TEXT,
  FOREIGN KEY (club_id) REFERENCES clubs(id)
);
