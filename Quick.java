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
    data[index] = data[0];
    data[0] = pivot;

    while (start + 1 < end){

      while (data[start] < pivot){
        start += 1;
      }

      while (data[end] > pivot){
        end -= 1;
      }

      if (start < end){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;

        start += 1;
        end -= 1;
      }
    }
    System.out.println("pivot: " + pivot);
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
    if (!(end - start <= 0)) {
      int split = partition(data, start, end);
      quicksortH(data, start, split- 1);
      quicksortH(data, split + 1, end);
    }
}


public static void quicksort(int[] data) {
  quicksortH(data, 0, data.length - 1);
}


  public static void main(String[] args) {
    int[] test = new int[]{10, 6,4 ,12, 13, 1, 22, 19};
    //quicksort(test);
    partition(test, 0, 7);
    for (int e : test){System.out.println(e);}
  }
}
