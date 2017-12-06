package Main.Dao;
import Main.BL.Klienti;
import Main.BL.Pytesori;
import Main.BL.Users;

import java.util.List;
import java.util.Set;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PytesoriRepository extends EntMngClass implements PytesoriInterface {
    
     private final Logger LOGGER = Logger.getLogger(PytesoriRepository.class);
     
    @Override
    public void create(Pytesori pytesori) throws KampanjaException {
                
        try{
            em.getTransaction().begin();
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Pytesori>> constraintViolations = validator.validate(pytesori);

            if (constraintViolations.size() > 0 ) {
            System.out.println("Constraint Violations occurred..");
            for (ConstraintViolation<Pytesori> contraints : constraintViolations) {
            System.out.println(contraints.getRootBeanClass().getSimpleName()+
            "." + contraints.getPropertyPath() + " " + contraints.getMessage());
              }
            }
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
        
    
    @Override
    public int countPytja1TV(){
        LOGGER.info("Duke numeruar pytja1TV");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1TV").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1Radio(){
        LOGGER.info("Duke numeruar pytja1Radio");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1Radio").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1RrjeteSociale(){
        LOGGER.info("Duke numeruar pytja1RrjeteSociale");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1RrjeteSociale").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1Billboards(){
        LOGGER.info("Duke numeruar pytja1Billboards");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1Billboards").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1Gazete(){
        LOGGER.info("Duke numeruar pytja1Gazete");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1Gazete").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1Portale(){
        LOGGER.info("Duke numeruar pytja1Portale");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1Portale").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1Referuar(){
        LOGGER.info("Duke numeruar pytja1Referuar");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1Referuar").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja1PromovimetDirekte(){
        LOGGER.info("Duke numeruar pytja1PromovimetDirekte");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1PromovimetDirekte").getSingleResult()).intValue();
       return count;
    }
    @Override
     public int countPytja1SMS(){
        LOGGER.info("Duke numeruar pytja1SMS");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja1SMS").getSingleResult()).intValue();
       return count;
     }
    
    @Override
    public int countPytja2TV(){
        LOGGER.info("Duke numeruar pytja2TV");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2TV").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2Radio(){
        LOGGER.info("Duke numeruar pytja2Radio");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2Radio").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2RrjeteSociale(){
        LOGGER.info("Duke numeruar pytja2RrjeteSociale");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2RrjeteSociale").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2Billboards(){
        LOGGER.info("Duke numeruar pytja2Billboards");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2Billboards").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2Gazete(){
        LOGGER.info("Duke numeruar pytja2Gazete");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2Gazete").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2Portale(){
        LOGGER.info("Duke numeruar pytja2Portale");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2Portale").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2Referuar(){
        LOGGER.info("Duke numeruar pytja2Referuar");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2Referuar").getSingleResult()).intValue();
       return count;
    }
     @Override
    public int countPytja2PromovimetDirekte(){
        LOGGER.info("Duke numeruar pytja2PromovimetDirekte");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2PromovimetDirekte").getSingleResult()).intValue();
       return count;
    }
    @Override
     public int countPytja2SMS(){
        LOGGER.info("Duke numeruar pytja2SMS");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja2SMS").getSingleResult()).intValue();
       return count;
            
     }
     @Override
     public int countPytja3Po(){
        LOGGER.info("Duke numeruar pytja3Po");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja3Po").getSingleResult()).intValue();
       return count;
     }
      @Override
     public int countPytja3Jo(){
        LOGGER.info("Duke numeruar pytja3Jo");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja3Jo").getSingleResult()).intValue();
       return count;
     }
    
           @Override
     public int countPytja4Neutral(){
        LOGGER.info("Duke numeruar pytja4Neutral");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja4Neutral").getSingleResult()).intValue();
       return count;
     }
      @Override
     public int countPytja4Pozitiv(){
        LOGGER.info("Duke numeruar pytja4Pozitiv");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja4Pozitiv").getSingleResult()).intValue();
       return count;
     }
        @Override
     public int countPytja4Negativ(){
        LOGGER.info("Duke numeruar pytja4Negativ");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja4Negativ").getSingleResult()).intValue();
       return count;
     }
      @Override
     public int countPytja5Po(){
        LOGGER.info("Duke numeruar pytja5Po");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja5Po").getSingleResult()).intValue();
       return count;
     }
       @Override
     public int countPytja5Jo(){
        LOGGER.info("Duke numeruar pytja5Po");
       int count = ((Number)em.createNamedQuery("Pytesori.countPytja5Jo").getSingleResult()).intValue();
       return count;
     }
    
    

}

