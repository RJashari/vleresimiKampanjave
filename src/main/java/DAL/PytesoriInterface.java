package DAL;





import BL.Pytesori;
import DAL.KampanjaException;
import java.util.List;

public interface PytesoriInterface {
    
    void create(Pytesori pytesori) throws KampanjaException;
    void edit (Pytesori pytesori) throws KampanjaException;
    void remove(Pytesori pytesori) throws KampanjaException;
    List<Pytesori> findAll();
    Pytesori findById(long id) throws KampanjaException;
}
