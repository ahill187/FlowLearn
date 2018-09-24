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

    //EFFECTS: return name of directory containing flow data files
    public String getDirectory(){
        if (Objects.equals(this.dirname, "")){
            throw new java.lang.RuntimeException("Directory has not been set yet");
        } else {
            return this.dirname;
        }
    }

    // EFFECTS: returns a list of .csv filenames in the directory
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

    // MODIFIES: this
    // EFFECTS: reads .csv files in directory
    //          create a Flow object containing data from all files
    public void readCSV(ArrayList<String> csvList){
        int numFiles = csvList.size();

        // Read each file in the list

        for(int i = 0; i < numFiles; i++){
            File file = new File(csvList.get(i));
            try {
                Scanner scanner = new Scanner(file);
                //scanner.useDelimiter(",");

                while (scanner.hasNext()) {
                    String row = scanner.nextLine();
                    String[] rowList = row.split(",");
                    System.out.println(rowList[0]);
                    if(i==0){
                        flowData flow = new flowData(rowList.length);
                    }
                    for(int j=0; j < rowList.length; j++){
                        System.out.println(rowList.length);
                        float cell = Float.parseFloat(rowList[j]);
                        System.out.println(cell);
                        System.out.println(flow.data.length);
                        flow.data[j].add(cell);
                    }
                    System.out.println(scanner.nextLine());
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
