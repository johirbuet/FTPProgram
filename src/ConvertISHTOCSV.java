import java.io.File;
import java.io.IOException;

public class ConvertISHTOCSV {
	public static void main(String[] args) {
		String input_base = "/Users/mislam/Desktop/Data/ish/2016_txt/";
		File folder = new File(input_base);
		File [] files = folder.listFiles();
		int count =0;
		for(File f : files){
			if(count==10){
				break;
			}
			System.out.println(f.getName());
			try {
				Process p = Runtime.getRuntime().exec("java /Users/mislam/Desktop/Data/ish/2016_txt/ishJava /Users/mislam/Desktop/Data/ish/2016_txt/ishJava/"+
										f.getName()+" /Users/mislam/Desktop/Data/ish/2016_txt/ishJava/"+f.getName()+".csv");
				count++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
