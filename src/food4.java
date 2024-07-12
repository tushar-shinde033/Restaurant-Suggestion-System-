import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class food4 extends JFrame implements ActionListener {
    JButton jb;
    JTable table;
//    JScrollPane sp;

    String choice;
    String rest_choice;
    String price_range;
    String location;



    food4() {
        Container c = getContentPane();
        setSize(1500, 920);
        c.setLayout(null);
        jb = new JButton("Show Data");
        table = new JTable();
        JScrollPane sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        Font f1=new Font("Arial",Font.BOLD,20);
        Font f2 = new Font("Arial", Font.BOLD, 30);

        jb.setFont(f2);
        table.setFont(f1);
        jb.setBounds(600, 80, 200, 40);
        table.setBounds(100, 200, 1200, 500);

        c.add(jb);
        c.add(sp);
        add(sp);
        c.add(table);


        jb.addActionListener(this);

    }

    void display(String choice, String rest_choice, String price_range, String location){
//        System.out.println("Your Choice : " + choice);
//        System.out.println("Resu Choice : " + rest_choice);
//        System.out.println("Price Range : " + price_range);
//        System.out.println("Location : " + location);
        this.choice=choice;
        this.rest_choice=rest_choice;
        this.price_range=price_range;
        this.location=location;
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("select * from omkar where area='"+location+"'and category1='"+rest_choice+"'and preference='"+choice+"'and price_range='"+price_range+"'");
//
                ResultSetMetaData rsmd = rs.getMetaData();

                DefaultTableModel model =(DefaultTableModel)table.getModel();

                int cols = rsmd.getColumnCount();
                String[] colName = new String[cols];
                for(int i = 0;i <cols;i++)
                    colName[i] = rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(colName);

//----------------Later Add------
                String[] row1 = {"     Area  ","     Category  ","     Preference  ","     Price Range  ","     Name  "};
                model.addRow(row1);
//                -------------------------------------



                String area,category,pref,price_range,name;
                while (rs.next()) {
                    area = rs.getString(2);
                    category = rs.getString(3);
                    pref = rs.getString(4);
                    price_range = rs.getString(5);
                    name = rs.getString(6);

                    String[] row = {area,category,pref,price_range,name};
                    model.addRow(row);
                }
                st.close();
                con.close();

            } catch (Exception exception) {
                exception.printStackTrace();

            }

        }
    }

    public static void main(String args[]) {
        food4 f = new food4();
        f.setSize(1500, 920);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setTitle("Choose");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
