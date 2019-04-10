import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BigramEquations2 {

	public static String doTheMaths (String filename1, String filename2) throws IOException {

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
		//filename1 = filename1.replace("Lady Gregory", "");
		//filename1 = filename1.replace("John Galsworthy", "");
		//filename1 = filename1.replace("George Bernard Shaw", "");
		filename1 = filename1.replace("Bigrams", "");
		filename1 = filename1.replace("Bigram", "");
		filename1 = filename1.replace("Compare", "");
		filename1 = filename1.replace("All Speech", "");
		filename1 = filename1.replace(".txt", "");
		filename1 = filename1.replace("   ", " ");
		filename1 = filename1.replace("  ", " ");

		filename2 = filename2.replace("\\", " ");
		filename2 = filename2.replace("Authors", "");
		//filename2 = filename2.replace("Lady Gregory", "");
		//filename2 = filename2.replace("John Galsworthy", "");
		//filename2 = filename2.replace("George Bernard Shaw", "");
		filename2 = filename2.replace("Bigrams", "");
		filename2 = filename2.replace("Bigram", "");
		filename2 = filename2.replace("Compare", "");
		filename2 = filename2.replace("All Speech", "");
		filename2 = filename2.replace(".txt", "");
		filename2 = filename2.replace("   ", " ");
		filename2 = filename2.replace("  ", " ");

		PrintWriter output = new PrintWriter (new FileWriter("Who Is It/" + filename1 + " VS " + filename2 + ".txt"));

		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;

		for(int i = 1; i < t1.length; i=i+2) {

			s1 = s1 + Double.parseDouble(t1[i]);
		}

		// counting total tokens as opposed to total unique tokens 
		for(int i = 1; i < t2.length; i=i+2) {
			s2 = s2 + Double.parseDouble(t2[i]);
		} 
		// counting total unique tokens as opposed to total tokens 
		for(int i = 1; i < t1.length; i=i+2) {
			s3++;
		}

		for(int i = 1; i < t2.length; i=i+2) {
			s4++;
		}

		//System.out.println(s1);
		//System.out.println(s2);

		double totaltokens = s1 + s2; //all token total
		double ttt = s3 + s4; //unique token total
		double answerTotal = 0; //final answer
	
		//get first token from file one
		for(int i = 0; i < t1.length-1; i=i+2) {
			//loop through each token in file two to find exact match if any exist
			for (int j = 0; j < t2.length-1; j=j+2) {
				//if token i1 matches token j2
				if (t1[i].equals(t2[j]))
				{
					double occurances1 = Integer.parseInt(t1[i+1]); //occurrences of token i in file one
					double occurances2 = Integer.parseInt(t2[j+1]); //occurrences of token i in file two
					double occurancesCombined = occurances1 + occurances2; // combined occurrences of token i in both files
					double eval1 = occurancesCombined * (s1/totaltokens); // estimated value of i in file one
					double eval2 = occurancesCombined * (s2/totaltokens); // estimated value of i in file two
					double occurrences1MinusEval1ThenSquared = (occurances1 - eval1) * (occurances1 - eval1); //see name
					double occurrences2MinusEval2ThenSquared = (occurances2 - eval2) * (occurances2 - eval2); //see name
					double final1 = occurrences1MinusEval1ThenSquared / eval1; //part one of TTT sum equation
					double final2 = occurrences2MinusEval2ThenSquared / eval2; //part two of TTT sum equation
					double final3 = final1 + final2; // add part1 and part2
					answerTotal = answerTotal + final3; // sum for each k
					/*if(final3 > 100) {
						System.out.print(filename1 + " " + filename2 + " = " + t1[i] + " - ");
						System.out.println(final3);
						
					} */
					output.println(t1[i] + " = " + final3); 
				}
			}
		} 
		answerTotal = answerTotal/(ttt-1); //sum divided by degrees of freedom
		output.println("THE ANSWER: "+answerTotal);
		//System.out.println(filename1 + " & " + filename2 +"," +answerTotal);
		String answer = filename1 + " & " + filename2 +"," +answerTotal;
		output.close();
		return answer;
		

	}
}

