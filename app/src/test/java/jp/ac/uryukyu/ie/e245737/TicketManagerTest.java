package jp.ac.uryukyu.ie.e245737;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TicketManagerTestクラス: TicketManagerクラスのメソッドをテストするクラス.
 */
public class TicketManagerTest {

    @Test
    public void testSelectMovie() {
        TicketManager manager = new TicketManager(0.0);

        // 有効な映画選択
        assertEquals("アクション映画", manager.selectMovie(1), "1番目の映画はアクション映画であるべき");
        assertEquals("コメディ映画", manager.selectMovie(2), "2番目の映画はコメディ映画であるべき");
        assertEquals("ドラマ映画", manager.selectMovie(3), "3番目の映画はドラマ映画であるべき");

        // 無効な映画選択
        assertEquals("無効な選択です。", manager.selectMovie(0), "0番目の選択は無効であるべき");
        assertEquals("無効な選択です。", manager.selectMovie(4), "4番目の選択は無効であるべき");
    }

    @Test
    public void testCalculatePrice() {
        TicketManager manager = new TicketManager(0.0);

        // 年齢による料金計算
        assertEquals(1000, manager.calculatePrice(18), "18歳の料金は1000円であるべき (学生)");
        assertEquals(1500, manager.calculatePrice(30), "30歳の料金は1500円であるべき (大人)");
        assertEquals(1200, manager.calculatePrice(70), "70歳の料金は1200円であるべき (シニア)");
    }

    
}
