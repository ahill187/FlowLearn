package data;
import exceptions.NoFilesInDirectory;

import java.io.File;
import java.util.ArrayList;

public abstract class dataHandler {

    public String dirname;
    public String filetype;
    public ArrayList<String> fileList;

    public void setDirectory(String dirname){
        this.dirname = dirname;
        System.out.println(this.dirname);
    }

    public String getDirectory(){
        return this.dirname;
    }

    public void setFileType(String filetype){
        if(filetype.equals("csv")){
            this.filetype = ".csv";
        } else {
            this.filetype = "";
        }
    }

    public ArrayList getFileList(){

        try {
            // Get list of *.csv files in directory
            File[] files = new File(this.dirname).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    if(name.contains(this.filetype)){
                        this.fileList.add(this.dirname+name);
                    }

                }
            }
        }
        catch(java.lang.RuntimeException ex) {
            System.out.print(ex.getMessage());
        }

        return fileList;
    }

    public abstract void fileReader(ArrayList<String> fileList, dataObject DataObject) throws NoFilesInDirectory;



}
