/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service.impl;

import Main.BL.Klienti;
import Main.BL.Pytesori;
import Main.Dao.KampanjaException;
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

    @Override
    public int countPytja1TV() {
      
        int countPytja1TV = pytesoriDao.countPytja1TV();
        System.out.println("--------------- numro pytjatv: "+countPytja1TV);
        return countPytja1TV;
       
    }

    @Override
    public int countPytja1Radio() {
        int countPytja1Radio = pytesoriDao.countPytja1Radio();
        System.out.println("--------------- numro PytjaRadio: "+countPytja1Radio);
        return countPytja1Radio;
    }

    @Override
    public int countPytja1RrjeteSociale() {
       int countPytja1Radio = pytesoriDao.countPytja1Radio();
        System.out.println("--------------- Pytja1Radio: "+countPytja1Radio);
        return countPytja1Radio;
    }

    @Override
    public int countPytja1Billboards() {
      int countPytja1Billboards = pytesoriDao.countPytja1Billboards();
        System.out.println("--------------- countPytja1Billboards: "+countPytja1Billboards);
        return countPytja1Billboards;
    }

    @Override
    public int countPytja1Gazete() {
        int countPytja1Gazete = pytesoriDao.countPytja1Gazete();
        System.out.println("--------------- numro countPytja1Gazete: "+countPytja1Gazete);
        return countPytja1Gazete;
    }

    @Override
    public int countPytja1Portale() {
        int countPytja1Portale = pytesoriDao.countPytja1Portale();
        System.out.println("--------------- numro countPytja1Portale: "+countPytja1Portale);
        return countPytja1Portale;
    }

    @Override
    public int countPytja1Referuar() {
        int countPytja1Referuar = pytesoriDao.countPytja1Referuar();
        System.out.println("--------------- numro countPytja1Referuar: "+countPytja1Referuar);
        return countPytja1Referuar;
    }

    @Override
    public int countPytja1PromovimetDirekte() {
       int countPytja1PromovimetDirekte = pytesoriDao.countPytja1PromovimetDirekte();
        System.out.println("--------------- numro countPytja1PromovimetDirekte: "+countPytja1PromovimetDirekte);
        return countPytja1PromovimetDirekte;
    }

    @Override
    public int countPytja1SMS() {
      int countPytja1SMS = pytesoriDao.countPytja1SMS();
        System.out.println("--------------- numro countPytja1SMS: "+countPytja1SMS);
        return countPytja1SMS;
    }

    @Override
    public int countPytja2TV() {
        int countPytja2TV = pytesoriDao.countPytja2TV();
        System.out.println("--------------- numro countPytja2TV: "+countPytja2TV);
        return countPytja2TV;
    }

    @Override
    public int countPytja2Radio() {
        int countPytja2Radio = pytesoriDao.countPytja2Radio();
        System.out.println("--------------- numro countPytja2Radio: "+countPytja2Radio);
        return countPytja2Radio;
    }

    @Override
    public int countPytja2RrjeteSociale() {
       int countPytja2RrjeteSociale = pytesoriDao.countPytja2RrjeteSociale();
        System.out.println("--------------- numro countPytja2RrjeteSociale: "+countPytja2RrjeteSociale);
        return countPytja2RrjeteSociale;
    }

    @Override
    public int countPytja2Billboards() {
        int countPytja2Billboards = pytesoriDao.countPytja2Billboards();
        System.out.println("--------------- numro countPytja2Billboards: "+countPytja2Billboards);
        return countPytja2Billboards;
    }

    @Override
    public int countPytja2Gazete() {
        int countPytja2Gazete = pytesoriDao.countPytja2Gazete();
        System.out.println("--------------- numro countPytja2Gazete: "+countPytja2Gazete);
        return countPytja2Gazete;
    }

    @Override
    public int countPytja2Portale() {
       int countPytja2Portale = pytesoriDao.countPytja2Portale();
        System.out.println("--------------- numro countPytja2Portale: "+countPytja2Portale);
        return countPytja2Portale;
    }

    @Override
    public int countPytja2Referuar() {
         int countPytja2Referuar = pytesoriDao.countPytja2Referuar();
        System.out.println("--------------- numro countPytja2Referuar: "+countPytja2Referuar);
        return countPytja2Referuar;
    }

    @Override
    public int countPytja2PromovimetDirekte() {
       int countPytja2PromovimetDirekte = pytesoriDao.countPytja2PromovimetDirekte();
        System.out.println("--------------- numro countPytja2PromovimetDirekte: "+countPytja2PromovimetDirekte);
        return countPytja2PromovimetDirekte;
    }

    @Override
    public int countPytja2SMS() {
        int countPytja2SMS = pytesoriDao.countPytja2SMS();
        System.out.println("--------------- numro countPytja2SMS: "+countPytja2SMS);
        return countPytja2SMS;
    }

    @Override
    public int countPytja3Po() {
          int countPytja3Po = pytesoriDao.countPytja3Po();
        System.out.println("--------------- numro countPytja3Po: "+countPytja3Po);
        return countPytja3Po;
    }

    @Override
    public int countPytja3Jo() {
          int countPytja3Jo = pytesoriDao.countPytja3Jo();
        System.out.println("--------------- numro countPytja3Jo: "+countPytja3Jo);
        return countPytja3Jo;
    }

    @Override
    public int countPytja4Neutral() {
         int countPytja4Neutral = pytesoriDao.countPytja4Neutral();
        System.out.println("--------------- numro countPytja4Neutral: "+countPytja4Neutral);
        return countPytja4Neutral;
    }

    @Override
    public int countPytja4Pozitiv() {
         int countPytja4Pozitiv = pytesoriDao.countPytja4Pozitiv();
        System.out.println("--------------- numro countPytja4Pozitiv: "+countPytja4Pozitiv);
        return countPytja4Pozitiv;
    }

    @Override
    public int countPytja4Negativ() {
        int countPytja4Negativ = pytesoriDao.countPytja4Negativ();
        System.out.println("--------------- numro countPytja4Negativ: "+countPytja4Negativ);
        return countPytja4Negativ;
    }

    @Override
    public int countPytja5Po() {
          int countPytja5Po = pytesoriDao.countPytja5Po();
        System.out.println("--------------- numro countPytja5Po: "+countPytja5Po);
        return countPytja5Po;
    }

    @Override
    public int countPytja5Jo() {
          int countPytja5Jo = pytesoriDao.countPytja5Jo();
        System.out.println("--------------- numro countPytja5Jo: "+countPytja5Jo);
        return countPytja5Jo;
    }

   

}
