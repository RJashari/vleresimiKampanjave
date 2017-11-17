/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import BL.Klienti;
import Dao.KampanjaException;
import Dao.KlientiInterface;
import Service.KlientiService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("klientiService")
public class KlientiServiceImpl implements KlientiService {
    
    @Autowired
    KlientiInterface klientiDao;

    @Override
    public void create(Klienti klienti) {
         try {
            klientiDao.create(klienti);
        } catch (KampanjaException ex) {
            Logger.getLogger(KlientiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Klienti klienti) {
        try {
            klientiDao.edit(klienti);
        } catch (KampanjaException ex) {
            Logger.getLogger(KlientiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Klienti klienti) {
        try {
            klientiDao.remove(klienti);
        } catch (KampanjaException ex) {
            Logger.getLogger(KlientiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Klienti> findAll() {
      return klientiDao.findAll();
    }

    @Override
    public Klienti findById(long id)  {
        return klientiDao.findById(id);
    }

}
