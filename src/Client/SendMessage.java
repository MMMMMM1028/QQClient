package Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SendMessage {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String FromID = null;
	private String ToID = null;
	private String Message = null;
	SendMessage(){
		//打开对话框 就确定了对方和自己
		setFromID();
		setToID();
		mp = new HashMap<String,String>();
	}
	void init() throws IOException {
		//setFromID();
		//setToID();
		//setMessage();
		mp.clear();
		mp.put("Type", "Send_Message");
		mp.put("From", FromID);
		mp.put("To", ToID);
		mp.put("Message", Message);
		mp.put("PacketIdentify", "1");
		con = new Concent(mp);
	}
	//对方ID
	void setToID() {
		this.ToID = "2";
	}
	void setFromID() {
		FromID = Main.getUserID();
	}
	void setMessage() {
		/*Scanner s = new Scanner(System.in);
		Message = s.nextLine();
		s.close();*/
		this.Message = "hello";
	}
	void Send() throws IOException {
		init();
		byte[] result = con.Send();
		String s = new String(result);
		System.out.println(s);
	}
}
class ClientSendMessage extends Thread{
	SendMessage m = new SendMessage();
	public void run() {
		try {
			while(true) {
				m.setMessage();
				m.Send();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
