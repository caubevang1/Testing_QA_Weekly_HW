import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Phần 2 – Kiểm thử giá trị biên
 * 26 ca kiểm thử, áp dụng giả thiết khiếm khuyết đơn
 * Đơn vị kết quả: nghìn VNĐ
 */
@DisplayName("Kiểm thử giá trị biên")
class BoundaryValueTest {

    // --- Thay đôỉ x (tuổi), cố định y = 50 (nom), z = Cuối tuần ---

    @Test
    @DisplayName("TC-BV-01: x=0 (min_x-), y=50, z=T → Lỗi input")
    void tc_bv_01() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(0, 50, true));
    }

    @Test
    @DisplayName("TC-BV-02: x=1 (min_x), y=50, z=T → 3150k")
    void tc_bv_02() {
        assertEquals(3150.0, MovieTicket.calculateTotal(1, 50, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-03: x=2 (min_x+), y=50, z=T → 3150k")
    void tc_bv_03() {
        assertEquals(3150.0, MovieTicket.calculateTotal(2, 50, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-04: x=60 (nom_x), y=50, z=T → 3600k")
    void tc_bv_04() {
        assertEquals(3600.0, MovieTicket.calculateTotal(60, 50, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-05: x=119 (max_x-), y=50, z=T → 2700k")
    void tc_bv_05() {
        assertEquals(2700.0, MovieTicket.calculateTotal(119, 50, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-06: x=120 (max_x), y=50, z=T → 2700k")
    void tc_bv_06() {
        assertEquals(2700.0, MovieTicket.calculateTotal(120, 50, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-07: x=121 (max_x+), y=50, z=T → Lỗi input")
    void tc_bv_07() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(121, 50, true));
    }

    // --- Thay đổi y (số vé), cố định x = 60 (nom), z = Cuối tuần ---

    @Test
    @DisplayName("TC-BV-08: x=60, y=0 (min_y-), z=T → Lỗi input")
    void tc_bv_08() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(60, 0, true));
    }

    @Test
    @DisplayName("TC-BV-09: x=60, y=1 (min_y), z=T → 80k")
    void tc_bv_09() {
        assertEquals(80.0, MovieTicket.calculateTotal(60, 1, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-10: x=60, y=2 (min_y+), z=T → 160k")
    void tc_bv_10() {
        assertEquals(160.0, MovieTicket.calculateTotal(60, 2, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-11: x=60, y=99 (max_y-), z=T → 7128k")
    void tc_bv_11() {
        assertEquals(7128.0, MovieTicket.calculateTotal(60, 99, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-12: x=60, y=100 (max_y), z=T → 7200k")
    void tc_bv_12() {
        assertEquals(7200.0, MovieTicket.calculateTotal(60, 100, true), 0.001);
    }

    @Test
    @DisplayName("TC-BV-13: x=60, y=101 (max_y+), z=T → Lỗi input")
    void tc_bv_13() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(60, 101, true));
    }

    // --- Thay đổi x (tuổi), cố định y = 50 (nom), z = Trong tuần ---

    @Test
    @DisplayName("TC-BV-14: x=0 (min_x-), y=50, z=F → Lỗi input")
    void tc_bv_14() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(0, 50, false));
    }

    @Test
    @DisplayName("TC-BV-15: x=1 (min_x), y=50, z=F → 2250k")
    void tc_bv_15() {
        assertEquals(2250.0, MovieTicket.calculateTotal(1, 50, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-16: x=2 (min_x+), y=50, z=F → 2250k")
    void tc_bv_16() {
        assertEquals(2250.0, MovieTicket.calculateTotal(2, 50, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-17: x=60 (nom_x), y=50, z=F → 2700k")
    void tc_bv_17() {
        assertEquals(2700.0, MovieTicket.calculateTotal(60, 50, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-18: x=119 (max_x-), y=50, z=F → 1800k")
    void tc_bv_18() {
        assertEquals(1800.0, MovieTicket.calculateTotal(119, 50, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-19: x=120 (max_x), y=50, z=F → 1800k")
    void tc_bv_19() {
        assertEquals(1800.0, MovieTicket.calculateTotal(120, 50, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-20: x=121 (max_x+), y=50, z=F → Lỗi input")
    void tc_bv_20() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(121, 50, false));
    }

    // --- Thay đổi y (số vé), cố định x = 60 (nom), z = Trong tuần ---

    @Test
    @DisplayName("TC-BV-21: x=60, y=0 (min_y-), z=F → Lỗi input")
    void tc_bv_21() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(60, 0, false));
    }

    @Test
    @DisplayName("TC-BV-22: x=60, y=1 (min_y), z=F → 60k")
    void tc_bv_22() {
        assertEquals(60.0, MovieTicket.calculateTotal(60, 1, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-23: x=60, y=2 (min_y+), z=F → 120k")
    void tc_bv_23() {
        assertEquals(120.0, MovieTicket.calculateTotal(60, 2, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-24: x=60, y=99 (max_y-), z=F → 5346k")
    void tc_bv_24() {
        assertEquals(5346.0, MovieTicket.calculateTotal(60, 99, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-25: x=60, y=100 (max_y), z=F → 5400k")
    void tc_bv_25() {
        assertEquals(5400.0, MovieTicket.calculateTotal(60, 100, false), 0.001);
    }

    @Test
    @DisplayName("TC-BV-26: x=60, y=101 (max_y+), z=F → Lỗi input")
    void tc_bv_26() {
        assertThrows(IllegalArgumentException.class,
                () -> MovieTicket.calculateTotal(60, 101, false));
    }
}