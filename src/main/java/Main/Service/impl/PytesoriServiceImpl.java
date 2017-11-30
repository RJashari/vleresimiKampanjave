/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service.impl;

import Main.BL.Klienti;
import Main.BL.Pytesori;
import Main.Dao.KampanjaException;
import Main.Dao.KlientiInterface;
import Main.Dao.PytesoriInterface;
import Main.Service.KlientiService;
import Main.Service.PytesoriService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pytesoriService")
public class PytesoriServiceImpl implements PytesoriInterface, PytesoriService {
    
    @Autowired
    PytesoriInterface pytesoriDao;

    @Override
    public void create(Pytesori pytesori) {
         try {
            pytesoriDao.create(pytesori);
        } catch (KampanjaException ex) {
            Logger.getLogger(PytesoriServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Pytesori pytesori) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Pytesori pytesori) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pytesori> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pytesori findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
