import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class job{
	
	int index,deadline,profit;
	
	public job(int index,int deadline,int profit){
		this.index=index;
		this.deadline=deadline;
		this.profit=profit;
	}
}
class jobComparator implements Comparator<job>{

	@Override
	public int compare(job o1, job o2) {
		if(o1.profit<o2.profit) {
			return 1;
		}
		else if(o1.profit>o2.profit) {
			return -1;
		}
		else {
			return 0;	
		}
	}
	
}
public class Job_Sequencing {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		jobComparator jobcmp=new jobComparator();
		PriorityQueue<job> queue=new PriorityQueue<job>(jobcmp);
		
		System.out.println("Enter the total number of jobs :");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter the deadline and profit of the "+i+" job :");
			int deadline=sc.nextInt();
			int profit=sc.nextInt();
			job j1=new job(i,deadline,profit);
			queue.add(j1);
		}
		
		//Array for storing the order of the processes
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=-1;
		}
		
		for(int i=0;i<n;i++) {
			job j1=queue.remove();
//			System.out.println(j1.index+" "+j1.deadline+" "+j1.profit);
			if(arr[j1.deadline-1]==-1) {
				arr[j1.deadline-1]=(j1.index+1);
			}
			else {
				for(int k=j1.deadline-2;k>=0;k--) {
					if(arr[k]==-1) {
						arr[k]=(j1.index+1);
					}
				}
			}
		}

		for(int i=0;i<n;i++) {
			if(arr[i]!=-1)
			System.out.print(arr[i]+" ");
		}
	}

}
