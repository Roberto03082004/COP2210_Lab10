import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) throws Exception {
        // Step 1: Print header information
        yourInfoHeader();

        // Step 2: Read data from file and populate lists
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<Fruit> fruits = new ArrayList<>();
        ArrayList<Bowl> bowls = new ArrayList<>();

        String fileLocation = "Data/data.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].equals("Fruit")) {
                    if (data.length >= 3) {
                        String type = data[1].trim();
                        String weight = data[2].trim();

                        Fruit fruit = new Fruit(type, weight);
                        fruits.add(fruit);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                } else if (data[0].equals("Bowl")) {
                    if(data.length >=3){
                        String color = data[1].trim();
                        String size = data[2].trim();
                        ArrayList<Fruit> bowlFruits = new ArrayList<>();

                        if (data.length >= 4 && data[3].equals("Fruit->YES")){
                            int i = 4;
                            while (i + 1 < data.length && data[i].equals("Fruit")) {
                                String fruitType = data[i + 1].trim();
                                String fruitWeight= data[i + 2].trim();
                                Fruit fruit = new Fruit(fruitType, fruitWeight);
                                bowlFruits.add(fruit);
                                i += 3;
                                }
                        }
                        Bowl bowl = new Bowl(bowlFruits, color, size);
                        bowls.add(bowl);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                } else if (data[0].equals("Car")) {
                    if (data.length >= 4) {
                        String price = data[1].trim();
                        String color = data[2].trim();
                        String numberOfDoors = data[3].trim();

                        Car car = new Car(price, color, numberOfDoors);
                        cars.add(car);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                } else if (data[0].equals("Human")) {
                    if (data.length >= 2) {
                        String age = data[1].trim();

                        if (data.length >= 7 && data[2].trim().equals("Car->YES")) {
                            String carPrice = data[4].trim();
                            String carColor = data[5].trim();
                            String carNumberOfDoors = data[6].trim();

                            Car car = new Car(carPrice, carColor, carNumberOfDoors);
                            Human human = new Human(car, age);
                            humans.add(human);
                        } else {
                            Human human = new Human(age);
                            humans.add(human);
                        }
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        System.out.println("================================================================");
        System.out.println("Car List");
        System.out.println("================================================================");

        // Step 3: Display the stored data
        for (Car car : cars) {
            car.displayInfo();
        }
        System.out.println();

        System.out.println("================================================================");
        System.out.println("Human List");
        System.out.println("================================================================");

        for (Human human : humans) {
            human.displayInfo();
        }
        System.out.println();
        System.out.println("================================================================");
        System.out.println("Fruit List");
        System.out.println("================================================================");

        for (Fruit fruit : fruits) {
            fruit.displayInfo();
        }
        System.out.println();
        System.out.println("================================================================");
        System.out.println("Bowl List");
        System.out.println("================================================================");

        for (Bowl bowl : bowls) {
            bowl.displayInfo();
        }

        //Step 13

        Human youngestWithoutCar = findYoungestHumanWithoutCar(humans);
        System.out.println();
        if (youngestWithoutCar != null) {
            System.out.println();
            System.out.println("================================");
            System.out.println("Youngest Human Without Car:");
            System.out.println("================================");
            youngestWithoutCar.displayInfo();
        } else {
            System.out.println("No humans found without a car.");
        }

        //Step 15

        Human oldestWithCar = findOldestHumanWithCar(humans);
        System.out.println();
        if (oldestWithCar != null) {
            System.out.println();
            System.out.println("================================");
            System.out.println("Oldest Human With Car:");
            System.out.println("================================");
            oldestWithCar.displayInfo();
        } else {
            System.out.println("No humans found with a car.");
        }

        //Step 17

        Bowl bowlWithMostFruitWeight = bowlWithMostFruitWeight(bowls);
        System.out.println();
        if (bowlWithMostFruitWeight != null) {
            System.out.println("=========================================");
            System.out.println("Bowl with the most fruit by weight");
            System.out.println("=========================================");
            bowlWithMostFruitWeight.displayInfo();
        } else {
            System.out.println("No bowls found with fruit.");
        }
    }
    public static Human findYoungestHumanWithoutCar(ArrayList<Human> humans){
        Human youngestHumanWithoutCar = null;
        int youngestAge = Integer.MAX_VALUE;

        for (Human human : humans) {
            if (human.getCar() == null && human.getAge() < youngestAge) {
                youngestHumanWithoutCar = human;
                youngestAge = human.getAge();
            }
        }

        return youngestHumanWithoutCar;
    }
    public static Human findOldestHumanWithCar(ArrayList<Human> humans){
        Human oldestHumanWithCar = null;
        int oldestAge = 0;

        for (Human human : humans) {
            Car car = human.getCar();
            if (car != null && human.getAge() > oldestAge) {
                oldestHumanWithCar = human;
                oldestAge = human.getAge();
            }
        }

        return oldestHumanWithCar;
    }
    public static Bowl bowlWithMostFruitWeight(ArrayList<Bowl> bowls){
        Bowl bowlWithMostFruit = null;
        double maxFruitWeight = 0;

        for (Bowl bowl : bowls) {
            double totalFruitWeight = 0;

            for (Fruit fruit : bowl.getFruits()) {
                totalFruitWeight += fruit.getWeight();
            }

            if (totalFruitWeight > maxFruitWeight) {
                maxFruitWeight = totalFruitWeight;
                bowlWithMostFruit = bowl;
            }
        }

        return bowlWithMostFruit;
    }

    public static void yourInfoHeader() {
        System.out.println("================================");
        System.out.println("PROGRAMMER:  " + "Roberto Callejas");
        System.out.println("PANTHER ID:  " + "6360177");
        System.out.println();
        System.out.println("CLASS \t\t COP2210 ");
        System.out.println("SECTION: \t " + "U02C");
        System.out.println("SEMESTER: \t " + "Summer 2023");
        System.out.println("CLASS TIME: \t " + "10:00 AM - 12:50 PM");
        System.out.println();
        System.out.println("Assignment:  " + "Lab 10");
        System.out.println();
        System.out.println("CERTIFICATION: \nI understand FIU's academic policies and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person");
        System.out.println("================================");
        System.out.println();
    }
}
