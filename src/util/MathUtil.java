package util;

import java.util.ArrayList;
import java.math.*;

public class MathUtil {

	
	public static double avg(ArrayList<Double> l) //computes average
	{
		double average = 0;
		for(int i = 0; i < l.size(); i++)
			average = average + l.get(i);
		
		if(l.size() > 0)
			return (average/l.size());
		else
		{
			System.out.println("ERROR: Can't average 0 numbers.");
			return 0;
		}
	}
	
	public static double std (ArrayList<Double> data) //compute standard deviation
	{ 
		final int n = data.size(); 
		if ( n < 2 ) 
			return Double.NaN; 
	
		double avg = data.get(0); 
		double sum = 0; 
		for ( int i = 1; i < data.size(); i++ ) 
		{ 
			double newavg = avg + ( data.get(i) - avg ) / ( i + 1 ); 
			sum += ( data.get(i) - avg ) * ( data.get(i) -newavg ) ; 
			avg = newavg; 
		} 
		return Math.sqrt( sum / n ); 
	} 
	
	public static double avgD(ArrayList<Double> l) //computes average
	{
		double average = 0;
		for(int i = 0; i < l.size(); i++)
			average = average + l.get(i);
		
		if(l.size() > 0)
			return (average/l.size());
		else
		{
			System.out.println("ERROR: Can't average 0 numbers.");
			return 0;
		}
	}
	
	public static double stdD(ArrayList<Double> data) //compute standard deviation
	{ 
		final int n = data.size(); 
		if ( n < 2 ) 
			return Double.NaN; 
	
		double avg = data.get(0); 
		double sum = 0; 
		for ( int i = 1; i < data.size(); i++ ) 
		{ 
			double newavg = avg + ( data.get(i) - avg ) / ( i + 1 ); 
			sum += ( data.get(i) - avg ) * ( data.get(i) -newavg ) ; 
			avg = newavg; 
		} 
		return Math.sqrt( sum / n ); 
	}
	
	
}
