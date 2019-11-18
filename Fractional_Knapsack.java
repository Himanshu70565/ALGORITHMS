import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
class listComparator implements Comparator<item>{

	@Override
	public int compare(item o1, item o2) {
		if(o1.ratio<o2.ratio)
			return 1;
		else if(o1.ratio>o2.ratio)
			return -1;
		else 			
			return 0;
	}
	
}
class item{
	
	int index,weight,value;
	
	double ratio; 
	
	public item(int index,int weight,int value){
		this.index=index;
		this.weight=weight;
		this.value=value;
		ratio=(double)value/weight;
	}
	
}
public class Fractional_Knapsack {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    
		
	    listComparator listcmp=new listComparator();
	    
	    PriorityQueue<item> list=new PriorityQueue<item>(listcmp);
	    
		System.out.println("Enter total items: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter weight and value of the "+i+" item");
			int weight=sc.nextInt();
			int value=sc.nextInt();
			item t=new item(i,weight,value);
		    list.add(t);
		}
		
		System.out.println("Enter Knapsack Capacity: ");
		
		int k=sc.nextInt();
		int net_value=0;
		while(k>0){
			item i=list.remove();
			if(k>i.weight) {
				net_value+=i.value;
				k=k-i.weight;
			}
			else{
				net_value+=(k)*i.ratio;
				k=0;
			}
		}
		
		System.out.println("Maximum Value that can be obtained is : "+net_value);
	}

}
