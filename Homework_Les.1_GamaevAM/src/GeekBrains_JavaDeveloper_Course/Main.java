package GeekBrains_JavaDeveloper_Course;

import java.util.Scanner;

public class Main {

    // Задача 1. Объявление метода main
    public static void main(String[] args) {

        // Здача 2. Вывод переменных
        byte byt_e = 127;
        short shrt = 10;
        int in_t = 10;
        long lng = 1000000L;
        float flt = 1.0f;
        double dbl = 1.0;
        char chr = 'x';
        boolean bool = true;

        // Вызов созданных методов
        calculateAbcd(10f, 10f, 10f, 10f);
        rtrnTrueOrFalse(10, 10);
        writePositiveOrNegativeNumber(10);
        chekPositiveOrNegativeNumber(10);
        greeting("Владимир");
        leapYear(2021);

    }

    // Задача 3. Вычисление по формуле и возврат результата
    public static float calculateAbcd(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // Задача 4. Сумма в пределах от 10 до 20
    public static boolean rtrnTrueOrFalse(int arg1, int arg2) {
        return (arg1 + arg2) >= 10 && (arg1 + arg2) <= 20; //Код был длинне и написано через метод if, но IJ предложил сократить код, до данного вида, понял почему.
    }

    // Здача 5. Положительное или отрицательное число
    public static void writePositiveOrNegativeNumber(int checkthis) {
        if (checkthis >= 0)
            System.out.println("Число переданное в метод положительно.");
        else System.out.println("Число переданное в метод отрицательно.");
    }

    // Задача 6. Проверка на положительность и возврат true or false
    public static boolean chekPositiveOrNegativeNumber(int chekit) {
        return chekit < 0; //Такая же ситуация как и в 4 задаче.
    }

    // Задача 7. Приветсвие
    public static void greeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // Задача 8. Выскосный-ли год
    public static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0)
            System.out.println("Год високосный");
        else if (year % 100 == 0 && year % 400 == 0) System.out.println("Год високосный");
        else System.out.println("Год не високосный");
    }
}

