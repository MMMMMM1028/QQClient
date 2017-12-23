package Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Search {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String SQL = null;
	private ArrayList<Map<String ,String>> response =null;	Search(){
		mp = new HashMap<String,String>();
	}
	
	private void init() throws IOException{
		mp.clear();
		mp.put("Type", "SQL_Q");
		mp.put("SQL", SQL);
		con = new Concent(mp);
	}
	void setSQL(String SQL) {
		this.SQL = SQL;
	}
	
	void Send() throws IOException, ClassNotFoundException {
		init();
		byte[] result = con.Send();
		response = new ArrayList<Map<String ,String>>();
		response = (ArrayList)ByteProcessingFunction.bytesToObject(result);
	}
	ArrayList<Map<String, String>> getResponse() {
		return response;
	}
	//¹Ø±ÕËÑË÷
	void Close() {
		con.Close();
	}
}

