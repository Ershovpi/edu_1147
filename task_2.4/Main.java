/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму вклада: ");
        double summ = scanner.nextDouble();
        System.out.print("Введите годовой процент: ");
        int p = scanner.nextInt();
        System.out.println("Сумма вклада "+summ+", под "+p+"% годовых");
        for (int i=0; i<5; i++) {
            summ = summ + (summ * p / 100);
            System.out.println(summ);
        }
    }
}
