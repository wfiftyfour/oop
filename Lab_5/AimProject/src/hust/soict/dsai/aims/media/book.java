package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class book extends media {
    private List<String> authous = new ArrayList<String>();

    // CONSTRUCTORS
    public book() {
        super();
    }

    public book(String title) {
        super(title);
        
    }

    public book(String title, float cost) {
         super(title,cost);
    }

    public book(String title, String category, float cost) {
        super(title, category, cost);
    }

   
    // METHOD
    public boolean addAuthor(String author) {
        // Kiem tra xem author co ton tai trong List hay khong
        for (String s : authous) {
            if (s == author) {
                System.out.println("Those authors existed");
                return false;
            }
        }
        // Neu khong ton tai thi add vao list
        System.out.println();
        this.authous.add(author);
        return true;
    }

    public boolean removeAuthor(String author) {
        for (String s : authous) {
            if (s == author) {
                this.authous.remove(author);
                System.out.println();
                return true;
            }
        }
        System.out.println("This author is not in the list");
        return false;
    }
}
