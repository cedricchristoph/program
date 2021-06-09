package tictactoe;

import java.awt.event.ItemEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Paquete para testear TacTacToe.java
 *
 * @author Cedric Christoph
 */
public class TicTacToeTest {

    private TicTacToe ttt;

    public TicTacToeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ttt = new TicTacToe();
        ttt.init();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getYesnull method, of class TicTacToe.
     */
    @Test
    public void testGetYesnull() {
        System.out.println("getYesnull");
        int result = ttt.getYesnull();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of setYesnull method, of class TicTacToe.
     */
    @Test
    public void testSetYesnull() {
        System.out.println("setYesnull");
        int expResult = 1;
        ttt.setYesnull(expResult);
        assertEquals(expResult, ttt.getYesnull());
    }

    /**
     * Test of getA method, of class TicTacToe.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        int expResult[][] = {{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11}, {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11},
        {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};
        int[][] result = ttt.getA();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setA method, of class TicTacToe.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        int[][] a = {{1}};
        ttt.setA(a);
        assertArrayEquals(a, ttt.getA());
    }

    /**
     * Test of init method, of class TicTacToe.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        TicTacToe instance = new TicTacToe();
        instance.init();

    }

    /**
     * Test of showResetButton method, of class TicTacToe.
     */
    @Test
    public void testShowResetButton() {
        System.out.println("showResetButton");
        TicTacToe instance = new TicTacToe();
        instance.showResetButton();
    }

    /**
     * Test of check method, of class TicTacToe.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int num1 = 0;
        TicTacToe instance = new TicTacToe();
        instance.check(num1);

    }

    /**
     * Test of complogic method, of class TicTacToe.
     */
    @Test
    public void testComplogic() {
        System.out.println("complogic");
        int num = 0;
        TicTacToe instance = new TicTacToe();
        instance.init();
        instance.complogic(num);
    }

    /**
     * Test of itemStateChanged method, of class TicTacToe.
     */
    @Test
    public void testItemStateChanged() {
        System.out.println("itemStateChanged");
        ItemEvent e = null;
        TicTacToe instance = new TicTacToe();
        instance.itemStateChanged(e);
    }

    /**
     * Test of checkVictory method, of class TicTacToe.
     */
    @Test
    public void testCheckVictory() {
        System.out.println("checkVictory");
        ttt.checkVictory();
    }

}
