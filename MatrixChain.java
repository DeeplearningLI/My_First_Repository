public class MatrixChain {
    private static String name = "ABCDEFG";  
	private static int[] P = {30, 35, 15, 5, 10, 25, 50, 40};
	
	private static int n = P.length - 1;		

    private static int[][] m = new int[n+1][n+1];  
    private static int[][] s = new int[n+1][n+1]; 

	public static void Matrix(int[] P, int n, int[][] m, int[][] s)
	{

		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=n; j++)
			{ 
				m[i][j] = 0;
				s[i][j] = i;
			}
		}
		
		int r, i, j, k, t;
		for(r=2; r<=n; r++)
		{
			for(i=1; i<=n-r+1; i++)
			{
				j = i+r-1;
				m[i][j] = m[i+1][j]+P[i-1]*P[i]*P[j];
				s[i][j] = i;
				for(k=i+1; k<=j-1; k++)
				{
					t = m[i][k]+m[k+1][j]+P[i-1]*P[k]*P[j];
					if(t < m[i][j])
					{
						m[i][j] = t; 
						s[i][j] = k;
					}
				}	
			}
		}	
		
	}
	
	
	/*输出矩阵相乘的顺序*/
    public static void Display(int[][] s, String name, int i, int j)  
    {  
        if(i == j)  
        {  
            System.out.print(name.charAt(i-1));  
        }  
        else  
        {  
            System.out.print("(");  
            Display(s, name, i, s[i][j]);  
            Display(s, name, s[i][j]+1, j);  
            System.out.print(")");  
        }  
    }  
	
	public static void main(String[] args){
	    
		Matrix(P, n, m, s); 
		
        System.out.print("最少需要的计算次数："+m[1][n]);  
        System.out.println();  
          
        System.out.print("矩阵相乘的顺序为： ");  
        Display(s, name, 1, n);  		
		
	}
	
	
}
