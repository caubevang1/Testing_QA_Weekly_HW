import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Kiểm thử bảng quyết định
 * 26 ca kiểm thử TC1–TC26
 * Đơn vị kết quả: nghìn VNĐ
 */
@DisplayName("Kiểm thử bảng quyết định")
class DecisionTableTest {

    @Test
    @DisplayName("TC1: x<1 → Không hợp lệ")
    void tc1_invalid_age_below_min() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(0, 5, true));
    }

    @Test
    @DisplayName("TC2: 1≤x<18, y<1 → Không hợp lệ")
    void tc2_invalid_qty_below_min_young() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(10, 0, true));
    }

    @Test
    @DisplayName("TC6: 1≤x<18, y>100 → Không hợp lệ")
    void tc6_invalid_qty_above_max_young() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(10, 101, true));
    }

    @Test
    @DisplayName("TC7: 18≤x≤65, y<1 → Không hợp lệ")
    void tc7_invalid_qty_below_min_adult() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(30, 0, true));
    }

    @Test
    @DisplayName("TC11: 18≤x≤65, y>100 → Không hợp lệ")
    void tc11_invalid_qty_above_max_adult() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(30, 101, false));
    }

    @Test
    @DisplayName("TC12: 65<x≤120, y<1 → Không hợp lệ")
    void tc12_invalid_qty_below_min_senior() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(70, 0, false));
    }

    @Test
    @DisplayName("TC16: 65<x≤120, y>100 → Không hợp lệ")
    void tc16_invalid_qty_above_max_senior() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(70, 101, true));
    }

    @Test
    @DisplayName("TC17: x>120 → Không hợp lệ")
    void tc17_invalid_age_above_max() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(121, 5, false));
    }


    @Test
    @DisplayName("TC3: 1≤x<18, 1≤y<5, Cuối tuần → (50+20)×y")
    void tc3_young_small_qty_weekend() {
        assertEquals(210.0, MovieTicket.calculateTotal(10, 3, true), 0.001);
    }

    @Test
    @DisplayName("TC4: 1≤x<18, 5≤y≤10, Cuối tuần → (50+20)×y×0.95")
    void tc4_young_medium_qty_weekend() {
        assertEquals(465.5, MovieTicket.calculateTotal(10, 7, true), 0.001);
    }

    @Test
    @DisplayName("TC5: 1≤x<18, 10<y≤100, Cuối tuần → (50+20)×y×0.90")
    void tc5_young_large_qty_weekend() {
        assertEquals(1260.0, MovieTicket.calculateTotal(10, 20, true), 0.001);
    }


    @Test
    @DisplayName("TC8: 18≤x≤65, 1≤y<5, Cuối tuần → (60+20)×y")
    void tc8_adult_small_qty_weekend() {
        assertEquals(240.0, MovieTicket.calculateTotal(30, 3, true), 0.001);
    }

    @Test
    @DisplayName("TC9: 18≤x≤65, 5≤y≤10, Cuối tuần → (60+20)×y×0.95")
    void tc9_adult_medium_qty_weekend() {
        assertEquals(608.0, MovieTicket.calculateTotal(30, 8, true), 0.001);
    }

    @Test
    @DisplayName("TC10: 18≤x≤65, 10<y≤100, Cuối tuần → (60+20)×y×0.90")
    void tc10_adult_large_qty_weekend() {
        assertEquals(1080.0, MovieTicket.calculateTotal(30, 15, true), 0.001);
    }

    @Test
    @DisplayName("TC13: 65<x≤120, 1≤y<5, Cuối tuần → (40+20)×y")
    void tc13_senior_small_qty_weekend() {
        assertEquals(120.0, MovieTicket.calculateTotal(70, 2, true), 0.001);
    }

    @Test
    @DisplayName("TC14: 65<x≤120, 5≤y≤10, Cuối tuần → (40+20)×y×0.95")
    void tc14_senior_medium_qty_weekend() {
        assertEquals(342.0, MovieTicket.calculateTotal(70, 6, true), 0.001);
    }

    @Test
    @DisplayName("TC15: 65<x≤120, 10<y≤100, Cuối tuần → (40+20)×y×0.90")
    void tc15_senior_large_qty_weekend() {
        assertEquals(1620.0, MovieTicket.calculateTotal(70, 30, true), 0.001);
    }

    @Test
    @DisplayName("TC18: 1≤x<18, 1≤y<5, Trong tuần → 50k×y")
    void tc18_young_small_qty_weekday() {
        assertEquals(200.0, MovieTicket.calculateTotal(10, 4, false), 0.001);
    }

    @Test
    @DisplayName("TC19: 1≤x<18, 5≤y≤10, Trong tuần → 50k×y×0.95")
    void tc19_young_medium_qty_weekday() {
        assertEquals(237.5, MovieTicket.calculateTotal(10, 5, false), 0.001);
    }

    @Test
    @DisplayName("TC20: 1≤x<18, 10<y≤100, Trong tuần → 50k×y×0.90")
    void tc20_young_large_qty_weekday() {
        assertEquals(495.0, MovieTicket.calculateTotal(10, 11, false), 0.001);
    }

    @Test
    @DisplayName("TC21: 18≤x≤65, 1≤y<5, Trong tuần → 60k×y")
    void tc21_adult_small_qty_weekday() {
        assertEquals(120.0, MovieTicket.calculateTotal(40, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC22: 18≤x≤65, 5≤y≤10, Trong tuần → 60k×y×0.95")
    void tc22_adult_medium_qty_weekday() {
        assertEquals(570.0, MovieTicket.calculateTotal(40, 10, false), 0.001);
    }

    @Test
    @DisplayName("TC23: 18≤x≤65, 10<y≤100, Trong tuần → 60k×y×0.90")
    void tc23_adult_large_qty_weekday() {
        assertEquals(2700.0, MovieTicket.calculateTotal(40, 50, false), 0.001);
    }

    @Test
    @DisplayName("TC24: 65<x≤120, 1≤y<5, Trong tuần → 40k×y")
    void tc24_senior_small_qty_weekday() {
        assertEquals(120.0, MovieTicket.calculateTotal(80, 3, false), 0.001);
    }

    @Test
    @DisplayName("TC25: 65<x≤120, 5≤y≤10, Trong tuần → 40k×y×0.95")
    void tc25_senior_medium_qty_weekday() {
        assertEquals(342.0, MovieTicket.calculateTotal(80, 9, false), 0.001);
    }

    @Test
    @DisplayName("TC26: 65<x≤120, 10<y≤100, Trong tuần → 40k×y×0.90")
    void tc26_senior_large_qty_weekday() {
        assertEquals(3600.0, MovieTicket.calculateTotal(80, 100, false), 0.001);
    }
}