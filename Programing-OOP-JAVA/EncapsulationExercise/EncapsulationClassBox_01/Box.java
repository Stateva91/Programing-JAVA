package EncapsulationClassBox_01;

public class Box {

    //fields-harakteristiki

    private double length;
    private double width;
    private double height;

    //methods-  funkcionalnostite, koito shte ima vsqka edna kutiq
    public Box(double length, double width, double height) {
        setLength(length);
        setHeight(height);
        setWidth(width);
    }


    private void setLength(double length) {
        //validaciq:  >0
        if(length>0) {
            this.length = length;
        }else{
            throw new IllegalArgumentException("Length cannot be zero or negative.");// hvurli greshka i prekratqva programata

        }
    }

    private void setWidth(double width) {
        if(width>0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if(height>0) {
            this.height = height;
        }else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea (){
        return 2*this.length*this.width+ 2*this.length*this.height
                + 2*this.width*this.height;
    }
    public  double calculateLateralSurfaceArea (){
        return 2*this.height*(this.width+this.length);
    }
    public double calculateVolume (){
       return  this.height*this.length*this.width;
    }
}
