package Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;
public class Register {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String Username = null;
	private String Password = null;
	Register() throws IOException{
		//init();
		mp = new HashMap<String,String>();
	}
	void init() throws IOException {
		
		//setUsername();
		//setPassword();
		mp.clear();
		mp.put("Type", "Register");
		mp.put("Username", Username);
		mp.put("Password", Password);
		con = new Concent(mp);
		//Send();
	}
	
	void setUsername() {
		/*Scanner s = new Scanner(System.in);
		Username = s.nextLine();
		s.close();*/
		this.Username = "a123";
	}
	
	void setPassword() {
		/*Scanner s = new Scanner(System.in);
		Password = s.nextLine();
		s.close();*/
		this.Password = "a123";
	}
	boolean checkUsername(){
		String pattern = "[a-zA-Z_]{1,}[0-9]{0,}";
		return Pattern.matches(pattern, Username);
	}
	boolean checkPassword() {
		String pattern = "[a-zA-Z_]{1,}[0-9]{0,}";
		return Pattern.matches(pattern, Password);
	}
	void Send() throws IOException {
		init();
		if(checkPassword()&&checkUsername()) {
			byte[] src = con.Send();
			int value = 0;  
	        
			value = ByteProcessingFunction.bytesToInt(src, 0);
		    System.out.println("注册成功，你的ID:"+value);
		}else {
			System.out.println("账号或密码不符合要求，重新输入");
		}
		
	}
	private void Close() {
		con.Close();
	}
}
