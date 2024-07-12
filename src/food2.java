import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class food2 extends JFrame implements ItemListener, ActionListener {
    JRadioButton rb1, rb2, rb3;
    Font f2;
    JComboBox jcm;
    JLabel l1;
    JButton b1;
    CheckboxGroup cbg;
    String s2;

    // -------------------------------------------//
    String choice;
    String ch = "Veg";
    String rest_choice;
    // -------------------------------------------//

    food2() {
        f2 = new Font("Arial", Font.BOLD, 30);
        setSize(1500, 920);
        Container c = getContentPane();
        c.setLayout(null);

        cbg = new CheckboxGroup();

        Checkbox cb1 = new Checkbox("Restaurant", cbg, true);
        Checkbox cb2 = new Checkbox("Cafe", cbg, false);
        Checkbox cb3 = new Checkbox("Street food", cbg, false);

        l1 = new JLabel("Price Range:");
        b1 = new JButton("Continue");

        String str[] = { "<500", "500-1000", "1000>"};
        jcm = new JComboBox(str);

        l1.setFont(f2);
        b1.setFont(f2);
        cb1.setFont(f2);
        cb2.setFont(f2);
        cb3.setFont(f2);
        jcm.setFont(f2);

        cb1.setBounds(200, 300, 300, 50);
        cb2.setBounds(200, 370, 300, 50);
        cb3.setBounds(200, 440, 300, 50);
        jcm.setBounds(700, 370, 250, 40);

        l1.setBounds(700, 300, 300, 50);
        b1.setBounds(500, 550, 200, 40);

        c.add(cb1);
        c.add(cb2);
        c.add(cb3);
        c.add(jcm);
        c.add(l1);
        c.add(b1);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);

        b1.addActionListener(this);
    }

    void display(String s1) {
        choice = s1;
        ch = s1;
    }

    // food2(String s1) {
    // choice = s1;
    // ch = s1;
    // System.out.println("Second: " + choice);
    // System.out.println("CH Second: " + ch);
    // }

    public void itemStateChanged(ItemEvent e) {
        s2 = cbg.getSelectedCheckbox().getLabel();
        JOptionPane.showMessageDialog(this, "You Choose : " + s2);
        rest_choice = s2;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // System.out.println("Price Range : " + jcm.getSelectedItem());
            String price_range = String.valueOf(jcm.getSelectedItem());
            food3 f3 = new food3();
            // food3 f4 = new food3(ch, rest_choice, price_range);
            f3.display1(ch, rest_choice, price_range);
            f3.setVisible(true);
            dispose();
        }

    }

    public static void main(String args[]) {
        food2 f = new food2();
//        f.setSize(900, 900);
        f.setSize(1500, 920);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setTitle("Choose");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
