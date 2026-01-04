# 🎓 University Management System (Java Swing + MySQL)

A desktop-based **University Management System** developed using **Java Swing** and **MySQL**, designed to manage university **clubs, events, and faculty coordination** efficiently.
This project focuses on clean architecture, database integration, and real-world CRUD operations, making it a strong **academic + portfolio project**.

---

## 🚀 Project Overview

Managing university clubs and events manually can be time-consuming and error-prone.
This system provides a **centralized GUI-based solution** to:

* Manage clubs and their faculty coordinators
* Organize and track events under each club
* Store and retrieve data securely using a relational database

The project is built with **scalability in mind**, allowing future upgrades to a **web-based system**.

---

## ✨ Key Features

* 🏫 **Club Management**

  * Add new clubs
  * Assign faculty-in-charge
  * View existing clubs

* 📅 **Event Management**

  * Create events under specific clubs
  * Store event details in the database
  * View and manage events easily

* 🖥️ **User-Friendly GUI**

  * Built using Java Swing
  * Simple and intuitive forms
  * Desktop application (no browser required)

* 🗄️ **Database Integration**

  * MySQL database
  * JDBC for connectivity
  * Structured tables with relationships

* 🧱 **Clean Project Structure**

  * Separate layers for UI, logic, and database
  * Easy to understand and extend

* 🔮 **Future-Ready**

  * Can be upgraded to a web-based system
  * Scope for authentication, roles, and dashboards

---

## 🖼️ Interface Preview

> **Club Management Form**
> Used to add and view university clubs along with faculty-in-charge.

> **Event Management Form**
> Used to create and manage events under specific clubs.

*(Screenshots can be added here for better visualization)*

---

## 🛠️ Technologies Used

* **Programming Language:** Java
* **GUI Framework:** Java Swing
* **Database:** MySQL
* **Database Connectivity:** JDBC
* **Version Control:** Git & GitHub

---

## 🗂️ Project Folder Structure

```
University-Management-System/
│
├── src/
│   ├── ui/              # Swing UI forms
│   ├── dao/             # Database access logic
│   ├── model/           # Data models (Club, Event, etc.)
│   └── main/            # Main application entry point
│
├── lib/
│   └── mysql-connector.jar
│
├── sql/
│   └── database.sql     # Database schema
│
├── README.md
└── .gitignore
```

---

## 🧪 Database Design

* **Clubs Table**

  * club_id (Primary Key)
  * club_name
  * faculty_in_charge

* **Events Table**

  * event_id (Primary Key)
  * event_name
  * event_date
  * club_id (Foreign Key)

---

## ⚙️ How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/your-username/university-management-system.git
   ```

2. Import the project into **IntelliJ IDEA / Eclipse**

3. Set up MySQL:

   * Create a database
   * Run the SQL file from `/sql/database.sql`

4. Update database credentials in the JDBC connection file

5. Run the `Main.java` file

---

## 📌 Future Enhancements

* 🔐 User Authentication (Admin / Student roles)
* 🌐 Web-based version (Spring Boot + React)
* 📊 Admin Dashboard
* 🧾 Event registrations
* 📱 Responsive UI for mobile access

---

## 🎯 Learning Outcomes

* Hands-on experience with **Java Swing**
* Practical use of **JDBC and MySQL**
* Understanding of **CRUD operations**
* Database design and relationships
* Building scalable academic projects

---

## 🤝 Contribution

This is a learning-focused project.
Suggestions, improvements, and feedback are welcome.

---

## 📬 Contact

**Uday Kumar Dubey**
B.Tech CSE (CSBS)


---

