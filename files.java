
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class files {
   
    // List all the files and folders from a directory

    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
            System.out.println("1");
        }
    }

    // List all the files under a directory
    public ArrayList<File> listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        ArrayList<File> files = new ArrayList<File>();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
                files.add(file);
                //System.out.println("2");
            }
        }
        return files;
    }
   
    // List all the folder under a directory
        public ArrayList<File> listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        ArrayList<File> folders = new ArrayList<File>();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getAbsolutePath().toUpperCase());
                folders.add(file);
                //System.out.println("3");
            }
        }
        return folders;
    }

    // List all files from a directory and its subdirectories

    public void listFilesAndFilesSubDirectories(String directoryName, PrintWriter out){
        File directory = new File(directoryName);
        //get all the files from a directory
        ArrayList<File> files, folders;
        //File[] fList = directory.listFiles();
        folders = this.listFolders(directoryName);
        files = this.listFiles(directoryName);
        if(!files.isEmpty())
        	for(File file :files)
        		out.println(file.getAbsolutePath());
        if(!folders.isEmpty())
        for (File folder : folders){
            System.out.println(folder.getAbsolutePath().toUpperCase() );
                this.listFilesAndFilesSubDirectories(folder.getAbsolutePath(), out);
            
        }
    }
   
    public static void main (String[] args){
        files listFilesUtil = new files();
        final String directoryLinuxMac ="/Users/alirezakarami/Desktop/3D";
        //Windows directory example
        final String directoryWindows ="C:\\Users\\Public";
       
       
        //
        //
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(directoryLinuxMac + "/../testing.txt"));
            } catch (IOException e) {
                    e.printStackTrace();
                    return;
            }
        //listFilesUtil.listFiles(directoryWindows);
        //listFilesUtil.listFolders(directoryWindows);
        listFilesUtil.listFilesAndFilesSubDirectories(directoryLinuxMac, out);
        
        out.close();
    }
}