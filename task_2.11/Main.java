/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int [] mas = {5,2,3,4,0};
        int summ = 0;
        int n = 1;
        for (int i = 0; i < mas.length; i++) {
            summ = summ + mas[i];
            if (summ<=10) {
                n++;
            }
        }
        System.out.println(n>5?"Сумма элементов не больше 10":n+" элемента (ов) массива > 10");
    }
}
