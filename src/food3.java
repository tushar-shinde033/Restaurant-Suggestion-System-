import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class food3 extends JFrame implements ActionListener {
    JComboBox jcm;
    Font f1, f2;
    JLabel l1;
    JButton b1;

    // -----------------------------//
    String choice;
    String rest_choice;
    String price_range;

    food3() {
        setSize(1500, 920);
        f1 = new Font("Arial", Font.BOLD, 45);
        f2 = new Font("Arial", Font.BOLD, 30);

        Container c = getContentPane();
        c.setLayout(null);
        String str[] = { "Vilad", "Professor Chowk","Bhistabag-Savedi","MIDC","Premdan" };
        jcm = new JComboBox(str);

        l1 = new JLabel("Area : ");
        b1 = new JButton("Continue");
        b1.setFont(f2);
        jcm.setFont(f2);
        l1.setFont(f1);
        c.add(jcm);
        c.add(l1);
        c.add(b1);
        l1.setBounds(300, 300, 250, 40);
        jcm.setBounds(300, 400, 250, 40);
        b1.setBounds(500, 550, 200, 40);

        b1.addActionListener(this);

    }

    // food3(String choice, String rest_choice, String price_range) {
    // // System.out.println("Third File : " + choice);
    // // System.out.println("Restrunt : " + rest_choice);
    // // System.out.println("Price Range : " + price_range);
    // this.choice = choice;
    // this.rest_choice = rest_choice;
    // this.price_range = price_range;
    // }

    void display1(String choice, String rest_choice, String price_range) {
        this.choice = choice;
        this.rest_choice = rest_choice;
        this.price_range = price_range;
        // this.location = location;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            String location = String.valueOf(jcm.getSelectedItem());
            food4 f3 = new food4();
//            food4 f4 = new food4(choice, rest_choice, price_range, location);
            f3.display(choice, rest_choice, price_range, location);
            f3.setVisible(true);
            dispose();
        }

    }

    public static void main(String args[]) {
        food3 f = new food3();
        f.setSize(1500, 920);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setTitle("Choose");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
