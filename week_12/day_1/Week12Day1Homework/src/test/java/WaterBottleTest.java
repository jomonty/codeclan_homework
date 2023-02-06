import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.codeclan.homework.WaterBottle;

public class WaterBottleTest {
    private WaterBottle waterBottle;

    @Before
    public void setup() {
        waterBottle = new WaterBottle();
    }

    @Test
    public void testStartVolumeEquals100() {
        assertEquals(100, waterBottle.getVolume());
    }
    @Test
    public void testDrinkFunction() {
        waterBottle.drink();
        assertEquals(90, waterBottle.getVolume());
        waterBottle.drink();
        assertEquals(80, waterBottle.getVolume());
    }
    @Test
    public void testEmptyFunction() {
        waterBottle.empty();
        assertEquals(0, waterBottle.getVolume());
    }
    @Test
    public void testFillFunction() {
        waterBottle.empty();
        assertEquals(0, waterBottle.getVolume());
        waterBottle.fill();
        assertEquals(100, waterBottle.getVolume());
    }



}
