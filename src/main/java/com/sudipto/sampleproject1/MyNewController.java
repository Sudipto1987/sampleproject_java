package com.sudipto.sampleproject1;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;






@RestController
public class MyNewController {	
	
	
	@GetMapping("/test1")
	public String test111() {
		
		return "Hi Sudipto Roy.......!";
		
		
	}
	

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountValueRepository arepository;	
	
	@Autowired
	private UserRequestValueRepository urepository;	
	
	
	
	@GetMapping("/getDetails")
	public List<Account> findAllAccounts() {
		
		System.out.println("Inside first");
		
		List<Account> accounts = arepository.findAll();
		
		
		
		System.out.println("Inside");
		logger.info("{}", accounts);
		
		return accounts;		
		
	}
	
	@PostMapping("/addAccountRequest/{acc_number}/{submitted_by}/{action_taken}")
	public void addAccount(@PathVariable("acc_number") int acc_number,@PathVariable("submitted_by") String submitted_by,@PathVariable("action_taken") String action_taken) {
		
		//http://localhost:8000/addAccountRequest/12345678/Kawasaki/Pending
		
		
		String approve="Approve";
		String pending="Pending";
		String reject="Reject";
		
		
		
		if(action_taken.equals(approve)) {
			//http://localhost:8000/addAccountRequest/123123/Sudipto/Approve
			List<UserRequest> uReqList=urepository.findAll();	
			System.out.println("Inside approve");
			
			for (UserRequest ureq:uReqList) {
				
				
				
				if (ureq.getAction().equals(pending) && ureq.getAccount_number()==acc_number) {
					
					
					Account account=new Account();
					account.setAccount_number(acc_number);
					arepository.save(account);	
					
					UserRequest ureqNew=new UserRequest();
					Date date = new Date();
					Random rd = new Random();
					ureqNew.setAccount_number(acc_number);
					ureqNew.setAction(approve);
					ureqNew.setDate(date);
					ureqNew.setId(rd.nextInt());
					ureqNew.setSubmittedBy(submitted_by);
					urepository.save(ureqNew);
					
				}
			}
			
			
			
		}
		
		if(action_taken.equals(pending)) {
			
			Date date = new Date();
			UserRequest urequest=new UserRequest();
			urequest.setDate(date);
			urequest.setAccount_number(acc_number);
			urequest.setAction(action_taken);
			urequest.setSubmittedBy(submitted_by);
			Random rd = new Random();
			urequest.setId(rd.nextInt());
			urepository.save(urequest);
			
		}
		
		if(action_taken.equals(reject)) {
			
				
			List<UserRequest> uReqList=urepository.findAll();
			
			for (UserRequest ureq:uReqList) {
				
				
				
				if (ureq.getAction().equals(pending) && ureq.getAccount_number()==acc_number) {
					
					
					
					
					
					ureq.setAction("Pending disabled");
					urepository.save(ureq);
					
					UserRequest ureqNew=new UserRequest();
					Date date = new Date();
					Random rd = new Random();
					ureqNew.setAccount_number(acc_number);
					ureqNew.setAction(reject);
					ureqNew.setDate(date);
					ureqNew.setId(rd.nextInt());
					ureqNew.setSubmittedBy(submitted_by);
					urepository.save(ureqNew);
					
				}
			}
			
			
		}
		
		
		/*
		 * Account account=new Account(); account.setAction("maker"); Date date = new
		 * Date(); account.setDate(date); account.setSubmittedBy(submitted_by);
		 * account.setAccount_number(acc_number);
		 */
		
		
		
		/*
		 * arepository.save(account);
		 * 
		 * System.out.println("Completed"); logger.info("{}", account);
		 */
		
				
		
	}
	

}
