import java.util.Scanner;
class Lsearch{
	public void lSearch(int [] a,int n,int key){
		int flag=-1;
		for(int i=0;i<n;i++){
			if(key==a[i]){
				flag=i;
			}
		}
		if(flag==-1){
			System.out.println("Search Failed, key not found!!!");
		}
		else{
			System.out.println("Search Succesful, Key is found at index "+flag);
		}
	}
}
public class LinearSearch{
	public static void main(String[] args){
		int [] arr=new int[20];
		int n;
		System.out.print("Enter the list size : ");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		System.out.print("Enter thge Lists elements : ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.print("Enter the element to be searched : ");
		System.out.println();
		int key=sc.nextInt();
		Lsearch l=new Lsearch();
		l.lSearch(arr,n,key);
	}
}
