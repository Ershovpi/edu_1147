/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(compare(5,7)?"равны":"не равны");
    }
    
    public static Boolean compare (int a, int b) {
        return a==b;
    }
}
