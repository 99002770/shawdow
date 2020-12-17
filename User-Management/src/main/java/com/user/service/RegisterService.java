package com.user.service;

import java.util.Optional;

import com.user.model.Address;
import com.user.model.User;
import com.user.model.Authentication;

public interface RegisterService {
	public void saveData(User user,Address add,Authentication valid);
	public boolean authenticate(Authentication valid);
	
	public void deleteData(Authentication valid);
	public Optional<User> search(String emailid);
}
