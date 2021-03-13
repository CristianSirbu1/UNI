import java.util.Random;

public class MarupekeGrid {
    char[][] grid;
    boolean[][] editable;
    public MarupekeGrid( int n){
        if(n>10){
            grid= new char[10][10];
            editable= new boolean[10][10];
            for(int i=0;i<10;i++)
                for(int j =10;j<n;j++)
                {editable[i][j]=true;grid[i][j]='-';}
        }
        if(n<3){
            grid= new char[3][3];
            editable= new boolean[3][3];
            for(int i=0;i<3;i++)
                for(int j =0;j<3;j++)
                {editable[i][j]=true;grid[i][j]='-';}
        }
        grid= new char[n][n];
        editable= new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j =0;j<n;j++)
            {editable[i][j]=true;grid[i][j]='-';}
    }
    public boolean setSolid(int x,int y){
        if(editable[x][y]){
            grid[x][y]='#';
            editable[x][y]=false;
            return true;
        }
        return false;
    }
    public boolean isValid(int x,int y, char temp){
        if(x >= 2 && temp == grid[x - 1][y] && temp == grid[x - 2][y]) {
            return false;
        }// checking coloumn above
        if(x >= 2 && y < grid[x].length && temp == grid[x - 1][y + 1] && temp == grid[x - 2][y + 2]) {
            return false;
        }//right diagonale above
        if(y < grid[x].length - 2 && temp == grid[x][y + 1] && temp == grid[x][y + 2]) {
            return false;
        }//right line
        if(x < grid.length - 2 && y < grid[x].length - 2 && temp == grid[x + 1][y + 1] && temp == grid[x + 2][y + 2]) {
            return false;
        }//right diagonale below
        if(x < grid.length - 2 && temp == grid[x + 1][y] && temp == grid[x + 2][y]) {
            return false;
        }//coulumn below
        if(x < grid.length - 2 && y >= 2 && temp == grid[x + 1][y - 1] && temp == grid[x + 2][y - 2]) {
            return false;
        }//left diagonale below
        if(y >= 2 && temp == grid[x][y - 1] && temp == grid[x][y - 2]) {
            return false;
        }//left line
        if(x >= 2 && y >= 2 && temp == grid[x - 1][y - 1] && temp == grid[x - 2][y - 2]) {
            return false;
        }//left diagonale above
        if(x >= 1 && x < grid.length - 1 && temp == grid[x - 1][y] && temp == grid[x + 1][y]) {
            return false;
        }//checking if its in the middle of 2 of the same symbols
        if(x >= 1 && y < grid[x].length - 1 && y >= 1 && x < grid.length - 1 && temp == grid[x - 1][y + 1] && temp == grid[x + 1][y - 1]) {
            return false;
        }//checking if its in the midlle of primal(first) diagonal
        if(y >= 1 && y < grid[x].length - 1 && temp == grid[x][y + 1] && temp == grid[x][y - 1]) {
            return false;
        }//if its in the middle of 2 symbols on the same line
        if(x >= 1 && x < grid.length - 1 && y >= 1 && y < grid[x].length - 1 && temp == grid[x - 1][y - 1] && temp == grid[x + 1][y + 1]) {
            return false;
        }//checking if its in the middle of secondary diagonale
        return true;
    }
    public boolean setX(int x, int y,boolean canEdit){
        if(editable[x][y] && isValid(x,y,'X')){
            grid[x][y]='X';
            editable[x][y]=canEdit;
           }
        return false;
       }
    public boolean setO(int x, int y,boolean canEdit){
        if(editable[x][y] && isValid(x,y,'O')){
            grid[x][y]='O';
            editable[x][y]=canEdit;
        }
        return false;
    }
    @Override
    public String toString(){
        String s = new String();
        for(int i=0;i< grid.length;i++){
            for (int j=0;j< grid[i].length;j++)
                s=s+grid[i][j];
            s=s+"\n";
        }
        return s;
    }
    public static MarupekeGrid  randomPuzzle (int size,int numFill,int numX,int numO ){
      int gridSize = size^2;
      int sumOfCells = numFill + numFill +numO +numX;
      if(sumOfCells > gridSize) return null;
      MarupekeGrid marupekeGrid = new MarupekeGrid(size);
      fillRandomCell(numFill,'#',size,marupekeGrid);
        fillRandomCell(numFill,'X',size,marupekeGrid);
        fillRandomCell(numFill,'O',size,marupekeGrid);
        return marupekeGrid;
    }
    public static void fillRandomCell(int numFill, char k, int size, MarupekeGrid grid) {
        int x, y;
        Random random = new Random();
        for (int i = 0; i < numFill; i++) {
            x = random.nextInt(size);
            y = random.nextInt(size);
            if(grid.editable[x][y])
                i--;
            switch (k) {
                case 'X': {
                    grid.setX(x, y, false);
                    break;
                }
                case 'O': {
                    grid.setO(x, y, false);
                    break;
                }
                case '#': {
                    grid.setSolid(x, y);
                    break;
                }
            }
        }
    }
    public static void main( String[] args){
        MarupekeGrid grid = new MarupekeGrid(7);
        grid = MarupekeGrid.randomPuzzle(7,4,2,2);
        System.out.println(grid);


    }

    }

