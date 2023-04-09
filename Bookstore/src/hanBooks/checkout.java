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

import hanBooks.login;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

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
			/*checkout frame = new checkout("Test");
			frame.setVisible(true);*/
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}



public checkout(String uEmail) {
	
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
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel.setBounds(463, 21, 277, 33);
	panel.add(lblNewLabel);
	
	
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
	lblNewLabel_2_1.setBounds(327, 273, 612, 81);
	panel_3.add(lblNewLabel_2_1);
	
	JLabel lblNewLabel_3 = new JLabel("HAPPY READING!");
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
	lblNewLabel_3.setBounds(537, 385, 177, 33);
	panel_3.add(lblNewLabel_3);
	
	JLabel lblName = new JLabel("\r\n");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblName.setBounds(327, 58, 264, 24);
	panel_3.add(lblName);
	
	JLabel lblPhn = new JLabel("\r\n");
	lblPhn.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblPhn.setBounds(327, 102, 264, 24);
	panel_3.add(lblPhn);
	
	JLabel lblEmail = new JLabel("");
	lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblEmail.setBounds(327, 152, 264, 24);
	panel_3.add(lblEmail);
	
	JLabel lblBuyerName = new JLabel("Buyer Name:\r\n");
	lblBuyerName.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblBuyerName.setBounds(30, 58, 264, 24);
	panel_3.add(lblBuyerName);
	
	JLabel lblPhoneNumber = new JLabel("Phone Number:\r\n");
	lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblPhoneNumber.setBounds(30, 102, 264, 24);
	panel_3.add(lblPhoneNumber);
	
	JLabel lblEmail_2 = new JLabel("Email:");
	lblEmail_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblEmail_2.setBounds(30, 152, 264, 24);
	panel_3.add(lblEmail_2);
	
	JLabel lblTotalItemCount = new JLabel("Total Item Count:\r\n");
	lblTotalItemCount.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblTotalItemCount.setBounds(750, 58, 264, 24);
	panel_3.add(lblTotalItemCount);
	
	JLabel lblICount = new JLabel("\r\n");
	lblICount.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblICount.setBounds(1038, 58, 238, 24);
	panel_3.add(lblICount);
	
	JLabel lblTotalCost = new JLabel("Total Cost:\r\n");
	lblTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblTotalCost.setBounds(750, 152, 264, 24);
	panel_3.add(lblTotalCost);
	
	JLabel lblTCost = new JLabel("");
	lblTCost.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblTCost.setBounds(1038, 152, 238, 24);
	panel_3.add(lblTCost);
	
	
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
	
	Connection conn = null;
	Statement stmt = null;
	
	String phn;
	String username;
	try {
		//Step 2: Register JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step 3: Open a connection

		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
		stmt = conn.createStatement();
		String sql = "Select username,phn,email from  user where email = \""+uEmail+"\"";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			phn = rs.getString(2);
			username = rs.getString(1);
			lblName.setText(username);
			lblPhn.setText(phn);
			lblEmail.setText(uEmail);
		}
		
		String sql2 = "Select sum(item_count),sum(item_count*prize) from cart";
		rs = stmt.executeQuery(sql2);
		if(rs.next()) {
			lblICount.setText(rs.getString(1));
			lblTCost.setText("Rs. "+rs.getString(2));
		}
	}
	catch (SQLException sqlException) {
        sqlException.printStackTrace();
    } catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	}
}