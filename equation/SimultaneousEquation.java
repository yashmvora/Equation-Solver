package equation;

import java.util.ArrayList;

public class SimultaneousEquation {
    
    ArrayList<LinearEquation> eqs;
    double originalMatrix[][];
    double constMatrix[][];
    int n;
    
    public SimultaneousEquation (ArrayList<LinearEquation> equations) { 
        eqs = equations;
    }

    public void setMatrix () {
        // initialise the matrix from getting data from eqs
        n = eqs.size();
        
        originalMatrix = new double[n][n];
        constMatrix  = new double[n][1];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                originalMatrix[i][j] = eqs.get(i).getVTerms().get(j).getCoefficient();  //need to check
        
        for (int i=0;i<n;i++) {
            constMatrix[i][0] = eqs.get(i).getConstant().getCoefficient();
        }
        
    }

    public void solve() {
    	
    	setMatrix();
    	int result[][] = new int[n][n]; 
    	double inverseMatrix[][] = inverse(originalMatrix);
        // multiplying 2 matrices    
        for(int i = 0; i < n; i++) {
            for(int j = 0;j < n; j++) {    
           
                result[i][j] = 0;     
                
                for(int k = 0; k < n; k++) {      
                    result[i][j] += inverseMatrix[i][k] * constMatrix[k][j];      
                } 
            } 
        }
        printResult(result);
    }

    public double[][] inverse(double originalMatrix[][]) 
    {
        int n = originalMatrix.length;
        double invert[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i) 
            b[i][i] = 1;
 
        // Transform the matrix into an upper triangle
        gaussian(originalMatrix, index);
 
        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k] -= originalMatrix[index[j]][i] * b[index[i]][k];
 
        // Perform backward substitutions
        for (int i = 0; i < n; i++) 
        {
            invert[n-1][i] = b[index[n-1]][i] / originalMatrix[index[n-1]][n-1];
            for (int j = n - 2; j >= 0; --j) 
            {
                invert[j][i] = b[index[j]][i];
                for (int k = j+1; k < n; ++k) 
                {
                    invert[j][i] -= originalMatrix[index[j]][k] * invert[k][i];
                }
                invert[j][i] /= originalMatrix[index[j]][j];
            }
        }
        return invert;
    }
 
    public void gaussian(double originalMatrix[][], int index[]) 
    {
        int n = index.length;
        double gauMatrix[] = new double[n];
 
        // Initialise the index
        for (int i = 0; i < n; ++i) 
            index[i] = i;
 
        for (int i = 0; i < n; ++i) 
        {
            double element1 = 0;
            for (int j = 0; j < n; ++j) 
            {
                double element0 = Math.abs(originalMatrix[i][j]);
                if (element1 < element0) 
                	element1 = element0;
            }
            gauMatrix[i] = element1;
        }
 
        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) 
        {
            double pivot1 = 0;
            for (int i = j; i < n; ++i) 
            {
                double pivot0 = Math.abs(originalMatrix[index[i]][j]);
                pivot0 /= gauMatrix[index[i]];
                if (pivot0 > pivot1) 
                {
                    pivot1 = pivot0;
                    k = i;
                }
            }
 
            // Interchange rows according to the pivoting order
            int temp = index[j];
            index[j] = index[k];
            index[k] = temp;
            for (int i = j + 1; i < n; ++i) 	
            {
                double pivot = originalMatrix[index[i]][j] / originalMatrix[index[j]][j];
 
            // Record pivoting ratios below the diagonal
                originalMatrix[index[i]][j] = pivot;
 
                // Modify other elements accordingly
                for(int l = j + 1; l < n; ++l)
                    originalMatrix[index[i]][l] -= pivot * originalMatrix[index[j]][l];
            }
        }
    }

    public void printResult(int[][] result) {
        //print result matrix
    	for (int i=0;i<n;i++) {
    		for (int j=0;j<n;j++) 
    			System.out.print(result[i][j]);
    		System.out.println();
    	}
    	
    }
}

// 3x + 4y = 5
// 2x - y = 2

// A 
// 3 4
// 2 -1

// B
// 5
// 2

// AX = B
// X = A-1 * B