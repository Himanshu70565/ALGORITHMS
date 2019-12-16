import java.util.Scanner;

public class Z_String {

	public static void count(String str,String patt) {
		
		String new_String=patt+"$"+str;
		System.out.println((new_String));
		
		int z[]=new int[new_String.length()];
		
		//Filling the Z Array
		z[0]=0;
		for(int i=1;i<new_String.length();i++) {
			
			boolean flag=true;
			int k=0,count=0;
			int j=i;
			while(flag==true&&j<new_String.length()) {
				if(new_String.charAt(k)==new_String.charAt(j)) {
					count++;
					k++;
					j++;
				}
				else {
					flag=false;
				}
			}
			z[i]=count;
		}
		for(int i=0;i<new_String.length();i++) {
			System.out.print(z[i]+" ");
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str="aabcdab";
		String patt="ab";
		
		count(str,patt);
		

	}

}
