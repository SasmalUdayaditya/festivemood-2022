import java.util.ArrayList;
import java.util.Arrays;

public class SubSeqPN {
    
    public static void main(String args[]){
        int[] arr = {-1,18,13,18,-2,-16,7,-1,-213,11};
        int c1 = 0;
        int c2 = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                c1++;
            }else{
                c2++;
            }
           
        }
          int[] neg = new int[c1];
          int[] pos = new int[c2];
          int j=0;
          int k = 0;
          for(int i=0;i<arr.length;i++){
              if(arr[i] < 0) {
                  neg[j++] = arr[i];
              }else{
                pos[k++] = arr[i];
              }
              
          }
          System.out.println(Arrays.toString(arr));
         System.out.println(Arrays.toString(pos));
         System.out.println(Arrays.toString(neg));

          System.out.println(seqItr(pos,neg));
    }

   

    // static void seq(){
    //      if(up.isEmpty()){
    //          System.out.println(p);
    //          return;
    //      }

    //     //int sum = 0;
    //      for(int i=0;i<up.length();i++){
    //          int in =  up.charAt(i) - '0';
    //          if(in < 0){
                 
               
    //                 seq(p + in,up.substring(1));
                
                
    //          }             
    //      }
    // } 


    static int seqItr(int[] pos,int[] neg){
        int maxSum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<pos.length && j<neg.length){
            int curr = neg[i] + pos[j];
            if( curr >= maxSum){
                maxSum += curr;
                // ans.add(pos[i]);
                // ans.add(neg[j]);
               
            }
            i++;
            j++;
           
             
        }
        System.out.println(ans);
       

        return maxSum;

    }
}
