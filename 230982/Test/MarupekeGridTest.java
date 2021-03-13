import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarupekeGridTest {
    MarupekeGrid obj;

    @Before
    public void setUp()  {
        obj= new MarupekeGrid(4);
    }

    @Test
    public void setSolid() {
        obj.setSolid(1,1);
        assertEquals('#',obj.grid[1][1]);
    }

    @Test
    public void isValid() {
        obj.setSolid(1,1);
        obj.setX(0,0,false);
        obj.setX(0,1,false);
        obj.setX(1,0,false);
        assertEquals(true,obj.isValid(2,2,'X'));
    }

    @Test
    public void setX() {
        obj.setX(1,2,false);
        assertEquals('X',obj.grid[1][2]);
    }

    @Test
    public void setO() {
        obj.setO(2,2,false);
        assertEquals('O',obj.grid[2][2]);
    }

    @Test
    public void testToString() {
        String s = new String();
        for(int i=0;i< obj.grid.length;i++){
            for (int j=0;j< obj.grid[i].length;j++)
                s=s+obj.grid[i][j];
            s=s+"\n";
        }
        assertEquals(s,obj.toString());
    }


    @Test
    public void randomPuzzle() {
        obj.fillRandomCell(2,'O',2,obj);
        for(int i=0;i< obj.grid.length;i++)
            for (int j=0;j< obj.grid[i].length;j++)
                if(obj.grid[i][j]=='O')
                    assert true;

    }

    @Test
    public void TestfillRandomCell() {
      obj.fillRandomCell(2,'X',2,obj);
        for(int i=0;i< obj.grid.length;i++)
            for (int j=0;j< obj.grid[i].length;j++)
                if(obj.grid[i][j]=='X')
                    assert true;

    }

    @Test
    public void main() {
        obj.fillRandomCell(2,'O',2,obj);
        obj.fillRandomCell(2,'X',2,obj);
        for(int i=0;i< obj.grid.length;i++)
            for (int j=0;j< obj.grid[i].length;j++)
                if(obj.grid[i][j]!='-')
                    assert true;


    }
}