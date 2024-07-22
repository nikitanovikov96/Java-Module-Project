import java.util.ArrayList;
import java.util.Scanner;



public class LeMan {

    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.start();

    }
}

class Racing{

    ArrayList<Car> cars = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void start(){
        for (int i = 0; i<3; i++){
            System.out.println("Введите название машины №" + (i+1));
            String name = scanner.nextLine();


            int speed;
            while (true) {
                System.out.println("Введите скорость машины № " + (i+1));
                speed = scanner.nextInt();
                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Некорректная скорость. Попробуйте еще раз. Диапозон скорости от 0 до 250 км/ч");
                }
            }
            scanner.nextLine();
            cars.add(new Car(name, speed));
        }
        int fullDistance = 0;
        String fastestCar = "";

        for(Car car : cars){
            int distance = car.speed * 24;
            if(distance > fullDistance){
                fullDistance = distance;
                fastestCar = car.name;
            }
        }
        System.out.println("Самая быстрая машина: " + fastestCar);
    }

}


class Car {

    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}
