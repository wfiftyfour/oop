package hust.soict.dsai.garbage;

import java.io.*;

public class GarbageCreator {
	public static void main(String[] args) throws IOException {
		FileReader input = null;

		// start để lưu thời điểm bắt đầu thực hiện chương trình (đo thời gian).
		long start = System.currentTimeMillis();

		// Chuỗi để lưu nội dung của tệp tin văn bản.
		String outputString = "";
		try {
			// Mở tệp tin text.txt
			input = new FileReader(
					"C:\\Users\\Admin\\Desktop\\OOP\\AimsProject\\src\\hust\\soict\\dsai\\garbage\\text.txt");

			// Sử dụng vòng lặp để đọc từng ký tự và thêm vào chuỗi outputString.
			int c;
			while ((c = input.read()) != -1) {
				outputString += c;
			}

			// In ra thời gian mất để đọc tệp tin
			System.out.println(System.currentTimeMillis() - start);
		} finally {
			// Đảm bảo rằng tệp tin sẽ được đóng ngay cả khi có lỗi xảy ra hoặc không.
			if (input != null) {
				input.close();
			}
		}

		// In ra nội dung của chuỗi sau khi đọc từ tệp tin
		// System.out.println("String is: " + outputString);
	}
}
