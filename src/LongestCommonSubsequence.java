
public class LongestCommonSubsequence {

	public static int findLIS(String s1, String s2) {
		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		int rowSize = s1.length();
		int colSize = s2.length();
		// instead of making row size = rowSize +1 and column size = colSize+1,
		// we can make row size = rowSize and column size = colSize.
		
		
		int[][] lookUpArray = new int[rowSize][colSize]; 
		
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (col==0 || row==0) {
					if (col==0 && row>0) {
						if (s1Array[row]==s2Array[col])
							lookUpArray[row][col] =1;
						else
							lookUpArray[row][col] = lookUpArray[row-1][col];
					}
					else if (row==0 && col>0) {
						if (s1Array[row]==s2Array[col] )
							lookUpArray[row][col] = 1;
							
						else {
							lookUpArray[row][col] = lookUpArray[row][col-1];
						}
					}
					else if (row==0 && col==0) {
						if (s1Array[row]==s2Array[col]) {
							lookUpArray[row][col] = 1;
						}else
							lookUpArray[row][col] = 0;
					}
				} else {
					
					if (s1Array[row]==s2Array[col]) {
						lookUpArray[row][col] = lookUpArray[row-1][col-1]+1;
					}
					else
						lookUpArray[row][col] = Math.max(lookUpArray[row-1][col], lookUpArray[row][col-1]);
				}
			}
		}
		
		
		return lookUpArray[rowSize-1][colSize-1];
	}

	
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(findLIS(s1, s2));

	}

}
