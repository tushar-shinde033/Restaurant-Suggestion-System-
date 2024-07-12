import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class front extends JFrame implements ActionListener {
    JButton b1, b2;
    Font f1, f2;
    front() {
        Container c = getContentPane();
        c.setLayout(null);
        b1 = new JButton("Login As Admin");
        f1 = new Font("Arial", Font.BOLD, 25);

        b2 = new JButton("Login As User");

        b1.setFont(f1);
        b2.setFont(f1);

        c.add(b1);
        c.add(b2);

        b1.setBounds(330,400,300,40);
        b2.setBounds(800,400,300,40);
        b1.addActionListener(this);
        b2.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            login f1 = new login();
            f1.setVisible(true);
            dispose();
        }
        if (e.getSource() == b2) {
            food f1 = new food();
            f1.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        front f = new front();
        f.setSize(1500, 920);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setTitle("Login");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
