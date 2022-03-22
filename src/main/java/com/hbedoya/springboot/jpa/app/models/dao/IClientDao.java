package com.hbedoya.springboot.jpa.app.models.dao;

import java.util.List;

import com.hbedoya.springboot.jpa.app.models.entity.Client;

public interface IClientDao {
	
	public List<Client> findAll();
	
	public void save(Client client);
	
	public Client findById(Long id);
	
	public void delete(Long id);

}
