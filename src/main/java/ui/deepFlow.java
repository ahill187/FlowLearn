package ui;

import data.csvHandler;
import data.dataHandler;
import data.flowObject;
import exceptions.NoFilesInDirectory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class deepFlow {

    static Logger log = Logger.getLogger(deepFlow.class);
    private flowObject flowInput;
    private flowObject flowOutput;
    private String inputFolder;
    private String outputFolder;

    private deepFlow(){
        flowInput = new flowObject(1);
        flowOutput = new flowObject(1);
        inputFolder = "/Users/Ainsleigh/IdeaProjects/personal_project/rawData/";
        outputFolder = "/Users/Ainsleigh/IdeaProjects/personal_project/rawData/";
    }

    // EFFECTS: get directory name from user input
    public String scanFile(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please specify the directory of *.fcs files: ");
        String file = reader.nextLine();
        reader.close();
        System.out.println("Setting directory: "+file);
        return file;
    }

    private void getInput(){
        dataHandler handler = new csvHandler("csv", "");
        handler.setDirectory(inputFolder);
        ArrayList<String> fileList = handler.getFileList();
        try {
            handler.fileReader(fileList, flowInput);
        } catch (NoFilesInDirectory noFilesInDirectory) {
            noFilesInDirectory.printStackTrace();
        } finally {
            System.out.println("testing...");
        }
        System.out.println(flowInput.get(1,1));
        System.out.print(flowInput.getRow(1));
    }

    public static void main(String[] args){

        BasicConfigurator.configure();
        log.info("This is Logger Info");
        deepFlow deep = new deepFlow();
        deep.getInput();
        System.out.println("This is the main method");
    }
}


