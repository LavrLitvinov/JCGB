package DZ7;

import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        String command = "";
        String city;
        Scanner scanner = new Scanner(System.in);
  // Надо бы валидировать и ответ, что города с таким названием нет, но это .... потом.
        while (true) {
            System.out.println("Введите имя города. Для выхода введите 0: ");
            city = scanner.nextLine();
            if(city.equals("")) continue;
            if (city.equals("0")) break;
            while (true) {
                System.out.println("Введите 1 для получения погоды на сегодня;" +
                        "Введите 5 для прогноза на 5 дней; ");
                command = scanner.nextLine();
                if (command.equals("1") | command.equals("5")) {
                    break;
                } else {
                    System.out.println("Такого варианта не предусмотрено. Сожалеем.");
                }
            }

            //TODO* Сделать метод валидации пользовательского ввода TUDUUU. Сделано
            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

