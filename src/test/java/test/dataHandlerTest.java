package test;
import data.dataHandler;
import data.flowObject;
import data.dataObject;
import data.csvHandler;
import exceptions.NoFilesInDirectory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

class dataHandlerTest {

    private dataHandler handler;
    private String directory = "/Users/Ainsleigh/IdeaProjects/personal_project/rawData/";

    @BeforeEach
    void init(){
        handler = new csvHandler("csv", "");
    }

    static Logger log = Logger.getLogger(dataHandlerTest.class);

    @Test
    void testSetDirectory(){

        handler.setDirectory(directory);
        assertEquals(handler.getDirectory(), directory);
    }

    @Test
    void testGetFileList(){
        handler.setDirectory(directory);
        ArrayList<String> fileList = new ArrayList<>();
        fileList.add(directory+"facs1.csv");
        ArrayList<String> fileList2 = new ArrayList<>();
        fileList2 = handler.getFileList();
        assertEquals(fileList.get(0),fileList2.get(0));
    }

    @Test
    void testCsvReader(){

        BasicConfigurator.configure();
        log.info("This is Logger Info");
        dataObject flow = new flowObject(1);
        handler.setDirectory(directory);
        ArrayList<String> fileList = handler.getFileList();
        try {
            handler.fileReader(fileList, flow);
        } catch (NoFilesInDirectory noFilesInDirectory) {
            noFilesInDirectory.printStackTrace();
        }
        float cell = flow.get(1,4);
        assertTrue(cell==2.0);

    }
}
