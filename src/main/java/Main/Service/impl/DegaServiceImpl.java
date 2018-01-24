/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service.impl;

import Main.BL.Dega;
import Main.Dao.DegaInterface;
import Main.Dao.KampanjaException;
import Main.Service.DegaService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("degaService")

public class DegaServiceImpl implements DegaService {
     @Autowired
    DegaInterface degaDao;

    @Override
    public void create(Dega dega) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Dega degas) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dega findDegaByName(String degaName) {
  
         return   degaDao.findDegaByDegaName(degaName); 
    }

    @Override
    public void remove(Dega degas) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeByUsername(String deganame) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetUserPassword(int id) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dega> findAll() {
       return degaDao.findAll();
    }

    @Override
    public Dega findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
