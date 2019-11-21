import java.util.Scanner;

public class N_Queens_Problem {

	public static boolean solveNQueen(int board[][],int i,int n){
		
		//Base Case (We have placed The Queens upto n-1 position)
		if(i==n) {
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					System.out.print(board[x][y]+" ");
				}
				System.out.println();
			}
			return true;
		}
		
		
		//Recursive Case
		for(int j=0;j<n;j++){
			//Here isSafe is a function which determine whether it is safe to place a Queen in given index or not
			boolean ans=isSafe(board,i,j,n);
			if(ans==true){
				board[i][j]=1;
				if(solveNQueen(board,i+1,n)==true){
					return true;
				}
				else {
					board[i][j]=0;
				}
			}
		}
		
		
		return false;
		
	}
	
	public static boolean isSafe(int board[][],int i,int j,int n){
		//Column Wise
		for(int k=i;k>=0;k--) {
			if(board[k][j]==1) {
//				System.out.println("Unsafe: ("+i+","+j+")"+" ("+k+","+j+")");
				return false;
			}
		}
		
		int x=i;
		int y=j;
		//Diagonal right hand 
		while(x>=0&&y<n) {
			if(board[x][y]==1) {
				return false;
			}
			x--;
			y++;
		}
		
		x=i;
		y=j;
		//Diagonal Left Hand Side
		while(x>=0&&y>=0) {
			if(board[x][y]==1) {
				return false;
			}
			x--;
			y--;
		}
//		System.out.println("Safe: "+i+" "+j);
		return true;
		
	}
	
	public static void printNQueen(int board[][],int i,int n){
		//Base Case
		if(i==n){
			for(int x=0;x<n;x++){
				for(int y=0;y<n;y++) {
					System.out.print(board[x][y]+" ");
				}
				System.out.println();
			}
			System.out.println();
		return;
		}
		//Recursive Case 
		for(int j=0;j<n;j++) {
			boolean ans=isSafe(board,i,j,n);
			if(ans==true){
				board[i][j]=1;
				printNQueen(board,i+1,n);
			    board[i][j]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Size of the Board or number of Queens to be placed");
		int n=sc.nextInt();

		int board[][]=new int[n][n];
		
//		System.out.println(solveNQueen(board,0,n));
//		printNQueen(board, 0, n);
	}

}
