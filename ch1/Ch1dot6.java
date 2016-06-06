
public class Ch1dot6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testMatrix = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};
		int n = testMatrix.length;
		
		/*
		rotate(testMatrix,n);
		System.out.println("Result of Crack the Code solution");
		for (int i = 0; i < testMatrix.length; i++) {
		    for (int j = 0; j < testMatrix[0].length; j++) {
		        System.out.print(testMatrix[i][j] + " ");
		    } 
		    System.out.print("\n");
		}
		*/
		
		myRotate(myRotate(testMatrix,n),n);
		//myRotate(result,n);
		

	}
	
	//rotatiion method that the solution provide
	public static void rotate(int[][] matrix, int n){
		for (int layer = 0; layer<n/2; ++layer){
			int first = layer;
			int last = n-1-layer;
			for(int i=first; i<last; ++i){
				int offset = i-first;
				int top = matrix[first][i]; //save top
				// left->top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom->left;
				matrix[last-offset][first] = matrix[i][last-offset];
				
				//right->bottom
				matrix[last][last-offset] = matrix[i][last];
				
				//top->right
				matrix[i][last] = top;
			}
		}
	}//End of rotate
	
	//My solution
	public static int[][] myRotate(int [][] matrix, int n){
		System.out.println("This is my solution");
		System.out.println();
		//Define a new matrix to store output
		int[][] result = new int[n][n];
		for (int i=0;i<n;i++){
			for (int j=0; j<n; j++){
				result[j][n-1-i] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < result.length; i++) {
		    for (int j = 0; j < result[0].length; j++) {
		        System.out.print(result[i][j] + " ");
		    } 
		    System.out.print("\n");
		}
		
		return result;
		
	}

}
