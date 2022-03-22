package com.hbedoya.springboot.jpa.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hbedoya.springboot.jpa.app.models.entity.Client;

public interface IClientDao extends CrudRepository<Client, Long>{

}
