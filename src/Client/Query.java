package Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String ToId= null;
	private String FromId = null;
	Query() throws IOException{
		//init();
		mp = new HashMap<String,String>();
		setToId();
	}
	void init() throws IOException {
		mp.clear();
		mp.put("Type", "Ask_Message");
		mp.put("To", ToId);
		mp.put("From", "1");
		con = new Concent(mp);
	}
	void setFrom() {
		
	}
	void setToId() {
		//Scanner s = new Scanner(System.in);
		//ID = s.nextLine();
		//s.close();
		this.ToId = "2";
	}
	void Send() throws IOException, ClassNotFoundException {
		init();
		byte[] result = con.Send();
		// ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(result));
	    //List<Map> list = (List) objIn.readObject();
		List list = new ArrayList();
		list = (List)ByteProcessingFunction.bytesToObject(result);
		//System.out.println(list.toString());
		int x = 1;
	}
}
