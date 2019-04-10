import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GrabAllBigramEquationFiles {

	public static void GABF () throws IOException {
		ArrayList answer = new ArrayList();
		File[] LG1 = GetFolderFiles.GFF("Authors/Lady Gregory/Coats/Bigrams/Compare");
		File[] LG2 = GetFolderFiles.GFF("Authors/Lady Gregory/Darmer's Gold/Bigrams/Compare");
		File[] LG3 = GetFolderFiles.GFF("Authors/Lady Gregory/McDonough's Wife/Bigrams/Compare");
		File[] LG4 = GetFolderFiles.GFF("Authors/Lady Gregory/The Bogie Men/Bigrams/Compare");
		File[] LG5 = GetFolderFiles.GFF("Authors/Lady Gregory/The Full Moon/Bigrams/Compare");

		int totalFilesLG = LG1.length + LG2.length + LG3.length + LG4.length + LG5.length;	
		File [] LG = new File[totalFilesLG];
		for(int i = 0; i < totalFilesLG; i++) {
			if (i<LG1.length) {
				LG[i] = LG1[i];
			}
			else if (i<LG1.length+LG2.length) {
				LG[i] = LG2[i-LG1.length];
			}
			else if (i<LG1.length+LG2.length + LG3.length) {
				LG[i] = LG3[i-(LG1.length+LG2.length)];
			}
			else if (i<LG1.length+LG2.length+LG3.length+LG4.length) {
				LG[i] = LG4[i-(LG1.length+LG2.length + LG3.length)];
			}
			else if (i<totalFilesLG) {
				LG[i] = LG5[i-(LG1.length+LG2.length+LG3.length+LG4.length)];
			}
		}

		File[] JG1 = GetFolderFiles.GFF("Authors/John Galsworthy/Defeat/Bigrams/Compare");
		File[] JG2 = GetFolderFiles.GFF("Authors/John Galsworthy/Hall-Marked/Bigrams/Compare");
		File[] JG3 = GetFolderFiles.GFF("Authors/John Galsworthy/Punch And Go/Bigrams/Compare");
		File[] JG4 = GetFolderFiles.GFF("Authors/John Galsworthy/The First And Last/Bigrams/Compare");
		File[] JG5 = GetFolderFiles.GFF("Authors/John Galsworthy/The Sun/Bigrams/Compare");
		int totalFilesJG = JG1.length + JG2.length + JG3.length + JG4.length + JG5.length;	
		File [] JG = new File[totalFilesJG];
		for(int i = 0; i < totalFilesJG; i++) {
			if (i<JG1.length) {
				JG[i] = JG1[i];
			}
			else if (i<JG1.length+JG2.length) {
				JG[i] = JG2[i-JG1.length];
			}
			else if (i<JG1.length+JG2.length + JG3.length) {
				JG[i] = JG3[i-(JG1.length+JG2.length)];
			}
			else if (i<JG1.length+JG2.length+JG3.length+JG4.length) {
				JG[i] = JG4[i-(JG1.length+JG2.length+JG3.length)];
			}
			else if (i<totalFilesJG) {
				JG[i] = JG5[i-(JG1.length+JG2.length+JG3.length+JG4.length)];
			}
		}

		File[] GBS1 = GetFolderFiles.GFF("Authors/George Bernard Shaw/Augustus Does His Bit/Bigrams/Compare");
		File[] GBS2 = GetFolderFiles.GFF("Authors/George Bernard Shaw/Dark Lady Of The Sonnets/Bigrams/Compare");
		File[] GBS3 = GetFolderFiles.GFF("Authors/George Bernard Shaw/How He Lied To Her Husband/Bigrams/Compare");
		File[] GBS4 = GetFolderFiles.GFF("Authors/George Bernard Shaw/Overruled/Bigrams/Compare");
		File[] GBS5 = GetFolderFiles.GFF("Authors/George Bernard Shaw/The Inca Of Perusalem/Bigrams/Compare");	
		int totalFilesGBS = GBS1.length + GBS2.length + GBS3.length + GBS4.length + GBS5.length;	
		File [] GBS = new File[totalFilesGBS];
		for(int i = 0; i < totalFilesGBS; i++) {
			if (i<GBS1.length) {
				GBS[i] = GBS1[i];
			}
			else if (i<GBS1.length+GBS2.length) {
				GBS[i] = GBS2[i-GBS1.length];
			}
			else if (i<GBS1.length+GBS2.length + GBS3.length) {
				GBS[i] = GBS3[i-(GBS1.length+GBS2.length)];
			}
			else if (i<GBS1.length+GBS2.length+GBS3.length+GBS4.length) {
				GBS[i] = GBS4[i-(GBS1.length+GBS2.length+GBS3.length)];
			}
			else if (i<totalFilesGBS) {
				GBS[i] = GBS5[i-(GBS1.length+GBS2.length+GBS3.length+GBS4.length)];
			}
		}

		int totalFiles = LG.length + JG.length + GBS.length;
		File [] all = new File[totalFiles];
		for(int i = 0; i < totalFiles; i++) {
			if (i<LG.length) {
				all[i] = LG[i];
			}
			else if (i<LG.length+JG.length) {
				all[i] = JG[i-LG.length];
			}
			else if (i<LG.length+JG.length+GBS.length) {
				all[i] = GBS[i-(LG.length+JG.length)];
			}
		}

		boolean firstFile = false;
		String filename1 = "";

		while (firstFile == false) {
			System.out.println("Enter the full name of the file you wish to guess.");
			Scanner sc = new Scanner(System.in);
			filename1 = sc.nextLine();
			File tmpDir = new File(filename1);
			if (tmpDir.exists()) {
				firstFile = true;
			}
		} 

		String toTest = Cleaning.clean(filename1,"Guess", "Guess");
		Bigram2.bigram(toTest, "Guess", "Guess","Guess");

		for(int i = 0; i < all.length; i++) {
			answer.add(BigramEquations2.doTheMaths("Guess Bigram.txt", all[i].toString()));
		}

		/*File[] all2 = GetFolderFiles.GFF("Who Is It");
		File[]all3 = GetFolderFiles.GFF("Bigram Comparisons");

		for(int i = 0; i < all2.length; i++) {
			for(int j = 0; j < all3.length; j++) {
				compareBigrams.CompBigrams(all2[i].toString(),all3[j].toString());
			}
		} */
		String[] output = answer.toString().replace("]", "").split(",");
		//System.out.println(output[1]);
		double jg = 0;
		double lg = 0;
		double gbs = 0;
		double jg2 = 0;
		double lg2 = 0;
		double gbs2 = 0;
		double [] a = new double[77];
		int count = 0;



		for (int i = 0; i < output.length; i=i+2) {
			a[count] = Double.parseDouble(output[i+1]);
			count++;
		}	



		int[] r = rankify(a,a.length);	
		count = 0;

		for (int i = 0; i < output.length; i=i+2) {
			if(output[i].contains("John Galsworthy")) {
				jg = jg + Double.parseDouble(output[i+1]);
				jg2 = jg2 + r[count];
			}
			else if(output[i].contains("Lady Gregory")) {
				lg = lg + Double.parseDouble(output[i+1]);
				lg2 = lg2 + r[count];
			}
			else if (output[i].contains("George Bernard")) {
				gbs = gbs + Double.parseDouble(output[i+1]);
				gbs2 = gbs2 + r[count];
			}
			count++;
		}	

		double def = 0;
		double hall = 0;
		double punch = 0;
		double first = 0;
		double sun = 0;
		double def2 = 0;
		double hall2 = 0;
		double punch2 = 0;
		double first2 = 0;
		double sun2 = 0;


		double aug = 0;
		double dark = 0;
		double how = 0;
		double over = 0;
		double inca = 0;
		double aug2 = 0;
		double dark2 = 0;
		double how2 = 0;
		double over2 = 0;
		double inca2 = 0;

		double coats = 0;
		double darmer = 0;
		double mcdon = 0;
		double bogie = 0;
		double moon = 0;
		double coats2 = 0;
		double darmer2 = 0;
		double mcdon2 = 0;
		double bogie2 = 0;
		double moon2 = 0;

		count = 0;
		for (int i = 0; i < output.length; i=i+2) {
			if(output[i].contains("Defeat")) {
				def = def + Double.parseDouble(output[i+1]);
				def2 = def2 + r[count];
			}
			else if(output[i].contains("Hall-Marked")) {
				hall = hall + Double.parseDouble(output[i+1]);
				hall2 = hall2 + r[count];
			}
			else if (output[i].contains("Punch And Go")) {
				punch = punch + Double.parseDouble(output[i+1]);
				punch2 = punch2 + r[count];
			}
			else if(output[i].contains("First And")) {
				first = first + Double.parseDouble(output[i+1]);
				first2 = first2 + r[count];
			}
			else if (output[i].contains("The Sun")) {
				sun = sun + Double.parseDouble(output[i+1]);
				sun2 = sun2 + r[count];
			}

			else if(output[i].contains("Does His Bit")) {
				aug = aug + Double.parseDouble(output[i+1]);
				aug2 = aug2 + r[count];
			}
			else if(output[i].contains("Dark Lady Of")) {
				dark = dark + Double.parseDouble(output[i+1]);
				dark2 = dark2 + r[count];
			}
			else if (output[i].contains("Lied")) {
				how = how + Double.parseDouble(output[i+1]);
				how2 = how2 + r[count];
			}
			else if(output[i].contains("Overruled")) {
				over = over + Double.parseDouble(output[i+1]);
				over2 = over2 + r[count];
			}
			else if (output[i].contains("Inca Of Per")) {
				inca = inca + Double.parseDouble(output[i+1]);
				inca2 = inca2 + r[count];
			}

			else if(output[i].contains("Coats")) {
				coats = coats + Double.parseDouble(output[i+1]);
				coats2 = coats2 + r[count];
			}
			else if(output[i].contains("Darmer's")) {
				darmer = darmer + Double.parseDouble(output[i+1]);
				darmer2 = darmer2 + r[count];
			}
			else if (output[i].contains("McDonough")) {
				mcdon = mcdon + Double.parseDouble(output[i+1]);
				mcdon2 = mcdon2 + r[count];
			}
			else if(output[i].contains("Bogie Men")) {
				bogie = bogie + Double.parseDouble(output[i+1]);
				bogie2 = bogie2 + r[count];
			}
			else if (output[i].contains("Full Moon")) {
				moon = moon + Double.parseDouble(output[i+1]);
				moon2 = moon2 + r[count];
			}

			count++;
		}	



		System.out.println("John Galsworthy X^2 Cumulative = " + jg + " Rank Cumulative = " + jg2);
		System.out.println("*----- Defeat = " + def + " Rank Cumulative = " + def2);
		System.out.println("*----- Hall-Marked = " + hall + " Rank Cumulative = " + hall2);
		System.out.println("*----- Punch And Go = " + punch + " Rank Cumulative = " + punch2);
		System.out.println("*----- The First And Last = " + first + " Rank Cumulative = " + first2);
		System.out.println("*----- The Sun = " + sun + " Rank Cumulative = " + sun2);

		System.out.println("\n Lady Gregory X^2 Cumulative = " + lg + " Rank Cumulative = " + lg2);
		System.out.println("*----- Coats = " + coats + " Rank Cumulative = " + coats2);
		System.out.println("*----- Darmer's Gold = " + darmer + " Rank Cumulative = " + darmer2);
		System.out.println("*----- McDonough's Wife = " + mcdon + " Rank Cumulative = " + mcdon2);
		System.out.println("*----- The Bogie Men = " + bogie + " Rank Cumulative = " + bogie2);
		System.out.println("*----- The Full Moon = " + moon + " Rank Cumulative = " + moon2);

		System.out.println("\n Bernard Shaw X^2 Cumulative = " + gbs + " Rank Cumulative = " + gbs2);
		System.out.println("*----- Augustus Does His Bit = " + aug + " Rank Cumulative = " + aug2);
		System.out.println("*----- Dark Lady Of The Sonnets = " + dark + " Rank Cumulative = " + dark2);
		System.out.println("*----- How He Lied = " + how + " Rank Cumulative = " + how2);
		System.out.println("*----- Overruled = " + over + " Rank Cumulative = " + over2);
		System.out.println("*----- The Inca Of Perusalem = " + inca + " Rank Cumulative = " + inca2);

	}

	public static void Samples (String filePath) throws IOException {
		ArrayList answer = new ArrayList();
		File[] LG1 = GetFolderFiles.GFF("Authors/Lady Gregory/Coats/Bigrams/Compare");
		File[] LG2 = GetFolderFiles.GFF("Authors/Lady Gregory/Darmer's Gold/Bigrams/Compare");
		File[] LG3 = GetFolderFiles.GFF("Authors/Lady Gregory/McDonough's Wife/Bigrams/Compare");
		File[] LG4 = GetFolderFiles.GFF("Authors/Lady Gregory/The Bogie Men/Bigrams/Compare");
		File[] LG5 = GetFolderFiles.GFF("Authors/Lady Gregory/The Full Moon/Bigrams/Compare");

		int totalFilesLG = LG1.length + LG2.length + LG3.length + LG4.length + LG5.length;	
		File [] LG = new File[totalFilesLG];
		for(int i = 0; i < totalFilesLG; i++) {
			if (i<LG1.length) {
				LG[i] = LG1[i];
			}
			else if (i<LG1.length+LG2.length) {
				LG[i] = LG2[i-LG1.length];
			}
			else if (i<LG1.length+LG2.length + LG3.length) {
				LG[i] = LG3[i-(LG1.length+LG2.length)];
			}
			else if (i<LG1.length+LG2.length+LG3.length+LG4.length) {
				LG[i] = LG4[i-(LG1.length+LG2.length + LG3.length)];
			}
			else if (i<totalFilesLG) {
				LG[i] = LG5[i-(LG1.length+LG2.length+LG3.length+LG4.length)];
			}
		}

		File[] JG1 = GetFolderFiles.GFF("Authors/John Galsworthy/Defeat/Bigrams/Compare");
		File[] JG2 = GetFolderFiles.GFF("Authors/John Galsworthy/Hall-Marked/Bigrams/Compare");
		File[] JG3 = GetFolderFiles.GFF("Authors/John Galsworthy/Punch And Go/Bigrams/Compare");
		File[] JG4 = GetFolderFiles.GFF("Authors/John Galsworthy/The First And Last/Bigrams/Compare");
		File[] JG5 = GetFolderFiles.GFF("Authors/John Galsworthy/The Sun/Bigrams/Compare");
		int totalFilesJG = JG1.length + JG2.length + JG3.length + JG4.length + JG5.length;	
		File [] JG = new File[totalFilesJG];
		for(int i = 0; i < totalFilesJG; i++) {
			if (i<JG1.length) {
				JG[i] = JG1[i];
			}
			else if (i<JG1.length+JG2.length) {
				JG[i] = JG2[i-JG1.length];
			}
			else if (i<JG1.length+JG2.length + JG3.length) {
				JG[i] = JG3[i-(JG1.length+JG2.length)];
			}
			else if (i<JG1.length+JG2.length+JG3.length+JG4.length) {
				JG[i] = JG4[i-(JG1.length+JG2.length+JG3.length)];
			}
			else if (i<totalFilesJG) {
				JG[i] = JG5[i-(JG1.length+JG2.length+JG3.length+JG4.length)];
			}
		}

		File[] GBS1 = GetFolderFiles.GFF("Authors/George Bernard Shaw/Augustus Does His Bit/Bigrams/Compare");
		File[] GBS2 = GetFolderFiles.GFF("Authors/George Bernard Shaw/Dark Lady Of The Sonnets/Bigrams/Compare");
		File[] GBS3 = GetFolderFiles.GFF("Authors/George Bernard Shaw/How He Lied To Her Husband/Bigrams/Compare");
		File[] GBS4 = GetFolderFiles.GFF("Authors/George Bernard Shaw/Overruled/Bigrams/Compare");
		File[] GBS5 = GetFolderFiles.GFF("Authors/George Bernard Shaw/The Inca Of Perusalem/Bigrams/Compare");	
		int totalFilesGBS = GBS1.length + GBS2.length + GBS3.length + GBS4.length + GBS5.length;	
		File [] GBS = new File[totalFilesGBS];
		for(int i = 0; i < totalFilesGBS; i++) {
			if (i<GBS1.length) {
				GBS[i] = GBS1[i];
			}
			else if (i<GBS1.length+GBS2.length) {
				GBS[i] = GBS2[i-GBS1.length];
			}
			else if (i<GBS1.length+GBS2.length + GBS3.length) {
				GBS[i] = GBS3[i-(GBS1.length+GBS2.length)];
			}
			else if (i<GBS1.length+GBS2.length+GBS3.length+GBS4.length) {
				GBS[i] = GBS4[i-(GBS1.length+GBS2.length+GBS3.length)];
			}
			else if (i<totalFilesGBS) {
				GBS[i] = GBS5[i-(GBS1.length+GBS2.length+GBS3.length+GBS4.length)];
			}
		}

		int totalFiles = LG.length + JG.length + GBS.length;
		File [] all = new File[totalFiles];
		for(int i = 0; i < totalFiles; i++) {
			if (i<LG.length) {
				all[i] = LG[i];
			}
			else if (i<LG.length+JG.length) {
				all[i] = JG[i-LG.length];
			}
			else if (i<LG.length+JG.length+GBS.length) {
				all[i] = GBS[i-(LG.length+JG.length)];
			}
		}

		String toTest = Cleaning.clean(filePath,"Guess", "Guess");
		Bigram2.bigram(toTest, "Guess", "Guess","Guess");

		for(int i = 0; i < all.length; i++) {
			answer.add(BigramEquations2.doTheMaths("Guess Bigram.txt", all[i].toString()));
		}

		/*File[] all2 = GetFolderFiles.GFF("Who Is It");
		File[]all3 = GetFolderFiles.GFF("Bigram Comparisons");

		for(int i = 0; i < all2.length; i++) {
			for(int j = 0; j < all3.length; j++) {
				compareBigrams.CompBigrams(all2[i].toString(),all3[j].toString());
			}
		} */
		String[] output = answer.toString().replace("]", "").split(",");
		//System.out.println(output[0] + output[1]);
		double jg = 0;
		double lg = 0;
		double gbs = 0;
		double jg2 = 0;
		double lg2 = 0;
		double gbs2 = 0;
		double [] a = new double[77];
		int count = 0;



		for (int i = 0; i < output.length; i=i+2) {
			a[count] = Double.parseDouble(output[i+1]);
			count++;
		}	



		int[] r = rankify(a,a.length);	
		count = 0;

		for (int i = 0; i < output.length; i=i+2) {
			if(output[i].contains("John Galsworthy")) {
				jg = jg + Double.parseDouble(output[i+1]);
				jg2 = jg2 + r[count];
			}
			else if(output[i].contains("Lady Gregory")) {
				lg = lg + Double.parseDouble(output[i+1]);
				lg2 = lg2 + r[count];
			}
			else if (output[i].contains("George Bernard")) {
				gbs = gbs + Double.parseDouble(output[i+1]);
				gbs2 = gbs2 + r[count];
			}
			count++;
		}	

		double def = 0;
		double hall = 0;
		double punch = 0;
		double first = 0;
		double sun = 0;
		double def2 = 0;
		double hall2 = 0;
		double punch2 = 0;
		double first2 = 0;
		double sun2 = 0;


		double aug = 0;
		double dark = 0;
		double how = 0;
		double over = 0;
		double inca = 0;
		double aug2 = 0;
		double dark2 = 0;
		double how2 = 0;
		double over2 = 0;
		double inca2 = 0;

		double coats = 0;
		double darmer = 0;
		double mcdon = 0;
		double bogie = 0;
		double moon = 0;
		double coats2 = 0;
		double darmer2 = 0;
		double mcdon2 = 0;
		double bogie2 = 0;
		double moon2 = 0;
		
		ArrayList playRankOrder = new ArrayList();

		count = 0;
		for (int i = 0; i < output.length; i=i+2) {
			if(output[i].contains("Defeat")) {
				def = def + Double.parseDouble(output[i+1]);
				def2 = def2 + r[count];
			}
			else if(output[i].contains("Hall-Marked")) {
				hall = hall + Double.parseDouble(output[i+1]);
				hall2 = hall2 + r[count];
			}
			else if (output[i].contains("Punch And Go")) {
				punch = punch + Double.parseDouble(output[i+1]);
				punch2 = punch2 + r[count];
			}
			else if(output[i].contains("First And")) {
				first = first + Double.parseDouble(output[i+1]);
				first2 = first2 + r[count];
			}
			else if (output[i].contains("The Sun")) {
				sun = sun + Double.parseDouble(output[i+1]);
				sun2 = sun2 + r[count];
			}

			else if(output[i].contains("Does His Bit")) {
				aug = aug + Double.parseDouble(output[i+1]);
				aug2 = aug2 + r[count];
			}
			else if(output[i].contains("Dark Lady Of")) {
				dark = dark + Double.parseDouble(output[i+1]);
				dark2 = dark2 + r[count];
			}
			else if (output[i].contains("Lied")) {
				how = how + Double.parseDouble(output[i+1]);
				how2 = how2 + r[count];
			}
			else if(output[i].contains("Overruled")) {
				over = over + Double.parseDouble(output[i+1]);
				over2 = over2 + r[count];
			}
			else if (output[i].contains("Inca Of Per")) {
				inca = inca + Double.parseDouble(output[i+1]);
				inca2 = inca2 + r[count];
			}

			else if(output[i].contains("Coats")) {
				coats = coats + Double.parseDouble(output[i+1]);
				coats2 = coats2 + r[count];
			}
			else if(output[i].contains("Darmer's")) {
				darmer = darmer + Double.parseDouble(output[i+1]);
				darmer2 = darmer2 + r[count];
			}
			else if (output[i].contains("McDonough")) {
				mcdon = mcdon + Double.parseDouble(output[i+1]);
				mcdon2 = mcdon2 + r[count];
			}
			else if(output[i].contains("Bogie Men")) {
				bogie = bogie + Double.parseDouble(output[i+1]);
				bogie2 = bogie2 + r[count];
			}
			else if (output[i].contains("Full Moon")) {
				moon = moon + Double.parseDouble(output[i+1]);
				moon2 = moon2 + r[count];
			}

			count++;
		}	
		
		playRankOrder.add(def2);
		playRankOrder.add(hall2);
		playRankOrder.add(punch2);
		playRankOrder.add(first2);
		playRankOrder.add(sun2);
		
		playRankOrder.add(aug2);
		playRankOrder.add(dark2);
		playRankOrder.add(how2);
		playRankOrder.add(over2);
		playRankOrder.add(inca2);
		
		playRankOrder.add(coats2);
		playRankOrder.add(darmer2);
		playRankOrder.add(mcdon2);
		playRankOrder.add(bogie2);
		playRankOrder.add(moon2);

		double minValue = Double.parseDouble(output[1]);
		for(int i=1;i<output.length;i=i+2){
			if(Double.parseDouble(output[i]) < minValue){
				minValue = Double.parseDouble(output[i]);
			}
		}
		String mostLikelyChar = "";
		for (int i =1; i < output.length; i=i+2) {
			if (Double.parseDouble(output[i]) == (minValue)) {
				mostLikelyChar = output[i-1];
			}
		}

		mostLikelyChar.replace("Guess & ", "");
		mostLikelyChar.replace("[", "");

		String splitter = FileSystems.getDefault().getSeparator();
		String fileName = filePath.replaceAll("Samples", "");
		fileName = fileName.replaceAll("All Speech.txtRemove Stage Directions.txtSample.txt", "");
		PrintWriter output2 = new PrintWriter (new FileWriter("Comparisons/" + fileName + ".txt"));

		String author = "";
		if(fileName.contains("John Galsworthy")) {
			author = "John Galsworthy";
		}
		if(fileName.contains("Lady Gregory")) {
			author = "Lady Gregory";
		}
		if(fileName.contains("George Bernard Shaw")) {
			author = "George Bernard Shaw";
		}
		String play = "";

		if(author.contains("John Galsworthy") | author.contains("Bernard Shaw")) {
		filePath = filePath.replace("Samples/", "");
		filePath = filePath.replace("John Galsworthy ", "");
		filePath = filePath.replace("Lady Gregory ", "");
		filePath = filePath.replace("George Bernard Shaw ", "");
		String[] filePath2 = filePath.split("[A-Z]{2,}");
		play = filePath2[0];
		}
		
		if(author.contains("Lady Gregory")) {
			filePath = filePath.replace("Samples/", "");
			filePath = filePath.replace("John Galsworthy ", "");
			filePath = filePath.replace("Lady Gregory ", "");
			filePath = filePath.replace("George Bernard Shaw ", "");
			if(filePath.contains("Coats")) {
			play = "Coats";
			}
			if(filePath.contains("Darmer's Gold")) {
				play = "Darmer's Gold";
				}
			if(filePath.contains("McDonough's Wife")) {
				play = "McDonough's Wife";
				}
			if(filePath.contains("The Bogie Men")) {
				play = "The Bogie Men";
				}
			if(filePath.contains("The Full Moon")) {
				play = "The Full Moon";
				}
		}

		double jgtotal = 1;
		int jgRank = 1;
		double lgtotal = 0;
		int lgRank = 1;
		double gbstotal = 0;
		int gbsRank = 1;
		lgtotal = coats + darmer + mcdon + bogie + moon;
		jgtotal = def + hall + punch + first + sun;
		gbstotal = aug + dark + how + over + inca;
		mostLikelyChar = mostLikelyChar.replace("Guess  &  ", "");
		int playRank = 1;
		if(author.contains("John Galsworthy")) {

			if (jgtotal > lgtotal) {
				jgRank++;
			}
			if (jgtotal > gbstotal) {
				jgRank++;
			}
			if(play.contains("Defeat")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (def2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," + jgtotal + "," + jgRank + "," + def + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Hall-Marked")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (hall2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," + jgtotal + "," + jgRank + "," + hall + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Punch And")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (punch2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," + jgtotal + "," + jgRank + "," + punch + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("First And")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (first >= Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," + jgtotal + "," + jgRank + "," + first + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("The Sun")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (sun2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," + jgtotal + "," + jgRank + "," + sun + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
		}

		if(author.contains("Lady Gregory")) {

			if (lgtotal > jgtotal) {
				lgRank++;
			}
			if (lgtotal > gbstotal) {
				lgRank++;
			}
			if(play.contains("Coats")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (coats2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +lgtotal + "," + lgRank + "," + coats + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Darmer's")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (darmer2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +lgtotal + "," + lgRank + "," + darmer + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("McDonough")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (mcdon2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +lgtotal + "," + lgRank + "," + mcdon + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Bogie")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (bogie2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +lgtotal + "," + lgRank + "," + bogie + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Moon")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (moon2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +lgtotal + "," + lgRank + "," + moon + "," + playRank +  ","  + mostLikelyChar + ","  + minValue );
			}

		}

		if(author.contains("George Bernard Shaw")) {
			
			if (gbstotal > jgtotal) {
				gbsRank++;
			}
			if (gbstotal > lgtotal) {
				gbsRank++;
			}
			if(play.contains("Augustus")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (aug2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +gbstotal + "," + gbsRank + "," + aug + "," + playRank + "," + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Sonnets")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (dark2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +gbstotal + "," + gbsRank + "," + dark + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Lied")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (how2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +gbstotal + "," + gbsRank + "," + how + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Overruled")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (over2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +gbstotal + "," + gbsRank + "," + over + "," + playRank + ","  + mostLikelyChar + ","  + minValue );
			}
			if(play.contains("Inca")) {
				for (int i = 0; i<playRankOrder.size(); i++) {
					if (inca2 >  Double.parseDouble(playRankOrder.get(i).toString())){
						playRank++;
					}
				}
				System.out.println(author + "," + play + "," + fileName + ",3000,4107," +gbstotal + "," + gbsRank + "," + inca + "," + playRank + ","  + mostLikelyChar + "," + minValue );
			}
		}



		output2.println("----------------------------------------");
		output2.println("This is likely: " + mostLikelyChar + ". X2 value: " + minValue);
		output2.println("----------------------------------------");
		output2.println("");

		output2.println("John Galsworthy X^2 Cumulative = " + jg + ", Rank Cumulative = " + jg2);
		output2.println("*----- Defeat = " + def + " Rank Cumulative = " + def2);
		output2.println("*----- Hall-Marked = " + hall + " Rank Cumulative = " + hall2);
		output2.println("*----- Punch And Go = " + punch + " Rank Cumulative = " + punch2);
		output2.println("*----- The First And Last = " + first + " Rank Cumulative = " + first2);
		output2.println("*----- The Sun = " + sun + " Rank Cumulative = " + sun2);

		output2.println("\n Lady Gregory X^2 Cumulative = " + lg + " Rank Cumulative = " + lg2);
		output2.println("*----- Coats = " + coats + " Rank Cumulative = " + coats2);
		output2.println("*----- Darmer's Gold = " + darmer + " Rank Cumulative = " + darmer2);
		output2.println("*----- McDonough's Wife = " + mcdon + " Rank Cumulative = " + mcdon2);
		output2.println("*----- The Bogie Men = " + bogie + " Rank Cumulative = " + bogie2);
		output2.println("*----- The Full Moon = " + moon + " Rank Cumulative = " + moon2);

		output2.println("\n Bernard Shaw X^2 Cumulative = " + gbs + " Rank Cumulative = " + gbs2);
		output2.println("*----- Augustus Does His Bit = " + aug + " Rank Cumulative = " + aug2);
		output2.println("*----- Dark Lady Of The Sonnets = " + dark + " Rank Cumulative = " + dark2);
		output2.println("*----- How He Lied = " + how + " Rank Cumulative = " + how2);
		output2.println("*----- Overruled = " + over + " Rank Cumulative = " + over2);
		output2.println("*----- The Inca Of Perusalem = " + inca + " Rank Cumulative = " + inca2);

		output2.println("-----------------------------");


		output2.close(); 

	}

	public static int[] rankify(double A[], int n) 
	{ 
		// Rank Vector 
		int R[] = new int[n]; 

		// Sweep through all elements in A 
		// for each element count the number 
		// of less than and equal elements 
		// separately in r and s 
		for (int i = 0; i < n; i++) {
			int a = 1;
			for (int j = 0; j <n; j++) {
				if(A[i] > A[j]) {
					a++;
				}
			}
			R[i] = a;
		}  

		return R;
	} 
}
