import org.junit.Test;
import static org.junit.Assert.*;
import org.codeclan.homework.Calculator;

public class CalculatorTest {

    @Test
    public void testAdd() {
        int result = Calculator.add(10, 10);
        assertEquals(20, result);
    }

    @Test
    public void testSubtract() {
        int result = Calculator.subtract(20, 10);
        assertEquals(10, result);
    }

    @Test
    public void testMultiply() {
        int result = Calculator.multiply(10, 10);
        assertEquals(100, result);
    }

    @Test
    public void testDivide() {
        double result = Calculator.divide(30, 4);
        assertEquals(7.5, result, 0.0);
    }

}
