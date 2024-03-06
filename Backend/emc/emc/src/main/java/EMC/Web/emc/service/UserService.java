package EMC.Web.emc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import EMC.Web.emc.entities.Cheque;
import EMC.Web.emc.entities.Client;
import EMC.Web.emc.entities.Role;
import EMC.Web.emc.entities.User;
import EMC.Web.emc.exception.UserNotFoundException;
import EMC.Web.emc.repo.ClientRepo;
import EMC.Web.emc.repo.UserRepo;

@Service
@Transactional
public class UserService {
	 private final UserRepo userRepo;
	 private final ClientRepo repoclient;
	    @Autowired
	    public UserService(UserRepo userRepo,ClientRepo repoclient) {
	        this.userRepo = userRepo;
	        this.repoclient=repoclient;
	    }
	    public Integer UserExists (Long matricule,String pwd) {
	    	if(userRepo.findMatricule(matricule).isPresent()) {
	    		if(userRepo.findUser(matricule,pwd).isPresent()) {
	    			return 0;
	    		}
	    		else return 1;
	    	}
	    	else {
	    		return 2;
	    	}
	    }
	    public User FindUser(Long matricule,String pwd) {
	    	return userRepo.findUser(matricule,pwd)
	    			.orElseThrow(() -> new UserNotFoundException("mot de passe incorrecte"));
	    }
	    public User FindMatricule(Long matricule) {
	    	return userRepo.findMatricule(matricule)
	    			.orElse(null);
	    }
	    
	    public List<User>afficherUsers(){
	    	List<User>liste=userRepo.findAll();
	    	return liste;
	    	}
	    
	    public void supprimerUser(User user){
		       Long matricule=user.getMatricule();
		       userRepo.deleteById(matricule);
		    }
	    
	    public void enregistrer(User user){
		       userRepo.save(user);
		    }
	    
	   
	  
	    
	    
	
		
		   
}
