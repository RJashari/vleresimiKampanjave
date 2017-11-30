/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;
 
import Main.BL.Pytesori;
import Main.Dao.KampanjaException;
import java.util.List;

/**
 *
 * @author rinor.jashari
 */
public interface PytesoriService {
 
  void create(Pytesori pytesori);
    void edit (Pytesori pytesori);
    void remove(Pytesori pytesori);
    List<Pytesori> findAll();
    Pytesori findById(long id);
}
