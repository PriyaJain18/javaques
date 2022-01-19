
// package Questions;
// import java.io.*;
import java.util.Arrays;
// import java.util.PriorityQueue;
import java.util.Scanner;

// Reverse the array

public class part1 {

static void ReverseArr(int[] arr){
    int sizeArr = arr.length;
    // int sizeArr = -1;
    for(int i=sizeArr-1;i>=0;i--){
        System.out.print(arr[i]+ " ");
    }
    
}

static void ReverseArr1(int[] arr){
    int sizeArr = arr.length;
   
    int start = 0, end = sizeArr-1;

    while(start<=end){
        int temp;
        temp= arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        start++;
        end--;
    }
    for(int i=0;i<sizeArr;i++){
        System.out.print(arr[i]+ " ");
    }
    
}


// Maximum and minimum of an array using minimum number of comparisons : 

static void minMax(int[] arr){
    int n = arr.length;
    int max = arr[0];
    int min = arr[0];

    for(int i=1;i<n;i++){
        if(arr[i]>max){ max=arr[i];}
        if(arr[i]<min){ min=arr[i];}
    }
    System.out.println("max: "+max+"and min: " +min);
}
public static class Pair{
    int min;
    int max;
}

static Pair minMax1(int[] arr,int start,int end){
    int n = arr.length;
    Pair pr = new Pair();
    Pair leftmm = new Pair();
    Pair rightmm = new Pair();

    if(start==end){    
        pr.min = arr[start];
        pr.max = arr[start];
        return pr;
    }
    if(end==start+1){
        if (arr[start] > arr[end]) {
        pr.max = arr[start] ;
        pr.min = arr[end];
        }else{
        pr.min = arr[start] ;
        pr.max = arr[end];
    }
    return pr;
    }

    //for arr having more than 1 elements :
    int mid = (start + end)/2;
    leftmm = minMax1(arr,start,mid);
    rightmm = minMax1(arr,mid+1,end);

    if(leftmm.min < rightmm.min){
        pr.min= leftmm.min;
    }else{pr.min= rightmm.min;}

    if(leftmm.max > rightmm.max){
        pr.max= leftmm.max;
    }else{pr.max= rightmm.max;}
    return pr;
}

static void  kthSmallest(int[] arr,int k){
    int n = arr.length;
    Arrays.sort(arr);  //sort 'arr' array permanently !!
    // Printing the array after sorting: 

    // for(int i=0;i<n;i++){
        // System.out.print(arr);
    // }
    System.out.println("sorted arr[] :" + Arrays.toString(arr));
    System.out.println("k-th smallest no. is :" + arr[k-1]);
} 

//Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


// Move all the negative elements to one side of the array :
static void rearrange1(int[] arr) {  //normal linear searching and swapping 
    int n = arr.length;
    int j = 0 ,temp; 
    for(int i=0;i<n;i++){
    if(arr[i]<0){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
    }
    }
    System.out.println("Array after sort: " + Arrays.toString(arr));
}

static void rearrange2(int[] arr) {   //2-pointer algo used 
    int n = arr.length;
    int left = 0 ,right= n-1;
    int temp;   //for swapping purposes
    while(left<=right){
            if (arr[left]>0 && arr[right]>0){
                right--;
            }
            else if (arr[left]<0 && arr[right]<0){ left++; } 
            else if (arr[left]<0 && arr[right]>0){ right--; }
            else if (arr[left]>0 && arr[right]<0){
                //swap : 
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                
                left++;
                right--;
            }
    }
System.out.print(Arrays.toString(arr));
}


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("enter no of test cases");

    int testCases = sc.nextInt();
    while(testCases > 0){
    System.out.print("enter size of array");

        int n = sc.nextInt();  //size of array 
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        //Reversing 

        ReverseArr(arr);
        System.out.println();
        ReverseArr1(arr);
        System.out.println();
        minMax(arr);
        Pair p = minMax1(arr,0,n-1);
        System.out.printf("max: " +p.max + "Min: "+ p.min);
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter value of k to get k-th minimum element :");
        int k = sc.nextInt();
        kthSmallest(arr, k);
        System.out.println();
       
        testCases--;
    }

    // Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
    
    /*
    int tCases = sc.nextInt(); 
    while(tCases >0){
        int n;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if((arr[i]!=0) && (arr[i]!=1) && (arr[i]!=2) ){
                throw new Exception("Only 0,1,2 are allowed as an input!");
                break;
            }
        }

        //sorting : 
        PriorityQueue<Integer> pq  =new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        int[] sortedArr = new int[n];
        for(int i=0;i<n;i++){
            sortedArr[i] = pq.poll(i);
        }
        System.out.print(Arrays.sort(sortedArr));
        tCases--; 
    }
    */

    //Move all the negative elements to one side of the array (note : order of elements not important): 
    System.out.println("enter no of test cases : ");
    int tCases2 = sc.nextInt(); 
    
    while(tCases2 >0){
        System.out.println("enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        // rearrange1(arr);
        rearrange2(arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    
   } 
}
