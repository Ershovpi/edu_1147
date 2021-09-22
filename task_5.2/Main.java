/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> familyList = new ArrayList<>();
        List<String> cityList = new ArrayList<>();
        while (true) {
            String city = scanner.nextLine();
            if (city.isEmpty()) break;
            cityList.add(city);
            String family = scanner.nextLine();
            familyList.add(family);
        }

        System.out.println("Введите город для поиска: ");
        String city = scanner.nextLine();
        String msg = "Такого города нет в списке";
        for (int i = 0; i < cityList.size(); i++)
            if (cityList.get(i).equals(city))
                msg = familyList.get(i);
        System.out.println(msg);
    }
}
