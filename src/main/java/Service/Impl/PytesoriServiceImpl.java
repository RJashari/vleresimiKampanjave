/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import BL.Pytesori;
import BL.Pytesori;
import Dao.KampanjaException;
import Dao.PytesoriInterface;
import Service.PytesoriService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pytesoriService")
public class PytesoriServiceImpl implements PytesoriService {

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
        try {
            pytesoriDao.edit(pytesori);
        } catch (KampanjaException ex) {
            Logger.getLogger(PytesoriServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Pytesori pytesori) {
        try {
            pytesoriDao.remove(pytesori);
        } catch (KampanjaException ex) {
            Logger.getLogger(PytesoriServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pytesori> findAll() {
      return pytesoriDao.findAll();
    }

    @Override
    public Pytesori findById(long id)  {
        return pytesoriDao.findById(id);
    }
    
}
