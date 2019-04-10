import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BigramEquations {

	public static void doTheMaths (String filename1, String filename2) throws IOException {

		boolean firstFile = false;
		boolean secondFile = false;
		/*String filename1 = "";
		String filename2 = "";

		while (firstFile == false) {
			System.out.println("Enter the full name of the file you wish to compare");
			Scanner sc = new Scanner(System.in);
			filename1 = sc.nextLine();
			File tmpDir = new File(filename1);
			if (tmpDir.exists()) {
				firstFile = true;
			}
		} */
		
		
		
		Scanner scanner1 = new Scanner( new File(filename1) );
		String bigram1 = scanner1.useDelimiter("\\A").next();
		scanner1.close();

		// Get every other file and compare
		
		Scanner scanner2 = new Scanner( new File(filename2) );
		String bigram2 = scanner2.useDelimiter("\\A").next();
		scanner2.close();

		String[]t1 = bigram1.split("&&|\r");
		String[]t2 = bigram2.split("&&|\r");
		
		filename1 = filename1.replace("\\", " ");
		filename1 = filename1.replace("Authors", "");
		filename1 = filename1.replace("Lady Gregory", "");
		filename1 = filename1.replace("John Galsworthy", "");
		filename1 = filename1.replace("George Bernard Shaw", "");
		filename1 = filename1.replace("Bigrams", "");
		filename1 = filename1.replace("Bigram", "");
		filename1 = filename1.replace("Compare", "");
		filename1 = filename1.replace("All Speech", "");
		filename1 = filename1.replace(".txt", "");
		filename1 = filename1.replace("   ", " ");
		filename1 = filename1.replace("  ", " ");
		
		filename2 = filename2.replace("\\", " ");
		filename2 = filename2.replace("Authors", "");
		filename2 = filename2.replace("Lady Gregory", "");
		filename2 = filename2.replace("John Galsworthy", "");
		filename2 = filename2.replace("George Bernard Shaw", "");
		filename2 = filename2.replace("Bigrams", "");
		filename2 = filename2.replace("Bigram", "");
		filename2 = filename2.replace("Compare", "");
		filename2 = filename2.replace("All Speech", "");
		filename2 = filename2.replace(".txt", "");
		filename2 = filename2.replace("   ", " ");
		filename2 = filename2.replace("  ", " ");
		
		PrintWriter output = new PrintWriter (new FileWriter("Bigram Comparisons/" + filename1 + " VS " + filename2 + ".txt"));

		double s1 = 0;
		double s2 = 0;

		for(int i = 1; i < t1.length; i=i+2) {
			s1 = s1 + Double.parseDouble(t1[i]);
		}

		for(int i = 1; i < t2.length; i=i+2) {
			s2 = s2 + Double.parseDouble(t2[i]);
		}

		System.out.println(s1);
		System.out.println(s2);

		double ttt = s1 + s2;

		for(int i = 0; i < t1.length-1; i=i+2) {
			for (int j = 0; j < t2.length-1; j=j+2) {
				if (t1[i].equals(t2[j]))
				{
					double occurances1 = Integer.parseInt(t1[i+1]);
					double occurances2 = Integer.parseInt(t2[j+1]);
					double eval1 = occurances1 * (s1/ttt);
					double eval2 = occurances2 * (s2/ttt);
					double evalsquared1 = eval1 * eval1;
					double evalsquared2 = eval2 * eval2;
					double final1 = (occurances1 - evalsquared1) / eval1;
					double final2 = (occurances2 - evalsquared2) / eval2;
					double final3 = final1 + final2;
					output.println(t1[i] + " = " + final3); 
				}
			}
		} 
		output.close();

	}
}

