package Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Query {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String ToId= null;
	private String FromId = null;
	private ArrayList<Map<String ,String>> response =null;
	Query() throws IOException{
		mp = new HashMap<String,String>();
	}
	void init() throws IOException {
		mp.clear();
		mp.put("Type", "Ask_Message");
		mp.put("To", ToId);
		mp.put("From", "1");
		con = new Concent(mp);
	}
	void setFromId(String FromId) {
		this.FromId = FromId;
	}
	void setToId(String ToId) {

		this.ToId = ToId;
	}
	void Send() throws IOException, ClassNotFoundException {
		init();
		byte[] result = con.Send();
		response = new ArrayList<Map<String ,String>>();
		response = (ArrayList)ByteProcessingFunction.bytesToObject(result);
	}
	ArrayList<Map<String ,String>> getResponse() {
		return response;
	}
}
