package jp.ac.uryukyu.ie.e245737;

import java.util.Random;

/**
 * 座席管理クラス.
 * 5x5の座席を管理し、予約状況の操作を提供する.
 */

public class Seat {
    private final boolean[][] seats = new boolean[5][5]; // 5行×5列の座席

    /**
     * コンストラクタ: ランダムに予約された座席状況を初期化する.
     * @param percentage 初期予約率 (例: 0.3 = 30%)
     */
    public Seat(double percentage) {
        randomizeSeats(percentage);
    }

    /**
     * 座席状況を表示する.
     */
    public void displaySeats() {
        System.out.println("座席状況:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "[X]" : "[ ]");
            }
            System.out.println();
        }
    }

    /**
     * 指定した座席を予約する.
     * @param row 行番号 (0始まり)
     * @param col 列番号 (0始まり)
     * @return 予約成功ならtrue、失敗ならfalse
     */
    public boolean reserveSeat(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println("無効な座席選択です。");
            return false;
        }
        if (seats[row][col]) {
            System.out.println("既に予約されています。");
            return false; // 既に予約済み
        }
        seats[row][col] = true;
        return true;
    }

    /**
     * ランダムに座席を予約する (内部で使用).
     * @param percentage 予約率 (例: 0.2 = 20%)
     */
    private void randomizeSeats(double percentage) {
        Random random = new Random();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = random.nextDouble() < percentage;
            }
        }
    }
}
