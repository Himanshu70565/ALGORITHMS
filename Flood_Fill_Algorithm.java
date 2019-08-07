import java.util.*;
class Pair{
	int x;
	int y;
	
	public Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class Flood_Fill_Algorithm {

	public static void main(String[] args) {
		int arr[][]= {{1,1,1,1,1,1},{1,1,2,2,1,1},{1,1,2,2,1,1},{2,2,2,2,2,2}};
		for(int i=0;i<4;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	int row=arr.length;
	int column=arr[0].length;
		Stack<Pair> stack=new Stack<Pair>(); 
	    int a=2,b=2;
	    int temp=arr[a][b];
	    boolean visited[][]=new boolean[4][6];
        Pair q=new Pair(a,b);
	    stack.push(q);
	    	
	    while(!stack.isEmpty()) {
        Pair frontNode=stack.pop();
        
	    int x=frontNode.x;
	    int y=frontNode.y;
	    arr[x][y]=3;
	    //System.out.println(x+" "+y);
	    if(visited[x][y]!=true) {
	    
	    if(x-1>=0&&y-1>=0&&arr[x-1][y-1]==temp) {
        	Pair p=new Pair(x-1,y-1);
        	stack.push(p);
        }
        if(x-1>=0&&arr[x-1][y]==temp) {
        	Pair p=new Pair(x-1,y);
        	stack.push(p);
        }
        if(x-1>=0&&y+1<column&&arr[x-1][y+1]==temp) {
        	Pair p=new Pair(x-1,y+1);
        	stack.push(p);
        }
        if(y-1>=0&&arr[x][y-1]==temp) {
        	Pair p=new Pair(x,y-1);
        	stack.push(p);
        }
        if(y+1<column&&arr[x][y+1]==temp){
        	Pair p=new Pair(x,y+1);
        	stack.push(p);
        }
        if(x+1<row&&y-1>=0&&arr[x+1][y-1]==temp) {
        	Pair p=new Pair(x+1,y-1);
        	stack.push(p);
        }
        if(x+1<row&&arr[x+1][y]==temp) {
        	Pair p=new Pair(x+1,y);
        	stack.push(p);
        }
        if(x+1<row&&y+1<column&&arr[x+1][y+1]==temp) {
        	Pair p=new Pair(x+1,y+1);
        	stack.push(p);
        }
	}
	visited[frontNode.x][frontNode.y]=true;    
}
	
	
	System.out.print("*******************************");
	System.out.println();
	
	    for(int i=0;i<4;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	
	
	
	
	
	
	}
	
}
//for(int i=0;i<4;i++) {
//for(int j=0;j<6;j++) {
//	System.out.print(visited[i][j]+" ");
//}
//System.out.println();
//}