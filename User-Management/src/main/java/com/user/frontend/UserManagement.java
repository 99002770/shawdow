package com.user.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.model.Address;
import com.user.model.Authentication;
import com.user.model.User;
import com.user.service.RegisterService;
import com.user.service.RegisterServiceImpl;
@Component
public class UserManagement extends JFrame{
	@Autowired
    RegisterService userService = new RegisterServiceImpl();
    User user=new User();

//	@Autowired(required=true)
	
    //User =new User();
    Address  address=new Address();
    Authentication authentication=new Authentication();
    
	JLabel label, label1;
	JFrame frame;
	JLabel Email, password, Confirmpassword, Firstname, Middlename, Lastname, Mobilenumber, Gender, country, state,
	city, pincode;
    JLabel emailval, passwordVal1, passwordVal, ConfirmpasswordVal, firstNameVal, MiddlenameVal, lastnameVal,
	MobilenumberVal, countryVal, cityVal, pincodeVal;
   JTextField firstname, middlename, lastname, email, mobilenumber, Country, City,  Pincode;
   JPasswordField Password, ConfirmPassword;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagement window = new UserManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserManagement () {
		 Main();
	}

	private void Main() {
		// TODO Auto-generated method stub
		
	setVisible(true);

		label = new JLabel("USER REGISTRATION");
		label.setBounds(700, 100, 400, 100);
		label.setFont(new Font("Verdana", Font.PLAIN, 30));
		add(label);
		// title.setFont(new Font("Verdana", Font.PLAIN, 18));

		label1 = new JLabel(
				"(New users should register and already registered users can login using valid credentials)");
		label1.setBounds(420, 200, 1000, 50);
		label1.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(label1);

		JButton signin = new JButton("Sign In");
		signin.setBounds(730, 500, 200, 50);
		// signin.setSize(50, 50);
		add(signin);

		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 Login();
				 frame.dispose();
			}
		});

		JButton register = new JButton("Register");
		register.setBounds(730, 550, 200, 50);
		// register.setSize(50, 50);
		add(register);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 Form();
				 frame.dispose();
			}
		});

		setSize(800, 800);
		setLayout(null);
		setBackground(Color.pink);

		
	}
	
	private void Form() {
		setVisible(true);

		Email = new JLabel(" Enter Email");
		Email.setBounds(50, 100, 250, 30);
		add(Email);

		email = new JTextField();
		email.setBounds(200, 100, 250, 30);
		add(email);

		JLabel password = new JLabel("Enter Password");
		password.setBounds(50, 200, 120, 30);
		add(password);

		Password = new JPasswordField();
		Password.setBounds(200, 200, 250, 30);
		add(Password);

		JLabel Confirmpassword = new JLabel("Confirm Password");
		Confirmpassword.setBounds(50, 300, 120, 30);
		add(Confirmpassword);

		ConfirmPassword = new JPasswordField();
		ConfirmPassword.setBounds(200, 300, 250, 30);
		add(ConfirmPassword);

		Firstname = new JLabel("First name");
		Firstname.setBounds(50, 400, 250, 30);
		add(Firstname);

		firstname = new JTextField();
		firstname.setBounds(200, 400, 250, 30);
		add(firstname);

		Middlename = new JLabel("Middle name");
		Middlename.setBounds(50, 500, 250, 30);
		add(Middlename);

		middlename = new JTextField();
		middlename.setBounds(200, 500, 250, 30);
		add(middlename);

		Lastname = new JLabel("Last name");
		Lastname.setBounds(50, 600, 250, 30);
		add(Lastname);

		lastname = new JTextField();
		lastname.setBounds(200, 600, 250, 30);
		add(lastname);

		Mobilenumber = new JLabel("Mobile number");
		Mobilenumber.setBounds(550, 100, 250, 30);
		add(Mobilenumber);

		mobilenumber = new JTextField();
		mobilenumber.setBounds(700, 100, 250, 30);
		add(mobilenumber);

		Gender = new JLabel("Gender");
		Gender.setBounds(550, 200, 250, 30);
		add(Gender);

		JRadioButton r1 = new JRadioButton("Male");
		r1.setActionCommand("Male");
		JRadioButton r2 = new JRadioButton("Female");
		r2.setActionCommand("Female");

		r1.setBounds(700, 200, 200, 30);
		r2.setBounds(950, 200, 200, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		add(r1);
		add(r2);

		state = new JLabel("Select state");
		state.setBounds(550, 300, 300, 30);
		add(state);

		JComboBox State = new JComboBox();
		State.setBounds(700, 300, 200, 30);
		State.setModel(new DefaultComboBoxModel(new String[] { "--Select--", "Andhra Pradesh", "Arunchal Pradesh",
				"Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
				"Karnataka", "Kerala", "Madhaya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
				"Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh",
				"Uttarakhand", "West Bengal", "Andaman & Nicobar", "Chandigarh", "Dadra & Nagar Haveli & Daman & Diu",
				"Delhi", "Jammu & Kashmir", "Ladakh", "Lakshadweep", "Puducherry" }));
		add(State);

		country = new JLabel("Enter country");
		country.setBounds(550, 400, 250, 30);
		add(country);

		 Country = new JTextField();
		 Country.setBounds(700, 400, 250, 30);
		add( Country);

		city = new JLabel("Enter city");
		city.setBounds(550, 500, 250, 30);
		add(city);

		City = new JTextField();
		City.setBounds(700, 500, 250, 30);
		add(City);

		pincode = new JLabel("Enter pincode");
		pincode.setBounds(550, 600, 250, 30);
		add(pincode);

		Pincode = new JTextField();
		Pincode.setBounds(700, 600, 250, 30);
		add(Pincode);

		JButton register = new JButton("Register");
		register.setBounds(450, 750, 100, 30);
		add(register);
		register.setEnabled(false);

		JButton Reset = new JButton("Reset");
		Reset.setBounds(550, 750, 100, 30);
		add(Reset);
		
		JButton signin = new JButton("Login");
		signin.setBounds(650, 750, 100, 30);
		add(signin);
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Login();
			}
		});

		JButton home = new JButton("Home");
		home.setBounds(50, 50, 100, 30);
		add(home);

		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				Main();
				//home.setVisible(true);
				dispose();

			}
		});

		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				firstname.setText("");
				middlename.setText("");
				lastname.setText("");
				email.setText("");
				Password.setText("");
				ConfirmPassword.setText("");
				mobilenumber.setText("");
				City.setText("");
				Pincode.setText("");
				 Country.setText("");
			}
		});



		// validation for password
		passwordVal = new JLabel("Please Enter strong password");
		passwordVal.setForeground(Color.RED);
		passwordVal.setBounds(200, 220, 250, 30);
		add(passwordVal);
		passwordVal.setVisible(false);

		Password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Password.setEditable(true);

			}

			@Override
			public void focusLost(FocusEvent e) {

				if ((Password.getText().length() == 0)) {
					Password.setBorder(new LineBorder(Color.red, 1));
					passwordVal.setVisible(true);
				}

			}
		});

		Password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Password.setEditable(true);
			}

			@Override
			public void focusLost(FocusEvent e) {

				String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])";
				Pattern p = Pattern.compile(regex);

				Matcher m = p.matcher(Password.getText());
				if (!m.matches() && Password.getText().length() < 8) {
					Password.setBorder(new LineBorder(Color.red, 1));
					passwordVal.setVisible(true);

				} else {
					Password.setBorder(new LineBorder(Color.gray, 1));
					passwordVal.setVisible(false);
				}
			}
		});

		Password.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}
			}
		});

		// validation for Confirm password
		ConfirmpasswordVal = new JLabel("Password does not match");
		ConfirmpasswordVal.setForeground(Color.RED);
		ConfirmpasswordVal.setBounds(200, 320, 250, 30);
		add(ConfirmpasswordVal);
		ConfirmpasswordVal.setVisible(false);

		ConfirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ConfirmPassword.setEditable(true);

			}

			@Override
			public void focusLost(FocusEvent e) {

				if ((ConfirmPassword.getText().length() == 0)) {
					ConfirmPassword.setBorder(new LineBorder(Color.red, 1));
					ConfirmpasswordVal.setVisible(true);
				}

			}
		});

		ConfirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ConfirmPassword.setEditable(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (!Arrays.equals(Password.getPassword(), ConfirmPassword.getPassword())) {

					// e.consume();
					System.out.println(Password.getPassword());
					System.out.println(ConfirmPassword.getPassword());
					ConfirmPassword.setBorder(new LineBorder(Color.red, 1));
					ConfirmpasswordVal.setVisible(true);
				} else {
					ConfirmPassword.setBorder(new LineBorder(Color.gray, 1));

					ConfirmpasswordVal.setVisible(false);
				}
			}
		});

		ConfirmPassword.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}
			}
		});

