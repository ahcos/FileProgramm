import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		FileFinder fileFind = new FileFinder();
		
		File file = new File ("C:\\xampp\\htdocs");
		
//		fileFind.showFiles(file);
//		fileFind.listFiles(file);
		
		List<File> list =  fileFind.getFiles(file);
		
		for (File item : list) {
			System.out.println("File: " + item.getName());
		}
	}

}
