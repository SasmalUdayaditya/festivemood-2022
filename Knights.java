public class Knights {
    public static void main(String args[]){
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0,0,n);
    }

    public static void knight(boolean[][] board,int row,int col,int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length - 1 &&  col == board.length){
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            knight(board,row,col+1,knights-1);
            board[row][col] = false;
        }

       
            knight(board, row, col + 1, knights);
        
        
    }

    public static boolean isSafe(boolean[][] board,int r,int c){
        if (isValidCoordinate(board, r-2, c+1)){
            if(board[r-2][c+1]){
                return false;
            }
        }

        if (isValidCoordinate(board, r-2, c-1)){
            if(board[r-2][c-1]){
                return false;
            }
        }

        if (isValidCoordinate(board, r-1, c+2)){
            if(board[r-1][c+2]){
                return false;
            }
        }

        if (isValidCoordinate(board, r-1, c-2)){
            if(board[r-1][c-2]){
                return false;
            }
        }

        return true;
    }

    public static boolean isValidCoordinate(boolean[][] board,int r,int c){
        return (r >= 0 && r < board.length && c >= 0 && c < board.length);
    }

    static void display(boolean[][] board){
        for(boolean[] arr : board){
            for(boolean el : arr){
                if(el){
                    System.out.print("K ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
