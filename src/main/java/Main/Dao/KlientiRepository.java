package Main.Dao;
import Main.BL.Klienti;

import java.util.List;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class KlientiRepository extends EntMngClass implements KlientiInterface {
    
    @Override
    public void create(Klienti klienti) throws KampanjaException {
                
        try{
            em.getTransaction().begin();
            em.persist(klienti);
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
    public void edit(Klienti klienti) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.merge(klienti);
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
    public void remove(Klienti klienti) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.remove(klienti);
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
    public List <Klienti> findAll() {
        return em.createNamedQuery("Klienti.findAll").getResultList();
    }
    @Override
    public Klienti findById(long klientiID){
        Query query = em.createQuery("SELECT p FROM Klienti p WHERE p.nrPersonal = :klientiID");
        query.setParameter("klientiID", klientiID);
        
           return (Klienti)query.getSingleResult();
   
    }

}

