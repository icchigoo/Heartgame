package peripherals;

public class LoginData {
	
	boolean checkPassword(String username, String passwd) { 
		if( username.equals("John") && passwd.equals("hello1")) return true; 
		return false; 
		
	}
}
