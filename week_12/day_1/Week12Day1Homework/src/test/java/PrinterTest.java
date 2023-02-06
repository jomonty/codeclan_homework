import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.codeclan.homework.Printer;

public class PrinterTest {
    private Printer printer;

    @Before
    public void setup() {
        printer = new Printer(100, 500);
    }

    @Test
    public void testGetSheetsRemaining() {
        int result = printer.getNumberSheetsRemaining();
        assertEquals(100, result);
    }
    @Test
    public void testGetTonerRemaining() {
        int result = printer.getTonerVolumeRemaining();
        assertEquals(500, result);
    }
    @Test
    public void testPrintEnoughPaperAndToner() {
        String result = printer.print(20, 2);
        assertEquals("Success", result);
        assertEquals(60, printer.getNumberSheetsRemaining());
        assertEquals(460, printer.getTonerVolumeRemaining());
    }
    @Test
    public void testPrintEnoughPaperNotToner() {
        Printer lowToner = new Printer(100, 30);
        String result = lowToner.print(20, 2);
        assertEquals("Not enough toner.", result);
        assertEquals(100, lowToner.getNumberSheetsRemaining());
        assertEquals(30, lowToner.getTonerVolumeRemaining());
    }
    @Test
    public void testPrintEnoughTonerNotPaper() {
        Printer lowPaper = new Printer(30, 500);
        String result = lowPaper.print(20, 2);
        assertEquals("Not enough paper.", result);
        assertEquals(30, lowPaper.getNumberSheetsRemaining());
        assertEquals(500, lowPaper.getTonerVolumeRemaining());
    }
}
