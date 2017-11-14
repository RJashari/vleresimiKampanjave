package DAL;
import BL.Klienti;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class KlientiRepository extends EntMngClass implements KlientiInterface {
    
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
    public List <Klienti> findAll() {
        return em.createNamedQuery("Klienti.findAll").getResultList();
    }
    public Klienti findById(long klientiID) throws KampanjaException {
        Query query = em.createQuery("SELECT p FROM Klienti p WHERE p.klientiID = :klientiID");
        query.setParameter("klientiID", klientiID);
        try{
            return (Klienti)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new KampanjaException("E dhëna nuk egziston!");
        }
    }

   
    
}

