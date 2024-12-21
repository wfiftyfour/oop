package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        // Tạo các đối tượng DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Thử nghiệm phương thức swap
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap:");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thử nghiệm phương thức changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle:");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(title);
    }
}
