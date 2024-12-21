package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	public CartScreen(Cart cart)
	{   super();
	
		this.cart=cart;
		
		JFXPanel fxPanel = new JFXPanel();
		
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			public void run()
			{
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
					CartScreenController controller =
							  new CartScreenController(cart);
					loader.setController(controller);
					Parent root= loader.load();
					fxPanel.setScene(new Scene(root));
					
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
    public static void main(String[] args) {
        // Tạo dữ liệu mẫu cho Cart
        Cart cart = new Cart();

        // Thêm một số DVD vào giỏ hàng làm ví dụ
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Media dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // Chạy chương trình
        Platform.startup(() -> {
            new CartScreen(cart);
        });
    }
}
