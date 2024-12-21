package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;
import java.util.Scanner;

public class cart {

    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0; // số đơn đã đặt hàng

    // Them DVD Vao gio hang
    public boolean addDigitalVideoDisc(DigitalVideoDisc addDVD) {
        // Nêu sô đơn đã đặt hàng >= 20 thì ko thể đặt thêm
        if (qtyOrdered >= MAX_NUMBER_ORDERED) {
            System.out.println("add DVD fail because cart full");
            return false;
        }
        // Duyệt toàn bộ số đơn đã đặt hàng, nếu tìm thấy đơn nào trùng với đơn cần thêm
        // thì thông báo ko thể thêm do DVD đã có trong giỏ hàng
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == addDVD) {
                System.out.println("Add DVD " + addDVD.getTitle() + " fail because DVD's existed");
                return false;
            }
        }
        // Nếu ko trong 2 trường hợp trên thì có thể thêm DVD vào giỏ hàng
        itemsOrdered[qtyOrdered] = addDVD;
        qtyOrdered++;
        System.out.println("Add DVD " + addDVD.getTitle() + " success");
        return true;

    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered >= 20) {
            System.out.println("Fail because cart full");
            return false;
        }

        for (int i = 0; i < dvdList.length; i++) {
            boolean check = true; // kiem tra xem DVD can them vao co the them duoc ko
            // xet xem addDVD co trung voi DVD nao trong don hang da dat ko
            // neu DVD can them trung thi se ko them
            for (int j = 0; j < qtyOrdered; j++) {
                if (itemsOrdered[j] == dvdList[i]) {
                    System.out.println("Add DVD " + dvdList[i].getTitle() + " fail because DVD's existed");
                    check = false;// neu DVD trung thi ko the them
                    break;
                }
            }
            // neu check = true thi co the them
            if (check == true) {
                this.itemsOrdered[qtyOrdered] = dvdList[i];
                System.out.println("Add DVD " + dvdList[i].getTitle() + "  success");
                qtyOrdered++;
            }

            if (qtyOrdered == MAX_NUMBER_ORDERED) {

                for (int t = i + 1; t < dvdList.length; t++) {
                    System.out.println("Add DVD " + dvdList[t].getTitle() + " faise because Cart full");
                }
                return false;
            }

        }
        return true;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (MAX_NUMBER_ORDERED - this.qtyOrdered < 2) {
            System.out.println("The cart is full");
        } else if (this.qtyOrdered == MAX_NUMBER_ORDERED - 2) {
            System.out.println("The cart is almost full");
            this.itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered += 1;
            System.out.println("The disc have been added");
            System.out.println("Current disc: " + qtyOrdered);

            this.itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered += 1;
            System.out.println("The disc have been added");
            System.out.println("Current disc: " + qtyOrdered);
        } else {
            this.itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered += 1;
            System.out.println("The disc have been added");
            System.out.println("Current disc: " + qtyOrdered);

            this.itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered += 1;
            System.out.println("The disc have been added");
            System.out.println("Current disc: " + qtyOrdered);
        }
    }

    // Xoá DVD khỏi giỏ hàng
    public boolean removeDigitalVideoDisc(DigitalVideoDisc removeDVD) {
        // Nếu số đơn đặt hàng = 0 thì ko thể xoá
        if (qtyOrdered == 0) {
            System.out.println("Fail by Disc empty");
            return false;
        } else {
            // Duyệt tất cả các đơn đã đặt hàng, để tìm đơn trùng với đơn cần xoá
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i] == removeDVD) {
                    for (int j = i; j < qtyOrdered - 1; j++) {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    System.out.println("Delete DVD success");
                    qtyOrdered--;
                    return true;
                }
            }
            return false;
        }
    }

    // hàm print ra số đơn hiện tại trong giỏ hàng
    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    // Tính toán tổng số tiền
    public double calculateTotalCost() {
        double sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void printListItems() {
        System.out.println("******************************CART******************************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total Cost: " + Math.round(calculateTotalCost() * 100.0) / 100.0);
        System.out.println("****************************************************************");
    }

    public void searchForDVDByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for DVD by ID!");
        System.out.print("ID = ");
        int ID1 = scanner.nextInt();
        // Kiem tra xem co tim thay don hang co ID can tim ko
        boolean check = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == ID1) {
                System.out.println("=> " + itemsOrdered[i].toString());
                check = true; // Tìm thấy ID cần tìm thì check -> true
                break;
            }
        }
        if (check == false) {
            System.out.println("No match is found");
        }
        scanner.close();
    }
    
    public void searchForDVDByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for DVD by title!");
        System.out.print("Title: ");
        String TitleSeach = scanner.nextLine();
        // Kiem tra xem co tim thay don hang co titlw can tim ko
        boolean check = false;
        for (int i = 0; i < qtyOrdered; i++) {
            //so sanh 2 string
            if (TitleSeach.equals(itemsOrdered[i].getTitle())) {
                System.out.println("=> " + itemsOrdered[i].toString());
                check = true; // Tìm thấy ID cần tìm thì check -> true
                break;
            }
        }
        if (check == false) {
            System.out.println("No match is found");
        }
        scanner.close();
    }
}