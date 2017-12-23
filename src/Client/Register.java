package Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
public class Register {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String Username = null;
	private String Password = null;
	private String response;
	Register() throws IOException{
		mp = new HashMap<String,String>();
	}
	void init() throws IOException {

		mp.clear();
		mp.put("Type", "Register");
		mp.put("Username", Username);
		mp.put("Password", Password);
		con = new Concent(mp);
		//Send();
	}
	
	void setUsername(String Username) {

		this.Username = Username;
	}
	
	void setPassword(String Password) {

		this.Password = Password;
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
			int ID;
			ID = ByteProcessingFunction.bytesToInt(src, 0);
		    response =  Integer.toString(ID);
		}else {
			response = "账号或密码不符合要求，重新输入";
		}
		
	}
	String getResponse() {
		return response;
	}
	private void Close() {
		con.Close();
	}
}
