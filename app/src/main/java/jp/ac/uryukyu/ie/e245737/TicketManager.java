package jp.ac.uryukyu.ie.e245737;

/**
 * チケット管理クラス.
 * 映画選択、座席管理、料金計算などの機能を提供する.
 */
public class TicketManager {
    private final String[] movies = {"アクション映画", "コメディ映画", "ドラマ映画"};
    private final Seat seatManager;

    /**
     * コンストラクタ: 指定された予約率で座席を初期化する.
     * @param seatReservationRate 初期予約率 (例: 0.3 = 30%の座席を予約)
     */
    public TicketManager(double seatReservationRate) {
        this.seatManager = new Seat(seatReservationRate);
    }

    /**
     * 映画リストを取得する.
     * @return 映画の配列
     */
    public String[] getMovies() {
        return movies;
    }

    /**
     * 指定された映画を選択する.
     * @param choice 映画番号 (1から始まる)
     * @return 選択された映画の名前.無効な選択の場合はエラーメッセージ.
     */
    public String selectMovie(int choice) {
        if (choice >= 1 && choice <= movies.length) {
            return movies[choice - 1];
        }
        return "無効な選択です。";
    }


    /**
     * 座席状況を表示。
     */
    public void displaySeats() {
        seatManager.displaySeats();
    }


    /**
     * 指定された座席を予約。
     * @param row 行番号 (0始まり)
     * @param col 列番号 (0始まり)
     * @return 予約成功ならtrue、失敗ならfalse
     */
    public boolean reserveSeat(int row, int col) {
        return seatManager.reserveSeat(row, col);
    }


    /**
     * 年齢に基づいてチケット料金を計算。
     * @param age ユーザーの年齢
     * @return チケット料金 (学生: 1000円、大人: 1500円、シニア: 1200円)
     */
    public int calculatePrice(int age) {
        if (age <= 22) {
            return 1000;
        } else if (age <= 65) {
            return 1500;
        } else {
            return 1200;
        }
    }
}

