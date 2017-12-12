/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;

import Main.BL.Klienti;
import Main.Dao.KampanjaException;
import java.util.List;

/**
 *
 * @author rinor.jashari
 */
public interface KlientiService {
 
    void create(Klienti klienti) throws KampanjaException;
    void edit (Klienti klienti) throws KampanjaException;
    void remove(Klienti klienti) throws KampanjaException;
    List<Klienti> findAll();
    Klienti findById(long id);
}
