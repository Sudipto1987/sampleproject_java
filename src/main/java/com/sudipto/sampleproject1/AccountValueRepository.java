package com.sudipto.sampleproject1;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;




public interface AccountValueRepository extends JpaRepository<Account, Integer>{	
	
	//List<Account> findAll();
	
	
	//Account findByFromAndTo(String from, String to);
	

}
