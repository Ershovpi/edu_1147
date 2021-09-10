/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        System.out.println("Введите массив из 4 элементов: ");
        int [] mas = {0,0,0,0};
        Boolean b = false;
        for (int i = 0; i < 4; i++) {
            mas[i] = scan.nextInt();
            if (mas[i]==5) {
                b = true;
            }
        }
        if (b) {
            System.out.println("да");
        } else {
            System.out.println("нет");
        }
    }
}
