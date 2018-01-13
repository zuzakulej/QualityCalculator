package pl.edu.agh.qualitycalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculationsTest {
    Calculations calculationsUnderTest;
    CalculationsVerbalizer calculationsVerbalizerUnderTest;

    @Before
    public void setUp() {
        calculationsUnderTest = new Calculations();
    }

    @Before
    public void setUpVeb() {
        calculationsVerbalizerUnderTest = new CalculationsVerbalizer();
    }

    @Test
    public void testVeb() throws Exception {
        assertEquals("3.0 plus 3.0 gives value 6.0",calculationsVerbalizerUnderTest.verbalize(Operation.SUM, 3, 3, 6));
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(5, calculationsUnderTest.calculate(Operation.SUM, 2, 3), 0.01);
    }

    @Test
    public void testMul() throws Exception {
        assertEquals(6, calculationsUnderTest.calculate(Operation.MULTIPLY, 2, 3), 0.01);
    }

    @Test
    public void testSub() throws Exception {
        assertEquals(2, calculationsUnderTest.calculate(Operation.SUBTRACT, 5, 3), 0.01);
    }

    @Test
    public void testDiv() throws Exception {
        assertEquals(3, calculationsUnderTest.calculate(Operation.DIVIDE, 9, 3), 0.01);
    }

    @Test
    public void testDivNullPos() throws Exception {
        assertEquals(Float.POSITIVE_INFINITY, calculationsUnderTest.calculate(Operation.DIVIDE, 5, 0), 0.01);
    }

    @Test
    public void testDivNullNeg() throws Exception {
        assertEquals(Float.NEGATIVE_INFINITY, calculationsUnderTest.calculate(Operation.DIVIDE, -5, 0), 0.01);
    }

    @After
    public void tearDown() {
    }
}
