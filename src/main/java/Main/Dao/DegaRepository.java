package Main.Dao;
import Main.BL.Klienti;
import Main.BL.Dega;


import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DegaRepository extends EntMngClass implements DegaInterface {
    private static final String DEFAULT_PASSWORD = "$2a$10$5kCKO/IAcqcrAy0IzrHFK.kEVBeBKVn8j/m4xcN7TTBhb1RJ3GJ7S";
     private final Logger LOGGER = Logger.getLogger(DegaRepository.class);
    @Override
    public void create(Dega dega) throws KampanjaException {
        LOGGER.info("Creating user: " + dega.getEmri()) ;
        try{
            
//            dega.setEmail("rinorjashari@gmail.com");
//            dega.setUsername("rinori");
            em.getTransaction().begin();
            em.persist(dega);
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
    public void edit(Dega dega) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.merge(dega);
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
    public void remove(Dega dega) throws KampanjaException {
        LOGGER.info("Removing user: " + dega.getEmri());
        try{
            em.getTransaction().begin();
            em.merge(dega);
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
    public List <Dega> findAll() {
        return em.createNamedQuery("Dega.findAll").getResultList();
    }
    @Override
    public Dega findById(int degaID){
        LOGGER.info("Duke gjetur degen me id : " + degaID);
        Query query = em.createQuery("SELECT d FROM Dega d WHERE d.degaID = :userID");
        query.setParameter("userID", degaID);
       
            return (Dega)query.getSingleResult();
       
    }


    @Override
    public void removeByName(String deganame) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dega findDegaByDegaName(String degaName) {
        LOGGER.info("Duke kerkuar degen me Emer:");
        
        Query query = em.createQuery("SELECT d FROM Dega d WHERE d.emri = :emri");
        query.setParameter("emri", degaName);
        
           return (Dega)query.getSingleResult();
    }

    @Override
    public void resetDegaPassword(int id) throws KampanjaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 }





    


