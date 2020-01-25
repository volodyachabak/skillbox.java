
public class Loader {

    private static final String SYMBOL = "X";
    private static final int  MATRIX_LENGTH = 7;

    public static void main(String[] args) {

        String[][] matrix = new String[MATRIX_LENGTH][MATRIX_LENGTH];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = SYMBOL;
            matrix[i][matrix[i].length - 1 - i] = SYMBOL;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((matrix[i][j] != null)? matrix[i][j] : " ");
            }
            System.out.println();
        }
    }
}

/*
 * X     X
 *  X   X
 *   X X
 *    X
 *   X X
 *  X   X
 * X     X
 * */
