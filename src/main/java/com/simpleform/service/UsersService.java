package com.simpleform.service;

import org.springframework.stereotype.Service;
import com.simpleform.model.UsersModel;
import com.simpleform.repository.UsersRepository;

@Service
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;

	}

	
	public UsersModel registerUser(String login, String password, String email){
		if(login == null || password == null){
			return null;
			
		}else {
			UsersModel usersModel = new UsersModel();
			usersModel.setLogin(login);
			usersModel.setPassword(password);
			usersModel.setEmail(email);
			return usersRepository.save(usersModel);
			
			
			
		}
	}
	
	public UsersModel authenticate(String login, String password){ 
		return usersRepository.findByLoginAndPassword(login, password).orElse(null);
		
	}


}
