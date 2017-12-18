package Main.Dao;
import Main.BL.Klienti;
import Main.BL.Users;


import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends EntMngClass implements UsersInterface {
    private static final String DEFAULT_PASSWORD = "$2a$10$5kCKO/IAcqcrAy0IzrHFK.kEVBeBKVn8j/m4xcN7TTBhb1RJ3GJ7S";
     private final Logger LOGGER = Logger.getLogger(UsersRepository.class);
    @Override
    public void create(Users users) throws KampanjaException {
        LOGGER.info("Creating user: " + users.getUsername()) ;
        try{
            users.setPassword(DEFAULT_PASSWORD);
//            users.setEmail("rinorjashari@gmail.com");
//            users.setUsername("rinori");
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
        LOGGER.info("Removing user: " + users.getUsername());
        try{
            em.getTransaction().begin();
            users.setStatus(false);
            users.setPassword("2345678ijhgfd");
            em.merge(users);
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
    public Users findById(int usersID){
        LOGGER.info("Duke gjetur userin me id : " + usersID);
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.userID = :userID");
        query.setParameter("userID", usersID);
       
            return (Users)query.getSingleResult();
       
    }

//   @Override
//	public Users loadUserByUsername(String username) {
//		List<Users> users = this.em
//				.createQuery("from " + Users.class.getName() + " WHERE username=?")
//				.setParameter(0, username).getResultList();
//		if (users.size() == 1) {
//			return users.get(0);
//		}
//		return null;
//	}

    @Override
    public void removeByUsername(String username) throws KampanjaException {
        LOGGER.info("Removing user: " + username);
        try{
            Users user = this.findUsersByUsername(username);
            em.getTransaction().begin();
            em.remove(user);
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
    public void resetUserPassword(int id) throws KampanjaException {
        LOGGER.info("Resetting user password: " + id);
        try{
            Users user = this.findById(id);
            em.getTransaction().begin();
            user.setPassword(DEFAULT_PASSWORD);
            em.merge(user);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            
                throw new KampanjaException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }

    @Override
    public Users findUsersByUsername(String username){
        LOGGER.info("Duke kerkuar usernin me username :"+username);
        
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username");
        query.setParameter("username", username);
        
           return (Users)query.getSingleResult();
    }


 }





    


