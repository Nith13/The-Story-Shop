package hanBooks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class login extends JFrame {

	
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bookstore";
	
	//Database credentials
	static final String USER = "root";
	static final String PASS = "breakthecode";
	
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("THE STORY SHOP");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\logobookstore.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(1650,1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Login ID");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(610, 126, 123, 25);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(610, 195, 147, 25);
		contentPane.add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(861, 130, 162, 25);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = txtEmail.getText();
				String password = new String(txtPass.getPassword());
				
				Connection conn = null;
				Statement stmt = null;
				try {
					//Step 2: Register JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Step 3: Open a connection

					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
		            //stmt = conn.createStatement();
		            					
		            PreparedStatement pst = (PreparedStatement) conn
	                        .prepareStatement("Select email, password from user where email=? and password=?");

	                    pst.setString(1, email);
	                    pst.setString(2, password);
	                    ResultSet rs = pst.executeQuery();
	                    if (rs.next()) {
	                        JOptionPane.showMessageDialog(contentPane, "You have successfully logged in");
	                        dispose();
	                        new Home().setVisible(true);            	
	                    } else {
	                        JOptionPane.showMessageDialog(contentPane, "Wrong Username & Password");
	                        txtEmail.setText("");
	                        txtPass.setText("");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                } catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}				
			}
		});
		btnNewButton.setBounds(705, 274, 169, 67);
		contentPane.add(btnNewButton);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(861, 199, 162, 25);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_1 = new JLabel("The Story Shop");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new homepage().setVisible(true);
				}
		});
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(51, 102, 51));
		lblNewLabel_1.setBounds(10, 10, 1540, 78);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\icons8-home-page-96.png"));
		btnNewButton_1_1.setToolTipText("Logout");
		btnNewButton_1_1.setBounds(1365, 10, 92, 78);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("The Story Shop");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 40));
		lblNewLabel_1_1.setBackground(new Color(51, 102, 51));
		lblNewLabel_1_1.setBounds(10, 695, 1520, 78);
		contentPane.add(lblNewLabel_1_1);
	}
}
