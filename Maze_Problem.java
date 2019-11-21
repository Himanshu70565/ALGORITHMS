import java.util.Scanner;

public class Maze_Problem {

	public static boolean findPath(int maze[][],int n) {
	    int path[][]=new int[n][n];
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		path[i][j]=0;
	    	}
	    }
		return findPathHelper(maze,path, 0, 0, n);
	}
	public static boolean findPathHelper(int maze[][],int path[][],int x,int y,int n){
		
		if(x==n-1&&y==n-1) {
			return true;
		}
		if(x>=n||x<0||y>=n||y<0) {
			return false;
		}
		if(maze[x][y]==0) {
			return false;
		}
		if(path[x][y]==1) {
			return false;
		}
		path[x][y]=1;
		
		boolean ans=false;
		
		//Right Move from given coordinate
		ans=findPathHelper(maze,path,x, y+1, n);
		if(ans==true){
			return true;
		}
		
		//Left Move from given coordinate
		ans=findPathHelper(maze,path,x, y-1, n);
		if(ans==true) {
			return true;
		}
		
		
		
		//Top Move from given coordinate
		ans=findPathHelper(maze,path,x-1, y, n);
		if(ans==true) {
			return true;
		}
		
		
		//Bottom Move from given ccordinate
		ans=findPathHelper(maze,path,x+1, y, n);
		if(ans==true) {
			return true;
		}
		
    return false;
}
	
	public static void printPath(int maze[][],int n){
		int path[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				path[i][j]=0;
			}
		}
		printPathHelper(maze,path,0,0,n);
	}
	public static void printPathHelper(int maze[][],int path[][],int x,int y,int n) {
		if(x<0||x>=n||y<0||y>=n) {
			return;
		}
		if(x==n-1&&y==n-1) {
			path[x][y]=1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(path[x][y]+" ");
				}
				System.out.println();
			}
			System.out.println();
		return;
		}
		if(maze[x][y]==0||path[x][y]==1){
			return;
		}
		path[x][y]=1;
		
		//Right
		printPathHelper(maze,path,x,y+1,n);
		
		//Left
		printPathHelper(maze,path,x,y-1,n);
		
		//Top
		printPathHelper(maze,path,x-1,y,n);
		
		//Bottom
		printPathHelper(maze,path,x+1,y,n);
		
		path[x][y]=0;
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter the size of maze");
		n=sc.nextInt();
		
		int maze[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				maze[i][j]=sc.nextInt();
			}
		}

//     System.out.println(findPath(maze,n));
	   printPath(maze,n);
		
		
	}

}
