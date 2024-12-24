import java.util.Scanner;
class Ssort{
	public void sSort(int [] a,int n){
		int i,j,minpos,temp;
		for(i=0;i<n-1;i++){
			minpos=i;
			for(j=i+1;j<n;j++){
				if(a[j]<a[minpos]){
					minpos=j;
				}
			}
			temp=a[i];
			a[i]=a[minpos];
			a[minpos]=temp;
		}
	}
}
public class selectionSort{
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
		Ssort s=new Ssort();
		System.out.print("Original list : ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		s.sSort(arr,n);
		System.out.print("List after sorting :");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
