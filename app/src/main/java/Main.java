import jp.ac.uryukyu.ie.e245737.*;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
        TicketManager manager = new TicketManager(0.3); // 初期予約率30%

        // 映画選択
        System.out.println("以下の映画から選択してください:");
        String[] movies = manager.getMovies();
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
        System.out.print("映画番号を入力: ");
        int movieChoice = scanner.nextInt();
        String selectedMovie = manager.selectMovie(movieChoice);
        System.out.println("選択された映画: " + selectedMovie);

        // 座席状況を表示
        System.out.println("\n現在の座席状況:");
        manager.displaySeats();

        // 座席選択
        boolean seatReserved = false;
        while(!seatReserved){
        System.out.print("\n座席の行番号を入力: ");
        int row = scanner.nextInt() - 1;
        System.out.print("座席の列番号を入力: ");
        int col = scanner.nextInt() - 1;
        seatReserved = manager.reserveSeat(row, col);
        if(seatReserved){
            System.out.println("座席が予約されました: (" + row + ", " + col + ")");
        } else {
            System.out.println("指定された座席は既に予約されています。");
        }
        
        }

        // 年齢入力と料金計算
        System.out.print("\n年齢を入力してください: ");
        int age = scanner.nextInt();
        int price = manager.calculatePrice(age);
        System.out.println("チケット料金: " + price + "円");

        // 最終座席状況を表示
        System.out.println("\n最終的な座席状況:");
        manager.displaySeats();
        }
    }
}
