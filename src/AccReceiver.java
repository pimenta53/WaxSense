import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;

import com.illposed.osc.*;

public class AccReceiver {

	
	private int receiverPort = 9876;
    private OSCPortIn receiver ;
   
	
	public AccReceiver(int rPort) throws SocketException{
		receiver = new OSCPortIn(rPort);
		receiverPort=rPort;
	}
	
	
	public void addSensor(AccSensor sensor){
		 receiver.addListener(sensor.getName(), sensor.getHandler());
		
	}
	
	public void startRecive() throws IOException{
		receiver.startListening();
		System.out.println("Starting accelerometers...");
	    String command = "cmd.exe /c start waxrec.exe \\\\.\\COM3 -osc localhost:"+receiverPort+" -init \"MODE=1\r\n\"";
	    Process child = Runtime.getRuntime().exec(command);
	    
	    System.out.println("Server is listening on port " + receiverPort + "...");
	}
	
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
	   
	    
	    AccSensor test = new AccSensor("/wax/18", "cadeiras costa");
	    test.startRecord();
	    
	    
	    AccReceiver recive = new AccReceiver(9876);
	    recive.startRecive();
	    
	    recive.addSensor(test);
	   
	    
	   
	    
	    
	    
	  }
	
	
	
}
