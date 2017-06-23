package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Utilisateur on 22/06/2017.
 */
public class ExitTest {
    Exit test;
    @Before
    public void setUp() throws Exception {
        test = new Exit();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNumber() throws Exception {
        final int expected = 6;
        assertEquals(expected,test.getNumber());
    }

}