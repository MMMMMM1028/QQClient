package Client;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Map;
public class Concent {
	
	
	private int DEST_PORT ;
	private final String DEST_IP = "10.17.67.11";
	private final int DATA_LEN = 1024;
	private DatagramSocket ds = null;
	private DatagramPacket outdp = null;
	private DatagramPacket indp = null;
	private byte[] outbuff = null;
	private byte[] inbuff = null;
	private Map<String,String> mp = null;
	
	Concent(Map<String,String> mp) throws IOException{
		Concention("UDP_Port");
		this.mp = mp;
		//init();
	}
	private void Concention(String type) throws IOException {
		DatagramSocket ds= new DatagramSocket();
		DatagramPacket dp = new DatagramPacket(type.getBytes(),type.getBytes().length,InetAddress.getByName(DEST_IP),2333);
		ds.send(dp);
		ds.receive(dp);
		byte[]src = dp.getData();
		int value;
		value = ByteProcessingFunction.bytesToInt(src, 0);
	    DEST_PORT = value;
	}
	
	private void init() throws IOException {
		ds = new DatagramSocket();
		byte[] outbuff = new byte[DATA_LEN];
		byte[] inbuff = new byte[DATA_LEN];
		/*ByteArrayOutputStream bout=new ByteArrayOutputStream();
		ObjectOutputStream objout = new ObjectOutputStream(bout);
		objout.writeObject(mp);
		outbuff = bout.toByteArray();*/
		
		outbuff = ByteProcessingFunction.objectToBytes(mp);
		
		outdp =  new DatagramPacket(outbuff,outbuff.length);
		outdp.setAddress(InetAddress.getByName(DEST_IP));
		outdp.setPort(DEST_PORT);
		indp = new DatagramPacket(inbuff, DATA_LEN);
	}
	
	byte[] Send() throws IOException {
		init();
		boolean isresponse = false;
		byte[] response = new byte[DATA_LEN];
		int tries = 0;
		while(!isresponse&&tries<5) {
			try{
				ds.send(outdp);
				ds.receive(indp);
				if(!(indp.getAddress()).equals(InetAddress.getByName(DEST_IP))) {
					tries++;
					throw new IOException("发送失败，正在重新发送....");
					
				}
				isresponse = true;
				response = indp.getData();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(!isresponse)
			throw new IOException("发送失败，请重新尝试连接");
		return response;
	}
	private DatagramSocket getDatagramSocket() {
		return ds;
	}
	void Close() {
		ds.close();
	}
}