//validation for first name
		firstNameVal = new JLabel("Please Enter first Name");
		firstNameVal.setForeground(Color.RED);
		firstNameVal.setBounds(200, 420, 250, 30);
		add(firstNameVal);
		firstNameVal.setVisible(false);

		firstname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				firstname.setEditable(true);

			}

			@Override
			public void focusLost(FocusEvent e) {

				if ((firstname.getText().length() == 0)) {
					firstname.setBorder(new LineBorder(Color.red, 1));
					firstNameVal.setVisible(true);
				}

			}
		});

		firstname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (!(firstname.getText().length() == 0)) {
					firstname.setBorder(new LineBorder(Color.gray, 1));
					firstNameVal.setVisible(false);
				}

				if (firstname.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "only 20 characters allowed");
					// tf1.setText("");
				}
			}

		});
		firstname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				char ch = e.getKeyChar();
				if (!(Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					firstname.setBorder(new LineBorder(Color.red, 1));
					firstNameVal.setVisible(true);
				} else {
					firstname.setBorder(new LineBorder(Color.gray, 1));
					firstNameVal.setVisible(false);
				}
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}

			}
		});

		// validation for middle name
		MiddlenameVal = new JLabel("Please Enter  Middlename");
		MiddlenameVal.setForeground(Color.RED);
		MiddlenameVal.setBounds(200, 520, 250, 30);
		add(MiddlenameVal);
		MiddlenameVal.setVisible(false);

		middlename.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (!(middlename.getText().length() == 0)) {
					middlename.setBorder(new LineBorder(Color.gray, 1));
					MiddlenameVal.setVisible(false);
				}

				if (middlename.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "only 20 characters allowed");
					// tf1.setText("");
				}
			}

		});
		middlename.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				char ch = e.getKeyChar();
				if (!(Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					middlename.setBorder(new LineBorder(Color.red, 1));
					MiddlenameVal.setVisible(true);
				} else {
					middlename.setBorder(new LineBorder(Color.gray, 1));
					MiddlenameVal.setVisible(false);
				}

			}
		});

		// validation for last name
		lastnameVal = new JLabel("Please Enter last Name");
		lastnameVal.setForeground(Color.RED);
		lastnameVal.setBounds(200, 620, 250, 30);
		add(lastnameVal);
		lastnameVal.setVisible(false);

		lastname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastname.setEditable(true);

			}

			@Override
			public void focusLost(FocusEvent e) {

				if ((lastname.getText().length() == 0)) {
					lastname.setBorder(new LineBorder(Color.red, 1));
					lastnameVal.setVisible(true);
				}

			}
		});

		lastname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (!(lastname.getText().length() == 0)) {
					lastname.setBorder(new LineBorder(Color.gray, 1));
					lastnameVal.setVisible(false);
				}

				if (lastname.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "only 20 characters allowed");
					// tf1.setText("");
				}
			}

		});
		lastname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				char ch = e.getKeyChar();
				if (!(Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					lastname.setBorder(new LineBorder(Color.red, 1));
					lastnameVal.setVisible(true);
				} else {
					lastname.setBorder(new LineBorder(Color.gray, 1));
					lastnameVal.setVisible(false);
				}
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}

			}
		});

