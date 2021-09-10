/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.

*/


public class Main {
    public static void main(String[] args) {
           System.out.println(isMore10(7,3)?"сумма > 10":"сумма <= 10");
    }

    public static Boolean isMore10 (int a, int b) {
        return a+b>10;
    }
}
