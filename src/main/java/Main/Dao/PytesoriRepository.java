package Main.Dao;
import Main.BL.Klienti;
import Main.BL.Pytesori;

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
    

}

