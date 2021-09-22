/*
* Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
* Коллекции вы создаёте сами
*/

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        list.add(4);
        list.add(-1);
        list.add(-5);
        list.add(2);
        list.add(7);
        list.add(13);
        list.add(-7);
        list.add(0);
        list.add(3);
        list.add(6);
        list.add(18);
        list.add(9);
        list.add(-4);
        for (int i = 0; i < list.size(); i++)
            if(list.get(i)>0 && list.get(i)<10) {
                newList.add(list.get(i));
                System.out.print(list.get(i)+" ");
            }
    }
}
