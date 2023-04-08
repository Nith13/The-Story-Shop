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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Toolkit;

public class Cart extends JFrame {

private JPanel contentPane;

//JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/Bookstore";

//Database credentials
static final String USER = "root";
static final String PASS = "breakthecode";

/**

* Launch the application.

*/

public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {	
				Cart frame = new Cart();
				frame.setVisible(true);
			}	 catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**

* Create the frame.

*/

public Cart() {
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logobookstore.png"));

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setBounds(100, 50, 1300, 700);

contentPane = new JPanel();

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);

contentPane.setLayout(null);


JPanel panel = new JPanel();

panel.setBackground(new Color(255, 255, 51));

panel.setBounds(0, 0, 1286, 75);

contentPane.add(panel);

panel.setLayout(null);


JLabel lblNewLabel = new JLabel("SHOPPING CART");

lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

lblNewLabel.setBounds(23, 20, 151, 33);

panel.add(lblNewLabel);


JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
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
		dispose();
		new homepage().setVisible(true);
	}
});
lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logout-4 (1).png"));

lblNewLabel_1.setForeground(Color.BLACK);

lblNewLabel_1.setBackground(Color.GRAY);

lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_1.setBounds(1193, 0, 83, 75);

panel.add(lblNewLabel_1);


JPanel panel_1 = new JPanel();

panel_1.setBounds(0, 73, 1286, 486);

contentPane.add(panel_1);

panel_1.setLayout(null);


JPanel panel_3 = new JPanel();

panel_3.setBackground(Color.LIGHT_GRAY);

panel_3.setBounds(0, 0, 512, 519);

panel_1.add(panel_3);

panel_3.setLayout(null);


JLabel lblNewLabel_2_1 = new JLabel("BOOKS");

lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));

lblNewLabel_2_1.setBounds(160, 24, 196, 32);

panel_3.add(lblNewLabel_2_1);


JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setIcon(new ImageIcon("/home/adi/Documents/MCA/SEM 3/java/image2.jpg"));

lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));

lblNewLabel_2.setBounds(0, -9, 512, 495);

panel_3.add(lblNewLabel_2);


JPanel panel_3_1 = new JPanel();

panel_3_1.setBackground(new Color(255, 255, 255));

panel_3_1.setBounds(511, 0, 775, 486);

panel_1.add(panel_3_1);

panel_3_1.setLayout(null);


JLabel lblNewLabel_2_2 = new JLabel("PRICE");

lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 30));

lblNewLabel_2_2.setBounds(46, 31, 166, 32);

panel_3_1.add(lblNewLabel_2_2);


JLabel lblNewLabel_2_2_1 = new JLabel("QUANTITY");

lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));

lblNewLabel_2_2_1.setBounds(315, 31, 181, 32);

panel_3_1.add(lblNewLabel_2_2_1);


JLabel lblNewLabel_2_2_1_1 = new JLabel("TOTAL");

lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));

lblNewLabel_2_2_1_1.setBounds(570, 31, 173, 32);

panel_3_1.add(lblNewLabel_2_2_1_1);


JPanel panel_2 = new JPanel();

panel_2.setBackground(new Color(255, 255, 51));

panel_2.setBounds(0, 558, 1286, 102);

contentPane.add(panel_2);

panel_2.setLayout(null);

JCheckBox chkAgree = new JCheckBox("AGREE TO TERMS & CONDITIONS");
chkAgree.setBackground(new Color(255, 255, 51));

chkAgree.setFont(new Font("Tahoma", Font.PLAIN, 15));

chkAgree.setBounds(594, 35, 277, 31);

panel_2.add(chkAgree);


JButton btnNewButton = new JButton("PURCHASE");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(chkAgree.isSelected()) {
			dispose();
			new summary().setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Please Agree to Terms");
		}
	}
});
btnNewButton.setForeground(new Color(255, 255, 255));
btnNewButton.setBackground(new Color(0, 0, 0));

btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));

btnNewButton.setBounds(1057, 34, 185, 45);

panel_2.add(btnNewButton);


JLabel lblNewLabel_3_3 = new JLabel("TOTAL Prize  : ");

lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);

lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 19));

lblNewLabel_3_3.setBounds(65, 35, 208, 32);

panel_2.add(lblNewLabel_3_3);
JLabel lblTotal = new JLabel("");
lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
lblTotal.setBounds(345, 43, 118, 23);
panel_2.add(lblTotal);



Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
	//Step 2: Register JDBC driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//Step 3: Open a connection
	System.out.println("Connecting to selected database");
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	System.out.println("Connected database succesfully");
	//Step 4: Execute a query
	
	stmt = conn.createStatement();
	String sql2 = "SELECT * FROM CART";
	
	rs = stmt.executeQuery(sql2);
	
	String item_name="";
	float prize = 0.0f;
	String Sprize;
	int count = 0;
	String Scount;
	float total = 0.0f;
	String Stotal;
	int i =0;
	float total_cost = 0.0f;
	
	int heightB= 70, heightP =70 , heightC =70, heightT =70;
	
	while(rs.next()) {
		item_name = rs.getString("item_name");
		JLabel lbl1 = new JLabel();
		lbl1.setText(item_name);
		lbl1.setBounds(130, heightB, 300, 32);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lbl1);
		heightB = heightB+42;
		
		prize = rs.getFloat("prize");
		Sprize = String.valueOf(prize);
		JLabel lbl2 = new JLabel();
		lbl2.setText(Sprize);
		lbl2.setBounds(92, heightP, 86, 32);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_1.add(lbl2);
		heightP = heightP+42;
		
		count = rs.getInt("item_count");
		Scount = String.valueOf(count);
		JLabel lbl3 = new JLabel();
		lbl3.setText(Scount);
		lbl3.setBounds(353, heightC, 86, 32);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_1.add(lbl3);
		heightC = heightC+42;
		
		total = prize*count;
		total_cost += total;
		Stotal = String.valueOf(total);
		JLabel lbl4 = new JLabel();
		lbl4.setText(Stotal);
		lbl4.setBounds(609, heightT, 86, 32);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_1.add(lbl4);
		heightT = heightT+42;
	}
	lblTotal.setText(String.valueOf(total_cost));
	
	JLabel lblNewLabel_3 = new JLabel("Rs.");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblNewLabel_3.setBounds(283, 40, 45, 26);
	panel_2.add(lblNewLabel_3);
}
catch(SQLException se) {
	//Handle errors for JDBC
	se.printStackTrace();
}
catch (Exception e) {
	//Handle errors for Class.forName
	e.printStackTrace();
}

}
}