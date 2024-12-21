package hust.soict.dsai.garbage;
import java.io.*;

public class CreateFileDemo {
	public static void main(String[] args) {
		try {
			// Tạo một đối tượng File đại diện cho đường dẫn và tên của tệp tin muốn tạo.
			File file = new File(
					"C:\\Users\\Admin\\Desktop\\OOP\\AimsProject\\src\\hust\\soict\\dsai\\garbage\\text.txt");

			// Tạo một tệp tin mới
			boolean fvar = file.createNewFile();

			// Nếu tệp tin đã được tạo mới thành công, in ra thông báo "File has been
			// created successfully", ngược lại, in ra "File already present at the
			// specified location"
			if (fvar) {
				System.out.println("File has been created successfully");
			} else {
				System.out.println("File already present at the specified location");
			}

			// In ra thông báo "Exception Occurred:" và hiển thị thông tin chi tiết về ngoại lệ
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}
	}
}
