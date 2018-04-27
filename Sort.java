import java.util.Arrays;

public class Sort {
	
	public static void Merge(int[] A,int p,int q,int r){
		int x=q-p+1;
		int y=r-q;
		int[] B=new int[x];
		int[] C=new int[y];
		for(int i=0;i<x;i++){
			B[i]=A[p+i];
		}
		for(int j=0;j<y;j++){
			C[j]=A[q+1+j];
		}
		int i=0;
		int j=0;
		int k=p;
		
		while(i<x&&j<y){
			if(B[i]<=C[j]){
				A[k]=B[i];
				i=i+1;
			}
			else{
				A[k]=C[j];
				j=j+1;
			}
			k=k+1;
		}
		
		if(i>=x){
			while(k<=r){
				A[k]=C[j];
				j=j+1;
				k=k+1;
			}
		}
		else{
			while(k<=r){
				A[k]=B[i];
				i=i+1;
				k=k+1;
			}
		}
	}
	public static void MergeSort(int[] A,int p,int r){
		if(p<r){
			int q=(p+r)/2;
			MergeSort(A,p,q);
			MergeSort(A,q+1,r);
			Merge(A,p,q,r);
		}
		
			
	}
	
	public static void main(String[] args){
		int[] A={9,3,6,4,5,8,1,7,2};
		System.out.println("Before:"+Arrays.toString(A));
		MergeSort(A,0,A.length-1);
		System.out.println("After:"+Arrays.toString(A));
		
	}
	
	
}