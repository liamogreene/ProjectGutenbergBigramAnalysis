import java.io.File;

public class GetFolderFiles {
	
	public static File[] GFF (String folderPath) {
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		   // System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    //System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		return listOfFiles;
	}

}
