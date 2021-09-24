  
/* 
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String file = scanner.nextLine();
        try {
            FileInputStream fin = new FileInputStream(file);
            int i;
            String number = "";
            while ((i=fin.read())!=-1) {
                if(i!=13) number = number + (char)i;
                else {
                    fin.read();
                    if(Integer.parseInt(number)%2==0)
                        list.add(Integer.parseInt(number));
                    number = "";
                    }
            }
            list.add(Integer.parseInt(number));
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл отсутствует");
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
