public class Queens {
    public static void main(String args[]){
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }


    static int queens(boolean[][] board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }


        int count = 0;
        for(int col = 0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1);
                board[row][col] = false;
            }
        }


        return count;
    }

    static void display(boolean[][] board){
        for(boolean[] arr : board){
            for(boolean el : arr){
                if(el){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board,int r,int c){
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }

        int maxLeft = Math.min(r,c);
        for(int i=0;i<=maxLeft;i++){
            if(board[r - i][c - i]){
                return false;
            }
        }
        
        int maxRight = Math.min(r,board.length - c - 1);
        for(int i=0;i<=maxRight;i++){
            if(board[r - i][c + i]){
                return false;
            }
        }

        return true;
    }
}
