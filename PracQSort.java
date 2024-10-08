 import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class PracQSort {
public static void quicksort(int[] a, int l, int h) {
if(l<h) {
int pi=part(a,l,h);
quicksort(a,l,pi-1);
quicksort(a,pi+1,h);
}
}
public static int part(int[] a,int l, int h) {
int p = a[h];
int i = l-1;//since we add one later
for(int j=l;j<h;j++) {
if(a[j]<p) {
i++;
int t = a[i];
a[i]=a[j];
a[j]=t;
}
}
int t = a[i+1];
a[i+1]=a[h];
a[h]=t;
return i+1;
}
public static void main(String[] args) {
int n;
Random r;
    try (Scanner sc = new Scanner(System.in)) {
        r = new Random();
        System.out.println("Enter the number of elements:");
        n=sc.nextInt();
    }
int[] arr=new int[n];
for(int i=0;i<n;i++) {
arr[i]=r.nextInt(10000);
}
System.out.println("Original array: "+Arrays.toString(arr));
long st=System.nanoTime();
quicksort(arr,0,n-1);
long et=System.nanoTime();
System.out.println("Sorted array: "+Arrays.toString(arr));
System.out.println("Time Complexity: "+(et-st)/1e6+" milliseconds");
}
} 
