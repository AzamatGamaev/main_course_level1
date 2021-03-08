import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static final int SIZE = 3; //Здесь можно ввести размер поля, значение должно быть > 0;
    public static final int DOTS_TO_WIN = 3; //Здесь можно указать количество фишек необходимое для выигрыша, значение должно быть > 0;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_COMP = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {
        do {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_HUMAN)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                compTurn();
                printMap();
                if (checkWin(DOT_COMP)) {
                    System.out.println("Победил Искуственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            } System.out.println("Сыграем ещё раз? (Y-да/N-нет)");
        } while (sc.next().equals("Y"));

        System.out.println("Игра закончена");

        sc.close();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_HUMAN;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void compTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_COMP;
    }

    public static boolean checkWin(char symb) {
        char[][] helpArr;
        helpArr = new char[DOTS_TO_WIN][DOTS_TO_WIN];

        for (int x = 0; x <= SIZE - DOTS_TO_WIN; x++) {
            for (int y = 0; y <= SIZE - DOTS_TO_WIN; y++) {
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    System.arraycopy(map[i + x], y, helpArr[i], 0, DOTS_TO_WIN);//IDEA предложила представить код в таком виде
                }

                int winCombVertical = 0;
                int winCombHorizontal = 0;
                int winCombDiagonalA = 0;
                int winCombDiagonalB = 0;

                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    winCombVertical = 0;
                    winCombHorizontal = 0;

                    if (helpArr[i][i] == symb) winCombDiagonalA++;
                    if (winCombDiagonalA == DOTS_TO_WIN) return true;


                    if (helpArr[i][DOTS_TO_WIN - 1 - i] == symb) winCombDiagonalB++;
                    if (winCombDiagonalB == DOTS_TO_WIN) return true;

                    for (int j = 0; j < DOTS_TO_WIN; j++) {
                        if (helpArr[i][j] == symb)
                            winCombHorizontal++;
                        if (winCombHorizontal == DOTS_TO_WIN) return true;

                        if (helpArr[j][i] == symb)
                            winCombVertical++;
                        if (winCombVertical == DOTS_TO_WIN) return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}