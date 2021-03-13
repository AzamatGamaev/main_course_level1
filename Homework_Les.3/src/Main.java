import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int bound = 10; /* Здесть можно задать диапозон загаданных чисел.
                            !!!Диапозон начинается с 0 и до введённого Вами значения - 1 */
    static int attepts = 3; // Количетсво попыток


    public static void main(String[] args) {

        System.out.println("============= УГАДАЙ ЧИСЛО =============\nВам нужно угадать загаднное число от 0 до "
                + (bound - 1) + ".\nВведите число:");

        do {
            playLvl(bound);
            System.out.println("Сыграем ещё? (0-Нет/1-Да)");
        } while (scanner.next().equals("1"));
        scanner.close();
    }

    private static void playLvl(int bound) {
        int compNumber = random.nextInt(bound);
        int userNumber;
        int atteptsCheck = 0;
        while (atteptsCheck < attepts) {
            while (true) {
                try {
                    userNumber = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
                    break;
                } catch (NumberFormatException ignored) {
                    System.out.println("Введите ЧИСЛО:");
                }
            }
            if (userNumber > compNumber)
                System.out.println("Загаданное число меньше.");
            else if (userNumber < compNumber)
                System.out.println("Загаданное число больше.");
            else {
                System.out.println("Вы угадали!");
                break;
            }
            System.out.println();
            atteptsCheck++;
            if (atteptsCheck<attepts) System.out.println("У вас осталось " + (attepts-atteptsCheck) + " шанса угадать число");
            else System.out.println("К сожалению, попыток больше не осталось");
        }
    }
}