//Validation for Mobile number
		MobilenumberVal = new JLabel("Please Enter valid number");
		MobilenumberVal.setForeground(Color.RED);
		MobilenumberVal.setBounds(700, 120, 250, 30);
		add(MobilenumberVal);
		MobilenumberVal.setVisible(false);

		mobilenumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				mobilenumber.setEditable(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if ((mobilenumber.getText().length() > 10 || mobilenumber.getText().length() < 10))

				{
					mobilenumber.setBorder(new LineBorder(Color.red, 1));
					MobilenumberVal.setVisible(true);
				} else {
					mobilenumber.setBorder(new LineBorder(Color.gray, 1));
					MobilenumberVal.setVisible(false);
				}

			}
		});

		mobilenumber.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char ch = e.getKeyChar();
				if (mobilenumber.getText().length() == 10) {

					mobilenumber.setBorder(new LineBorder(Color.gray, 1));

					MobilenumberVal.setVisible(false);

				}
				if ((Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					mobilenumber.setBorder(new LineBorder(Color.red, 1));
					MobilenumberVal.setVisible(true);

				} else {
					mobilenumber.setBorder(new LineBorder(Color.gray, 1));

				}
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}
			}

		});

		mobilenumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if ((mobilenumber.getText().length() > 9 || (ch == KeyEvent.VK_BACK_SPACE)
						|| ch == KeyEvent.VK_DELETE)) {
					e.consume();
					mobilenumber.setBorder(new LineBorder(Color.gray, 1));
					MobilenumberVal.setVisible(false);
				}
			}

		});

