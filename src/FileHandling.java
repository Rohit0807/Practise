import java.io.File;

public class FileHandling {

	public static void main(String[] args) {
		//Counting no. of files in a folder with .txt extension
				String s = "D:\\Interview";
				int count=0;
				File folder= new File(s);
				
				if(folder.isDirectory()) {
					File[] f = folder.listFiles();
					
					for(File x:f) {
						if(x.isFile()  && x.getName().endsWith(".txt")) count++;
					}
				}
				System.out.println(count);
	}

}
