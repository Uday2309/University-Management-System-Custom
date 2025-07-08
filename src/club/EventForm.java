package club;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class EventForm extends JFrame {
    private JComboBox<String> clubCombo;
    private JTextField nameField, dateField, venueField;
    private JTextArea descField;

    public EventForm() {
        setTitle("Event Management");
        setSize(500, 450);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Select Club:"));
        clubCombo = new JComboBox<>();
        loadClubs();
        add(clubCombo);

        add(new JLabel("Event Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Event Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Venue:"));
        venueField = new JTextField();
        add(venueField);

        add(new JLabel("Description:"));
        descField = new JTextArea(3, 20);
        add(descField);

        JButton addBtn = new JButton("Add Event");
        add(addBtn);

        JButton viewBtn = new JButton("View All Events");
        add(viewBtn);

        addBtn.addActionListener(e -> insertEvent());
        viewBtn.addActionListener(e -> showAllEvents());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadClubs() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM clubs");
            while (rs.next()) {
                clubCombo.addItem(rs.getString("name"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading clubs: " + ex.getMessage());
        }
    }

    private void insertEvent() {
        String clubName = (String) clubCombo.getSelectedItem();
        String name = nameField.getText();
        String date = dateField.getText();
        String venue = venueField.getText();
        String desc = descField.getText();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO events (club_id, name, event_date, venue, description) " +
                "VALUES ((SELECT id FROM clubs WHERE name = ?), ?, ?, ?, ?)"
            );
            ps.setString(1, clubName);
            ps.setString(2, name);
            ps.setString(3, date);
            ps.setString(4, venue);
            ps.setString(5, desc);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Event added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding event: " + ex.getMessage());
        }
    }

    private void showAllEvents() {
        JFrame frame = new JFrame("All Events");
        frame.setSize(700, 400);
        String[] columns = {"Event Name", "Date", "Venue", "Description", "Club"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT e.name, e.event_date, e.venue, e.description, c.name AS club_name " +
                           "FROM events e JOIN clubs c ON e.club_id = c.id";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("name"),
                    rs.getString("event_date"),
                    rs.getString("venue"),
                    rs.getString("description"),
                    rs.getString("club_name")
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading events: " + ex.getMessage());
        }

        frame.add(new JScrollPane(table));
        frame.setVisible(true);
    }
}
