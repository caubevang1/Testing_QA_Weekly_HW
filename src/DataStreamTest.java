import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataStreamTest {

    @Test
    @DisplayName("TC 1, Input: (0, 2, true), Expected: IllegalArgumentException")
    void age_duPair_0_1T_invalidAge_zero() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(0, 2, true)
        );
        assertEquals("Tuổi không hợp lệ: 0", ex.getMessage());
    }

    @Test
    @DisplayName("TC 2, Input: (5, 0, true), Expected: IllegalArgumentException")
    void age_duPair_0_1F_invalidQty_zero() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(5, 0, true)
        );
        assertEquals("Số vé không hợp lệ: 0", ex.getMessage());
    }

    @Test
    @DisplayName("TC 3, Input: (17, 6, false), Expected: 285.0")
    void age_duPair_0_6T_child_noWeekend_midDiscount() {
        assertEquals(285.0, MovieTicket.calculateTotal(17, 6, false), 0.001);
    }

    @Test
    @DisplayName("TC 4, Input: (80, 3, false), Expected: 120.0")
    void age_duPair_0_6F_senior_noWeekend_noDiscount() {
        assertEquals(120.0, MovieTicket.calculateTotal(80, 3, false), 0.001);
    }

    @Test
    @DisplayName("TC 5, Input: (50, 8, false), Expected: 456.0")
    void age_duPair_0_8T_adult_noWeekend_midDiscount() {
        assertEquals(456.0, MovieTicket.calculateTotal(50, 8, false), 0.001);
    }

    @Test
    @DisplayName("TC 6, Input: (55, 2, true), Expected: 160.0")
    void age_duPair_0_8F_adult_weekend_noDiscount() {
        assertEquals(160.0, MovieTicket.calculateTotal(55, 2, true), 0.001);
    }

    @Test
    @DisplayName("TC 7, Input: (16, 0, true), Expected: IllegalArgumentException")
    void qty_duPair_0_3T_invalidQty() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(16, 0, true)
        );
        assertEquals("Số vé không hợp lệ: 0", ex.getMessage());
    }

    @Test
    @DisplayName("TC 8, Input: (90, 4, false), Expected: 160.0")
    void qty_duPair_0_3F_validQty_senior_noDiscount() {
        assertEquals(160.0, MovieTicket.calculateTotal(90, 4, false), 0.001);
    }

    @Test
    @DisplayName("TC 9, Input: (16, 7, false), Expected: 332.5")
    void qty_duPair_0_14T_child_midDiscount() {
        assertEquals(332.5, MovieTicket.calculateTotal(16, 7, false), 0.001);
    }

    @Test
    @DisplayName("TC 10, Input: (15, 11, false), Expected: 495.0")
    void qty_duPair_0_14F_child_highDiscount() {
        assertEquals(495.0, MovieTicket.calculateTotal(15, 11, false), 0.001);
    }

    @Test
    @DisplayName("TC 11, Input: (14, 12, false), Expected: 540.0")
    void qty_duPair_0_16T_child_qty12_highDiscount() {
        assertEquals(540.0, MovieTicket.calculateTotal(14, 12, false), 0.001);
    }

    @Test
    @DisplayName("TC 12, Input: (14, 3, false), Expected: 150.0")
    void qty_duPair_0_16F_child_noDiscount() {
        assertEquals(150.0, MovieTicket.calculateTotal(14, 3, false), 0.001);
    }

    @Test
    @DisplayName("TC 13, Input: (67, 4, false), Expected: 160.0")
    void qty_duPair_0_13_senior_noDiscount() {
        assertEquals(160.0, MovieTicket.calculateTotal(67, 4, false), 0.001);
    }

    @Test
    @DisplayName("TC 14, Input: (68, 2, true), Expected: 120.0")
    void isWeekend_duPair_0_11T_senior_weekendSurcharge() {
        assertEquals(120.0, MovieTicket.calculateTotal(68, 2, true), 0.001);
    }

    @Test
    @DisplayName("TC 15, Input: (75, 2, false), Expected: 80.0")
    void isWeekend_duPair_0_11F_senior_noWeekend() {
        assertEquals(80.0, MovieTicket.calculateTotal(75, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC 16, Input: (75, 3, false), Expected: 120.0")
    void basePrice_duPair_5_13_senior_def() {
        assertEquals(120.0, MovieTicket.calculateTotal(75, 3, false), 0.001);
    }

    @Test
    @DisplayName("TC 17, Input: (16, 2, false), Expected: 100.0")
    void basePrice_duPair_7_13_child_def() {
        assertEquals(100.0, MovieTicket.calculateTotal(16, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC 18, Input: (20, 2, false), Expected: 120.0")
    void basePrice_duPair_9_13_adult_def() {
        assertEquals(120.0, MovieTicket.calculateTotal(20, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC 19, Input: (66, 2, false), Expected: 80.0")
    void basePrice_duPair_10_13_senior_else() {
        assertEquals(80.0, MovieTicket.calculateTotal(66, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC 20, Input: (67, 2, true), Expected: 120.0")
    void basePrice_duPair_12_13_senior_weekendAdd() {
        assertEquals(120.0, MovieTicket.calculateTotal(67, 2, true), 0.001);
    }

    @Test
    @DisplayName("TC 21, Input: (68, 6, false), Expected: 228.0")
    void total_duPair_13_15_midDiscount() {
        assertEquals(228.0, MovieTicket.calculateTotal(68, 6, false), 0.001);
    }

    @Test
    @DisplayName("TC 22, Input: (68, 15, false), Expected: 540.0")
    void total_duPair_13_17_highDiscount() {
        assertEquals(540.0, MovieTicket.calculateTotal(68, 15, false), 0.001);
    }

    @Test
    @DisplayName("TC 23, Input: (69, 2, false), Expected: 80.0")
    void total_duPair_13_18_noDiscount_return() {
        assertEquals(80.0, MovieTicket.calculateTotal(69, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC 24, Input: (70, 7, false), Expected: 266.0")
    void total_duPair_15_18_midDiscount_return() {
        assertEquals(266.0, MovieTicket.calculateTotal(70, 7, false), 0.001);
    }

    @Test
    @DisplayName("TC 25, Input: (71, 12, false), Expected: 432.0")
    void total_duPair_17_18_highDiscount_return() {
        assertEquals(432.0, MovieTicket.calculateTotal(71, 12, false), 0.001);
    }
}