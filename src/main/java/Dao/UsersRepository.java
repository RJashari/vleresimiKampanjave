package Dao;
import BL.Users;


import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends EntMngClass implements UsersInterface {
     private final Logger LOGGER = Logger.getLogger(UsersRepository.class);
    @Override
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
    @Override
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
    @Override
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
    @Override
    public List <Users> findAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }
    @Override
    public Users findById(long usersID){
        Query query = em.createQuery("SELECT p FROM Users p WHERE p.usersID = :usersID");
        query.setParameter("usersID", usersID);
       
            return (Users)query.getSingleResult();
       
    }

   @Override
	public Users loadUserByUsername(String username) {
		List<Users> users = this.em
				.createQuery("from " + Users.class.getName() + " WHERE username=?")
				.setParameter(0, username).getResultList();
		if (users.size() == 1) {
			return users.get(0);
		}
		return null;
	}





    
}

