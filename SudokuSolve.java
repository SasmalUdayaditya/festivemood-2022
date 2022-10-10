public class SudokuSolve {
    public static void main(String args[]){
        int[][] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    if (solve(board)) {
        display(board);
    } else {
        System.out.println("Cannot solve");
    }
      
    }


    public static boolean solve(int[][] board){
       int n = board.length;
       int row = -1;
       int col = -1;
       boolean emptyLeft = false;
       //this is how we should replace r and c from the arguments
       for(int i = 0;i<n;i++){
        for(int j=0;j<n;j++){
            if(board[i][j] == 0){
                row = i;
                col = j;
                emptyLeft = true;
                break;
            }
        }
       }

       if(emptyLeft == false){
        return true;
       }

       for(int num = 1;num<=9;num++){
        if(isSafe(board,row,col,num)){
            board[row][col] = num;
            if(solve(board)){
                return true;
            }else{
                board[row][col] = 0;
            }
        }
       }
       return false;
    }

    public static boolean isSafe(int[][] board,int row,int col,int num){

        for(int i=0;i<board.length;i++){
            if(board[row][i] == num){
                return false;
            }
        }

        for(int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart;r<rowStart + sqrt;r++){
            for(int c = colStart;c<colStart+sqrt;c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;

    }

    public static void display(int[][] board){
        for(int[] arr:board){
            for(int el : arr){
                System.out.print(el + " ");
            }

            System.out.println();
        }
    }
}
