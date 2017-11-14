/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BL.Klienti;
import java.util.Set;

/**
 *
 * @author rinor.jashari
 */
public interface KlientiDao {
    
    void save(Klienti klienti);
    void removeById(long id);
    Set <Klienti> getAllKlientet();
    
    
    
}
