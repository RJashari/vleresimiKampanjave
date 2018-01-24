/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;


import Main.BL.Dega;
import Main.Dao.KampanjaException;
import java.util.List;


/**
 *
 * @author rinor.jashari
 */
public interface DegaService {
    
    void create(Dega dega) throws KampanjaException;
    void edit (Dega degas) throws KampanjaException;
    Dega findDegaByName(String degaName);
    void remove(Dega degas) throws KampanjaException;
    void removeByUsername(String deganame) throws KampanjaException; 
    void resetUserPassword(int id) throws KampanjaException;
    List<Dega> findAll();
    Dega findById(int id);
}
