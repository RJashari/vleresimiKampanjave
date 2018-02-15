/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Dao;

import Main.BL.Kampanja;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Rinor Jashari
 */

public interface KampanjaInterface {
    void create(Kampanja kampanja) throws KampanjaException;
    void edit (Kampanja kampanja) throws KampanjaException;
    void remove(Kampanja kampanja) throws KampanjaException;
    List<Kampanja> findAll();
    Kampanja findById(long id);
    Kampanja findKampanjaByName(String name);
   
}
