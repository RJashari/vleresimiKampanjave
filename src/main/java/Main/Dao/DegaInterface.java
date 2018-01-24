/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Dao;

import Main.BL.Dega;
import java.util.List;

/**
 *
 * @author Rinor Jashari
 */
public interface DegaInterface {
    void create(Dega degas) throws KampanjaException;
    void edit (Dega degas) throws KampanjaException;
    void remove(Dega degas) throws KampanjaException;
    void removeByName(String deganame) throws KampanjaException;
    List<Dega> findAll();
    Dega findById(int id);
    Dega findDegaByDegaName(String deganame);
    void resetDegaPassword(int id) throws KampanjaException;
}
