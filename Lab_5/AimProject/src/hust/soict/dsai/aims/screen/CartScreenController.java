package hust.soict.dsai.aims.screen;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private ObservableList<Media> x = FXCollections.observableArrayList();
	private ObservableList<Media> y = FXCollections.observableArrayList();

	private Float total;
	@FXML
	private Label lblTotal;
	@FXML
	private TextField tfFilter;
	private Cart cart;
	@FXML
	private Button btnPlay;
	@FXML
	private RadioButton rbtnFilterID;
	@FXML
	private RadioButton rbtnFilterTitle;
	@FXML
	private Button btnRemove;
	@FXML
	private ToggleGroup filter;

	@FXML
	private TableColumn<Media, String> colMediacategory;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}

	@FXML
	private void initialize() { // Khoi tao
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		setTotal();
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> arg0, Media arg1, Media arg2) {
				// TODO Auto-generated method stub
				if (arg2 != null)
					updateButtonBar(arg2);
			}

			private void updateButtonBar(Media arg2) {
				btnRemove.setVisible(true);
				if (arg2 instanceof Playable)
					btnPlay.setVisible(true);
				else
					btnPlay.setVisible(false);

			};

		});
		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				showFilteredMedia(arg2);

			}

			private void showFilteredMedia(String arg2) {
				if (arg2.length() == 0) {
					tblMedia.setItems(cart.getItemsOrdered());
					setTotal();

				} else {
					if (rbtnFilterID.isSelected()) {
						tblMedia.setItems(cart.searchID(Integer.parseInt(arg2)));
						setTotal();
					}

					if (rbtnFilterTitle.isSelected()) {
						tblMedia.setItems(cart.searchTitle(arg2));
						setTotal();

					}
				}
			}

		});

	}

	private void setTotal() { // tinh tong
		x = tblMedia.getItems();
		total = (float) 0;
		for (Media m : x)
			total = total + m.getCost();
		DecimalFormat df = new DecimalFormat("#.00");

		lblTotal.setText(df.format(total) + "$");
	}

	@FXML
	void btnRemovePressed(ActionEvent event)
// remove button
	{
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		setTotal();
	}

	@FXML
	void btnPlayPressed(ActionEvent event)
	// play button
	{
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof DigitalVideoDisc) {

			DigitalVideoDisc dvd = (DigitalVideoDisc) media;
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			if (dvd.getLength() > 0)
				JOptionPane.showMessageDialog(frame, "DVD length: " + dvd.getLength(), dvd.title + " is playing",
						JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame, "ERROR: DVD length is non-positive!", dvd.title + " ERROR",
						JOptionPane.ERROR_MESSAGE);
		} else {
			CompactDisc cd = (CompactDisc) media;
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			if (cd.getLength() > 0)
				JOptionPane.showMessageDialog(frame, "CD length: " + cd.getLength(), cd.title + " is playing",
						JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame, "ERROR: CD length is non-positive!", cd.title + " ERROR",
						JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void PlaceOrderPressed(ActionEvent event)
//PlaceOrder button
	{
		cart.itemsOrdered.clear();
		setTotal();
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		JOptionPane.showMessageDialog(frame, "Cart was Ordered", "Ordered Information",
				JOptionPane.INFORMATION_MESSAGE);

	}

	@FXML
	void AddBookPressed(ActionEvent event) {
		// Add Book
		StoreScreen.scCart.setVisible(false);
		StoreScreen.sc2 = new AddBookscreen();
		StoreScreen.sc2.setSize(934, 595);
	}

	@FXML
	void AddCDPressed(ActionEvent event) {
		// Add CD
		StoreScreen.scCart.setVisible(false);
		StoreScreen.sc1 = new AddCDscreen();
		StoreScreen.sc1.setSize(934, 595);

	}

	@FXML
	void AddDVDPressed(ActionEvent event) {
		// Add DVD
		StoreScreen.scCart.setVisible(false);
		StoreScreen.sc = new AddDVDscreen();
		StoreScreen.sc.setSize(934, 595);

	}

	@FXML
	void ViewStorePressed(ActionEvent event) {
		new StoreScreen(Aims.Mediastore);
		StoreScreen.scCart.setVisible(false);

	}

}
