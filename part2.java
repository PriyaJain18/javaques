import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class part2 {
    public static void unionn(int[] arr1 ,int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] a = new int[256];
        int n = a.length;

        int max = Math.max(n1,n2);
        ArrayList<Integer> unionArr = new ArrayList<Integer>(max);  //specify maximum size of ArrayList to be created  = max
        // int[] unionArr = new int[max];

        int c;
        for(int i=0;i<n1;i++){ 
            c = arr1[i];
            a[c]++;
        }
        for(int i=0;i<n2;i++){ 
            c = arr2[i];
            a[c]++;
        }
        
        for(int i=0;i<n;i++){
            if(a[i]!=0){
                unionArr.add(i);
            }
        }
        System.out.println("union of 2 arrays: ");
        for(int i=0;i<unionArr.size();i++){
            System.out.println(unionArr.get(i));
        }
    }
    public static void intersectionn(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int n = Math.min(n1,n2);
        ArrayList<Integer> interArr = new ArrayList<Integer>(n);  //specify max ArrayList size : n 
        
        int i=0,j=0;
        while (i < n1 && j < n2) {
        if(arr1[i]<arr2[j]){ i++;
        }else if(arr1[i]>arr2[j]){ j++;
        }else{     // if both array elements are same
            if (interArr.contains(arr1[i]) == false ) {  //if arr2[j] or arr1[i] donot exists in interArr already then
                interArr.add(arr1[i]); 
                i++;
                j++;
        }else{
            i++;
            j++;
        }}
    }
        System.out.println("Intersection of 2 arrays: ");
        for(int k=0;k<interArr.size();k++){
            System.out.println(interArr.get(k));
        }
        // System.out.println(interArr.size());

    }

    public static void cyclicity(int[] arr){
        int n = arr.length;

        int temp = arr[n-1];
        for(int i=n-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        System.out.println(Arrays.toString(arr));

    }
    public static void subArraySum(int[] arr){
        int n = arr.length;
        // ArrayList<Integer> sum = new ArrayList<>();
        int sum[] = new int[50];

        int k=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){      
                sum[k] = sum[k] + arr[j];  
                k++;
            }
        }
        int max = sum[0];
        for (int l=0;l<sum.length;l++){
            if (sum[l]>max){
                max = sum[l];
            }
        }
        for(int l=0;l<sum.length;l++){
           System.out.print(sum[l] + " ");
        }
        System.out.println("max of all subarrays : "+ max);
        
    }
    public static void maxSum(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        // System.out.println(max);  //-2147483648
        int cursum=0;
        for (int i=0;i<n;i++){
            cursum = cursum+arr[i];
            if(cursum>max){
                max = cursum;
            }
            if(cursum<0){ cursum=0 ;}//means discarding all subarrays before current position for currsum (max will contain max calculated upto now) 
        }
        System.out.println("max of all subarrays : "+ max);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Find the Union and Intersection of the two sorted arrays.
        int testCases = sc.nextInt();
        while(testCases>0){

            int[] arr1 = {1,4,4,5,6,7};
            int[] arr2 = {3,4,4,5,9};
            //   {1,4,5,6,7};  {3,4,4,5,9};
            //union = 1 3 4 5 6 7 9
            //intersection =  4 ,5

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            unionn(arr1,arr2);
            intersectionn(arr1,arr2);  //NOTE : size of ArrayList = 0  if no intersection / i.e. intersection is (phi)
            //Write a program to cyclically rotate an array by one.
            cyclicity(arr1);
            //find Largest sum contiguous Subarray = KADANE'S ALGORITHM [V. IMP]
            int[] arr3 = {1,2,3,-2,5};
            // subArraySum(arr3);  //complexity: n^2       //DOUBT ?????????????????????????????????
            maxSum(arr3);          //complexity: n
            int[] arr4 = {-3,-4,-1,-6,-2};
            maxSum(arr4);

            testCases--;

        }
        
    }
    
}
