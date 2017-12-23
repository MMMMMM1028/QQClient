package Client;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Login {
	Map<String,String>mp = null;
	private String ID = null;
	private String Password = null;
	private Concent con;
	private String response = null;
	public Login() {
		mp = new HashMap<String, String>();
	}
	void init() throws IOException {
		mp.clear();
		mp.put("Type", "Login");
		mp.put("Id", ID);
		mp.put("Password", Password);
		con = new Concent(mp);
	}
	//从键盘读入ID
	void setID(String ID) {
		this.ID = ID;
	}
	//从键盘读入Password
	void setPassword(String Password) {
		this.Password = Password;
	}
	void Send() throws IOException {
		init();
		response = new String(con.Send());
	}
	String getResponse() {
		return response;
	}
	void Close() {
		con.Close();
	}
	String getID() {
		return ID;
	}
}
