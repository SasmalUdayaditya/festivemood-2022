import java.util.ArrayList;

public class Search {
    public static void main(String args[]){               
        int[] arr = {5,6,7,8,9,9,2,3};
        int target = 2;
        System.out.println(searchRotatedArray(arr,target,0,arr.length-1));
    }

    static int search(int[] arr,int target, int i){
        if(i == arr.length){
            return -1;
        }
       if(arr[i] == target){
           return i;
       }
        return search(arr,target,i+1);
    }

    static ArrayList<Integer> find(int arr[],int target,int i, ArrayList<Integer> list){
          if(i == arr.length){
              return list;
          }

          if(arr[i] == target){
              list.add(i);
          }

          return find(arr,target,i+1,list);
    }

    static ArrayList<Integer> find2(int arr[],int target,int i){
        ArrayList<Integer> list = new ArrayList<>();
        if(i == arr.length){
            return list;
        }

        if(arr[i] == target){
            list.add(i);
        }

        ArrayList<Integer> ansFromBelow = find2(arr,target,i+1);
        list.addAll(ansFromBelow);
        return list;
  }

    static int searchRotatedArray(int[] arr,int target,int s,int e){
        if(s>e){
            return -1;
        }

        int mid = s + (e-s)/2;
        if(target == arr[mid]){
            return mid;
        }

        if(arr[s] <= arr[mid]){
             if(target >= arr[s] && target <= arr[mid]){
                return searchRotatedArray(arr, target,s,mid - 1);
             }else{
                return searchRotatedArray(arr, target,mid + 1,e);
             }
        }

        if(target >= arr[mid] && target <= arr[e]){
            return searchRotatedArray(arr, target,mid + 1,e);
        }

            return searchRotatedArray(arr, target,s,mid - 1);
        
    }
}
