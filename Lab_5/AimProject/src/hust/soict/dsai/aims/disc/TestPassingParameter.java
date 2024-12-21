package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
   public static void main(String[] args) {
	 DigitalVideoDisc jungleDVD= new DigitalVideoDisc("Jungle");
	 DigitalVideoDisc cinderellaDVD= new DigitalVideoDisc("Cinderella");
	 swap(jungleDVD,cinderellaDVD);
	 //hoanDoi(jungleDVD,cinderellaDVD);
	 System.out.println("jungle dvd title: "+jungleDVD.getTitle());
	 System.out.println("cinderella dvd title: "+cinderellaDVD.getTitle());
     
	 changeTitle(jungleDVD,cinderellaDVD.getTitle());
	 System.out.println("jungle dvd title: "+jungleDVD.getTitle());
   }
   public static void swap(Object o1,Object o2)
   {
	   Object tmp=o1;
	   o1=o2;
	   o2=tmp;
	   
   }
   public static void changeTitle(DigitalVideoDisc dvd,String title)
   {
	   String oldTitle=dvd.getTitle();
	   dvd.setTitle(title);
	   dvd= new DigitalVideoDisc(oldTitle);
   }
   //Phuong thuc hoan doi 2 doi tuong chinh xac
   public static void hoanDoi(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
   {
	   String title1=dvd1.getTitle();
	   String title2=dvd2.getTitle();
	   dvd1.setTitle(title2);
	   dvd2.setTitle(title1);
   }
   
}
