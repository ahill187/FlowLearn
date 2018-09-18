import java.util.ArrayList;
public class DataInput {

    String dirname;
    public ArrayList importData(){

    }

    public void setDirectory(String dirname){
        this.dirname = dirname;
    }

    public String getDirectory(){
        if (this.dirname==""){
            throw new java.lang.RuntimeException("Directory has not been set yet");
        } else {
            return this.dirname;
        }
    }

    public ArrayList getCsvList (){
        try {
            String directory = this.dirname;
        } catch(java.lang.RuntimeException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void readCSV(){

    }

    public void DataInput(){

    }


}
