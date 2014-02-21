package WaxDevices;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;


import com.illposed.osc.*;

public class AccReceiver {

	private int com=3;
	private int receiverPort = 9876;
    private OSCPortIn receiver ;
   
	
	public AccReceiver(int rPort,int com) throws SocketException{
		receiver = new OSCPortIn(rPort);
		receiverPort=rPort;
		this.com = com;
	}
	
	
	public void addSensor(AccSensor sensor){
		 receiver.addListener(sensor.getName(), sensor.getHandler());
		
	}
	
	public void startRecive() throws IOException{
		receiver.startListening();
		System.out.println("Starting accelerometers...");
	    String command = "cmd.exe /c start waxrec.exe \\\\.\\COM"+com+" -osc localhost:"+receiverPort+" -init \"MODE=1\r\n\"";
	    Process child = Runtime.getRuntime().exec(command);
	    
	    System.out.println("Server is listening on port " + receiverPort + " and com: "+com);
	}
	
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
	   
	    
	    AccSensor test = new AccSensor("/wax/18", "cadeiras costa");
	    test.startRecord();
	    
	    
	    AccReceiver recive = new AccReceiver(9876,3);
	    recive.startRecive();
	    
	    recive.addSensor(test);
	   
	    
	   
	    
	    
	    
	  }
	
	
	
}
