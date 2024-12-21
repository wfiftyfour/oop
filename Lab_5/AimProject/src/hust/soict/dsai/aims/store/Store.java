package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBER_ITEMS = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBER_ITEMS];
    private int qtyItems = 0; // so luong item trong cua hang

    public boolean addDVD(DigitalVideoDisc disc) {
        if (qtyItems >= MAX_NUMBER_ITEMS) {
            // Neu so luong trong Store full thi ko the them
            System.out
                    .println("ERROR: Adding DVDs to the store failed because the number of DVDs in the store was full");
            return false;
        }

        // Neu disc dc them trung voi DVD trong Store thi that bai
        for (int i = 0; i < qtyItems; i++) {
            if (disc == itemsInStore[i]) {
                System.out.println(
                        "ERROR: The DVD cannot be added because it matches a DVD already available in the store.");
                return false;
            }
        }

        // Neu disc ko trung thì them disc vao trong Store
        itemsInStore[qtyItems] = disc;
        qtyItems++;
        return true;
    }
    //hàm xoá 1 phần tử DVD trong store
    public void removeDVD(DigitalVideoDisc disc) {
        if (qtyItems == 0) {
            System.out.println("ERROR: The cart is null");
        } else {
            for (int i = 0; i < qtyItems; i++) {
                if (this.itemsInStore[i] == disc) {
                    this.itemsInStore[i] = this.itemsInStore[qtyItems - 1];
                    this.itemsInStore[qtyItems - 1] = null;
                    qtyItems--;
                }
            }
            System.out.println("The disc has been deleted from store");
        }
    }

    public int getQtyItems() {
        return qtyItems;
    }
}
