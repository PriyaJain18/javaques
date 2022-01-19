// package Questions;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

import java.util.Arrays;
public class part4 {
// 1 3 5 9 8
//N = 6
// arr = {1, 4, 3, 2, 6, 7}

    public static void jumps(int[] arr){
        int n = arr.length;
        int i=0, count = 0, temp;
        temp = arr[0];
        while(i<n-1){
            temp = arr[i];
            if(temp==0){ 
                System.out.println(count);
                return;
            }
            int max ,cur_max =0;
            int j=i;
            if(temp<arr.length){
                while(j<=temp){
                    // j = i;
                    max = Math.max(arr[j],arr[j-1]);
                    cur_max = Math.max(max, cur_max);
                    j++;
                }
            }
            
            i= i+cur_max;
            if (i>n-1){ i=n-1;}
            count++;
            System.out.println(arr[i]);
        }
        System.out.println("count :"+count );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i] = sc.nextInt();  
        }
        System.out.println(Arrays.toString(arr));

        //Minimum no. of Jumps to reach end of an array: 
        jumps(arr);       ERROORRRRRRR!!!
        
        // Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.There is only one 
        // repeated number in nums, return this repeated number.
        // Input: nums = [3,1,3,4,2] Output: 3

        int[] arr1 = { 1,2,4,2,3 } ;     // n + 1 = 5 numbers in range (1 to 4)=(1,n)
        int[] matchArr =  new int[256];
        Arrays.sort(arr1);   //sorting is important !! 
        int index;
        int extra = 0 ;     //give default value here
        for (int i=0;i<n;i++){
            index = arr1[i];
            if (matchArr[index] == 0){ 
                matchArr[index]++;
            }else{
                extra  = index;
                break;
            }
        }
        System.out.println("duplicate element's value is : "+extra);

        //m2 : 
        System.out.println(Arrays.toString(arr1));
        int n1 = arr1.length;
        Arrays.sort(arr1);
        System.out.println("sorted array: "+Arrays.toString(arr1));
        for (int i=1;i<n1;i++){
            if(arr1[i-1]==arr1[i]){ System.out.println("duplicate number found : "+arr1[i]);}
        }

    }
}
