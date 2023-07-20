public class Human {
    private Car car;
    private int age;
    public Human(String age){
        this.age = Integer.parseInt(age);

    }//end of Human constructor
    public Human(Car car, String age){
        this.car = car;
        this.age = Integer.parseInt(age);

    }//end of Human constructor
    public Car getCar(){
        return car;
    }//end of getCar
    public void setCar(Car car){
        this.car = car;
    }//end of setCar
    public int getAge(){
        return age;
    }//end of getAge
    public void setAge(int age){
        this.age = age;
    }//end of setAge
    public void displayInfo(){
        System.out.printf("Type-> Human-> \t\tAge: %-5d\n", age);
        if (car != null) {
            System.out.print("\t\t");
            car.displayInfo();
        }

    }//end of displayInfo
}
