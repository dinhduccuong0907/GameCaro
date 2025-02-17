
package caro;

import java.util.Scanner;




public class Main {
	
	public static void main(String[] args) {
		System.out.println("--------------Chào mừng bạn đến với trò chơi cờ caro!------------------");
		Scanner scanner = new Scanner(System.in);
		String check;
		do {
			try {

				// khởi tạo đối tương bàn cờ boardCaro
				BoardCaro boardCaro = new BoardCaro();
				// Vẽ bàn cờ
				boardCaro.paintBoard();
				// Khởi tạo danh sách thế cờ
				ListChess listChess = new ListChess();
				// Đọc file theco.txt
				listChess.readFile();
				// Khởi tạo một danh sách listPoint
				ListPoint listPoint = new ListPoint();
				// Khởi tạo một người chơi player
				Player player = new Player(boardCaro, "Bạn", listPoint);
				// Khởi tạo đối tượng com cho máy
				Computer com = new Computer(boardCaro, "Máy", listChess);
				// Hiển thị bàn cờ
				boardCaro.displayBoard();
				do {
					// Người thực hiện đánh nước cờ của mình
					player.activePlayer();
					if (boardCaro.check_win) { // Kiểm tra check win cho người
						boardCaro.displayBoard(); // Hiển thị bàn cờ
						System.out.println(player.name + " thắng.");
						break;
					}
					// Máy đánh
					com.playCom();
					if (boardCaro.check_win) { // Kiểm tra check win cho máy
						boardCaro.displayBoard(); // Hiển thị bàn cờ
						System.out.println(com.name + " thắng.");
						break;
					}
					// Lấy điểm máy vừa đánh lưu vào danh sách listPoint của người chơi
					player.listPoint.listPoint.add(com.pointD);
					boardCaro.displayBoard(); // Hiển thị bàn cờ
				} while (!listPoint.checkFullBoard()); // vòng lặp dừng lại khi bàn cờ đã full

			} catch (Exception e) {
				System.out.println("Máy đã đầu hàng.");
			}
			do {
				System.out.println("Bạn có muốn chơi nữa không? y/n");
				check = scanner.nextLine(); // Nhập giá trị y/n từ bàn phím
			} while (!"y".equalsIgnoreCase(check) && !"n".equalsIgnoreCase(check));

		} while ("y".equalsIgnoreCase(check)); // Nếu là n thì dừng chương trình
		scanner.close(); // đóng scanner
	}
}
