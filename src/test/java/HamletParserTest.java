import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        HamletParser hamletParser = new HamletParser();
        String expected = "Lovely Leon tiptoed through the tulips.";

        //When
        String actual = hamletParser.changeHamletToLeon("Lovely Hamlet tiptoed through the tulips.");

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        HamletParser hamletParser = new HamletParser();
        String expected = "Petty Tariq dipped in the pool of pettiness.";

        //When
        String actual = hamletParser.changeHoratioToTariq("Petty Horatio dipped in the pool of pettiness.");

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
        //Given
        Boolean firstExpect = true;
        Boolean secondExpect = false;

        //When
        Boolean trueness = hamletParser.findHoratio("Horatio, HORATIO. Where you at?");
        Boolean falseness = hamletParser.findHoratio(" Where you at?");

        //Then
        Assert.assertEquals(firstExpect, trueness);
        Assert.assertEquals(secondExpect, falseness);

    }

    @Test
    public void testFindHamlet() {
        //Given
        Boolean firstExpect = true;
        Boolean secondExpect = false;

        //When
        Boolean trueness = hamletParser.findHamlet("Hamlet, HAMLET. Where you at?");
        Boolean falseness = hamletParser.findHamlet(" Where you at?");

        //Then
        Assert.assertEquals(firstExpect, trueness);
        Assert.assertEquals(secondExpect, falseness);

    }
}