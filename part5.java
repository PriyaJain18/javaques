// package Questions;4
import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

public class part5 {
    /*
     * N = 2, M = 3
     * arr1[] = {10, 12}
     * arr2[] = {5, 18, 20}
     * Output: 5 10 12 18 20
     * Explanation:
     * arr1[] = {5, 10}
     * arr2[] = {12, 18, 20}
     */

    public static void mergeArr(int[] arr1,int[] arr2,int n1,int n2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // boolean b = null;
        for (int i=0;i<n1;i++){
            pq.offer(arr1[i]);
        }
        for (int i=0;i<n2;i++){
            pq.offer(arr2[i]);
        }
        System.out.println(pq);
      
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i =0;i<n1;i++){
            arr1[i] = sc.nextInt();  
        }
        int[] arr2 = new int[n2];
        for (int i =0;i<n2;i++){
            arr2[i] = sc.nextInt();  
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        mergeArr(arr1,arr2,n1,n2);

    }

}
