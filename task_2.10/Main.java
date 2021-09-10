/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int [] mas = {4,5,5,7,3,2};
        Boolean b = false;
        for (int i = 0; i < mas.length; i++) {
            if ((i>0)&&(mas[i]==mas[i-1])) {
                b = true;
            }
        }
        System.out.println(b?"да":"нет");
    }
}
