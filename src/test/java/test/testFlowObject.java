package test;

import data.flowObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class testFlowObject {

    private flowObject flow;

    @BeforeEach
    void runBefore(){
        flow = new flowObject(1);
    }

    @Test
    void testSetColumnSize(){
        int size = 10;
        flow.setColumnSize(size);
        int getSize = flow.getColumnSize();
        assertEquals(getSize, size);
    }

    @Test
    void testAddRow(){

    }

    @Test
    void testGet(){

    }

    @Test
    void testGetRow(){

    }

    @Test
    void testGetColumn(){

    }
}
