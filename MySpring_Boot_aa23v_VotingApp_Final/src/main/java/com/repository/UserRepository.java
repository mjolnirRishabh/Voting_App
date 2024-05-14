package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select v from User v where v.Voter_Id = :Voter_Id")
	public User getUserByVoter_Id(@Param("Voter_Id") String Voter_Id);


}
	

	



