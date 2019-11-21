import java.util.Scanner;

public class Graph_Coloring {

	public static boolean checkPossible(int edges[][],int colour[],int n,int i,int m){
		if(i==n||m>=n) {
			for(int l=0;l<n;l++) {
				System.out.print(colour[l]+" ");
			}
			System.out.println();
			return true;
		}
		//Recurive Case
		for(int j=0;j<m;j++) {
			boolean ans=isSafe(edges,colour,i,j,n);
			if(ans==true) {
				colour[i]=j;
				ans=checkPossible(edges,colour,n,i+1,m);
				if(ans==true) {
					return true;
				}
				else {
					colour[i]=-1;	
				}
			}
		}
	return false;
	}
	
	public static boolean isSafe(int edges[][],int colour[],int i,int j,int n){
		for(int k=0;k<n;k++) {
			if(edges[i][k]==1) {
				if(colour[k]==j) {
					return false;
				}
			}
		}
	return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of nodes of the graph :");
		int n=sc.nextInt();
		
		//Adjacency Matrix
		int edges[][]=new int[n][n];
		int colour[]=new int[n];
		
		for(int i=0;i<n;i++) {
			colour[i]=-1;
		}
		
		System.out.println("Enter the number of edges :");
		int m=sc.nextInt();
		
		for(int i=0;i<m;i++) {
			int sv=sc.nextInt();
			int ev=sc.nextInt();
			edges[sv][ev]=1;
			edges[ev][sv]=1;
		}
		System.out.println("Enter the number of colour :");
		m=sc.nextInt();
		
      System.out.println(checkPossible(edges,colour,n,0,m));
	}

}
