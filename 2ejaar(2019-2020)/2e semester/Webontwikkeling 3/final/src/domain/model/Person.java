package domain.model;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	private String userid;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String role;

	public Person(String userid, String email, String password, String firstName, String lastName, String role) {
		setUserid(userid);
		setEmail(email);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
	}

	public Person() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		if(userid.isEmpty()){
			throw new IllegalArgumentException("No userid given");
		}
		this.userid = userid;
	}

	public void setEmail(String email) {
		if(email.isEmpty()){
			throw new IllegalArgumentException("No email given");
		}
		String USERID_PATTERN =
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.email = email;
	}



	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(password);
	}

	public void setPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}
	public void setPasswordHashed(String password)  {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		try {
			this.password = hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	private String hashPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest crypt = MessageDigest.getInstance("SHA-512");
		crypt.reset();

		// encrypts
		crypt.update(password.getBytes("UTF-8"));

		//16 hexadecimal system the sixteen digits are "0–9" followed by "A–F".
		String hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		System.out.println(hashedPassword.length());
		return hashedPassword;
	}

	public String getRole(){return this.role;}

	public void setRole(String role){
	    if(role.equals("Admin") || role.equals("User")){
            this.role = role;
        }
	    else{
	        throw new IllegalArgumentException("Not a valid role");
        }
	}

	public boolean isCorrectPasswordHashed(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return hashPassword(s).equals(password);
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.isEmpty()){
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.isEmpty()){
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public boolean isValidPassword(String password){return password != null && password.length() > 2;}

	public boolean isValidName(String name){return name != null && !name.isEmpty();}

	public boolean isPasswordCorrect(String password){
		try {
			return this.password.equals(hashPassword(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String toString(){
		return getFirstName() + " " + getLastName() + ": " + getUserid() + ", " + getEmail();
	}


	public Person getpersonIfAuthenticated(String password){
		if(this != null && this.isPasswordCorrect(password))
			return this;
		return null;
	}
}
