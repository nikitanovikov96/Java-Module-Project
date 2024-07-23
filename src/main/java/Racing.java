import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Racing {

    ArrayList<Car> cars = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        for (int i = 0; i < 3; i++) {
            String name = "";
            while (true) {
                System.out.println("Введите название машины №" + (i + 1));
                name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Название автомобиля не может быть короче 1 символа");
                }
            }


            int speed;
            while (true) {
                System.out.println("Введите скорость машины № " + (i + 1));
                try {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Некорректная скорость. Попробуйте еще раз. Диапозон скорости от 0 до 250 км/ч");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Некорректная скорость. Попробуйте еще раз. Введите число");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            cars.add(new Car(name, speed));
        }
        if (cars.get(0).speed == cars.get(1).speed && cars.get(1).speed == cars.get(2).speed) {
            System.out.println("Никто не выйграл, все машины оказались равны");
        } else {
            int fullDistance = 0;
            String fastestCar = "";

            for (Car car : cars) {
                int distance = car.speed * 24;
                if (distance > fullDistance) {
                    fullDistance = distance;
                    fastestCar = car.name;
                }
            }
            System.out.println("Самая быстрая машина: " + fastestCar);
        }

    }
}