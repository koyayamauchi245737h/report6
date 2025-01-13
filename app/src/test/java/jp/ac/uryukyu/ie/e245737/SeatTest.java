package jp.ac.uryukyu.ie.e245737;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SeatTestクラス: Seatクラスのメソッドをテストするクラス.
 */
public class SeatTest {

    @Test
    public void testReserveSeat() {
        Seat seat = new Seat(0.0); // 初期状態では全座席が空いている

        // 有効な座席を予約
        assertTrue(seat.reserveSeat(2, 3), "(2, 3) の座席は予約可能であるべき");
        assertFalse(seat.reserveSeat(2, 3), "(2, 3) の座席は既に予約されているべき");

        // 無効な座席を予約
        assertFalse(seat.reserveSeat(-1, 3), "負の座席番号は予約できないべき");
        assertFalse(seat.reserveSeat(5, 5), "範囲外の座席番号は予約できないべき");
    }

    @Test
    public void testRandomizeSeats() {
        Seat seat = new Seat(0.5); // 初期状態で50%の確率で予約

        // 座席の予約率をチェック (少なくとも1つの座席が予約されているはず)
        boolean hasReservedSeats = false;
        boolean hasEmptySeats = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (seat.reserveSeat(i, j)) {
                    hasEmptySeats = true;
                } else {
                    hasReservedSeats = true;
                }
            }
        }

        assertTrue(hasReservedSeats, "少なくとも1つの座席が予約されているべき");
        assertTrue(hasEmptySeats, "少なくとも1つの座席が空いているべき");
    }
}

