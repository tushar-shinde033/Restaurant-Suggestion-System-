
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class operation extends JFrame implements ActionListener{
    JButton b1, b2;
    Font f1, f2;
    JButton j1,j2;

    JTextField t1,t2,t3,t4,t5,t6,d1;

    String rest_id;
    String area,category,preference,price_range,name;
    operation(){
        Container c = getContentPane();
        c.setLayout(null);
        setSize(1500, 920);

        b1 = new JButton("Insert Record");
        f1 = new Font("Arial", Font.BOLD, 25);

        b2 = new JButton("Delete Record");

        b1.setFont(f1);
        b2.setFont(f1);

        c.add(b1);
        c.add(b2);

        b1.setBounds(330,100,300,40);
        b2.setBounds(800,100,300,40);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            JLabel l1,l2,l3,l4,l5,l6;


            Font f4 = new Font("Arial", Font.BOLD, 20);
            l1=new JLabel("Entry ID");
            l2=new JLabel("Area");
            l3=new JLabel("Category");
            l4=new JLabel("Preference");
            l5=new JLabel("Price Range");
            l6=new JLabel("Name");
            j1=new JButton("Insert");

            t1=new JTextField();

            t2=new JTextField();

            t3=new JTextField();

            t4=new JTextField();

            t5=new JTextField();

            t6=new JTextField();




            l1.setFont(f4);
            l2.setFont(f4);
            l3.setFont(f4);
            l4.setFont(f4);
            l5.setFont(f4);
            l6.setFont(f4);
            j1.setFont(f4);

            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            add(l6);

            add(t1);
            add(t2);
            add(t3);
            add(t4);
            add(t5);
            add(t6);

            add(j1);

            l1.setBounds(150,250,200,30);
            l2.setBounds(150,350,200,30);
            l3.setBounds(150,450,200,30);
            l4.setBounds(150,550,200,30);
            l5.setBounds(150,650,200,30);
            l6.setBounds(150,750,200,30);

            t1.setBounds(300,250,200,30);
            t2.setBounds(300,350,200,30);
            t3.setBounds(300,450,200,30);
            t4.setBounds(300,550,200,30);
            t5.setBounds(300,650,200,30);
            t6.setBounds(300,750,200,30);

            j1.setBounds(220,830,200,40);
            j1.addActionListener(this);

        }

        if (e.getSource() == b2) {
            JLabel l1;
            Font f4 = new Font("Arial", Font.BOLD, 20);
            l1=new JLabel("Entry ID");
            d1=new JTextField();
            j2=new JButton("Delete");
            l1.setFont(f4);
            j2.setFont(f4);
            add(l1);
            add(d1);
            add(j2);

            l1.setBounds(750,250,200,30);
            d1.setBounds(900,250,200,30);
            j2.setBounds(840,340,200,40);
            j2.addActionListener(this);
        }

        if (e.getSource() == j1) {
            try{
                rest_id=t1.getText();
                area=t2.getText();
                category=t3.getText();
                preference=t4.getText();
                price_range=t5.getText();
                name=t6.getText();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
                PreparedStatement pst=con.prepareStatement("insert into omkar values(?,?,?,?,?,?)");

                pst.setString(1,rest_id);
                pst.setString(2,area);
                pst.setString(3,category);
                pst.setString(4,preference);
                pst.setString(5,price_range);
                pst.setString(6,name);

                pst.executeUpdate();
                System.out.println("Data Saved...");

            }catch(Exception exception){
                exception.printStackTrace();
            }


            JOptionPane.showMessageDialog(this, "Data Insert Successfull");
        }

        if (e.getSource() == j2) {
            try{
                int delete=Integer.parseInt(d1.getText());
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
                PreparedStatement pst=con.prepareStatement("delete from omkar where rest_id='"+delete+"'");

                pst.executeUpdate();
                System.out.println("Data Delete...");

            }catch(Exception exception){
                exception.printStackTrace();
            }


            JOptionPane.showMessageDialog(this, "Data Deleted Successfull");
        }


    }
    public static void main(String[] args) {
        operation f = new operation();
        f.setSize(1500, 1000);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setTitle("Operation");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
