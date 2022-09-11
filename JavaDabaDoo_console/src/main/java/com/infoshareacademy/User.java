import java.util.ArrayList;
import java.util.List;

public class User {
    public int UserId;
    public String firstName;
    public String lastName;
    private ArrayList<String> borrowlist;

    public String getFullName() {
        return firstName + lastName;
    }
    public ArrayList<String> getBorrowlistlist(){
        return borrowlist;
    }
    List<String> lista;

    {
        lista = new ArrayList<String>();
    }
 		lista.add("ksiazka");
}
