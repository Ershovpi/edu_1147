/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Введите число: ");
        float num = scanner.nextFloat();
        System.out.print("+15% = "+num*1.15);
    }
}
