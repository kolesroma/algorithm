import java.util.Arrays;

public class QueensProblem {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        board[1][0] = 1;
        board[7][1] = 1;
        board[1][1] = 1;
        board[6][1] = 1;
        board[5][5] = 1;
        board[2][6] = 1;
        for (int[] ar : board) {
            System.out.println(Arrays.toString(ar));
        }

        QueensProblem qp = new QueensProblem();
        System.out.println(qp.coupleBeaten(board));
        System.out.println(qp.checkCurrentPosition(board, 2, 2));
    }

    public int coupleBeaten(int[][] board) {
        int counter = 0;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    counter += checkCurrentPosition(board, i, j);
                }
            }
        }
        return counter / 2;
    }

    private int checkCurrentPosition(int[][] board, int i, int j) {
        int counter = 0;
        //horizontal
        for (int k = 0; k < 8; k++) {
            if (k == j)
                continue;
            if (board[i][k]==1)
                counter++;
        }
        //vertical
        for (int k = 0; k < 8; k++) {
            if (k == i)
                continue;
            if (board[k][j] == 1)
                counter++;
        }
        //diagonal \
        int ci = 0;
        int cj = 0;
        if (j < i)
            ci = i - j;
        else
            cj = j - i;
        while (ci < 8 && cj < 8) {
            if (ci == i && cj == j) {
                ci++;
                cj++;
                continue;
            }
            if (board[ci][cj] == 1)
                counter++;
            ci++;
            cj++;
        }
        //diagonal /
        ci = i - 1;
        cj = j + 1;
        while (ci >= 0 && cj < 8) {
            if (board[ci][cj] == 1)
                counter++;
            ci--;
            cj++;
        }
        ci = i + 1;
        cj = j - 1;
        while (ci < 8 && cj >= 0) {
            if (board[ci][cj] == 1)
                counter++;
            ci++;
            cj--;
        }
        return counter;
    }
}
