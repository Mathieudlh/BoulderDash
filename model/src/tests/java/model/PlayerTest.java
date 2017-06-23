package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Utilisateur on 22/06/2017.
 */
public class PlayerTest {

    private Player test;

    @Before
    public void setUp() throws Exception {
        test = new Player();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPlayer() throws Exception {
        final boolean expected = true;
        assertEquals(expected,test.isPlayer());
    }

    @Test
    public void move() throws Exception {
    }

    @Test
    public void getImage() throws Exception {
    }

}