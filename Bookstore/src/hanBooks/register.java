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

public class register extends JFrame {

	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bookstore";
	
	//Database credentials
	static final String USER = "root";
	static final String PASS = "breakthecode";
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtNo;
	private JTextField txtMail;
	private JButton register;
	private JPasswordField txtPass;
	private JPasswordField txtConfirmPass;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
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
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 140, 96, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContactNo.setBounds(270, 154, 125, 34);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(460, 154, 96, 28);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(639, 154, 120, 28);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(853, 154, 167, 28);
		contentPane.add(lblConfirmPassword);
		
		txtName = new JTextField();
		txtName.setBounds(102, 213, 96, 43);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtNo = new JTextField();
		txtNo.setColumns(10);
		txtNo.setBounds(270, 213, 125, 43);
		contentPane.add(txtNo);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(460, 213, 96, 43);
		contentPane.add(txtMail);
		
		register = new JButton("Register");
		register.setFont(new Font("Tahoma", Font.PLAIN, 19));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				int phn = Integer.parseInt(txtNo.getText());
				String email = txtMail.getText();
				String password = new String(txtPass.getPassword());
				String cPassword = new String(txtConfirmPass.getPassword());
				int user_id =0;
				
				if(password.equals(cPassword)){
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					try {
						//Step 2: Register JDBC driver
						Class.forName("com.mysql.cj.jdbc.Driver");
						//Step 3: Open a connection

						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						
						
						stmt = conn.createStatement();
						
						String sql2 = "SELECT * FROM USER";
				        rs = stmt.executeQuery(sql2);
				        
				        while(rs.next()) {
				        	user_id = rs.getInt("user_id");
				        }
				        user_id++;
				        
						String sql = "INSERT INTO USER VALUES("+user_id+",\""+name+"\","+phn+",\""+email+"\",\""+password+"\")";
						
						stmt.execute(sql);
						
						JOptionPane.showMessageDialog(null, "Registration successful");
						setVisible(false);
						new login().setVisible(true);
					}
					catch(SQLException se) {
						//Handle errors for JDBC
						se.printStackTrace();
					}
					catch (Exception e1) {
						//Handle errors for Class.forName
						e1.printStackTrace();
					}
					finally {
						//end finally try
					}//end try
				}
				else {
					JOptionPane.showMessageDialog(null,"Password Mismatch", "Error", JOptionPane.WARNING_MESSAGE, null);
					txtPass.setText("");
					txtConfirmPass.setText("");
				}
			}
		});
		register.setBounds(512, 329, 113, 43);
		contentPane.add(register);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(639, 213, 120, 43);
		contentPane.add(txtPass);
		
		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setBounds(853, 213, 140, 43);
		contentPane.add(txtConfirmPass);
		
		lblNewLabel_1 = new JLabel("The Story Shop");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new homepage().setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(51, 102, 51));
		lblNewLabel_1.setBounds(-10, 10, 1540, 78);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91885\\eclipse-workspace\\Bookstore\\src\\views\\icons8-home-page-96.png"));
		btnNewButton_1.setToolTipText("Logout");
		btnNewButton_1.setBounds(1345, 10, 92, 78);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1_1 = new JLabel("The Story Shop");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 40));
		lblNewLabel_1_1.setBackground(new Color(51, 102, 51));
		lblNewLabel_1_1.setBounds(10, 696, 1520, 78);
		contentPane.add(lblNewLabel_1_1);
	}
}
