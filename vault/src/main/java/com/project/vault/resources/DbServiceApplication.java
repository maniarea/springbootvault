package com.project.vault.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vault.model.PasswordData;
import com.project.vault.repository.passwordRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceApplication {
	
	@Autowired
	private passwordRepository passwordRepository;
	
	@GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PasswordData> getAllData(){
		List<PasswordData> pd=new ArrayList<PasswordData>();
		pd=passwordRepository.findAll();
		return pd;
	}

	@GetMapping(value="/{accountid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PasswordData getData(@PathVariable(value="accountid") Integer accountid){
		PasswordData pd=passwordRepository.findById(accountid).orElse(null);
		return pd;
	}
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PasswordData> addUserData(@RequestBody PasswordData pData){
		
		passwordRepository.save(pData);
		
		return getAllData();
	}
	
	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PasswordData updateUserData(@PathVariable(value="id") Integer id,@RequestBody PasswordData pData){
		PasswordData pd=getData(id);
		pd.setAccountName(pData.getAccountName());
		pd.setAccPassword(pData.getAccPassword());
		passwordRepository.save(pData);
		return getData(pData.getAccountId());
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public <T> ResponseEntity<T> deleteUserData(@PathVariable(value="id") Integer id){
		PasswordData pd=getData(id);
		passwordRepository.delete(pd);
		return ResponseEntity.ok().build();
	}
	
}