//Validation for City
		cityVal = new JLabel("Please Enter city name");
		cityVal.setForeground(Color.RED);
		cityVal.setBounds(700, 520, 250, 30);
		add(cityVal);
		cityVal.setVisible(false);

		City.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				char ch = e.getKeyChar();
				if (!(Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					City.setBorder(new LineBorder(Color.red, 1));
					cityVal.setVisible(true);
				} else {
					City.setBorder(new LineBorder(Color.gray, 1));
					cityVal.setVisible(false);
				}
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}

			}
		});

//Validation for Country

		countryVal = new JLabel("Please Enter country name");
		countryVal.setForeground(Color.RED);
		countryVal.setBounds(700, 420, 250, 30);
		add(countryVal);
		countryVal.setVisible(false);

		 Country.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				char ch = e.getKeyChar();
				if (!(Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					 Country.setBorder(new LineBorder(Color.red, 1));
					 countryVal.setVisible(true);
				} else {
					 Country.setBorder(new LineBorder(Color.gray, 1));
					 countryVal.setVisible(false);
				}

			}
		});
		
		 Country.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (!( Country.getText().length() == 0)) {
					 Country.setBorder(new LineBorder(Color.gray, 1));
					 countryVal.setVisible(false);
				}

				if ( Country.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "only 20 characters allowed");
					// tf1.setText("");
				}
			}

		});

//Validation for pin code
		pincodeVal = new JLabel("Please Enter valid pincode");
		pincodeVal.setForeground(Color.RED);
		pincodeVal.setBounds(700, 620, 250, 30);
		add(pincodeVal);
		pincodeVal.setVisible(false);

		Pincode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Pincode.setEditable(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if ((Pincode.getText().length() > 10 || Pincode.getText().length() < 6))

				{
					Pincode.setBorder(new LineBorder(Color.red, 1));
					pincodeVal.setVisible(true);
				} else {
					Pincode.setBorder(new LineBorder(Color.gray, 1));
					pincodeVal.setVisible(false);
				}

			}
		});

		Pincode.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char ch = e.getKeyChar();
				if (Pincode.getText().length() == 6) {

					Pincode.setBorder(new LineBorder(Color.gray, 1));

					pincodeVal.setVisible(false);

				}
				if ((Character.isLetter(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					Pincode.setBorder(new LineBorder(Color.red, 1));
					pincodeVal.setVisible(true);

				} else {
					Pincode.setBorder(new LineBorder(Color.gray, 1));

				}
				if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
						&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
						&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
						&& (Password.getText().length() != 0)) {
					register.setEnabled(true);
				} else {
					register.setEnabled(false);
				}
			}

		});

		Pincode.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if ((Pincode.getText().length() > 5 || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE)) {
					e.consume();
					Pincode.setBorder(new LineBorder(Color.gray, 1));
					pincodeVal.setVisible(false);
				}
			}

		});
		//validation for email
				emailval = new JLabel("Please Enter valid Email");
				emailval.setForeground(Color.RED);
				emailval.setBounds(200, 120, 250, 30);
				add(emailval);
				emailval.setVisible(false);

				email.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						email.setEditable(true);

					}

					@Override
					public void focusLost(FocusEvent e) {

						if ((email.getText().length() == 0)) {
							email.setBorder(new LineBorder(Color.red, 1));
							emailval.setVisible(true);
						}

					}
				});

				email.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						if ((firstname.getText().toString() != null) && (lastname.getText().length() != 0)
								&& (email.getText().length() != 0) && (mobilenumber.getText().length() != 0)
								&& (Pincode.getText().length() != 0) && (ConfirmPassword.getText().length() != 0)
								&& (Password.getText().length() != 0)) {
							register.setEnabled(true);
						} 
						else 
						{
							register.setEnabled(false);
						}
					}
				});

				email.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						email.setEditable(true);
					}

					@Override
					public void focusLost(FocusEvent e) {
						String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
								+ "A-Z]{2,7}$";
						Pattern p = Pattern.compile(regex);
						Matcher m = p.matcher(email.getText());
						if (!m.matches()) {

							email.setBorder(new LineBorder(Color.red, 1));
							emailval.setVisible(true);

						} else {
							email.setBorder(new LineBorder(Color.gray, 1));
							emailval.setVisible(false);
						}

					}
				});

		email.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (email.getText().length() != 0) {
					int source = 0;
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/form", "root",
								"root@1234");
						PreparedStatement ps = connection.prepareStatement("select Email from user where Email= ?");
						ps.setString(1, email.getText());
						ResultSet rs = ps.executeQuery();
						if (rs.next()) {
							source = 1;
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (source == 1) {
						JOptionPane.showMessageDialog(null, "user exists");
						register.setEnabled(false);

					} else {
						//register.setEnabled(true);
					}

				}
			}
		});
	
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setFirstname(firstname.getText());
	            user.setMiddlename(middlename.getText());
	            user.setLastname(lastname.getText());
	            user.setEmailid(email.getText());
	            user.setGender(bg.getSelection().getActionCommand().toString());
	            user.setMobilenumber(mobilenumber.getText());
	            authentication.setEmailid(email.getText());
	            authentication.setPassword(Password.getText());
	            address.setCity( City.getText());
	            address.setEmailid(email.getText());
	            address.setState(State.getSelectedItem().toString());
	            address.setPincode(Pincode.getText());

                 authentication. setConfirm(ConfirmPassword.getText());

	 

	             String msg = "" + firstname;
	             msg += " \n";
	             userService.saveData(user,address,authentication);

			}
		});

		setSize(800, 800);
		setLayout(null);
		setBackground(Color.pink);
	}
	
	
		
	
