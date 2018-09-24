package ui;
import data.DataInput;
import java.util.Scanner;
import java.util.ArrayList;

public class deepFlow {

    DataInput input = new DataInput();

    public String scanFile(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please specify the directory of *.fcs files: ");
        String file = reader.nextLine();
        reader.close();
        System.out.println("Setting directory: "+file);
        return file;
    }

    public static void main(String[] args){

        deepFlow flow = new deepFlow();
        String file = flow.scanFile();
        flow.input.setDirectory(file);
        ArrayList<String> csvList = flow.input.getCsvList();
        System.out.println(csvList);
        flow.input.readCSV(csvList);
        System.out.println("This is the main method");
    }
}


