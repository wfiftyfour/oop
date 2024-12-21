package hust.soict.dsai.aims;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.cart;

public class Aims {
    public static void main(String[] args) throws Exception {
        cart anOrdered = new cart();

        DigitalVideoDisc DVD1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87 , 19.95f);
        //anOrdered.addDigitalVideoDisc(DVD1);
        //System.out.println("ID: " + DVD1.getId());
        DigitalVideoDisc DVD2 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas", 87, 24.95f);
        //anOrdered.addDigitalVideoDisc(DVD2);
        //System.out.println("ID: " + DVD2.getId());
        DigitalVideoDisc DVD3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        //anOrdered.addDigitalVideoDisc(DVD3);
        //System.out.println("ID: " + DVD3.getId());
        //anOrdered.addDigitalVideoDisc(DVD2);
        //System.out.println(anOrdered.getQtyOrdered());
        //System.out.println("Total Cost is: " + Math.round(anOrdered.calculateTotalCost()*100.0)/100.0);
        //DigitalVideoDisc[] dvdList = new DigitalVideoDisc[20];
        DigitalVideoDisc dvdList[] = {DVD1,DVD2,DVD3};
        anOrdered.addDigitalVideoDisc(dvdList);
        anOrdered.addDigitalVideoDisc(DVD2, DVD3);
        anOrdered.printListItems();
        anOrdered.searchForDVDByID();
        anOrdered.searchForDVDByTitle();
        System.exit(0); 
    }
}
