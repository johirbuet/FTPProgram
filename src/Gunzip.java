import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Gunzip {
	public static void main(String[] args) {
		String inputbase ="/Users/mislam/Desktop/Data/ish/2016/";
		String outputBase ="/Users/mislam/Desktop/Data/ish/2016_txt/";
		File folder = new File(inputbase);
		File[] listOfFiles = folder.listFiles();
		for(File file : listOfFiles){
			gunzipIt(inputbase+file.getName(),outputBase+file.getName().substring(0,file.getName().indexOf(".")));
		}
	}

	public static void gunzipIt(String INPUT_GZIP_FILE, String OUTPUT_FILE) {

		byte[] buffer = new byte[1024];

		try {

			GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(INPUT_GZIP_FILE));

			FileOutputStream out = new FileOutputStream(OUTPUT_FILE);

			int len;
			while ((len = gzis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}

			gzis.close();
			out.close();

			System.out.println("Done");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
