import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CallCharacterExtractor {

	public static void CCE () throws IOException {
		File folder = new File("Authors");
		String folderDisplay = DisplayFolder.printFolderTree(folder);
		System.out.println(folderDisplay);
		boolean authorCorrect = false;
		boolean playCorrect = false;
		String authorName = "";
		String playName = "";
		Scanner sc = new Scanner(System.in);
		File tmpDir3 = new File(playName);

		while (authorCorrect == false) {
			System.out.println("Enter the full name of the Author you wish to study");
			authorName = sc.nextLine();
			File tmpDir = new File("Authors/"+authorName);
			System.out.println(tmpDir);
			if (tmpDir.isDirectory()) {
				authorCorrect = true;
			}
		}

		while (playCorrect == false) {
			System.out.println("Enter the full name of the play you wish to study");
			playName = sc.nextLine();
			File tmpDir2 = new File("Authors/" + authorName + "/" + playName + "/" + playName + " Full.txt");
			System.out.println(tmpDir2);
			if (tmpDir2.exists()) {
				playCorrect = true;
				tmpDir3 = tmpDir2;
			}

		}

		CharacterExtractor.charExtractor(tmpDir3.toString(),authorName,playName);
	}
}