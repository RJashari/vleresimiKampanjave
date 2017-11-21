package Main.Dao;





import Main.BL.Klienti;
import Main.Dao.KampanjaException;
import java.util.List;

public interface KlientiInterface {
    
    void create(Klienti klienti) throws KampanjaException;
    void edit (Klienti klienti) throws KampanjaException;
    void remove(Klienti klienti) throws KampanjaException;
    List<Klienti> findAll() ;
    Klienti findById(long id);
}
