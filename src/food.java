
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class food extends JFrame implements ItemListener, ActionListener {
    JFrame frame1, frame2;
    JLabel l1;
    JButton b1;
    Font f1, f2;
    CheckboxGroup cbg;
    String s1;

    food() {
        setSize(1500, 920);
        l1 = new JLabel("Select Your Preference");
        b1 = new JButton("Continue");
        f1 = new Font("Arial", Font.BOLD, 52);
        f2 = new Font("Arial", Font.BOLD, 30);
        b1 = new JButton("Continue");

        cbg = new CheckboxGroup();

        Checkbox cb1 = new Checkbox("veg", cbg, true);
        Checkbox cb2 = new Checkbox("non-veg", cbg, false);
        Checkbox cb3 = new Checkbox("veg/nonveg", cbg, false);

        Container c = getContentPane();
        c.setLayout(null);
        l1.setFont(f1);
        cb1.setFont(f2);
        cb2.setFont(f2);
        cb3.setFont(f2);
        b1.setFont(f2);

        l1.setBounds(450, 200, 600, 50);
        cb1.setBounds(500, 320, 300, 50);
        cb2.setBounds(500, 390, 300, 50);
        cb3.setBounds(500, 460, 300, 50);
        b1.setBounds(650, 530, 180, 50);
        c.add(l1);
        c.add(cb1);
        c.add(cb2);
        c.add(cb3);

        c.add(b1);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        b1.addActionListener(this);

    }

    public void itemStateChanged(ItemEvent e) {
        s1 = cbg.getSelectedCheckbox().getLabel();
        JOptionPane.showMessageDialog(this, "You Choose : " + s1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            food2 f1 = new food2();
            // food2 f2 = new food2(s1);
            f1.display(s1);
            f1.setVisible(true);
            dispose();

        }

    }

    public static void main(String args[]) {
        food f = new food();
        f.setSize(1500, 920);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setTitle("Preference");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
