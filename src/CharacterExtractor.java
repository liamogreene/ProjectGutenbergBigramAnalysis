import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.events.Characters;

public class CharacterExtractor {


	public static void charExtractor(String filename, String author, String play) throws IOException {

		String inputFileName = filename ;
		String fullCharacterList = "User Decided Character List.txt";
		PrintWriter outputFullCharacterList = new PrintWriter (new FileWriter("Authors/" + author + "/" + play + 
				"/" + "Bigrams/" + fullCharacterList));

		List<String> characters = new ArrayList<String>();
		String chars = "";

		String playWithSpacesRemoved = Cleaning.clean(inputFileName, author, play);

		//find all characters
		if(author.equals("John Galsworthy") | author.equals("George Bernard Shaw")) {
			Pattern getCharacter = Pattern.compile("[A-Z]{2,} [A-Z]{2,}[.]|[A-Z]{2,}[.]"); //can add Pattern.compile("[A-Z]{2,}[.]"); or [A-Z]{2,} [A-Z]{2,}[.]|[A-Z]{2,}[.]
			Matcher getCharacters = getCharacter.matcher(playWithSpacesRemoved);
			while (getCharacters.find()) {
				String characterNameFull = getCharacters.group();
				int characterNameLength = characterNameFull.length();
				String characterNameMinusPeriod = characterNameFull.substring(0, characterNameLength-1);
				characters.add(characterNameMinusPeriod);
			}
		}

		//find all characters
		if(author.equals("Lady Gregory")) {
			Pattern getCharacter = Pattern.compile("_{1}[A-z]{2,}:_ |_{1}[A-z]{2,} [A-z]{2,}:_ "); //can add Pattern.compile("[A-Z]{2,}[.]"); or [A-Z]{2,} [A-Z]{2,}[.]|[A-Z]{2,}[.]
			Matcher getCharacters = getCharacter.matcher(playWithSpacesRemoved);
			while (getCharacters.find()) {
				String characterNameFull = getCharacters.group();
				int characterNameLength = characterNameFull.length();
				String characterNameMinusPeriod = characterNameFull.substring(0, characterNameLength-1);
				characters.add(characterNameMinusPeriod);
			}
		}

		// remove duplicates
		List<String> characterWithDuplicatesRemoved = new ArrayList<String>(); 
		// Traverse through the first list 
		for (String element : characters) { 
			// If this element is not present in newList 
			// then add it 
			if (!characterWithDuplicatesRemoved.contains(element)) { 
				characterWithDuplicatesRemoved.add(element); 
			} 
		} 

		List<String> userDecidedCharacterList = new ArrayList<String>(); 

		//check list with user and confirm
		for (String element : characterWithDuplicatesRemoved) { 
			System.out.println(element + " - Keep (1), Remove (2)");
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			if (i == 1) { 
				userDecidedCharacterList.add(element); 
				outputFullCharacterList.println(element);
			} 
		} 
		outputFullCharacterList.close();
		for (int i = 0; i<userDecidedCharacterList.size();i++) {
			chars = chars + userDecidedCharacterList.get(i) + "|";
		}

		quoteExtractor(userDecidedCharacterList, playWithSpacesRemoved, author, play);

	}

