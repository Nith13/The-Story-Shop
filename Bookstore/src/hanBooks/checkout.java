package hanBooks;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import java.awt.Color;

import javax.swing.JButton;

import javax.swing.JCheckBox;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class checkout extends JFrame {


private JPanel contentPane;

//JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/Bookstore";

//Database credentials
static final String USER = "root";
static final String PASS = "breakthecode";


public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {

public void run() {

try {

checkout frame = new checkout();

frame.setVisible(true);

} catch (Exception e) {

e.printStackTrace();

}

}

});

}



public checkout() {
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logobookstore.png"));

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setBounds(140, 60, 1300, 730);

contentPane = new JPanel();

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);

contentPane.setLayout(null);


JPanel panel = new JPanel();

panel.setBackground(new Color(255, 255, 51));

panel.setBounds(0, 0, 1286, 75);

contentPane.add(panel);

panel.setLayout(null);


JLabel lblNewLabel = new JLabel("THE STORY SHOP\r\n");

lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

lblNewLabel.setBounds(23, 20, 277, 33);

panel.add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logout-4 (1).png"));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setForeground(Color.BLACK);
lblNewLabel_1.setBackground(Color.GRAY);
lblNewLabel_1.setBounds(1203, 0, 83, 75);
panel.add(lblNewLabel_1);


JPanel panel_1 = new JPanel();

panel_1.setBounds(0, 73, 1286, 486);

contentPane.add(panel_1);

panel_1.setLayout(null);


JPanel panel_3 = new JPanel();

panel_3.setBackground(Color.LIGHT_GRAY);

panel_3.setBounds(0, 0, 1286, 572);

panel_1.add(panel_3);

panel_3.setLayout(null);


JLabel lblNewLabel_2_1 = new JLabel("Thank you for shopping with us!");

lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 40));

lblNewLabel_2_1.setBounds(335, 112, 612, 81);

panel_3.add(lblNewLabel_2_1);
JLabel lblNewLabel_3 = new JLabel("HAPPY READING!");
lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
lblNewLabel_3.setBounds(515, 206, 177, 33);
panel_3.add(lblNewLabel_3);


JPanel panel_2 = new JPanel();

panel_2.setBackground(new Color(255, 255, 51));

panel_2.setBounds(0, 558, 1286, 102);

contentPane.add(panel_2);

panel_2.setLayout(null);


JButton btnNewButton = new JButton("Exit\r\n");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//Step 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 3: Open a connection

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			
			String sql = "TRUNCATE CART";
			
			stmt.execute(sql);
		}
		catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(contentPane, "Thank you!!");
		System.exit(0);
	}
});
btnNewButton.setForeground(new Color(255, 255, 255));
btnNewButton.setBackground(new Color(0, 0, 0));

btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));

btnNewButton.setBounds(1057, 34, 185, 45);

panel_2.add(btnNewButton);




}
}