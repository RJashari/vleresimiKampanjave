package Main.Dao;





import Main.BL.Pytesori;
import java.util.List;
public interface PytesoriInterface {
    
    void create(Pytesori pytesori) throws KampanjaException;
    void edit (Pytesori pytesori) throws KampanjaException;
    void remove(Pytesori pytesori) throws KampanjaException;
    List<Pytesori> findAll();
    Pytesori findById(long id);
}