package data;
import java.util.ArrayList;
import java.util.Objects;
import data.flowData;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DataInput {

    String dirname;
    flowData flow;

    public void setDirectory(String dirname){
        this.dirname = dirname;
    }

    public String getDirectory(){
        if (Objects.equals(this.dirname, "")){
            throw new java.lang.RuntimeException("Directory has not been set yet");
        } else {
            return this.dirname;
        }
    }

    public ArrayList getCsvList(){
        // Check to see if directory has been specified
        ArrayList<String> csvList = new ArrayList<>();
        try {
            String directory = this.dirname;
            // Get list of *.csv files in directory
            File[] files = new File(directory).listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    csvList.add(directory+file.getName());
                }
            }
        } catch(java.lang.RuntimeException ex) {
            System.out.print(ex.getMessage());
        }

        return csvList;

    }

    public void readCSV(ArrayList<String> csvList){
        int numFiles = csvList.size();
        flowData flow = new flowData();
        // Read each file in the list

        for(int i = 0; i < numFiles; i++){
            File file = new File(csvList.get(i));
            try {
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    System.out.println(scanner.next());
                }
                scanner.close();
            } catch (FileNotFoundException fe){
                fe.printStackTrace();
            }
        }
        this.flow = flow;

    }

    public void DataInput(){

    }


}