	public static void quoteExtractor(List<String> userDecidedCharacterList, String playWithSpacesRemoved,
			String author, String play) throws IOException {

		//create the appropriate amount of output files based on characters in play
		List<String> characterOutputFileNames = new ArrayList<String>();
		for (int i = 0; i<userDecidedCharacterList.size(); i++) {
			characterOutputFileNames.add(userDecidedCharacterList.get(i) + " All Speech.txt");
		}

		for (int i = 0; i<characterOutputFileNames.size(); i++) {
			characterOutputFileNames.set(i, characterOutputFileNames.get(i).replaceAll("_", "").replaceAll(":", ""));
		}

		for (int i = 0; i<characterOutputFileNames.size(); i++) {



			PrintWriter outputCharacterAllSpeech = new PrintWriter (new FileWriter("Authors/" + author + "/" + play + 
					"/" + "Bigrams/" + characterOutputFileNames.get(i)));

			String patternFinal = "";
			if (author.equals("John Galsworthy") | author.equals("George Bernard Shaw")) {
				System.out.println(characterOutputFileNames.get(i));
				String cList = userDecidedCharacterList.toString();
				String cList2 = cList.replaceAll("\\[", "");
				String cList3 = cList2.replaceAll("\\]", "");
				String cList4 = cList3.replaceAll(",", "\\\\\\.|");
				String cList5 = cList4.replaceAll(" ", "");
				String cList6 = "\\.)";
				String cList7 = cList5 + cList6;

				String patternPart1 = "(?<=" + userDecidedCharacterList.get(i) + "\\.)(.*?)(?=";
				patternFinal = patternPart1 + cList7;
			}

			if (author.equals("Lady Gregory")) {
				System.out.println(characterOutputFileNames.get(i));
				String cList = userDecidedCharacterList.toString();
				String cList2 = cList.replaceAll("\\[", "");
				String cList3 = cList2.replaceAll("\\]", "");
				String cList4 = cList3.replaceAll(",", "\\|");
				String cList5 = cList4.replaceAll(" ", " ");
				String cList6 = ")";
				String cList7 = cList5 + cList6;

				String patternPart1 = "(?<=" + userDecidedCharacterList.get(i) + ")(.*?)(?=";
				patternFinal = patternPart1 + cList7;
			}


			Pattern getCharacterQuote = Pattern.compile(patternFinal); //for ref = "(?<=LARRY\\.)(.*?)(?=LARRY\\.|WANDA\\.|KEITH\\.)"
			Matcher getCharacterQuotes = getCharacterQuote.matcher(playWithSpacesRemoved);
			while (getCharacterQuotes.find()) {
				outputCharacterAllSpeech.println(getCharacterQuotes.group());
			}
			outputCharacterAllSpeech.close();

			String readCharacterAllSpeechFile = characterOutputFileNames.get(i);
			System.out.println(readCharacterAllSpeechFile);
			System.out.println(patternFinal);
			String characterAllSpeechWithSpacesRemoved = Cleaning.clean("Authors/" 
					+ author + "/" + play + "/" + "Bigrams/" + readCharacterAllSpeechFile, author, play);

			String characterSpeechWithSDRemovedFile = characterOutputFileNames.get(i) + "Remove Stage Directions.txt";
			PrintWriter outputCharacterSpeechWithSDRemoved = new PrintWriter (new FileWriter("Authors/" + author + "/" + play + 
					"/" + "Bigrams/" + characterSpeechWithSDRemovedFile));

			Pattern removedSD = Pattern.compile("(?<=^|\\])[^\\[]*");
			Pattern removedSDLG = Pattern.compile("(?<=^|\\)\\_)[^\\\\|\\_\\(]*");
			Matcher removedSDs = removedSD.matcher(characterAllSpeechWithSpacesRemoved);
			Matcher removedSDsLG = removedSDLG.matcher(characterAllSpeechWithSpacesRemoved);

			if (author.equals("John Galsworthy") | author.equals("George Bernard Shaw")) {
				while (removedSDs.find()) 
				{
					outputCharacterSpeechWithSDRemoved.println(removedSDs.group());
				}
				outputCharacterSpeechWithSDRemoved.close();
			}

			else if (author.equals("Lady Gregory")) {
				while (removedSDsLG.find()) 
				{
					outputCharacterSpeechWithSDRemoved.println(removedSDsLG.group());
				}
				outputCharacterSpeechWithSDRemoved.close();
			}


			String inputFileName3 = characterSpeechWithSDRemovedFile;
			String outputCharacterSpeechWithSDRemovedAndCleaned = Cleaning.clean("Authors/" 
					+ author + "/" + play + "/" + "Bigrams/" + inputFileName3, author, play);

			int totalCount = Bigram.bigram(outputCharacterSpeechWithSDRemovedAndCleaned, characterOutputFileNames.get(i)
					,author, play);

		} 

	}
}



