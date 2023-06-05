import java.util.* ;
import java.io.*; 
import java.util.* ;
import java.io.*; 
public class SetMatrixZero {
    public static void setZeros(int matrix[][]) {
        // Write your code here..

        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int i = 0 ;i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0 ;i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }

}