package data;

import java.util.ArrayList;

public class flowData {
    int size;
    ArrayList<Float> Column;
    ArrayList<Float>[] data;
    flowData(int size){
        this.setColumnSize(size);
        this.Column = new ArrayList<>();
        this.data = new ArrayList[this.size];

    }

    public void setColumnSize(int size){
        this.size = size;
    }

}


