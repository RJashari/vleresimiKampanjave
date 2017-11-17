/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BL.Pytesori;
import Dao.KampanjaException;
import java.util.List;

/**
 *
 * @author rinor.jashari
 */
public interface PytesoriService {
    
    void create(Pytesori pytesori) throws KampanjaException;
    void edit (Pytesori pytesori) throws KampanjaException;
    void remove(Pytesori pytesori) throws KampanjaException;
    List<Pytesori> findAll();
    Pytesori findById(long id);
    
}
