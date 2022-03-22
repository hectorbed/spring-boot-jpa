package com.hbedoya.springboot.jpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbedoya.springboot.jpa.app.models.dao.IClientDao;
import com.hbedoya.springboot.jpa.app.models.entity.Client;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	private IClientDao clientDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	@Transactional
	public void save(Client client) {
		clientDao.save(client);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clientDao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.delete(id);
		
	}

}
