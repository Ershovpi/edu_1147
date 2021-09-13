/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse mouse = new Mouse("Jerry", 12, 5);
        Cat cat = new Cat("Tom",30, 6);
        Dog dog = new Dog ("Doggy", 8, 15)
    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }

}

class Dog {
    String name;
    int age;
    int weight;

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

}

class Cat {
    String name;
    int height;
    int weight;

    public Cat(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}
