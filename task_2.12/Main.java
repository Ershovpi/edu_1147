/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите массив из 10 элементов: ");
        int [] mas = {0,1,2,3,4,5,6,7,8,9};
        int max = 1;
        int n = 1;
        for (int i = 0; i < 10; i++) {
            mas[i] = scan.nextInt();
             if ((i>0)&&(mas[i])==mas[i-1]) {
                n++;
             } else {
                if (n>max) {
                    max = n;
                }
                n = 1;
             }
        }
        System.out.println(max);
    }
}
