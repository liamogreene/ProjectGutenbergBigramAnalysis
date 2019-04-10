import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class grabAllBigramFiles {

	public static void GABF () throws IOException {
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

		for(int i = 0; i < all.length; i++) {
			for (int j = 0; j < all.length; j++) {
				BigramEquations.doTheMaths(all[i].toString(), all[j].toString());
			}
			
		}
	}
}
