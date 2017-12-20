package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Search {
	private Concent con = null;
	private Map<String,String>mp = null;
	private String SQL = null;
	Search(){
		mp = new HashMap<String,String>();
		//init();
	}
	
	private void init() throws IOException{
		//setSQL();
		mp.clear();
		mp.put("Type", "SQL_Q");
		mp.put("SQL", SQL);
		con = new Concent(mp);
	}
	void setSQL() {
		Scanner s = new Scanner(System.in);
		SQL = s.nextLine();
		s.close();
	}
	
	void Send() throws IOException, ClassNotFoundException {
		init();
		byte[] result = con.Send();
		// ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(result));
	    //List<Map> list = (List) objIn.readObject();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		list = (List<Map<String, String>>)ByteProcessingFunction.bytesToObject(result);
	     for(int i=0;i<list.size();i++) {
	    	 //System.out.println(list.get(i));
	     }
	}
	//¹Ø±ÕËÑË÷
	private void Close() {
		con.Close();
	}
}
/*class ClientSearch extends Thread{
	Search m = new Search();
	public void run() {
		try {
			while(true) {
				m.setSQL();
				m.Send();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}*/
