import java.util.Arrays;

public class Q_Sort {
	
	public static int Partition(int[] A,int p,int r){
		int x=A[p];
		int i=p;
		int j=r;
		int temp=0;
		while(true){
			while(A[j]>x){
				j--;
		    }
				
			while(i<=r&&A[i]<=x){
				i++;
			}
			
			if(i<j){
				temp=A[i];
	    		A[i]=A[j];
	    		A[j]=temp;
			}
			else return j;			
		}
	}
	
	public static void Quicksort(int[] A,int p,int r){
		int q=0;
		int temp=0;
		
		if(p<r){
			q=Partition(A,p,r);
			temp=A[p];
			A[p]=A[q];
			A[q]=temp;
			
			Quicksort(A,p,q-1);
			Quicksort(A,q+1,r);
		}	
	}
	
	public static void main(String[] args){
		int[] A={9,3,6,4,5,8,1,7,2};
		System.out.println("Before:"+Arrays.toString(A));
		Quicksort(A,0,A.length-1);
		System.out.println("After:"+Arrays.toString(A));
	}
	
	
	
	
	
	
}
