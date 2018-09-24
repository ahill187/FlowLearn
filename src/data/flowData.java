package data;

import java.util.ArrayList;

public class flowData {
    int size;
    flowData(int size){
        this.setColumnSize(size);
        ArrayList<Float> Column = new ArrayList<>();
        ArrayList<Float>[] data = new ArrayList[this.size];
    }

    public void setColumnSize(int size){
        this.size = size;
    }

}


