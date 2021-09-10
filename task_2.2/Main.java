/*Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 4 ...
2 4 6 8 ...
3 6 9 12 ...
4 8 12 16 ...
... */
public class Main {
    public static void main(String[] args) {
       for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                System.out.print(a*b+" ");
            }
            System.out.println();
        }
    }
}
