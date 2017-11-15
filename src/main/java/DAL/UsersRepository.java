package DAL;
import BL.Users;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UsersRepository extends EntMngClass implements UsersInterface {
    
    public void create(Users users) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.persist(users);
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
    public void edit(Users users) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.merge(users);
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
    public void remove(Users users) throws KampanjaException {
        try{
            em.getTransaction().begin();
            em.remove(users);
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
    public List <Users> findAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }
    public Users findById(String usersID) throws KampanjaException {
        Query query = em.createQuery("SELECT p FROM Users p WHERE p.usersID = :usersID");
        query.setParameter("usersID", usersID);
        try{
            return (Users)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new KampanjaException("E dhëna nuk egziston!");
        }
    }
    

    
}

