import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class GetRandomSpeechSamples {

	public static void GRSS() throws IOException {
		ArrayList files = GetFiles();
		ArrayList speeches = new ArrayList();

		for (int i = 0; i < files.size(); i++) {
			speeches.add(Cleaning.clean(files.get(i).toString(), "", ""));
		}

		int average = 0;
		for (int i = 0; i < speeches.size(); i++) {
			average = average + speeches.get(i).toString().length();
		}

		average = average / files.size();
		//System.out.println(average);
		int sampleSize = 2000;
		ArrayList samples = new ArrayList();
		for (int i = 0; i < speeches.size(); i++) {
			if(speeches.get(i).toString().length() >= 2000) {
				double randomStartingPoint = (Math.random() * (((speeches.get(i).toString().length() - sampleSize) - 0) + 1)) + 0;
				double end = randomStartingPoint + sampleSize;
				String sample = speeches.get(i).toString().substring((int) randomStartingPoint, (int) end);
				String splitter = FileSystems.getDefault().getSeparator();
				String[] fileName = files.get(i).toString().split(Pattern.quote(splitter));
				String filePath = "Samples/" + fileName[1] + " " + fileName[2] + " " + fileName[4] + "Sample.txt";
				PrintWriter output = new PrintWriter (new FileWriter(filePath));
				output.print(sample);
				samples.add(sample);
				output.close();
				GrabAllBigramEquationFiles.Samples(filePath);
			}
		}



	}

	public static ArrayList GetFiles() {
		File[] folder = new File[15];
		folder[0] = new File("Authors/John Galsworthy/Defeat/Bigrams");
		folder[1] = new File("Authors/John Galsworthy/Hall-Marked/Bigrams");
		folder[2] = new File("Authors/John Galsworthy/Punch And Go/Bigrams");
		folder[3] = new File("Authors/John Galsworthy/The First And Last/Bigrams");
		folder[4] = new File("Authors/John Galsworthy/The Sun/Bigrams");

		folder[5] = new File("Authors/George Bernard Shaw/Augustus Does His Bit/Bigrams");
		folder[6] = new File("Authors/George Bernard Shaw/Dark Lady Of The Sonnets/Bigrams");
		folder[7] = new File("Authors/George Bernard Shaw/How He Lied To Her Husband/Bigrams");
		folder[8] = new File("Authors/George Bernard Shaw/Overruled/Bigrams");
		folder[9] = new File("Authors/George Bernard Shaw/The Inca Of Perusalem/Bigrams");

		folder[10] = new File("Authors/Lady Gregory/Coats/Bigrams");
		folder[11] = new File("Authors/Lady Gregory/Darmer's Gold/Bigrams");
		folder[12] = new File("Authors/Lady Gregory/McDonough's Wife/Bigrams");
		folder[13] = new File("Authors/Lady Gregory/The Bogie Men/Bigrams");
		folder[14] = new File("Authors/Lady Gregory/The Full Moon/Bigrams");

		File[] test1 = folder[0].listFiles();
		File[] test2 = folder[1].listFiles();
		File[] test3 = folder[2].listFiles();
		File[] test4 = folder[3].listFiles();
		File[] test5 = folder[4].listFiles();
		File[] test6 = folder[5].listFiles();
		File[] test7 = folder[6].listFiles();
		File[] test8 = folder[7].listFiles();
		File[] test9 = folder[8].listFiles();
		File[] test10 = folder[9].listFiles();
		File[] test11 = folder[10].listFiles();
		File[] test12 = folder[11].listFiles();
		File[] test13 = folder[12].listFiles();
		File[] test14 = folder[13].listFiles();
		File[] test15 = folder[14].listFiles();

		ArrayList<String> ans = new ArrayList<String>();

		//Edited i<testi.length to i<3 2 to have only two characters for each play

		int CC = 0;
		int counter = 2;

		for(int i = 0; i<test1.length;i++) {
			if(CC < counter) {
				if(test1[i].toString().contains("Remove Stage Directions")) {
					ans.add(test1[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test2.length;i++) {
			if(CC < counter) {
				if(test2[i].toString().contains("Remove Stage Directions")) {
					ans.add(test2[i].toString()); CC++;
				}
			}
		}
		CC = 0;
		for(int i = 0; i<test3.length;i++) {
			if(CC < counter) {
				if(test3[i].toString().contains("Remove Stage Directions")) {
					ans.add(test3[i].toString()); CC++;
				}	
			}
		}

		CC = 0;
		for(int i = 0; i<test4.length;i++) {
			if(CC < counter) {
				if(test4[i].toString().contains("Remove Stage Directions")) {
					ans.add(test4[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test5.length;i++) {
			if(CC < counter) {
				if(test5[i].toString().contains("Remove Stage Directions")) {
					ans.add(test5[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test6.length;i++) {
			if(CC < counter) {
				if(test6[i].toString().contains("Remove Stage Directions")) {
					ans.add(test6[i].toString()); CC++;
				}
			}

		}

		CC = 0;
		for(int i = 0; i<test7.length;i++) {
			if(CC < counter) {		
				if(test7[i].toString().contains("Remove Stage Directions")) {
					ans.add(test7[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test8.length;i++) {
			if(CC < counter) {	
				if(test8[i].toString().contains("Remove Stage Directions")) {
					ans.add(test8[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test9.length;i++) {
			if(CC < counter) {	
				if(test9[i].toString().contains("Remove Stage Directions")) {
					ans.add(test9[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test10.length;i++) {
			if(CC < counter) {	
				if(test10[i].toString().contains("Remove Stage Directions")) {
					ans.add(test10[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test11.length;i++) {
			if(CC < counter) {	
				if(test11[i].toString().contains("Remove Stage Directions")) {
					ans.add(test11[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test12.length;i++) {
			if(CC < counter) {
				if(test12[i].toString().contains("Remove Stage Directions")) {
					ans.add(test12[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test13.length;i++) {
			if(CC < counter) {
				if(test13[i].toString().contains("Remove Stage Directions")) {
					ans.add(test13[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test14.length;i++) {
			if(CC < counter) {
				if(test14[i].toString().contains("Remove Stage Directions")) {
					ans.add(test14[i].toString()); CC++;
				}
			}
		}

		CC = 0;
		for(int i = 0; i<test15.length;i++) {
			if(CC < counter) {
				if(test15[i].toString().contains("Remove Stage Directions")) {
					ans.add(test15[i].toString()); CC++;
				}
			}
		}

		ArrayList ans2 = ans;
		//System.out.println(ans.toString()); CC++;
		return ans;



	}
}
