import java.util.Random;
import java.util.ArrayList;

public class SudokuGenerator {
    public static void main(String[] args) {
        int[][] Puzzle = new int[9][9];
        Random rand = new Random();
        
        //Building the Array Row by Row
                
        // Gets available numbers
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                ArrayList<Integer> numGen = new ArrayList<>();
                
                for (int value = 1; value <= 9; value++) {
                    if ( !rowCheck(Puzzle, value, row, col) &&
                            !colCheck(Puzzle, value, row, col) &&
                            !areaCheck(Puzzle, value, row, col)) {
                                numGen.add(value);
                            }
                }
                // Resets
                if (numGen.isEmpty()) {
                    for (int c = 0; c < 9; c++) {
                        Puzzle[row][c] = 0;
                    }
                    col = -1;
                } else { //Chooses from the list
                    int temp = numGen.get(rand.nextInt(numGen.size()));
                    Puzzle[row][col] = temp;
                }
            }
        }
        
        
        System.out.print("-----------------");
        System.out.println();
        
        //Printing out the puzzle
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(Puzzle[row][col] + " ");
            } 
            System.out.println();
        }
        
        System.out.println("-----------------");
        System.out.print("--Sudoku Puzzle--");
        
        
        
    }
    
    //Checking Row and returning true if already present
    
    public static boolean rowCheck(int[][] Puzzle, int value, int row, int currentCol) {
        ArrayList<Integer> rowValues = new ArrayList<>();
        int col = currentCol;
        while (col != 0) {
            rowValues.add(Puzzle[row][col - 1]);
            col --;
        }
        if (rowValues.contains(value)) {
            return true;
        }
        return false;
    }
    
    
    //Checking Column and returning true if already present
    
    public static boolean colCheck(int[][] Puzzle, int value, int currentRow, int col) {
        ArrayList<Integer> colValues = new ArrayList<>();
        int row = currentRow;
        while (row != 0) {
            colValues.add(Puzzle[row - 1][col]);
            row --;
        }
        if (colValues.contains(value)) {
            return true;
        }
        return false;
    }
    
    //Checking the 3x3 and returning true if already present
    
    public static boolean areaCheck(int[][] puzzle, int value, int row, int col) {
        int localRow = row - (row % 3);
        int localCol = col - (col % 3);
        
        for (int r = localRow; r < localRow + 3; r++) {
            for (int c = localCol; c < localCol +3; c++) {
                if (puzzle[r][c] == value) {
                    return true;
                }
            }
        }
        return false;
    }
    
}