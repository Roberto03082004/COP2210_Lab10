public class Fruit {


    private String type;
    private double weight;
    public Fruit(String type, String weight) {
        this.type = type;
        this.weight = Double.parseDouble(weight);

    }//end of Fruit constructor
    public String getType() {
        return type;
    }//end of getType
    public void setType(String type) {
        this.type = type;
    }//end of setType
    public double getWeight() {
        return weight;
    }//end of getWeight
    public void setWeight(double weight) {
        this.weight = weight;
    }//end of setWeight
    public void displayInfo(){
        System.out.printf("Type-> Fruit-> \t\tType: %-5s \t\tWeight: %-5.1f\n", type, weight);

    }
}
