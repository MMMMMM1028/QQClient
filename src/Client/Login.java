package Client;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Login {
	Map<String,String>mp = null;
	private String ID = null;
	private String Password = null;
	private Concent con;
	public Login() {
		mp = new HashMap<String, String>();
	}
	void init() throws IOException {
		mp.clear();
		//setID();
		//setPassword();
		mp.put("Type", "Login");
		mp.put("Id", ID);
		mp.put("Password", Password);
		con = new Concent(mp);
	}
	//从键盘读入ID
	void setID() {
		this.ID = "1";
	}
	//从键盘读入Password
	void setPassword() {
		this.Password = "a123";
	}
	void Send() throws IOException {

		init();
		String response = new String(con.Send());
		//if(response.equals("FALSE")) {
			System.out.println(response);
		//}
		//else {
			//登陆成功
			//con.Close();
		//}
	}	
	void Close() {
		con.Close();
	}
	String getID() {
		return ID;
	}
}
