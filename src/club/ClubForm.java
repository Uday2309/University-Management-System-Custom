package club;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ClubForm extends JFrame {
    private JTextField nameField, facultyField;

    public ClubForm() {
        setTitle("Add Club");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Club Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Faculty In-Charge:"));
        facultyField = new JTextField();
        add(facultyField);

        JButton addBtn = new JButton("Add Club");
        add(addBtn);

        addBtn.addActionListener(e -> insertClub());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void insertClub() {
        String name = nameField.getText();
        String faculty = facultyField.getText();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO clubs (name, faculty_incharge) VALUES (?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, faculty);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Club added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
