/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonathanpomper
 */
public class RandomTestsTest {
    
    public RandomTestsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class RandomTests.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        int z = RandomTests.main(args);
        if (z==11)
        {
            System.out.println("pass");
        }
        else
        {
            fail("The test case is a prototype.");
        }
    }
}
