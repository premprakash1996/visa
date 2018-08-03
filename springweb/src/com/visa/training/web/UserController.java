package com.visa.training.web;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.domain.User;

@RestController
public class UserController {
	
	Map<Integer,User> db = new ConcurrentHashMap<>();
	AtomicInteger idSequence = new AtomicInteger(0);
	
	@PostConstruct
	public void init(){
		User u1 = new User("user1", "secret");
		User u2 = new User("Bono","secret");
		int id = idSequence.incrementAndGet();
		db.put(id, u1);
		id = idSequence.incrementAndGet();
		db.put(id	, u2);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return new ArrayList<User>(db.values());
	}

	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> getById(@PathVariable("id") int id){
		User u = db.get(id);
		if(u == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public ResponseEntity<User> add(@RequestBody User u){
		int id = idSequence.incrementAndGet();
		db.put(id, u);
		HttpHeaders h = new HttpHeaders();
		h.setLocation(URI.create("/users/"+id));
		return new ResponseEntity<User>(u,h,HttpStatus.CREATED);
	}
}
