package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Utilisateur on 22/06/2017.
 */
public class WallTest {
    private Wall test;
    @Before
    public void setUp() throws Exception {
        test = new Wall();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNumber() throws Exception {
        final int expected = 0;

        assertEquals(expected,test.getNumber());
    }

}