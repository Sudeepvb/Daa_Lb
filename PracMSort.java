import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class PracMSort {
public static void mergesort(int[] arr, int l, int r) {
if(l<r) {
int m = l+(r-l)/2;
mergesort(arr,l,m);
mergesort(arr,m+1,r);
merge(arr,l,m,r);
}
}
public static void merge(int[] arr, int l,int m, int r) {
int n1 = m-l+1;
int n2 = r-m;
int[]la=new int [n1];
int[]ra=new int [n2];
for(int i=0; i<n1;i++)
la[i]=arr[l+i];
for(int i=0; i<n2;i++)
ra[i]=arr[(m+1)+i];
int i=0,j=0,k=l;
while(i<n1 && j<n2) {
if(la[i]<ra[j]) {
arr[k++]=la[i++];
}
else {
arr[k++]=ra[j++];
}
}
while(i<n1)
{
arr[k++]=la[i++];
}
while(j<n2)
{
arr[k++]=ra[j++];
}
}
public static void main(String[] args) {
int n;
Random r;
    try (Scanner sc = new Scanner(System.in)) {
        r = new Random();
        System.out.println("Enter the number of elements: ");
        n=sc.nextInt();
    }
int[] arr=new int[n];
for(int i=0;i<n;i++) {
arr[i]=r.nextInt(100);
}
System.out.println("Original array: "+Arrays.toString(arr));
long st=System.nanoTime();
mergesort(arr,0,n-1);
long et=System.nanoTime();
System.out.println("Sorted array: "+Arrays.toString(arr)+ '\n'+"Time Complexity: "+ ((et-st)/1e6)+" milliseconds");
}
}
