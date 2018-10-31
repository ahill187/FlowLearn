package data;

import java.util.ArrayList;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.serde.binary.BinarySerde;

public class flowObject implements dataObject {
    int size;
    ArrayList<Float> Column;
    public INDArray dataArray;

    public flowObject(int size){
        this.setColumnSize(size);
        this.Column = new ArrayList<>();

    }

    //MODIFIES: this
    //EFFECTS: set number of data columns (flow markers)
    //         initialize data array
    public void setColumnSize(int size){
        this.size = size;
        this.dataArray = Nd4j.create(this.size);
    }
    //EFFECTS: return column size
    public int getColumnSize(){
        return this.size;
    }

    public void addRow(int row, INDArray rowArray){
        if(row==0) {
            this.dataArray.putRow(row, rowArray);
        }
        else{
            this.dataArray = Nd4j.concat(0,this.dataArray,rowArray);
        }
    }

    public INDArray getRow(int row){
        return this.dataArray.getRow(row);
    }

    public INDArray getColumn(int column){
        return this.dataArray.getColumn(column);
    }

    public float get(int row, int column){
        INDArray rowArray = this.dataArray.getRow(row);
        float cell = rowArray.getFloat(column);
        return cell;
    }

    public void flowObject(){

    }

}




