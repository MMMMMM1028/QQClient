package Client;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	private static String ID;
	
	public static void main(String args[]) {
		try {
			Login l = new Login();
			l.setID();
			l.setPassword();
			l.Send();
			ID = l.getID();
			SendMessage s = new SendMessage();
			//s.setFromID();
			s.setMessage();
			s.Send();
			//s.setToID();
			Query q = new Query();
			q.setToId();
			q.Send();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static String getUserID() {
		return ID;
	}
}
