import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class compareBigrams {

	public static void CompBigrams (String filename1, String filename2) throws IOException {

		double value = 0;
		Scanner scanner = new Scanner( new File(filename1) );
		String text1 = scanner.useDelimiter("\\A").next();
		scanner.close();

		Scanner scanner2 = new Scanner( new File(filename2) );
		String text2 = scanner2.useDelimiter("\\A").next();
		scanner2.close();


		String [] t1split = text1.split(" = |\n|\r");
		String [] t2split = text2.split(" = |\n|\r");

		int anchor = 0;
		for (int a = 1; a < t1split.length-2; a = a+4) {
			for (int j = 1; j < t2split.length-2; j = j+4) {
				if (t1split[a].substring(0, 2).equals(t2split[j].substring(0, 2))) {
					if(t1split[a+1].equals("")){
						t1split[a+1] = "0";
					}
					if(t2split[j+1].equals("")){
						t2split[j+1] = "0";
					}
					if(t1split[a+1].equals(null)){
						t1split[a+1] = "0";
					}
					if(t2split[j+1].equals("")){
						t2split[j+1] = "0";
					}
					if (Double.parseDouble(t1split[a+1]) < 0 && Double.parseDouble(t2split[j+1]) < 0) {
						double x = Math.abs(Double.parseDouble(t1split[a+1]));
						double y = Math.abs(Double.parseDouble(t2split[j+1]));
						double dif = Math.abs(x-y);
						value = value + dif;

					}

					else if (Double.parseDouble(t1split[a+1]) >= 0 && Double.parseDouble(t2split[j+1]) >= 0) {
						value = value + Math.abs(Double.parseDouble(t1split[a+1])) 
						- Double.parseDouble(t2split[j+1]) ;
					}

					else if (Double.parseDouble(t1split[a+1]) < 0 || Double.parseDouble(t2split[j+1]) < 0) {
						value = value + (Math.max(Double.parseDouble(t1split[a+1]), Double.parseDouble(t2split[j+1]))
								+ Math.min(Double.parseDouble(t1split[a+1]), Double.parseDouble(t2split[j+1])));
					}
				}
				else {
					anchor++;
				}
			}
		}
		
		if (value < 0) {
			value = value - ((anchor/t2split.length)*100);
		}
		
		if (value >= 0) {
			value = value + ((anchor/t2split.length)*100);
		}
		if (value%10==0) {
			value = value - 1000000;
		}
		
		System.out.println(filename1 + "," + filename2 + "," + value);

	}
	

}


