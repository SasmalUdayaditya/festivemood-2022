import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringOP {
    public static void main(String args[]){
   System.out.println(die("",4));
      
   
       
       
    }

    static String ans = "";
    static void skipAChar(String str,int i){
        if(i >= str.length()){
            return;
        }
        
          
           if(str.charAt(i) != 'a'){
               ans += str.charAt(i);
           }

           skipAChar(str,i+1);
    }


    static void skipChar(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            skipChar(p, up.substring(1));
        }else{
            skipChar(p+ch, up.substring(1));
        }
    }

    static String skip(String up){
        if(up.isEmpty()){
           
            return "";
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            return skip(up.substring(1));
        }else{
            return ch + skip(up.substring(1));
        }
    }

    static String skipApple(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }else{
            return ch + skipApple(str.substring(1));
        }
    }

    static String skipAppNotApple(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);

        if(str.startsWith("app") && !str.startsWith("apple")){
            return skipAppNotApple(str.substring(3));
        }else{
            return ch + skipAppNotApple(str.substring(1));
        }
    }


    static List<List<Integer>> subsetArrayItr(int[] arr){
          List<List<Integer>> outer = new ArrayList<>();
          
          
          outer.add(new ArrayList<>());

          for(int num : arr){
              int n = outer.size();
              for(int i=0;i<n;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
              }
              
          }


          return outer;
    }


    static List<List<Integer>> subsetDuplicateArrayItr(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        
        
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for(int i=0;i<arr.length;i++){
            start = 0;
            if(i> 0 && arr[i] == arr[i-1]){
                 start = end+1;
                 
            }
            end = outer.size()-1;
            
            int n = outer.size();
            for(int j=start;j<n;j++){
              List<Integer> inner = new ArrayList<>(outer.get(j));
              inner.add(arr[i]);
              outer.add(inner);
            }
            
        }


        return outer;
  }


  static void permutations(String p,String up){
      if(up.isEmpty()){
          System.out.println(p);
          return;
      }

      char ch = up.charAt(0);
      for(int i=0;i<=p.length();i++){
          String f = p.substring(0,i);
          String s = p.substring(i, p.length());
          permutations(f+ ch + s, up.substring(1));
      }
  }


  static ArrayList<String> permutationsList(String p,String up){
    if(up.isEmpty()){
       ArrayList<String> list = new ArrayList<>();
       list.add(p);
        return list;
    }

    char ch = up.charAt(0);
    ArrayList<String> ans = new ArrayList<>();
    for(int i=0;i<=p.length();i++){
        String f = p.substring(0,i);
        String s = p.substring(i, p.length());
        
        ans.addAll(permutationsList(f+ ch + s, up.substring(1)));
    }
    return ans;
}


static int permutationsCount(String p,String up){
    if(up.isEmpty()){
        return 1;
    }

    char ch = up.charAt(0);
    int count = 0;
    for(int i=0;i<=p.length();i++){
        String f = p.substring(0,i);
        String s = p.substring(i, p.length());
        
       count = count + permutationsCount(f+ ch + s, up.substring(1));
    }
    return count;
}

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

static List<String> phonePad(String p,String up){
    if(up.isEmpty()){
        ArrayList<String> list = new ArrayList<>();
        list.add(p);
        return list;
    }
    
    int digit = up.charAt(0) - '0'; // convert to int "1" -> 1
    
    ArrayList<String> ans = new ArrayList<>();
    
    int start = (digit - 2)*3;
    int end = (digit - 1)* 3;
    
    if(digit == 7){
        end = ((digit - 1) * 3)+1;
    }
    if(digit == 8){
        start = (digit - 2)*3 + 1;
        end = ((digit - 1) * 3) +1;
    }
    if(digit == 9){
        start = (digit - 2)*3 + 1;
        end = ((digit - 1) * 3)+2;
    }
    
    for(int i = start;i<end;i++){
        char ch = (char) ('a' + i);
        ans.addAll(phonePad(p+ch,up.substring(1)));
    }
    return ans;
}

public static int die(String p,int up){
    if(up == 0){
        // ArrayList<String> list = new ArrayList<>();
        // list.add(p);
        return 1;
    }
    
    int count = 0;
    
    for(int i=1;i<=6 && i<=up;i++){
        count = count +  die(p + i,up-i);
    }
   return count;
}
  


}
