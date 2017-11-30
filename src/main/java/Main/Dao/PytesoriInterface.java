package Main.Dao;





import Main.BL.Klienti;
import Main.BL.Pytesori;
import Main.Dao.KampanjaException;
import java.util.List;

public interface PytesoriInterface {
    
    void create(Pytesori pytesori) throws KampanjaException;
  }
