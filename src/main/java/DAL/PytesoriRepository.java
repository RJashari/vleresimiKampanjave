package DAL;
import BL.Pytesori;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PytesoriRepository extends EntMngClass implements PytesoriInterface {
    
    public void create(Pytesori pytesori) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.persist(pytesori);
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
    public List <Pytesori> findAll() {
        return em.createNamedQuery("Pytesori.findAll").getResultList();
    }
    public Pytesori findById(long pytesoriID) throws KampanjaException {
        Query query = em.createQuery("SELECT p FROM Pytesori p WHERE p.pytesoriID = :pytesoriID");
        query.setParameter("pytesoriID", pytesoriID);
        try{
            return (Pytesori)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new KampanjaException("E dhëna nuk egziston!");
        }
    }

    
}

