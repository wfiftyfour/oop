package hust.soict.dsai.garbage;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		FileReader input = null;
		long start = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		
		try {
			input = new FileReader("C:\\Users\\Admin\\Desktop\\OOP\\AimsProject\\src\\hust\\soict\\dsai\\garbage\\text.txt");
			
			int c;
			// Sử dụng vòng lặp để đọc từng ký tự và thêm vào outputStringBuilder.
			while((c = input.read()) != -1) {
				outputStringBuilder.append(c);
			}

			// In ra thời gian mất để đọc tệp tin.
			System.out.println(System.currentTimeMillis() - start);
		} finally {
			// Đảm bảo rằng tệp tin sẽ được đóng ngay cả khi có lỗi xảy ra hoặc không.
			if (input != null) {
				input.close();
			}
		}
		//System.out.println("String is: " + outputStringBuilder);
	}
}
