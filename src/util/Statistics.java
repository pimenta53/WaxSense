package util;

import java.util.ArrayList;
import java.util.Collections;


public class Statistics {

	/** Quando alfa vale 0.1, (1 - alfa/2) = 0.95. Valor de t-student-95 para n tendendo a infinito = 1.645.*/
	public static final double T_STUDENT_095 = 1.645;
	
	
	/** 
	 * Método utilizado para calcular intervalo de confiança de n amostras.
	 * @param amostras analisadas
	 * @return percentual do intervalo de confiança
	 */
	public static double confidenceInterval(ArrayList<Double> sample) {

		double n = sample.size();
		
		double somatorioValores = 0.0;
		double somatorioQuadradoValores = 0.0;
		
		for (Double amostra : sample) {
			somatorioValores += amostra;
			somatorioQuadradoValores += Math.pow(amostra, 2);
		}
		return calculaIC(somatorioQuadradoValores, somatorioValores, n);
	}
	
	/** 
	 * Método utilizado para calcular intervalo de confiança de n amostras.
	 * @param somatorioQuadradoValores de uma amostra
	 * @param somatorioValores de uma amostra
	 * @param size tamanho de uma amostra
	 * @return percentual do intervalo de confiança
	 */
	public static double calculaIC(double somatorioQuadradoValores, double somatorioValores, double size) {
		
		double variancia = 0.0;
		double n = size;
		
		//Referência da fórmula: Site de AD - Ano:2000 - Período:1º - Assuntos:Simulação - 4a Questão
		variancia = ((somatorioQuadradoValores)/(n-1)) - (Math.pow(somatorioValores, 2)/(n*(n-1)));
		
		return T_STUDENT_095 * Math.sqrt(variancia / n);
		
	}
	
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
	
	
	
		public static double Median(ArrayList values)
		{
		    Collections.sort(values);
		 
		    if (values.size() % 2 == 1)
			return (Double) values.get((values.size()+1)/2-1);
		    else
		    {
			double lower = (Double) values.get(values.size()/2-1);
			double upper = (Double) values.get(values.size()/2);
		 
			return (lower + upper) / 2.0;
		    }	
		}
		

		public static ArrayList GetValuesGreaterThan(ArrayList<Double> values, double limit, boolean orEqualTo)
		{
		    ArrayList modValues = new ArrayList();
		 
		    for (double value : values)
		        if (value > limit || (value == limit && orEqualTo))
		            modValues.add(value);
		 
		    return modValues;
		}
		 
		public static ArrayList GetValuesLessThan(ArrayList<Double> values, double limit, boolean orEqualTo)
		{
		    ArrayList modValues = new ArrayList();
		 
		    for (double value : values)
		        if (value < limit || (value == limit && orEqualTo))
		            modValues.add(value);
		 
		    return modValues;
		}
		
		
		public static double[] Quartiles(ArrayList values) throws Exception
		{
		    if (values.size() < 3)
		    throw new Exception("This method is not designed to handle lists with fewer than 3 elements.");
		 
		    double median = Median(values);
		 
		    ArrayList lowerHalf = GetValuesLessThan(values, median, true);
		    ArrayList upperHalf = GetValuesGreaterThan(values, median, true);
		 
		    return new double[] {Median(lowerHalf), median, Median(upperHalf)};
		}
		 
		 public static double InterQuartileRange(ArrayList values) throws Exception
		    {
			double[] quartiles = Quartiles(values);
			return quartiles[2] - quartiles[0];
		    }
		
		 public static ArrayList<Double> FilterOutLiers(ArrayList<Double> values) throws Exception{
			 
			 if(values.size()<=3) return values;
			 
			 ArrayList<Double> list = new ArrayList();
			 double[] quartiles = Quartiles(values);
			 double iq = quartiles[2] - quartiles[0];
			 double lower =quartiles[0];
			 double upper =quartiles[2];
			 double extremeUpperLimit = (iq*3) + upper;
			 double extremeLowerLimit = lower - (iq*3);
			 
			 
			 for(double v : values){
				 if(v>extremeLowerLimit && v<extremeUpperLimit) list.add(v); 
			 }
			 
		return list;
		 }

		 public static void main(String args[]) throws Exception{
			
			 ArrayList<Double> list = new ArrayList<Double>();
			 list.add((double) 71);
			 list.add((double) 70);
			 list.add((double) 73);
			 list.add((double) 70);
			 list.add((double) 70);
			 list.add((double) 72);
			 list.add((double) 71);
			 list.add((double) 100);
			 list.add((double) 71);
			 list.add((double) 69);
			 
			 ArrayList<Double> values = FilterOutLiers(list);
			 for(double v : values){
				  System.out.print(v+" "); 
			 }
			 
			}
		 
}
