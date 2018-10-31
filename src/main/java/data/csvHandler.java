package data;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.NoFilesInDirectory;

public class csvHandler extends dataHandler {

    public csvHandler(String filetype, String dirname){
        this.filetype = filetype;
        this.dirname = dirname;
        this.fileList = new ArrayList<>();
    }


    public void fileReader(ArrayList<String> fileList, dataObject DataObject) throws NoFilesInDirectory {

        int numFiles = fileList.size();
        if(numFiles==0){
            throw new NoFilesInDirectory();
        }
        File file = new File(fileList.get(0));
        try{
            Scanner scanner0 = new Scanner(file);
            String row0 = scanner0.nextLine();
            String[] rowList0 = row0.split(",");
            System.out.println(rowList0[0]);
            DataObject.setColumnSize(rowList0.length);
            System.out.println(DataObject.getColumnSize());
            scanner0.close();}
        catch (FileNotFoundException fe){
            fe.printStackTrace();

        }

        // Read each file in the list

        for(int i = 0; i < numFiles; i++){
            file = new File(fileList.get(i));
            try {
                Scanner scanner = new Scanner(file);
                //scanner.useDelimiter(",");
                int line = 0;
                while (scanner.hasNextLine()) {
                    String row = scanner.nextLine();
                    String[] rowList = row.split(",");
                    INDArray rowArray = Nd4j.create(rowList.length);
                    System.out.println(rowList[0]);

                    for(int j=0; j < rowList.length; j++) {
                        System.out.println("Reading column:");
                        System.out.println(j);
                        float cell = Float.parseFloat(rowList[j]);
                        rowArray.putScalar(j, cell);

                    }
                    if(line==0 & i==0){
                        int size = DataObject.getColumnSize();
                        DataObject.addRow(0,rowArray);
                    } else {
                        DataObject.addRow(1,rowArray);

                    }
                    line++;
                }
                scanner.close();
            } catch (FileNotFoundException fe){
                fe.printStackTrace();
            }
        }

    }

}

