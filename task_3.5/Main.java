/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};
        int a = 0;
        output (num,a);
    }

    public static void output (int num[],int a) {
        System.out.println(num[a++]);
        if(a<num.length) {
            output (num,a);
        }
    }
}
