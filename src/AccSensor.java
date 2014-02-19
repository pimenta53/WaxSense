import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;

import data.*;


public class AccSensor {

	private String name;
	private String description;
	private OSCListener handler;
	private ArrayList<AccData> dataRecord;
	private File file;
	private BufferedWriter out;
	private boolean writing;
	
	
	
	
	public boolean isWriting() {
		return writing;
	}


	public void setWriting(boolean writing) {
		this.writing = writing;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	public OSCListener getHandler() {
		return handler;
	}


	public void setHandler(OSCListener handler) {
		this.handler = handler;
	}


	public ArrayList<AccData> getDataRecord() {
		return dataRecord;
	}


	public void setDataRecord(ArrayList<AccData> dataRecord) {
		this.dataRecord = dataRecord;
	}


	public AccSensor(String name, String description){
		this.name=name;
		this.description=description;
		writing=false;
		dataRecord = new ArrayList<>();
		
		
	}

	public void startRecordFile(String file_name) throws IOException{
		file = new File(file_name+name+"_"+description+"_"+new Date().getTime()+".csv");
		file.getParentFile().mkdirs();
		FileWriter writer = new FileWriter(file);
		out = new BufferedWriter(writer);
		writing=true;
		out.write("cordx;cordy;cordz;timestamp\n");
		
	}
	
	public void stopRecordFile() throws IOException{
		writing=false;
		out.close();
	
	}
	
	public void startRecord(){
		
		handler = new OSCListener() 
	    {
	      public void acceptMessage(java.util.Date time, OSCMessage message) 
	      {
	        System.out.println("gravar");
	        AccData data = new AccData();
	    	
	        Object[] values = message.getArguments();
	        
	        data.setCordX(values[0].toString());
	        data.setCordY(values[1].toString());
	        data.setCordZ(values[2].toString());
	        data.setTimestamp(new Date());
	        
	        System.out.println(data.toString());
	       
	        if(writing){
	        	try {
	        		out.write(data.getCordX()+";"+data.getCordY()+";"+data.getCordZ()+";"+data.getTimestamp()+"\n");
	        	} catch (IOException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	}
	        }
	        else {
	        	//dataRecord.add(data);
	        }
	      }
	    };
		
		
	}
	
}
