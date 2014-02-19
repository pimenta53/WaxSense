package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




public class FileUtil {


	
	public static  String creatPath(String path,String user){
		
		String result =path+user+"\\";
		
		File dir = new File(result);
		dir.mkdirs();
		return result;
		
	}
	
	public static <T> void writeResultsFile(String file_name,ArrayList<T> v) throws IOException{
		
		File file = new File(file_name);
		file.getParentFile().mkdirs();
		FileWriter writer = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(writer);
		
		for(T data : v){
			out.write(data+"\n");
		}
		  out.close();
	}
	
	
	
	
	public static void writeResultsFileCleanOutLiers(String file_name,ArrayList<Double> results) throws Exception{
		
		FileWriter fstream = new FileWriter(file_name);
		BufferedWriter out = new BufferedWriter(fstream);
		ArrayList<Double> cleanData = new ArrayList<Double>();
		
		if(results.size()>=3)  cleanData = util.Statistics.FilterOutLiers(results);
		else cleanData=results;
		
		for(Double data : cleanData){
			 out.write(data+"\n");
		}
		  out.close();
	}
	
	

	



}
