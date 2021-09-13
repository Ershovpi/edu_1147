/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        System.out.println("Введите возраст, вес и силу 1-го кота");
        cat1.age = scanner.nextInt();
        cat1.weight = scanner.nextInt();
        cat1.strength = scanner.nextInt();
        System.out.println("Введите возраст, вес и силу 2-го кота");
        cat2.age = scanner.nextInt();
        cat2.weight = scanner.nextInt();
        cat2.strength = scanner.nextInt();
        System.out.println("Первый кот "+(cat1.fight(cat2)?"сильнее":"слабее")+" второго кота");
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat(){
    }

    public boolean fight(Cat anotherCat) {
        return  (this.age > anotherCat.age && this.weight > anotherCat.weight) ||
                (this.age > anotherCat.age && this.strength > anotherCat.strength) ||
                (this.weight > anotherCat.weight && this.strength > anotherCat.strength);
    }
}
