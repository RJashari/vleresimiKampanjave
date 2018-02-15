/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Dao;

import Main.BL.Kampanja;
import Main.BL.Kampanja;
import javax.persistence.Query;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class KampanjaRepository extends EntMngClass implements KampanjaInterface {

     private final Logger LOGGER = Logger.getLogger(UsersRepository.class);
    @Override
    public void create(Kampanja kampanja) throws KampanjaException {
        LOGGER.info("Creating kampanja: " + kampanja.getEmri()) ;
        try{
            em.getTransaction().begin();
            em.persist(kampanja);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new KampanjaException("E dhëna egziston !");
            }
        else{
                throw new KampanjaException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }

    @Override
    public void edit(Kampanja kampanja) throws KampanjaException {
        LOGGER.info("Editing kampanja: " + kampanja.getEmri()) ;
         try{
            em.getTransaction().begin();
            em.merge(kampanja);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new KampanjaException("E dhëna egziston");
            }
            else{
                throw new KampanjaException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    

    @Override
    public void remove(Kampanja kampanja) throws KampanjaException {
        LOGGER.info("Removing kampanja: " + kampanja.getEmri()) ;
        try{
            em.getTransaction().begin();
            em.remove(kampanja);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new KampanjaException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new KampanjaException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Kampanja> findAll() {
        LOGGER.info("Duke kerkuar te gjitha kampanjat") ;
       return em.createNamedQuery("Kampanja.findAll").getResultList();
    }
    

    @Override
    public Kampanja findById(long kampanjaID) {
        LOGGER.info("Duke kerkuar kampanjen me id: " +kampanjaID) ;
        Query query = em.createQuery("SELECT k FROM Kampanja k WHERE k.kampanjaID = :kampanjaID");
        query.setParameter("kampanjaID", kampanjaID);
        
           return (Kampanja)query.getSingleResult();}

    @Override
    public Kampanja findKampanjaByName(String name) {
        LOGGER.info("Duke kerkuar Kampanjen :"+name);
        
        Query query = em.createQuery("SELECT k FROM Kampanja k WHERE k.emri = :emri");
        query.setParameter("emri", name);
        
           return (Kampanja)query.getSingleResult();
    }

   
}
