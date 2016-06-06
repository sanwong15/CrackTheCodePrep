/*
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0
 */
public class Ch1dot7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testMatrix = {{1,1,1,1,1},
							  {2,0,2,2,2},
							  {3,3,3,3,3},
							  {4,4,4,0,4},
							  {5,5,5,5,5}};
		
		for (int i = 0; i < testMatrix.length; i++) {
		    for (int j = 0; j < testMatrix[0].length; j++) {
		        System.out.print(testMatrix[i][j] + " ");
		    } 
		    System.out.print("\n");
		}
		
		setZeros(testMatrix);

	}
	
	public static void setZeros(int[][] matrix){
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		for (int i =0; i<matrix.length; i++){
			for (int j=0; j<matrix[0].length; j++){
				if (matrix[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for (int i=0; i<matrix.length; i++){
			for (int j=0; j<matrix[0].length; j++){
				if (row[i] == 1 || col[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
		
		//Print out result
		System.out.println("Result of setZeros");
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[0].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    } 
		    System.out.print("\n");
		}
	}

}
