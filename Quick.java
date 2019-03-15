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

    System.out.println("pivot: " + pivot);
    return start;
  }

  public static int quickselect(int[]data, int k){
    partition(data, 0, data.length-1);
    for (int i = 0; i < data.length; i++){
      if (i == k){
        ans = data[k];
      }
    }
    return ans;
  }





  public static void main(String[] args) {
    int[] test = new int[]{10,31, 10, 6,4 ,12, 29 };
    System.out.println(partition(test, 0, 6));
    for (int element : test){System.out.println(element);}
    System.out.println("\n");
    System.out.println(quickselect(test, 3));
  }
}
