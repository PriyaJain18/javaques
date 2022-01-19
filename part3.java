package Questions;
import java.util.Arrays;
import java.util.Scanner;

public class part3 {
    public static void minDiff(int[] arr,int k){
        int n = arr.length;
        int min=0,max=0;
        int[] convArr = new int[n];
        int i=0;
        if(arr[i]-k>=0){
            convArr[i] = arr[i]-k;
            min=max=convArr[i];
        }else{ 
            convArr[i] = arr[i]+k;
            min=max=convArr[i];
        } 
        for(i=1;i<n;i++){
            
            

            
            
        }



        convArr;

        System.out.println(Arrays.toString(convArr));

    }

    //Minimise the maximum difference between heights [V.IMP]:  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i] = sc.nextInt();  //note : enter sorted Arrays
        }
        System.out.println(Arrays.toString(arr));

        minDiff(arr,2);
        
    }
    
}
