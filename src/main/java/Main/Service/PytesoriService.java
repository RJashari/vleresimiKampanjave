/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;
 
import Main.BL.Pytesori;
import Main.Dao.KampanjaException;
import java.util.List;

/**
 *
 * @author rinor.jashari
 */
public interface PytesoriService {
 
  void create(Pytesori pytesori);
    void edit (Pytesori pytesori);
    void remove(Pytesori pytesori);
    List<Pytesori> findAll();
    Pytesori findById(long id);
    int countPytja1TV();
    int countPytja1Radio();
    int countPytja1RrjeteSociale();
    int countPytja1Billboards();
    int countPytja1Gazete();
    int countPytja1Portale();
    int countPytja1Referuar();
    int countPytja1PromovimetDirekte();
    int countPytja1SMS();
    int countPytja2TV();
    int countPytja2Radio();
    int countPytja2RrjeteSociale();
    int countPytja2Billboards();
    int countPytja2Gazete();
    int countPytja2Portale();
    int countPytja2Referuar();
    int countPytja2PromovimetDirekte();
    int countPytja2SMS();
    
    int countPytja3Po();
    int countPytja3Jo();
    
    int countPytja4Neutral();
    int countPytja4Pozitiv();
    int countPytja4Negativ();
    
    int countPytja5Po();
    int countPytja5Jo();
    
}
