// package Questions;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;
// import java.util.TreeSet;
import java.util.HashMap;
import java.util.TreeMap;

//OTHER (HANDY) IMPORTANT CLASSES : 
import java.util.Arrays;
import java.util.Collections;
import java.lang.Comparable;
// import java.text.NumberFormat.Style;

//CLASS FOR CREATING DATA-STRUCTURES WITH CUSTOM-TYPE : (contains/overrides methods of 'collection' class) : 
class Student implements Comparable<Student>{  
    String name;
    int rollNo; 
    public Student(String name ,int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
    @Override
    public String toString(){
        return "Student{"+"name='"+name+"' , rollNo='"+rollNo+"'}";
    }
    @Override
    public boolean equals(Object o){  //modified to the way -> if rollnos are same then this fun would return {true}
        if(this == o) return true;
        if ( o==null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }
    @Override
    public int hashCode(){ ////modified to the way -> so it returns hash codes by seeing rollnos ONLY not whole object 
        return Objects.hashCode(rollNo);     
    }
    @Override      //method belongs to 'Comparable' class; Also required for using Collections.sort() method 
    public int compareTo(Student that){
        return this.rollNo - that.rollNo; //implementation : s1.compareTo(s2)  i.e. (s1.rollNo - s2.rollNo) ; returns 0 if s1>s2 else -1  
    }

}


public class collectionFm {
    //collection framework : collection interface {interfaces -> List, Set, Queue } , Map interface , Iterator interface 
    public static void main(String[] args) {

        /*LIST INTERFACE */
    /*
    1)Arraylist :  
    non-synchronized 
    intially empty arraylist -> add -> 10 size 
    increase (size) by -> n + n/2 + 1  
    */
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(0, 3);   // a.add(index,element);

        Iterator<Integer> it = a.iterator();       //the ArrayList returns and 'iterator' that can be used to traverse through it 
        while(it.hasNext()){
            System.out.print("iterator"+it.next());

        }

        a.remove(0); //removes index
        a.remove(Integer.valueOf(3));  //removes integer value 
        a.clear(); //clear whole arrayList 
        // a.set(2,100)  : sets/changes value at a particular pos.: thus O(1)
        //add/remove value from mid of ArrayList : O(N) :as all elements after that element shifts by one place

        /*2) Linked List*/

        LinkedList<String> al=new LinkedList<>();  
        al.add("Ravi");  
        al.add("Vijay");  

        /*3) Vector -> STACK : */
        Vector<String> v=new Vector<>();
        v.add("Ayush");  

        Stack<String> animals = new Stack<>();
        animals.push("lion");
        animals.push("dog");
        animals.push("tiger");
        animals.push("horse");
        System.out.println(animals.peek());  //accor to LIFO 
        animals.pop();
        System.out.println(animals.peek());  //accor to LIFO 

       

        /* QUEUE INTERFACE: implementation using PriorityQueue, array and linkedlist 
        */
        
        // 1) Deque -> ArrayDeque and LinkedList : {FIFO}

        ArrayDeque<Integer> q1 = new ArrayDeque<>();      //If reference/LHS = ArrayDeque : we can USE ArrayDeque funs,else WE CANT !
        q1.offer(10);  //adds from RHS , .peek and .poll removes from LHS 
        //ArrayDeque's methods are as follows {double-sided work!!} : 
        q1.offerFirst(20);
        q1.offerLast(30);
        //similarly for '--peek()' and '--1poll()' 

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(12);  //add : can throw exception 
        q2.offer(24);
        q2.offer(36); 
        System.out.println(q2.peek());  //12
        System.out.println(q2.element()); //12  ; element :can throw exception 
        q2.poll();  //12
        System.out.println(q2.poll()); //24
        q2.remove();   //remove : can throw exception 

        // 2) Priority Queue : implements max/min heap etc underhood {Priority wise}; 
        Queue<Integer> q3 = new PriorityQueue<>();  //runs as MIN-HEAP by default 
        q3.add(8);
        q3.offer(3);
        q3.offer(12);
        q3.offer(6); 

        System.out.println(q3);
        System.out.println(q3.peek()); //3 as it is smallest (min-heap prioritize smallest first )
        System.out.println(q3.poll()); //3
        System.out.println(q3.element()); //6

        Queue<Integer> q4 = new PriorityQueue<>(Comparator.reverseOrder());  //runs as MAX-HEAP now 
        q4.add(8);    
        q4.offer(3);
        q4.offer(12);
        q4.offer(6); 
        
        System.out.println(q4);
        System.out.println(q4.peek()); //12 as it is Largest (max-heap prioritize Largest first )
        System.out.println(q4.poll()); //12
        System.out.println(q4.element()); //8
        
        
        /* SET INTERFACE  : Duplicate elements NOT allowed;
        >>>check enumset             
        >note : normally set's operation like clear() etc -> O(1) Complexity 
        SET CAN BE INSTANTIATED AS :
        Set<data-type> s1 = new HashSet<data-type>();  
        Set<data-type> s2 = new LinkedHashSet<data-type>();  
        Set<data-type> s3 = new TreeSet<data-type>();  
        */


        //1) Hashset {order not-defined/non-orderly/DOESNOT prints in order of value entered: as internally hashing is going on; uses a hash table 
        //for storage} -> LinkedHashSet { 'linkedlist implementation of SET interface; maintains the insertion order and permits null elements. } :

        Set<Integer> set = new HashSet<>(); //prints in random order 
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50); //50
        set.add(60);
        set.add(50); //50 repeated
        System.out.println(set);
        set.remove(20);
        System.out.println(set);
        boolean b = set.contains(10);  //true
        System.out.println(b);
        System.out.println(set.isEmpty());  //returns Boolean
        System.out.println(set.size()); //no. of elements in set
        set.clear(); //empties set 
        System.out.println(set);

        Set<Integer> lh = new LinkedHashSet<>();   //prints in ORDER as data added
        lh.add(10);
        lh.add(20);
        lh.add(30);
        lh.add(40);
        lh.add(50); //50
        lh.add(60);
        lh.add(50); //50 repeated
        System.out.println(lh);

        // 2)SortedSet {behind the scenes sorts structure and works on that ; alternate of Set} ={ BST + SET }-> treeset {Uses tree as storage}
        SortedSet<Integer> ss1 = new TreeSet<>();  //SortedSet can be instantiated like this 
        Set<Integer> ss2 = new TreeSet<>();  

        // note :  access and retrieval time of TreeSet is quite fast
        //NOTE : One that implements binary search tree have normal operations like set.clear() of -> O(LogN) Complexity 


        //CUSTOMIZED hashset {for non-primitive our-created}: 

        Set<Student> studentSet = new HashSet<>(); //NOTE : check Student class made at the top of this file !!
        studentSet.add(new Student("priya",1));
        studentSet.add(new Student("suhana",2));
        studentSet.add(new Student("payal",3));
        studentSet.add(new Student("suhana",2));
        System.out.println(studentSet.toString());
        System.out.println(studentSet);

        System.out.println(studentSet.toString());  //to get duplicate members also{Considers each duplicate element to be different existentially!}

        Student s1 = new Student("JK", 10);
        Student s2 = new Student("Tae", 10);
        Student s3 = new Student("Tae", 20);

        System.out.println(s1.equals(s2));    //s1 s2 : roll nos are same //true : as we customized/overrided equals method
        System.out.println(s2.equals(s3));    //s2 s3 : names are same 

        /* MAP: For storing key-value pairs ;'keys' should be unique. If we make another pair with same 'key_name',it would get overriden.
        [MAP Interface] -> [HashTable , hashMap (-> LinkedHashMap), weakHashMap , SortedSet ,SortedMap(-> TreeMap) ,AbstractMap (-> enumMap) ]
        //check : hashmap, enummap,weakHashMap
        */

        Map<String,Integer> numbs = new HashMap<>();
        numbs.put("one", 1);
        numbs.put("two", 2);
        numbs.put("three", 3);
        numbs.put("two", 4);    //overriden value of "two" from 2->4 
        //to prevent above (unknowingly) over-riding of values : 
        if(!numbs.containsKey("two")){
            numbs.put("two", 20);
        }
        numbs.putIfAbsent("two",30);

        System.out.println(numbs.containsKey("three"));
        System.out.println(numbs.containsValue(3));
       
        //PRINTING MAPS :
        //M1 :
        System.out.println(numbs);
        ///M2 :
        for(Map.Entry<String,Integer> e: numbs.entrySet()){                //map ke pairs ke 'entry' create hote h automatic that we can use to get data 
        System.out.print(e); // two=4 prints for key : two's iteration
        System.out.print(" "+ e.getKey());
        System.out.println(" "+ e.getValue());     //println = ISKE O/P KE BAD NEW ME CURSOR PAHUCH JAEGA 
        }
        //M3 : 
        for(String key : numbs.keySet()){   //for getting all keys
            System.out.print(key+ " ");
        }
        System.out.println();
        for(Integer val : numbs.values()){   //for getting all values 
            System.out.print(val + " ");
        }


        numbs.remove("two");
        System.out.println(numbs); 
        numbs.clear();
        System.out.println(numbs.isEmpty());

        //SortedMap {SORTED ON THE BASIS OF 'keys'-> TreeMap {under the hood puts the entries in binary search tree (BST) while doing the mapping}
        Map<String, Integer> tm = new TreeMap<>();
        tm.put("guava", 1);
        tm.put("apple", 2);
        tm.put("papaya", 3);
        tm.put("banana", 4);
        System.out.println(tm); //Prints (sorted) accor to 'keys' i.e. 'STRING' i.e. 'DICTIONARY-ORDER'
       

        /*Iterator ->listIterator */



        /*ARRAYS CLASS : works for 'array' NOT 'ArrayList' */
        int[] n1 = { 1,2,3,4,5 };
        
        int bs = Arrays.binarySearch(n1, 4);  //gives index of element=4 in array n1 
        System.out.println("index of '4' : "+ bs);
        //note : Try to implement Arrays.binarySearch() on ALREADY SORTED arrays
        
        //METHOD -> PARALLEL SEARCH : for splitting and distributing an array to multiple processors to search something;works for array-size >8192  
       
        int[] n2 = { 1,2,4,3,5 };
        System.out.println(Arrays.toString(n2));
        Arrays.sort(n2);
        System.out.println(Arrays.toString(n2));
        Arrays.fill(n2, 12);
        System.out.println(Arrays.toString(n2));

        /*Collections class usage : */
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(9);  
        arr.add(5);  
        arr.add(4);
        System.out.println(arr);
        Collections.sort(arr);  
        System.out.println(arr);

        List<Student> st = new ArrayList<>();
        st.add(new Student("hope", 10));
        st.add(new Student("rm", 20));
        st.add(new Student("augustD", 30));

        //compareTo() of Comparable class :
        Student S1 = new Student("a",10);
        Student S2 = new Student("b",10);
        Student S3 = new Student("c",60);
        //we setted compareTo() on the basis of roll no. 
        System.out.println(S1.compareTo(S2));  //same roll nos
        System.out.println(S1.compareTo(S3));  //different roll nos
        //Sorted ascendingly on the basis of rollNo :
        Collections.sort(st); //would give error if Student class doesnt implement 'Comparable' class,in order for elements to get compared & sorted

        //Sorting descendingly on the basis of Student's name : 
        
        Collections.sort(st,new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);       //here compareTo is normal method used for strings
            }
            
        });

        //or
        //Collections.sort(st,(o1, o2) -> o1.name.compareTo(o2.name));

         
    }
    
   

}
