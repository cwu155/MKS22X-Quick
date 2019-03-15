import java.util.*;

public class Quick{
  public static int median;

  /*Modify the data array such that:
   *1. Only the indices from start to end inclusive are considered in range
   *2. A random index from start to end inclusive is chosen, the corresponding
   *   element is designated the pivot element.
   *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
   *4. all elements in range that are larger than the pivot element are placed after the pivot element.
   *@return the index of the final position of the pivot element.
   */


  public static int partition(int[] data, int start, int end){

    //Random rand = new Random();
    //int index = rand.nextInt(data.length);
    int pivot = data[0];

    while (start <= end){
      while (data[start] < pivot){
        start++;
      }
      while (data[end] > pivot){
        end--;
      }

      if (start <= end){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        start++;
        end--;
      }
    }

    System.out.println("pivot: " + pivot);
    return start;
  }



  public static void main(String[] args) {
    int[] test = new int[]{4, 7, 8, 10, 11, 3, 9, 5, 6, 22,};
    partition(test, 0, 8);
    for (int element : test){System.out.println(element);}
  }
}
