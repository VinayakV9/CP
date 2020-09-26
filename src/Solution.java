import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

        static class Matrix{
            int[][] matrix;
            int sum;
            public Matrix(int[][] m){
                this.matrix = m;
                this.sum = getUpperLeft(this.matrix.length/2);
            }
            public int getSum(){
                return this.sum;
            }

            @Override
            public int hashCode(){
                return Arrays.deepHashCode(this.matrix);
            }

            @Override
            public boolean equals(Object object){
                if( object ==null || !(object instanceof Matrix)){
                    return false;
                }

                return Arrays.deepEquals(this.matrix, ((Matrix)object).matrix);
            }

            public Matrix reverseRow(int index){
                int[][] tMatrix = this.clone2dArray();
                int temp;
                int len = tMatrix.length;
                for(int i=0; i < tMatrix.length; i++){
                    temp = tMatrix[index][i];
                    tMatrix[index][i] = tMatrix[index][len-i-1];
                    tMatrix[index][len-i-1] = temp;
                }

                return new Matrix(tMatrix);
            }

            public Matrix reverseCol(int index){
                int[][] tMatrix = this.clone2dArray();
                int temp;
                int len = tMatrix.length;
                for(int i=0; i < tMatrix.length; i++){
                    temp = tMatrix[i][index];
                    tMatrix[i][index] = tMatrix[len-i-1][index];
                    tMatrix[len-i-1][index] = temp;
                }
                return new Matrix(tMatrix);
            }

            @Override
            public Matrix clone(){
                return new Matrix(this.matrix.clone());
            }

            public int getUpperLeft(int upperLeft){
                int sum = 0;
                for(int i = 0 ; i < upperLeft; i++){
                    for(int j=0; j< upperLeft;i++){
                        sum += matrix[i][j];
                    }
                }

                return sum;
            }

            private int[][] clone2dArray(){
                int[][] cMatrix = new int[this.matrix.length][];

                for(int i = 0 ; i < this.matrix.length; i++){
                    cMatrix[i] = Arrays.copyOf(this.matrix[i], this.matrix.length);
                }
                return cMatrix;
            }
        }
        // Complete the flippingMatrix function below.
        static int flippingMatrix(int[][] m1) {
            int maxSum = 0;
            int mLen = m1.length;

            Matrix matrix = new Matrix(m1);
            Set<Matrix> visited = new HashSet<>();
            Queue<Matrix> queue = new LinkedList<>();

            queue.add(matrix);
            while( !queue.isEmpty()){
                matrix = queue.poll();
                visited.add(matrix);

                if( matrix.getSum() > maxSum){
                    maxSum = matrix.getSum();
                }

                for(int i = 0; i < mLen; i++){
                    Matrix reversed = matrix.reverseRow(i);
                    if( !visited.contains(reversed) ){
                        queue.add(reversed);
                    }
                }

                for(int i = 0; i < mLen; i++){
                    Matrix reversed = matrix.reverseCol(i);
                    if( !visited.contains(reversed) ){
                        queue.add(reversed);
                    }
                }
            }

            return maxSum;
        }



        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[][] matrix = new int[2*n][2*n];

                for (int i = 0; i < 2*n; i++) {
                    String[] matrixRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < 2*n; j++) {
                        int matrixItem = Integer.parseInt(matrixRowItems[j]);
                        matrix[i][j] = matrixItem;
                    }
                }

                int result = flippingMatrix(matrix);

                System.out.println(result);
            }

            scanner.close();
        }
    }

