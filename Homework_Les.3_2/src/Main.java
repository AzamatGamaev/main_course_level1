import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato" };/*Здесь можно изменить набор слов, которые будет
                                                                   угадывать пользователь*/
    static char[] outArrayForUser = new char[15];//Массивы небходимый для вывода правиьно угаданных букв


    public static void main(String[] args) {
        System.out.println("==========УГАДАЙ СЛОВО==========");
        do {
            int wordIndex = random.nextInt(wordsArray.length);
            String chooseWord = wordsArray[wordIndex];
            char[] compWordToArray = chooseWord.toCharArray();

            System.out.println("Загадано слово! Попробуйте его угадать.\nВведите слово:");

            while (true) {
                String userWord = scanner.next();
                char[] userWordToArray = userWord.toCharArray();

                char[] endArr = new char[compWordToArray.length];

                for (int i = 0; i < outArrayForUser.length; i++) {
                    if (i < compWordToArray.length && i < userWordToArray.length && compWordToArray[i] == userWordToArray[i]) {
                        outArrayForUser[i] = compWordToArray[i];
                        endArr[i] = compWordToArray[i];
                    } else outArrayForUser[i] = '#';
                }

                if (Arrays.equals(endArr, compWordToArray)) {
                    System.out.println("Вы угадали! Было загаданно слово " + "<" + chooseWord + ">");
                    break;
                } else {
                    System.out.println("Вы угадали следующие буквы:");
                    for (int i = 0; i < outArrayForUser.length; i++) System.out.print(outArrayForUser[i]);
                    System.out.println("\nПоробуйте ещё раз! Введите слово:");
                }
            } System.out.println("Сыграем ещё? (0-Нет/1-Да)");
        }
        while (scanner.next().equals("1"));
        scanner.close();
    }
}
