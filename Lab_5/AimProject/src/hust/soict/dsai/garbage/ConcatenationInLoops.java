package hust.soict.dsai.garbage;
import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		// Sử dụng phép nối chuỗi thông thường (String)

		// Một đối tượng Random được tạo với seed là 123.
		Random r = new Random(123);

		// Một biến start được sử dụng để lưu thời điểm bắt đầu đo thời gian
		long start = System.currentTimeMillis();

		// Một chuỗi rỗng s được khởi tạo.
		String s = "";

		// Một vòng lặp được thực hiện 65536 lần, và trong mỗi lần lặp, một số nguyên
		// ngẫu nhiên nằm trong khoảng từ 0 (bao gồm) đến 2 (ngoại trừ) được tạo ra bằng
		// cách sử dụng r.nextInt(2). Điều này thực tế tạo ra các chữ số nhị phân ngẫu
		// nhiên (0 hoặc 1), và mỗi chữ số được thêm vào chuỗi s. Vòng lặp này tạo ra
		// một chuỗi nhị phân có độ dài 65536.
		for (int i = 0; i < 65536; i++) {
			s += r.nextInt(2);
		}

		// thời gian hiện tại tính bằng mili giây được lấy lại, và hiệu giữa thời gian
		// hiện tại (System.currentTimeMillis()) và thời điểm bắt đầu (start) được tính.
		// Điều này cho ta tổng thời gian mất để tạo ra chuỗi nhị phân ngẫu nhiên.
		System.out.println(System.currentTimeMillis() - start);

		// Sử dụng StringBuilder

		// Đối tượng Random được khởi tạo lại với cùng một seed để đảm bảo cùng một
		// chuỗi ngẫu nhiên.
		r = new Random(123);

		// Biến start được cập nhật để đo thời gian bắt đầu của phương pháp thứ hai.
		start = System.currentTimeMillis();

		// Một đối tượng StringBuilder được khởi tạo để xây dựng chuỗi.
		StringBuilder sb = new StringBuilder();

		// Một vòng lặp tương tự như phía trên để thêm các chữ số nhị phân vào
		// StringBuilder bằng cách sử dụng append
		for (int i = 0; i < 65536; i++) {
			sb.append(r.nextInt(2));
		}

		// Sau đó, chuỗi cuối cùng được lấy ra từ StringBuilder bằng cách sử dụng
		// toString.
		s = sb.toString();

		// Thời gian mất để tạo chuỗi này cũng được in ra màn hình.
		System.out.println(System.currentTimeMillis() - start);

		// In chuỗi ra màn hình
		//System.out.println(s);
	}
}
