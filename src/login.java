import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class login extends JFrame implements ActionListener {
    TextField tf1,tf2;

    login() {
        setSize(1500, 920);
        setLayout(null);
        JLabel l1 = new JLabel("Login Name ");
        JLabel l2 = new JLabel("Password");

        tf1 = new TextField();
        tf2 = new TextField();
        tf2.setEchoChar('*');


        JButton b1 = new JButton("Login");
        JButton b2 = new JButton("Cancel");

        Font f = new Font("arial", Font.BOLD, 35);
        Font f2 = new Font("arial", Font.BOLD, 25);

        l1.setFont(f);
        l2.setFont(f);

        tf1.setFont(f);
        tf2.setFont(f);

        b1.setFont(f2);
        b2.setFont(f2);

        l1.setBounds(370, 350, 220, 40);
        l2.setBounds(370, 500, 220, 40);

        tf1.setBounds(600, 350, 380, 40);
        tf2.setBounds(600, 500, 380, 40);

        b1.setBounds(630, 600, 120, 35);
        b2.setBounds(850, 600, 120, 35);

        add(l1);
        add(l2);

        add(tf1);
        add(tf2);

        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent a) {
        String s1 = a.getActionCommand();

        if (s1.equals("Login")) {
            String str1 = tf1.getText();
            String str2 = tf2.getText();


            try{

                int count=0;
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("select * from login where user_name='"+str1+"' and pass='"+str2+"'");


                while(rs.next()){
//
                    count++;
                }
                System.out.println(count);
                if (count>=1) {
                    JOptionPane.showMessageDialog(this, "Login Successfull");
                    operation o1=new operation();
                    o1.setVisible(true);
                    dispose();
                }
                if(count<1) {
                    JOptionPane.showMessageDialog(this, "Login Unsuccessfull");
                }

            }catch(Exception e){
                e.printStackTrace();
            }



        }


        // ----------------------------------------------------------
        if (s1.equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        login lo = new login();
        lo.setSize(1500, 1000);

        lo.setVisible(true);
        lo.setLocationRelativeTo(null);
        lo.setTitle("Login");
        lo.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}