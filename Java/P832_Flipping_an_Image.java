class P832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        return sol_2(A);
    }

    public int[][] sol_1(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int [][]B = new int [col][row];

        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                B[r][col - c - 1] = A[r][c] ^ 1;
            }
        }

        return B;
    }

    public int[][] sol_2(int[][] A) {
        int col = A[0].length;

        for (int[] row: A) {
            for (int c = 0; c < (col + 1) / 2; ++c) {
                int temp = row[c] ^ 1;
                row[c] = row[col - 1 - c] ^ 1;
                row[col - 1 - c] = temp;
            }
        }

        return A;
    }
}


