package hanBooks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Home extends JFrame {

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
					Home frame = new Home();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logobookstore.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1650,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setToolTipText("Go to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Cart().setVisible(true);
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setToolTipText("The Subtle Art of Not giving a Fuck");
		panel_8.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_8.setBounds(650, 447, 230, 349);
		contentPane.add(panel_8);
		
		JLabel lblNewLabel_2_8 = new JLabel("");
		lblNewLabel_2_8.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-10.jpg"));
		lblNewLabel_2_8.setToolTipText("The Subtle Art of Not giving A Fuck");
		lblNewLabel_2_8.setBounds(20, 10, 188, 280);
		panel_8.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_3_8 = new JLabel("Rs. 399.00");
		lblNewLabel_3_8.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_8.setBounds(87, 300, 67, 13);
		panel_8.add(lblNewLabel_3_8);
		
		JButton btnNewButton_2_8 = new JButton("Add to Cart");
		btnNewButton_2_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "RAM";
				int count = 0;
				float prize = 399.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_8.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_8.setBounds(60, 323, 113, 21);
		panel_8.add(btnNewButton_2_8);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setToolTipText("Atomic Habits");
		panel_7.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_7.setBounds(650, 88, 230, 349);
		contentPane.add(panel_7);
		
		JLabel lblNewLabel_2_7 = new JLabel("");
		lblNewLabel_2_7.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-3.jpg"));
		lblNewLabel_2_7.setToolTipText("ATOMIC HABITS");
		lblNewLabel_2_7.setBounds(20, 10, 188, 280);
		panel_7.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_3_7 = new JLabel("Rs. 549.00");
		lblNewLabel_3_7.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_7.setBounds(87, 300, 67, 13);
		panel_7.add(lblNewLabel_3_7);
		
		JButton btnNewButton_2_7 = new JButton("Add to Cart");
		btnNewButton_2_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "The Psychology of Money";
				int count = 0;
				float prize = 549.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_7.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_7.setBounds(60, 323, 113, 21);
		panel_7.add(btnNewButton_2_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setToolTipText("REACHER: KILLING FLOOR");
		panel_6.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_6.setBounds(969, 447, 230, 349);
		contentPane.add(panel_6);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-11.jpg"));
		lblNewLabel_2_6.setToolTipText("REACHER: KILLING FLOOR");
		lblNewLabel_2_6.setBounds(20, 10, 188, 280);
		panel_6.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_3_6 = new JLabel("Rs. 649.00");
		lblNewLabel_3_6.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(87, 300, 67, 13);
		panel_6.add(lblNewLabel_3_6);
		
		JButton btnNewButton_2_6 = new JButton("Add to Cart");
		btnNewButton_2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "The Immortals of Meluha";
				int count = 0;
				float prize = 649.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_6.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_6.setBounds(60, 323, 113, 21);
		panel_6.add(btnNewButton_2_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setToolTipText("The Immortals of Meluha");
		panel_5.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_5.setBounds(969, 88, 230, 349);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-3.png"));
		lblNewLabel_2_5.setToolTipText("The Immortals of Meluha");
		lblNewLabel_2_5.setBounds(20, 10, 188, 280);
		panel_5.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_3_5 = new JLabel("Rs. 399.00");
		lblNewLabel_3_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(87, 300, 67, 13);
		panel_5.add(lblNewLabel_3_5);
		
		JButton btnNewButton_2_5 = new JButton("Add to Cart");
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "The Subtle Art of Not Giving A F";
				int count = 0;
				float prize = 399.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_5.setBounds(60, 323, 113, 21);
		panel_5.add(btnNewButton_2_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setToolTipText("A DANCE WITH DRAGONS");
		panel_4.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_4.setBounds(331, 447, 230, 349);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-9.jpg"));
		lblNewLabel_2_4.setToolTipText("A DANCE WITH DRAGONS");
		lblNewLabel_2_4.setBounds(20, 10, 188, 280);
		panel_4.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Rs. 799.00");
		lblNewLabel_3_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(87, 300, 67, 13);
		panel_4.add(lblNewLabel_3_4);
		
		JButton btnNewButton_2_4 = new JButton("Add to Cart");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "Reacher : Killing Floor";
				int count = 0;
				float prize = 799.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_4.setBounds(60, 323, 113, 21);
		panel_4.add(btnNewButton_2_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setToolTipText("RAM: Scion of Ikshvaku");
		panel_3.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_3.setBounds(331, 88, 230, 349);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-2.jpg"));
		lblNewLabel_2_3.setToolTipText("RAM: Scion of Iskshvaku");
		lblNewLabel_2_3.setBounds(20, 10, 188, 280);
		panel_3.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Rs. 399.00");
		lblNewLabel_3_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(87, 300, 67, 13);
		panel_3.add(lblNewLabel_3_3);
		
		JButton btnNewButton_2_3 = new JButton("Add to Cart");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "IKIGAI";
				int count = 0;
				float prize = 399.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_3.setBounds(60, 323, 113, 21);
		panel_3.add(btnNewButton_2_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setToolTipText("The Terminal List");
		panel_2_1.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_2_1.setBounds(1281, 447, 230, 349);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-12.jpg"));
		lblNewLabel_2_2_1.setToolTipText("The Terminal List");
		lblNewLabel_2_2_1.setBounds(20, 10, 188, 280);
		panel_2_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Rs. 699.00");
		lblNewLabel_3_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_2_1.setBounds(87, 300, 67, 13);
		panel_2_1.add(lblNewLabel_3_2_1);
		
		JButton btnNewButton_2_2_1 = new JButton("Add to Cart");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "A Dance With Dragons";
				int count = 0;
				float prize = 699.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_2_1.setBounds(60, 323, 113, 21);
		panel_2_1.add(btnNewButton_2_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("The Psychology of Monet");
		panel_2.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_2.setBounds(1281, 88, 230, 349);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setToolTipText("The Psychology OfMoney");
		lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-5.jpg"));
		lblNewLabel_2_2.setBounds(20, 10, 188, 280);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Rs. 599.00");
		lblNewLabel_3_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(87, 300, 67, 13);
		panel_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_2_2 = new JButton("Add to Cart");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "Atomic Habits";
				int count = 0;
				float prize = 599.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_2.setBounds(60, 323, 113, 21);
		panel_2.add(btnNewButton_2_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("IKIGAI");
		panel_1.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel_1.setBounds(22, 447, 230, 349);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setToolTipText("IKIGAI");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-7.jpg"));
		lblNewLabel_2_1.setBounds(20, 10, 188, 280);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rs. 499.00");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(87, 300, 67, 13);
		panel_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_2_1 = new JButton("Add to Cart");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "The Terminal List";
				int count = 0;
				float prize = 499.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2_1.setBounds(60, 323, 113, 21);
		panel_1.add(btnNewButton_2_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(250, 250, 210), 3));
		panel.setToolTipText("Think Like A Monk");
		panel.setBounds(22, 88, 230, 349);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Think Like a Monk");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\book-1 (4).jpg"));
		lblNewLabel_2.setBounds(20, 10, 188, 280);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rs. 399.00");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3.setBounds(87, 300, 67, 13);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_name = "Think Like A Monk";
				int count = 0;
				float prize = 399.0f;
				int no_of_books = 0;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					
					String sql = "Select * from cart ";
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						no_of_books++;
					}

					if(no_of_books<11) {
						String sql1 = "Select * from cart where item_name = \""+item_name+"\"";
						ResultSet rs = stmt.executeQuery(sql1);
						
						if(rs.next()) {
			            	count = rs.getInt("item_count");
			            	item_name = rs.getString("item_name");
			            	count++;
			            	String sql2 = "UPDATE CART SET ITEM_COUNT = "+count+" WHERE ITEM_NAME =\""+item_name+"\"";
			            	stmt.execute(sql2);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
						else {
							count++;
							String sql3 = "INSERT INTO CART VALUES(\""+item_name+"\","+count+","+prize+")";
							stmt.execute(sql3);
							JOptionPane.showMessageDialog(contentPane, "Item Added to Cart");
			            }
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "You can buy maximum 4 type of books at once");
						dispose();
						new Cart().setVisible(true);					
					}
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}		
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2.setBounds(60, 323, 113, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
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
				dispose();
				new homepage().setVisible(true);
			}
		});
		btnNewButton_1.setToolTipText("Logout");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logout-4 (1).png"));
		btnNewButton_1.setBounds(1355, 0, 92, 78);
		contentPane.add(btnNewButton_1);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\cart-2-removebg-preview (2).png"));
		btnNewButton.setBounds(1193, 0, 92, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\Brown Minimalist Quotes Desktop Wallpaper (2).png"));
		lblNewLabel.setBounds(0, 77, 1540, 768);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The Story Shop");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 40));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(51, 102, 51));
		lblNewLabel_1.setBounds(0, 0, 1540, 78);
		contentPane.add(lblNewLabel_1);
	}
}
