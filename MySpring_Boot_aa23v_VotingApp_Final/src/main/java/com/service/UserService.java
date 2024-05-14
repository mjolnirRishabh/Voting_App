package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.CandidateRepository;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CandidateRepository canRepo;
	
	public void addUser(User user)
	{
		user.setRole("ROLE_NORMAL");

		this.userRepo.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return this.userRepo.findAll();
	}
	
	public User getUserById(int id)
	{
		return this.userRepo.getById(id);
	}
	
	public void deleteUser(int id)
	{
		this.userRepo.deleteById(id);
	}
	
	public User getUserByVoter_ID(String Voter_Id)
	{
		return this.userRepo.getUserByVoter_Id(Voter_Id);
	}
	

	

}
