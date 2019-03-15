import java.util.*;

public class Quick{
  public static int ans;

  /*Modify the data array such that:
   *1. Only the indices from start to end inclusive are considered in range
   *2. A random index from start to end inclusive is chosen, the corresponding
   *   element is designated the pivot element.
   *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
   *4. all elements in range that are larger than the pivot element are placed after the pivot element.
   *@return the index of the final position of the pivot element.
   */


  public static int partition(int[] data, int start, int end){

    Random rand = new Random();
    int index = rand.nextInt(data.length);
    int pivot = data[index];

    while (start <= end){

      while (data[start] < pivot){
        start += 1;
      }

      while (data[end] > pivot){
        end -= 1;
      }

      if (start >= end){
        break;
      } else if (start < end){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        start += 1;
        end -= 1;
      }
    }
    return start;
  }

  /*return the value that is the kth smallest value of the array. k=0 is the smallest*/

  public static int quickselect(int[]data, int k){
    partition(data, 0, data.length-1);
    for (int i = 0; i < data.length; i++){
      if (i == k){
        ans = data[k];
      }
    }
    return ans;
  }


//I don't know how to write quickSort without a helper?? :(
public static void quicksortH(int[] data, int start, int end) {
    if (end - start <= 0) {
       return;
    } else {
      int split = partition(data, start, end);
      quicksortH(data, start, split- 1);
      quicksortH(data, split + 1, end);
    }
}


public static void quicksort(int[] data) {
  quicksortH(data, 0, data.length - 1);
}


  public static void main(String[] args) {
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
