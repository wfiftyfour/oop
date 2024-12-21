package hust.soict.dsai.aims.screen;

import java.security.Identity;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddBookController {

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfID;

    @FXML
    void OkPressed(ActionEvent event) {
      Book book =new Book();
      book.setTitle(tfTitle.getText());
      book.setCategory(tfCategory.getText());
      
      try {
          int id = Integer.parseInt(tfID.getText());

          if (id >= 0) {
              // Thực hiện các thao tác khi id hợp lệ
              book.setId(id);
          } else {
              // Nếu id âm, ném ra một ngoại lệ IllegalArgumentException và xử lý theo cách mong muốn
              throw new IllegalArgumentException("ID không thể là giá trị âm");
          }
      } catch (NumberFormatException e) {
          // Xử lý khi người dùng nhập không phải số
          System.err.println("Lỗi: ID phải là số nguyên");
          e.printStackTrace();  // In ra stack trace để theo dõi lỗi (có thể thay đổi tùy theo yêu cầu)
      }
  
    
      book.setCost(Float.parseFloat(tfCost.getText()));
      Aims.Mediastore.addMedia(book);
      JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	  JOptionPane.showMessageDialog(frame,
                "Update Store",
                book.getTitle()+ " Added to Store",
                JOptionPane.INFORMATION_MESSAGE);
   	  
	  new StoreScreen(Aims.Mediastore);
      StoreScreen.sc2.setVisible(false);
    }

    @FXML
    void e8e408(ActionEvent event) {

    }

}
