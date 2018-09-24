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

        File file = new File(csvList.get(0));
        try{
            Scanner scanner0 = new Scanner(file);
            //scanner.useDelimiter(",");
            String row0 = scanner0.nextLine();
            String[] rowList0 = row0.split(",");
            System.out.println(rowList0[0]);
            flowData flow = new flowData(rowList0.length);
            System.out.println(flow.size);
            scanner0.close();}
            catch (FileNotFoundException fe){
            fe.printStackTrace();
                flowData flow = new flowData(1);
        }

        // Read each file in the list

        for(int i = 0; i < numFiles; i++){
            file = new File(csvList.get(i));
            try {
                Scanner scanner = new Scanner(file);
                //scanner.useDelimiter(",");

                while (scanner.hasNext()) {
                    String row = scanner.nextLine();
                    String[] rowList = row.split(",");
                    System.out.println(rowList[0]);

                    for(int j=0; j < rowList.length; j++){
                        System.out.println(rowList.length);
                        float cell = Float.parseFloat(rowList[j]);
                        System.out.println(flow.size);
                        System.out.println(cell);
                        if(i==0){
                            ArrayList<Float> Column = new ArrayList<>();
                            Column.add(cell);

                            flow.data.set(j, Column);
                        } else {
                            ArrayList<Float> Column = flow.data.get(j);
                            Column.add(cell);
                            flow.data.set(j, Column);
                        }

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
