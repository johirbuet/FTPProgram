import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Download {
	public static void main(String[] args) {
        String server = "ftp.ncdc.noaa.gov";
        int port = 21;
        String user = "anonymous";
        String pass = "johirbuet@gmail.com";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server, port);
          //  ftpClient.login(user, pass);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            int reply = ftpClient.getReplyCode();
            System.out.println(reply);
            if(!FTPReply.isPositiveCompletion(reply)){
            	System.out.println("Not postive reply");
            	ftpClient.disconnect();
            }
          
           // System.out.println(ftpClient.getSystemName());
            System.out.println(ftpClient);
            ftpClient.changeWorkingDirectory("/pub/data/noaa/2016/");
            System.out.println("Working directory "+ ftpClient.printWorkingDirectory());
            FTPFile [] files = ftpClient.listFiles();
            System.out.println(files.length);
            if(files != null &&  files.length > 0){
            	for(FTPFile file : files){
            		if(!file.isFile()){
            			continue;
            		}
            		System.out.println(file.getName());
            		OutputStream outputStream = new FileOutputStream("/Users/mislam/Desktop/Data/ish/2016/"+file.getName());
            		ftpClient.retrieveFile(file.getName(), outputStream);
            		outputStream.close();
            	}
            }
           
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    //ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
}
}
