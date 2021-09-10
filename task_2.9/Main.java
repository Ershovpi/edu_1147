/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int [] mas = {1,5,2,8};
        Boolean b = false;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]==5) {
                b = true;
            }
        }
        System.out.println(b?"да":"нет");
    }
}
