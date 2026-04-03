import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhiteBoxTest {

    @Test
    void testCase1_InvalidAge() {
        // ID 1: age = -1, qty = 3, isWeekend = true
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MovieTicket.calculateTotal(-1, 3, true);
        });
        assertEquals("Tuổi không hợp lệ: -1", exception.getMessage());
    }

    @Test
    void testCase2_InvalidQty() {
        // ID 2: age = 18, qty = -1, isWeekend = false
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MovieTicket.calculateTotal(18, -1, false);
        });
        assertEquals("Số vé không hợp lệ: -1", exception.getMessage());
    }

    @Test
    void testCase3_ChildWeekendDiscount5() {
        // ID 3: age = 17, qty = 5, isWeekend = true
        // (50 + 20) * 5 * 0.95 = 332.5
        double expected = 332.5;
        double actual = MovieTicket.calculateTotal(17, 5, true);
        assertEquals(expected, actual, 0.001, "TC fail:  tính vé trẻ em cuối tuần có giảm giá 5%");
    }

    @Test
    void testCase4_AdultWeekdayDiscount10() {
        // ID 4: age = 20, qty = 11, isWeekend = false
        // (60 + 0) * 11 * 0.9 = 594.0
        double expected = 594.0;
        double actual = MovieTicket.calculateTotal(20, 11, false);
        assertEquals(expected, actual, 0.001, "TC fail: tính vé người lớn ngày thường có giảm giá 10%");
    }

    @Test
    void testCase5_ElderlyWeekendNoDiscount() {
        // ID 5: age = 67, qty = 2, isWeekend = true
        // (40 + 20) * 2 = 120.0
        double expected = 120.0;
        double actual = MovieTicket.calculateTotal(67, 2, true);
        assertEquals(expected, actual, 0.001, "TC fail: tính vé người già cuối tuần không giảm giá");
    }
}