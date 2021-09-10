/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите массив из 5 элементов: ");
        int [] mas = {0,0,0,0,0};
        int summ = 0;
        int n = 1;
        for (int i = 0; i < 5; i++) {
            mas[i] = scan.nextInt();
            summ = summ + mas[i];
            if (summ<=10) {
                n++;
            }
        }
        if (n>5) {
            System.out.println("Сумма элементов не больше 10");
        } else {
            System.out.println(n+" элемента (ов) массива > 10");
        }
    }
}
