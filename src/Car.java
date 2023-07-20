public class Car {
    private double price;
    private String color;
    private int numberOfDoors;
    public Car(String price, String color, String numberOfDoors) {
        this.price = Double.parseDouble(price);
        this.color = color;
        this.numberOfDoors = Integer.parseInt(numberOfDoors);

    }//end of Car constructor
    public double getPrice() {
        return price;
    }//end of getPrice
    public void setPrice(double price) {
        this.price = price;
    }//end of setPrice
    public String getColor() {
        return color;
    }//end of getColor
    public void setColor(String color) {
        this.color = color;
    }//end of setColor
    public int getNumberOfDoors() {
        return numberOfDoors;
    }//end of getNumberOfDoors
    public void setNumberOfDoors(int numberOfDoors){
        this.numberOfDoors = numberOfDoors;
    }//end of setNumberOfDoors
    public void displayInfo(){
        System.out.printf("Type-> Car-> \t\tPrice: $%-5.2f \t\tColor: %-5s \t\tDoors: %-5d\n",
                price, color, numberOfDoors);
    }//end of displayInfo
}
