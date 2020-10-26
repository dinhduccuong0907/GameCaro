
package caro;


public class Chess {
	// Khởi tạo ma trận 5 * 5
	public String chess[][] = new String[5][5];

	
	public Chess addChess(String str) {
		// Khởi tạo 1 biến tạm thời ch
		Chess ch = new Chess();
		// tách chuỗi
		String[] arr = str.split("");
		// Khởi tạo biến đếm temp
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ch.chess[i][j] = arr[temp]; // gán mỗi phần tử của thế cờ bằng 1 phần tử của mảng arr
				temp++; // tăng biến đem temp thêm 1
			}
		}
		return ch; // Trả về 1 thế cờ
	}
}
