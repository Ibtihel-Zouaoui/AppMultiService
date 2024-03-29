package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.service.ClienttService;

@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClienttService clientservice;
	
	@Autowired
	ClientRepository clientrepository;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void saveUser(@RequestBody Client client) {
		clientservice.saveUser(client);
		
	}
	
	@RequestMapping(value="/deleteclient/{id}",method=RequestMethod.DELETE)
	public void deleteclient(@PathVariable("id") Integer id) {
		Client c =clientservice.getclientById(id);
		clientservice.suppclient(c);
	}
	
	@RequestMapping(value="/allclient", method=RequestMethod.GET)
	public List<Client> getall(){
		return clientrepository.findAll();
	}
}
