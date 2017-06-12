import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class FileFinder  {

	/**Für diese Methode habe ich mich eigentlich 1:1 an 
	 * <a href="https://stackoverflow.com/questions/3154488/how-do-i-iterate-through-the-files-in-a-directory-in-java"> diesen Thread auf StackOverflow</a>
	 * gehalten, da ich absolut keinen blassen Schimmer hatte, wie die Aufgabe zu lösen wäre. 
	 * Da ich ein Programmierer bin und Programmierer faul sind (und das eine gute Eigenschaft sein soll!), habe ich eigentlich nur den Code kopiert
	 * und die öffentliche Methode so geschrieben, dass sie an die private Methode die nötigen Parameter übergibt. 
	 * Ist aber, denke ich, in diesem Fall zu verschmerzen, da das Prinzip doch sehr simpel ist.
	 * 
	 * @param directory
	 * 
	 */
	
	public void showFiles(File directory) {
		
		// Array erstellen mit Files aus dem spezifizierten Verzeichnis
		
		File[] fileArr = directory.listFiles(); 
		
		// private Methode mit dem erstellten Array als Parameter aufrufen
		
		showFiles(fileArr);

		
	}
	private void showFiles (File[] fileArr) {
		
		// über alle Element des Arrays iterieren
		
		for (File file : fileArr) {
	        if (file.isDirectory()) { // wenn es ein Verzeichnis ist, rekursiv absteigen nachdem Name ausgegeben wurde
	            System.out.println("Directory: " + file.getName());
	            showFiles(file.listFiles()); 
	        } else {
	            System.out.println("File: " + file.getName()); // falls es eine Datei ist, Namen ausgeben
	        }
	    }
	}
	
	/**
	 * Diese Methode habe ich selbst geschrieben, nutzt aber einfach nur das Wissen vom selben Link: 
	 *  <a href ="https://stackoverflow.com/questions/3154488/how-do-i-iterate-through-the-files-in-a-directory-in-java">Thread auf StackOverflow.com</a>
	 *  
	 * @param directory
	 */
	
	public void listFiles (File directory) {
		File[] fileArr = directory.listFiles();  //Array anhand der Eingabe erschaffen
		
		for (File file : fileArr) { // über alle Dateien iterieren, die eine Datei sind (und kein Unterverzeichnis)
			if (file.isFile()) {
				System.out.println("File: " + file.getName());
				
			}
		}
		System.out.println("\nKeine weiteren Dateien im Verzeichnis, Methode bitte mit neuem Unterverzeichnis neu aufrufen.");
		
	}
	
	/**
	 * Selbes Prinzip wie bei {@link #showFiles(File) showFiles()}, public Methode die dann die private Methode aufruft.
	 * Einziger Unterschied: es wird auch eine Liste übergeben, welche dann innerhalb der privaten Methode gefüllt wird.
	 * @param directory
	 * @return List<File>
	 */
	
	public List<File> getFiles(File directory) {
		LinkedList<File> toReturn = new LinkedList<File>();
		File[] fileArr = directory.listFiles(); 
		
		return getFiles(fileArr, toReturn); // Liste die von der privaten Methode erstellt wird zurückgeben
	}
	
	private List<File> getFiles (File[] fileArr, List<File> toReturn) {
		
		for (File file : fileArr) {
	        if (file.isDirectory()) { // wenn es ein Verzeichnis ist, rekursiv absteigen 
	        	
	        	// Liste wird mit übergeben, damit sie um die weiteren Einträge erweitert wird
	            getFiles(file.listFiles(), toReturn); 
	        } else {
        		toReturn.add(file); // falls es eine Datei ist, in die Liste anfügen
	        }
	    }
		
		// sortieren nach den Spezifikationen des Comperators, in diesem Fall: Name der Datei
		// ergibt eine alphabetische Sortierung
		
		Collections.sort(toReturn, new Comparator<File>(){
			@Override
			public int compare (File file1, File file2) {
				return file1.getName().compareTo(file2.getName());
			}
			
		});
		
		return toReturn;
		
	}

	
}
