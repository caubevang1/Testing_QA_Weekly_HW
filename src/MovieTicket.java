public class MovieTicket {

    /**
     * Tính tổng tiền mua vé.
     *
     * @param age       tuổi khách hàng
     * @param qty       số vé mua
     * @param isWeekend true = cuối tuần, false = trong tuần
     * @return tổng tiền (nghìn VNĐ)
     * @throws IllegalArgumentException nếu tuổi hoặc số lượng vé nằm ngoài miền hợp lệ
     */
    public static double calculateTotal(int age, int qty, boolean isWeekend) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Tuổi không hợp lệ: " + age);
        }
        if (qty < 1 || qty > 100) {
            throw new IllegalArgumentException("Số vé không hợp lệ: " + qty);
        }

        // Bước 1: Xác định giá vé cơ bản theo tuổi (nghìn VNĐ)
        double basePrice;
        if (age < 18) {
            basePrice = 50.0;
        } else if (age <= 65) {
            basePrice = 60.0;
        } else {
            basePrice = 40.0;
        }

        // Bước 2: Cộng thêm 20k nếu cuối tuần
        if (isWeekend) {
            basePrice += 20.0;
        }

        // Bước 3: Tính tổng tiền trước chiết khấu
        double total = basePrice * qty;

        // Bước 4: Áp dụng chiết khấu theo số lượng vé
        if (qty >= 5 && qty <= 10) {
            total = total * 0.95;   // giảm 5%
        } else if (qty > 10) {
            total = total * 0.90;   // giảm 10%
        }
        return total;
    }
}