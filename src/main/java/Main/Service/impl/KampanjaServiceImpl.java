/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service.impl;

import Main.BL.Kampanja;
import Main.Dao.KampanjaException;
import Main.Dao.KampanjaInterface;
import Main.Dao.UsersInterface;
import Main.Service.KampanjaService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service("kampanjaService")
public class KampanjaServiceImpl implements KampanjaService {
    
    @Autowired
    KampanjaInterface kampanjaDao;

    @Override
    public void create(Kampanja kampanja) throws KampanjaException {
        try {
            kampanjaDao.create(kampanja);
        } catch (KampanjaException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    public void edit(Kampanja kampanja) throws KampanjaException {
       try {
            kampanjaDao.edit(kampanja);
        } catch (KampanjaException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Kampanja kampanja) throws KampanjaException {
        try {
            kampanjaDao.remove(kampanja);
        } catch (KampanjaException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    public List<Kampanja> findAll() {
        return kampanjaDao.findAll();}

    @Override
    public Kampanja findById(long id) {
         return kampanjaDao.findById(id);
    }

    @Override
    public Kampanja findKampanjaByName(String name) {
       
             return kampanjaDao.findKampanjaByName(name);
        
    }
    
    
}
