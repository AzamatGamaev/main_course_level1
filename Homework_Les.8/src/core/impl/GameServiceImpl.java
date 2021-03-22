package core.impl;

import core.GameService;
import core.enums.DotType;
import core.domain.MatrixCoordinate;

import java.util.Random;

public class GameServiceImpl implements GameService {
//    private int dotsToWin;
//    private int size;
//
//    public DotType[][] map;
//    public DotType playerType;
//    public DotType aiType;
//
//    public static Random rand = new Random();
//
//    public GameServiceImpl(int mapSize, DotType playerType) {
//        this.size = mapSize;
//        this.dotsToWin = mapSize;
//
//        this.playerType = playerType;
//        this.aiType = DotType.getEnemyType(playerType);
//
//        initMap();
//    }
//
//    public void initMap() {
//        DotType map[][] = new DotType[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                map[i][j] = DotType.EMPTY;
//            }
//        }
//    }
//
//    public void printMap() {
//        for (int i = 0; i <= size; i++)
//            System.out.print(i + " ");
//        System.out.println();
//        for (int i = 0; i < size; i++) {
//            System.out.print((i + 1) + " ");
//            for (int j = 0; j < size; j++)
//                System.out.print(map[i][j] + " ");
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//    public void humanTurn(int rowIndex, int columnIndex) {
//        map[rowIndex][columnIndex] = playerType;
//        printMap();
//    }
//
//    public boolean isCellValid(int x, int y) {
//        if (x < 0 || x >= size || y < 0 || y >= size) return false;
//        if (map[y][x] == DotType.EMPTY) return true;
//        return false;
//    }
//
//    public MatrixCoordinate aiTurn() {
//        int x, y;
//        do {
//            x = rand.nextInt(size);
//            y = rand.nextInt(size);
//        } while (!isCellValid(x, y));
//        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
//        map[y][x] = aiType;
//
//        return new MatrixCoordinate(y, x);
//    }
//
//    public boolean checkWin(DotType dotType) {
//        DotType[][] helpArr;
//        helpArr = new DotType[dotsToWin][dotsToWin];
//
//        for (int x = 0; x <= size - dotsToWin; x++) {
//            for (int y = 0; y <= size - dotsToWin; y++) {
//                for (int i = 0; i < dotsToWin; i++) {
//                    System.arraycopy(map[i + x], y, helpArr[i], 0, dotsToWin);//IDEA предложила представить код в таком виде
//                }
//
//                int winCombVertical = 0;
//                int winCombHorizontal = 0;
//                int winCombDiagonalA = 0;
//                int winCombDiagonalB = 0;
//
//                for (int i = 0; i < dotsToWin; i++) {
//                    winCombVertical = 0;
//                    winCombHorizontal = 0;
//
//                    if (helpArr[i][i] == dotType) winCombDiagonalA++;
//                    if (winCombDiagonalA == dotsToWin) return true;
//
//
//                    if (helpArr[i][dotsToWin - 1 - i] == dotType) winCombDiagonalB++;
//                    if (winCombDiagonalB == dotsToWin) return true;
//
//                    for (int j = 0; j < dotsToWin; j++) {
//                        if (helpArr[i][j] == dotType)
//                            winCombHorizontal++;
//                        if (winCombHorizontal == dotsToWin) return true;
//
//                        if (helpArr[j][i] == dotType)
//                            winCombVertical++;
//                        if (winCombVertical == dotsToWin) return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//
//    public boolean isMapFull() {
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (map[i][j] == DotType.EMPTY) return false;
//            }
//        }
//        return true;
//    }
//}

    private int dotsToWin;
    private int size;

    public DotType[][] map;
    public DotType playerType;
    public DotType aiType;

    public Random rand = new Random();

    public GameServiceImpl(int mapSize, DotType playerType) {
        this.size = mapSize;
        this.dotsToWin = mapSize;

        this.playerType = playerType;
        this.aiType = DotType.getEnemyType(playerType);

        initMap();
    }

    public boolean checkWin(DotType dotType) {
        DotType[][] helpArr;
        helpArr = new DotType[dotsToWin][dotsToWin];

        for (int x = 0; x <= size - dotsToWin; x++) {
            for (int y = 0; y <= size - dotsToWin; y++) {
                for (int i = 0; i < dotsToWin; i++) {
                    System.arraycopy(map[i + x], y, helpArr[i], 0, dotsToWin);//IDEA предложила представить код в таком виде
                }

                int winCombVertical = 0;
                int winCombHorizontal = 0;
                int winCombDiagonalA = 0;
                int winCombDiagonalB = 0;

                for (int i = 0; i < dotsToWin; i++) {
                    winCombVertical = 0;
                    winCombHorizontal = 0;

                    if (helpArr[i][i] == dotType) winCombDiagonalA++;
                    if (winCombDiagonalA == dotsToWin) return true;


                    if (helpArr[i][dotsToWin - 1 - i] == dotType) winCombDiagonalB++;
                    if (winCombDiagonalB == dotsToWin) return true;

                    for (int j = 0; j < dotsToWin; j++) {
                        if (helpArr[i][j] == dotType)
                            winCombHorizontal++;
                        if (winCombHorizontal == dotsToWin) return true;

                        if (helpArr[j][i] == dotType)
                            winCombVertical++;
                        if (winCombVertical == dotsToWin) return true;
                    }
                }
            }
        }
        return false;
    }

    public int getWinValue(int indRow, int indCol, int value, DotType dotType) {
        if (map[indRow][indCol] == dotType) {
            return value + 1;
        }

        return 0;
    }

    public boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DotType.EMPTY) return false;
            }
        }

        return true;
    }

    public MatrixCoordinate aiTurn() {
        int x, y;

        do {
            y = rand.nextInt(size);
            x = rand.nextInt(size);
        } while (!isCellValid(x, y));

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = aiType;

        return new MatrixCoordinate(y, x);
    }

    public boolean isCellValid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        return map[y][x] == DotType.EMPTY;
    }

    public void humanTurn(int rowIndex, int columnIndex) {
        map[rowIndex][columnIndex] = playerType;
        printMap();
    }

    public void initMap() {
        map = new DotType[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DotType.EMPTY;
            }
        }
    }

    public void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}