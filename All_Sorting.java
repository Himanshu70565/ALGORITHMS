import java.util.Scanner;

public class All_Sorting {

	
	public static void BubbleSort(int arr[],int n) {
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					
					//Swap
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
				}
			}
		}
		
	}
	
	public static void SelectionSort(int arr[],int n) {
		
		for(int i=0;i<n-1;i++) {
			int min_index=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min_index]) {
					min_index=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min_index];
			arr[min_index]=temp;
		}
		
	}
	
	public static void InsertionSort(int arr[],int n) {
		
		for(int i=1;i<n;i++) {
			int key=arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
		    arr[j+1]=key;	
	   }
	}
	
	public static void MergeSort(int arr[],int n) {
		mergeSort(arr,0,n-1);
	}
	public static void mergeSort(int arr[],int l,int r) {
		if(l<r) {
			int mid=(l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			merge(arr,l,r);
		}
	}
	public static void merge(int arr[],int l,int r) {
		
		int arr2[]=new int[r-l+1];
		int k=0;
		int mid=(l+r)/2;
		int i=l,j=mid+1;
		while(i<=mid&&j<=r) {
			if(arr[i]<arr[j]) {
				arr2[k]=arr[i];
				k++;
				i++;
			}
			else {
				arr2[k]=arr[j];
				k++;
				j++;
		    }
		}
		while(i<=mid) {
			arr2[k]=arr[i];
			k++;
			i++;
		}
		while(j<=r) {
			arr2[k]=arr[j];
			k++;
			j++;
		}
		for(i=0;i<arr2.length;i++) {
			arr[l+i]=arr2[i];
		}
	}
	
	public static void QuickSort(int arr[],int n){
		quickSort(arr,0,n-1);
	}
	public static void quickSort(int arr[],int si,int ei) {
		if(si<ei) {
			
			int piv_position=position(arr,si,ei);
			quickSort(arr,si,piv_position);
			quickSort(arr,piv_position+1,ei);
			
		}
	}
	public static int position(int arr[],int si,int ei){
		
		int piv_ele=arr[si];
		int count=0;
		for(int i=si+1;i<=ei;i++) {
			if(arr[i]<piv_ele) {
				count++;
			}
		}
		
		int piv_pos=si+count;
//		Swapping of piv_element
		swap(arr,si,piv_pos);
		int i=si;
		int j=ei;
		while(i<piv_pos&&j>piv_pos) {
			if(arr[i]>arr[piv_pos]) {
				
				while(j>piv_pos) {
					if(arr[j]<arr[piv_pos]) {
						swap(arr,i,j);
						j--;
						break;
					}
				j--;	
				}
			}
		i++;	
		}
		return piv_pos;
	}
	public static void swap(int arr[],int si,int piv_pos){
		
		int temp=arr[si];
		arr[si]=arr[piv_pos];
		arr[piv_pos]=temp;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//Number of Element in the array
		int n=sc.nextInt();
		
		//Array
        int arr[]=new int[n];
        
        //Taking array input
        for(int i=0;i<n;i++) {
        	arr[i]=sc.nextInt();
        }
	
//        BubbleSort(arr, n);
  
//        SelectionSort(arr, n);
       
//        InsertionSort(arr, n);        
        
//        MergeSort(arr, n);       
        
//        QuickSort(arr, n);
        
        for(int i=0;i<n;i++) {
        	System.out.print(arr[i]+" ");
        }
        
        
	}

}
