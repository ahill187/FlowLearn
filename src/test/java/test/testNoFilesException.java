package test;

import data.csvHandler;
import data.dataHandler;
import data.dataObject;
import data.flowObject;
import exceptions.NoFilesInDirectory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class testNoFilesException {

    private dataHandler handler;
    private String directory = "/Users/Ainsleigh/IdeaProjects/personal_project/rawData/";
    static Logger log = Logger.getLogger(dataHandlerTest.class);

    @BeforeEach
    void runBefore(){
        handler = new csvHandler("csv", "");
        BasicConfigurator.configure();
        log.info("This is Logger Info");
    }

    @Test
    void testFilesInDir(){

        dataObject flow = new flowObject(1);
        handler.setDirectory(directory);
        ArrayList<String> fileList = handler.getFileList();
        try {
            handler.fileReader(fileList, flow);
        } catch (NoFilesInDirectory noFilesInDirectory) {
            noFilesInDirectory.printStackTrace();
            Assertions.fail();
        }
        float cell = flow.get(1,4);
        assertTrue(cell==2.0);

    }

    @Test
    void testFilesNotInDir(){

        dataObject flow = new flowObject(1);
        handler.setDirectory("");
        ArrayList<String> fileList = handler.getFileList();
        try {
            handler.fileReader(fileList, flow);
            Assertions.fail();
        } catch (NoFilesInDirectory noFilesInDirectory) {
            noFilesInDirectory.printStackTrace();
        }


    }
}
