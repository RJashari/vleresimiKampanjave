/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;

import Main.BL.Kampanja;
import Main.Dao.KampanjaException;
import java.util.List;

/**
 *
 * @author Rinor Jashari
 */
public interface KampanjaService {
    void create(Kampanja kampanja) throws KampanjaException;
    void edit (Kampanja kampanja) throws KampanjaException;
    void remove(Kampanja kampanja) throws KampanjaException;
    List<Kampanja> findAll();
    Kampanja findById(long id);
    Kampanja findKampanjaByName(String name);
   
}