private void Login() {
	setVisible(true);
	setSize(800, 800);
	setLayout(null);
	setBackground(Color.pink);

	Email = new JLabel(" Enter Email");
	Email.setBounds(550, 250, 250, 30);
	add(Email);

	email = new JTextField();
	email.setBounds(650, 250, 250, 30);
	add(email);

	JLabel password = new JLabel("Enter Password");
	password.setBounds(550, 350, 120, 30);
	add(password);

	Password = new JPasswordField();
	Password.setBounds(650, 350, 250, 30);
	add(Password);
	
	JLabel Signin = new JLabel("SIGN IN");
	Signin.setBounds(700, 150, 200, 30);
	Signin.setFont(new Font("Verdana", Font.PLAIN, 30));
	add(Signin);

	JButton signin = new JButton("Login");
	signin.setBounds(730, 500, 100, 40);
	add(signin);
	
	JLabel SignIn = new JLabel("New user? Register here");
	SignIn.setBounds(700, 570, 300, 30);
	add(SignIn);
	
	JButton register = new JButton("Register");
	 register.setBounds(730, 600, 100, 50);
	// signin.setSize(50, 50);
	add( register);
	
	register.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			Form();
			frame.dispose();
		}
	});


	

	signin.addActionListener(new ActionListener() {

		 

        public void actionPerformed(ActionEvent e) {
            String Email = email.getText();
            String password = Password.getText();
     
            
          try {
                 if((email.getText().length()==0)||(Password.getText().length()==0)) {
                     JOptionPane.showMessageDialog(signin, "Enter Username & Password");
                     //login.setEnabled(false);
                 }
                 
                 if((email.getText().length()!=0)&&(Password.getText().length()!=0)){
                     //login.setEnabled(true);
                	 authentication.setEmailid(email.getText());
                	 authentication.setPassword(Password.getText());
                    if(userService.authenticate(authentication)) {
                        System.out.println("Logged in");
                        frame.dispose();
                        Operations();
//                    
                        
                    }
                    else {
                          JOptionPane.showMessageDialog(signin, "Wrong Email & Password");
                    }
                 }
          }
             catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    });    
 }
private void Operations() {	
	frame = new JFrame();
	frame.setVisible(true);

	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JButton btnNewButton = new JButton("Edit");
	btnNewButton.setBackground(new Color(0, 0, 128));
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setBounds(24, 82, 101, 43);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Search");
	btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Search Pressed");
//			new SearchResult(valid.getEmailid());
			Optional<User> user=userService.search(authentication.getEmailid());
			System.out.println(user);
		}
	});
	btnNewButton_1.setForeground(new Color(255, 255, 255));
	btnNewButton_1.setBackground(new Color(0, 0, 128));
	btnNewButton_1.setBounds(154, 82, 111, 43);
	frame.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("Delete");
	btnNewButton_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			userService.deleteData(authentication);
		}
	});
	btnNewButton_2.setForeground(new Color(255, 255, 255));
	btnNewButton_2.setBackground(new Color(0, 0, 128));
	btnNewButton_2.setBounds(317, 82, 101, 43);
	frame.getContentPane().add(btnNewButton_2);
}
}

	



