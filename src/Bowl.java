import java.util.ArrayList;


public class Bowl {

    private ArrayList<Fruit> fruits;


    private String color;
    private int size;
    public Bowl(ArrayList<Fruit> fruits,String color, String size){
        this.color = color;
        this.fruits = fruits;
        this.size = Integer.parseInt(size);

    }//end of Bowl constructor
    public ArrayList<Fruit> getFruits(){
        return fruits;
    }//end of getFruits
    public void setFruits(ArrayList<Fruit> fruits){
        this.fruits = new ArrayList<>(fruits);
    }//end of setFruits
    public String getColor(){
        return color;
    }//end of getColor
    public void setColor(String color){
        this.color = color;
    }//end of setColor
    public int getSize(){
        return size;
    }//end of getSize
    public void setSize(int size){
        this.size = size;
    }//end of setSize
    public void displayInfo(){
        System.out.printf("Type-> Bowl-> \tColor: %-5s \t\tSize: %-5d\n", color, size);
        for (Fruit fruit : fruits) {
            System.out.printf("\t\tType-> Fruit-> \tType: %-5s \t\tWeight: %-5.1f\n", fruit.getType(), fruit.getWeight());
        }
    }
}
