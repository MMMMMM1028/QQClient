package Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
public class SendMessage {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String FromID = null;
	private String ToID = null;
	private String Message = null;
	private String response = null;
	SendMessage(){
		//登陆成功就能获取ID
		setFromID();
		mp = new HashMap<String,String>();
	}
	void init() throws IOException {

		mp.clear();
		mp.put("Type", "Send_Message");
		mp.put("From", FromID);
		mp.put("To", ToID);
		mp.put("Message", Message);
		Date d = new Date();
		mp.put("PacketIdentify", d.toString());
		con = new Concent(mp);
	}
	//对方ID
	void setToID(String ToID) {
		this.ToID = ToID;
	}
	void setFromID() {
		FromID = Main.getUserID();
	}
	void setMessage(String Message) {

		this.Message = Message;
	}
	void Send() throws IOException {
		init();
		byte[] result = con.Send();
		response = new String(result);
	}
	String getResponse() {
		return response;
	}
}

