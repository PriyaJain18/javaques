public class priorityQueue {
    private int MAX; //max no of elements in the array 
    private int[] arr;
    private int nItems;

    //constructor of class  : 
    public priorityQueue(){
        MAX=  10;
        arr = new int[10]; //initializing array
        nItems = 0 ; //initially 

    }
    public void insert(int val){
       
        if(nItems == 0){
            arr[0] = val;
            return;
        }
        int  i;
        for(i =nItems-1;i>=0;i--){
            if (val > arr[i]){
                arr[i+1] = arr[i] ; 
            }
            else {break; }
        }
        arr[i+1] = val;
        nItems++;
        return;
    }
    public void printQueue(){
    
        for(int i=0;i< nItems;i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        priorityQueue pq =new priorityQueue();
        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.printQueue();
    }
    
}
