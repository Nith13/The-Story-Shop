package hanBooks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

public class summary extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Bookstore";
	
	//Database credentials
	static final String USER = "root";
	static final String PASS = "breakthecode";
	private JButton btnReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*summary frame = new summary("Test");
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public summary(String uEmail) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logobookstore.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,180,600,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(1, 1, 575, 411);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setFillsViewportHeight(true);
		contentPane.add(table);
		

		
		JButton btnNewButton = new JButton("PROCEED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new checkout(uEmail).setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(76, 422, 140, 31);
		contentPane.add(btnNewButton);
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String[] columnNames = {"item_name","item_count", "prize"};
		try {
			//Step 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 3: Open a connection

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        
			DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columnNames);
	        
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        
	        String item_name = "";
	        int count = 0;
	        float prize = 0.0f;
	        
	        String sql2 = "SELECT * FROM CART";
	        
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql2);
	        int i = 0;
	        
	        String[] names = {"BOOKNAME","QUANTITY","PRIZE"};
	        model.addRow(names);
	        while (rs.next()) {
	        	item_name = rs.getString("item_name");
	        	count = rs.getInt("item_count");
	        	prize = rs.getFloat("prize");
	        	
	        	String []data = {item_name, String.valueOf(count), String.valueOf(prize)};
	        	model.addRow(data);
	        	++i;
	        }
	        if (i < 1) {
	        	JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
	        }
			table.setModel(model);
				
			btnReturn = new JButton("RETURN");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Cart(uEmail).setVisible(true);
				}
			});
				btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 19));
				btnReturn.setBounds(351, 422, 140, 31);
				contentPane.add(btnReturn);
		}
		catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch (Exception e1) {
			//Handle errors for Class.forName
			e1.printStackTrace();
		}
	}
}
