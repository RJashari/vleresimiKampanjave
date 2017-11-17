package Dao;
import BL.Pytesori;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class PytesoriRepository extends EntMngClass implements PytesoriInterface {
    private final Logger LOGGER = Logger.getLogger(PytesoriRepository.class);
    @Override
    public void create(Pytesori pytesori) throws KampanjaException {
        LOGGER.info("Duke ruajtur pyetesorin: " + pytesori.getPytesoriID());
        try{
            em.getTransaction().begin();
            em.persist(pytesori);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
             LOGGER.info("Ruajtja e pyetesorit: " + pytesori.getPytesoriID()+" ka deshtuar");
            if(thro.getMessage().contains("2627")){
            
                    throw new KampanjaException("E dhëna egziston !");
            }
        else{
                throw new KampanjaException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    @Override
    public void edit(Pytesori pytesori) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.merge(pytesori);
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
    public void remove(Pytesori pytesori) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.remove(pytesori);
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
    public List <Pytesori> findAll() {
        return em.createNamedQuery("Pytesori.findAll").getResultList();
    }
    @Override
    public Pytesori findById(long pytesoriID){
        Query query = em.createQuery("SELECT p FROM Pytesori p WHERE p.pytesoriID = :pytesoriID");
        query.setParameter("pytesoriID", pytesoriID);
        
            return (Pytesori)query.getSingleResult();
     
    }

    
}

