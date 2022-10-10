import java.util.Arrays;

public class Sorted {
    public static void main(String args[]){
       int[] arr = {1, 4, 2, 5, 7, 6, 3};
    //    bubbleSort(arr, arr.length-1, 0);
    // selectionSort(arr,arr.length,0,0);
    quickSort(arr,0,arr.length-1);
       System.out.println(Arrays.toString(arr));
    //triangle(5,0);
    }

    static boolean sorted(int arr[], int index){
        if(index == arr.length - 1){
            return true;
        }

        return arr[index] < arr[index+1] && sorted(arr,index+1);
    }

    static void triangle(int r, int c){
        if(r==0){
            return;
        }
        if(c<r){
            System.out.print("* ");
            triangle(r, c+1);
        }else{
            System.out.println();
            triangle(r-1, 0);
        }
    }

    static void bubbleSort(int[] arr, int r, int c){
        if(r == 0){
            return;
        }

        if(c<r){
            if(arr[c] > arr[c+1]){
                int temp = arr[c+1];
                arr[c+1] = arr[c];
                arr[c] = temp;
            }
            bubbleSort(arr,r,c+1);
        }else{
            bubbleSort(arr,r-1,0);
        }
    }

    static void selectionSort(int[] arr,int r,int c,int max){
        if(r==0){
            return;
        }
        

        if(c<r){
            if(arr[c] > arr[max]){
                selectionSort(arr,r,c+1,c);
            }else{
                selectionSort(arr,r,c+1,max);
            }
            
        }else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selectionSort(arr, r-1, 0, 0);
        }

       
        
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }


    static void mergeSortInPlace(int[] arr,int s,int e){
        if(e-s == 1){
            return;
        }

        int mid = (s+e)/2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr,mid,e);


       mergeInPlace(arr,s,mid,e);

    }

    static void mergeInPlace(int[] arr, int s, int m,int e){
        int[] mix = new int[e-s];
          int i=s;
          int j=m;
          int k=0;


          while(i<m && j<e){
              if(arr[i] < arr[j]){
                  mix[k] = arr[i];
                  i++;
              }else{
                  mix[k] = arr[j];
                  j++;
              }
              k++;
          }
          while(i<m){
              mix[k] = arr[i];
              i++;
              k++;
          }

          while(j<e){
            mix[k] = arr[j];
            j++;
            k++;
          }

          for(int z=0;z<mix.length;z++){
              arr[s+z] = mix[z];
          }
         
          
    }

    static int[] merge(int[] left,int[] right){
          int[] mix = new int[left.length+right.length];

          int i=0;
          int j=0;
          int k=0;

          while(i<left.length && j<right.length){
              if(left[i] < right[j]){
                 mix[k] = left[i];
                 i++;
              }else{
                mix[k] = right[j];
                j++;
              }
              k++;
          }

          while(i<left.length){
              mix[k] = left[i];
              i++;
              k++;
          }

          while(j<right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }

    static void quickSort(int[] arr,int l,int h){
         if(l>=h){
             return;
         }
         int s = l;
         int e = h;
         int mid = s + (e-s)/2; 
         int pivot = arr[mid];
         while(s<=e){
             while(arr[s] < pivot){
                 s++;
             }
             while(arr[e] > pivot){
                e--;
            }

            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
         }


         quickSort(arr,l,e);
         quickSort(arr,s,h);
    }
}
