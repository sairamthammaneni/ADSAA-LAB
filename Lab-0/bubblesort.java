import java.util.Scanner;
class Bsort{
	public void bSort(int [] a,int n){
		int temp;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(a[i]>a[j]){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
}
public class bsort{
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
		Bsort b=new Bsort();
		System.out.print("Original list : ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		b.bSort(arr,n);
		System.out.print("List after sorting :");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
