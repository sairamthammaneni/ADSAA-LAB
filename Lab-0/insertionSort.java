import java.util.Scanner;
class Insort{
	public void inSort(int [] a,int n){
		int item;
		int i,j;
		for(i=1;i<=n-1;i++)
	   	{
	   		item=a[i];
			for(j= i-1;j>=0 && a[j]>item;j--)
			{
				a[j+1]=a[j];	        
			}
			a[j+1]=item;    
		}
	}
}
public class insertionSort{
	public static void main(String[] args){
		int [] arr = new int[20];
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter List size : ");
		n=sc.nextInt();
		System.out.print("Enter the List elements : ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		Insort in=new Insort();
		System.out.print("Original list : ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		in.inSort(arr,n);
		System.out.print("List after sorting :");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
