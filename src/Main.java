import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import club.ClubForm;
import club.EventForm;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("University Management System");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JButton clubBtn = new JButton("Club Management");
        JButton eventBtn = new JButton("Event Management");

        clubBtn.addActionListener(e -> new ClubForm());
        eventBtn.addActionListener(e -> new EventForm());

        frame.add(clubBtn);
        frame.add(eventBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
