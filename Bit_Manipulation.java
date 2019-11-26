import java.util.*;
public class Bit_Manipulation {

	
	//Program to Calculate the min number of bits required to change a to b 
	public static void Question_1() {
	// TODO Auto-generated method stub
        
		//Program to Calculate the min number of bits required to change a to b 
		Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        
        int n=a^b;
//        calculateBits(n);
          calBits(n);
    	
	}
	
	//Program to calculate the set bits present in the binary representation O(num_of_bits)
	public static  void calculateBits(int n){
		int count=0;
		while(n>0) {
			count+=(n&1);
			n=n>>1;
		}
		System.out.println(count);
	}
	
	//Program to calculate the Set bIts O(set_bits)
	public static void calBits(int n){
		
		int count=0;
		while(n!=0) {
			count=count+1;
			n=n&(n-1);
		}
		System.out.println(count);
	}
	
	public static void xor_swapping() {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("Before Swapping : "+a+" "+b);
		a=a^b;
		b=b^a;
		a=a^b;
		System.out.println("After Swapping :"+a+" "+b);
	}
	
	public static int getIthBit() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number and its position to be checked : ");
		int n=sc.nextInt();
		int i=sc.nextInt();
		int res=1;
//		while(i--!=0) {
//			res=res<<1;
//		}
//		int ans=res&n;
//		if(ans==res) {
//			System.out.println("1");
//		}
//		else {
//			System.out.println("O");
//		}
		return (n&(1<<i))!=0?1:0;
		
		
	}
	
	public static int setIthBit(int n,int i){
		return (n|(1<<i));
	}
	
	public static int clearIthBit(int n,int i){
		return n^(1<<i);
	}
	public static void main(String[] args) {
//	    xor_swapping();
//	    System.out.println(getIthBit());
//	    System.out.println(setIthBit(5, 1));
		System.out.println(clearIthBit(5,0));
	}

}
