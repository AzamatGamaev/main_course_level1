package GeekBrains_JavaDeveloper_Course;

public class Main {

    public static void main(String[] args) {

        int[] x = {1, 2, 3, 4, 5};

        checkBalance(x);
        shiftIt(x, 1);


        int[] reversArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < reversArr.length; i++) {
            if (reversArr[i] == 0)
                reversArr[i] = 1;
            else reversArr[i] = 0;
        }
        // for (int i = 0; i < reversArr.length; i++) System.out.print(reversArr[i] + "\t");

        int[] multiplyBy3 = new int[8];
        for (int i = 0; i < multiplyBy3.length; i++) {
            multiplyBy3[i] = i * 3;
        }
        // for (int i = 0; i < multiplyBy3.length; i++) System.out.print(multiplyBy3[i] + "\t");

        int[] multiplyBy2IfLessThan6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < multiplyBy2IfLessThan6.length; i++) {
            if (multiplyBy2IfLessThan6[i] < 6)
                multiplyBy2IfLessThan6[i] *= 2;
        }
        /* for (int i = 0; i < multiplyBy2IfLessThan6.length; i++) System.out.print(multiplyBy2IfLessThan6[i] + "\t"); */


        int[][] diagonalsArrIs1 = new int[4][4];
        for (int i = 0; i < diagonalsArrIs1.length; i++) {
            for (int j = 0; j < diagonalsArrIs1[i].length; j++) {
                if (i == j || i + j == diagonalsArrIs1.length - 1)
                    diagonalsArrIs1[i][j] = 1;
            }
        }

        // for (int i = 0; i < diagonalsArrIs1.length; i++) {
        //     System.out.println();
        //     for (int j = 0; j < diagonalsArrIs1.length; j++) {
        //         System.out.print(diagonalsArrIs1[i][j] + "\t");
        //     }
        // }

        int[] minMaxElements = {2, 4, 5, 6, -111, 400, 0, -300};
        int min = minMaxElements[0];
        for (int i = 1; i < minMaxElements.length; i++) {
            if (min > minMaxElements[i]) {
                min = minMaxElements[i];
            }
        }
        int max = minMaxElements[0];
        for (int i = 1; i < minMaxElements.length; i++) {
            if (max < minMaxElements[i]) {
                max = minMaxElements[i];
            }
        }
        // System.out.println("minElement = " + min + "\nmaxElement = " + max);
    }

    public static boolean checkBalance(int enterArr[]) {
        int sumArr = 0;
        int sumLeft = 0;
        boolean inspector = false;
        for (int i = 0; i < enterArr.length; i++) sumArr += enterArr[i];
        for (int i = 0; i < enterArr.length - 1; i++) {
            sumLeft += enterArr[i];
            if (sumLeft == sumArr - sumLeft) inspector = true;
        }
        // System.out.println(inspector);
        return inspector;
    }

    public static int[] shiftIt(int shiftArr[], int shift) {
        int rezerv = 0;
        if (Math.abs(shift) > shiftArr.length) shift %= shiftArr.length;
        if (shift > 0) shift -= shiftArr.length;
        for (int i = 0; i > shift; i--) {
            rezerv = shiftArr[0];
            for (int j = 1; j < shiftArr.length; j++) {
                shiftArr[j - 1] = shiftArr[j];
            }
            shiftArr[shiftArr.length - 1] = rezerv;
        }
//         for (int i = 0; i < shiftArr.length; i++) System.out.print(shiftArr[i] + " ");
        return shiftArr;
    }
}


