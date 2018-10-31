package data;
import java.util.ArrayList;
import org.nd4j.linalg.api.ndarray.INDArray;

public interface dataObject {

    public int getColumnSize();

    public void setColumnSize(int size);

    public void addRow(int row, INDArray rowArray);

    public INDArray getRow(int row);

    public INDArray getColumn(int column);

    public float get(int row, int column);




}
