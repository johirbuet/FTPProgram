import java.io.File;
import java.io.IOException;

public class ConvertISHTOCSV {
	public static void main(String[] args) {
		String input_base = "/Users/mislam/Desktop/Data/ish/2016_txt/";
		File folder = new File(input_base);
		File [] files = folder.listFiles();
		int count =0;
		for(File f : files){
			System.out.println(f.getName());
			try {
				Process p = Runtime.getRuntime().exec("java ishJava /Users/mislam/Desktop/Data/ish/2016_txt/"+
										f.getName()+" /Users/mislam/Desktop/Data/ish/2016_csv/"+f.getName()+".csv");
				count++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
