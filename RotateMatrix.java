import java.util.*;

public class RotateMatrix {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        if (mat == null || n == 0 || m == 0) {
            return;
        }
        int row_start = 0;
        int col_start = 0;
        int row_end = n - 1;
        int col_end = m - 1;

        while (row_start < row_end && col_start < col_end) {
            // Store the first element of the next row to be placed in the first row
            int prev = mat.get(row_start + 1).get(col_start);

            // Move elements of the first row
            for (int i = col_start; i <= col_end; i++) {
                int curr = mat.get(row_start).get(i);
                mat.get(row_start).set(i, prev);
                prev = curr;
            }
            row_start++;

            // Move elements of the last column
            for (int i = row_start; i <= row_end; i++) {
                int curr = mat.get(i).get(col_end);
                mat.get(i).set(col_end, prev);
                prev = curr;
            }
            col_end--;

            // Move elements of the last row
            if (row_start <= row_end) {
                for (int i = col_end; i >= col_start; i--) {
                    int curr = mat.get(row_end).get(i);
                    mat.get(row_end).set(i, prev);
                    prev = curr;
                }
            }
            row_end--;

            // Move elements of the first column
            if (col_start <= col_end) {
                for (int i = row_end; i >= row_start; i--) {
                    int curr = mat.get(i).get(col_start);
                    mat.get(i).set(col_start, prev);
                    prev = curr;
                }
            }
            col_start++;
        }
    }
}
