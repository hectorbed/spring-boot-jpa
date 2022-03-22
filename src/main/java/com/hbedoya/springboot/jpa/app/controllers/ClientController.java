package com.hbedoya.springboot.jpa.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hbedoya.springboot.jpa.app.models.dao.IClientDao;
import com.hbedoya.springboot.jpa.app.models.entity.Client;
import com.hbedoya.springboot.jpa.app.service.IClientService;

@Controller
@SessionAttributes("client") // This is to retain the object during the session
public class ClientController {
	
	@Autowired
	private IClientService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", "Clients list");
		model.addAttribute("clients", service.findAll());
		return "list";
	}
	
	@GetMapping("/form")
	public String create(Map<String, Object> model) {
		model.put("title", "Client Form");
		Client client = new Client();
		model.put("client", client);
		return "form";
	}
	
	@PostMapping("/form")
	public String save(@Valid Client client, BindingResult br, Model model, SessionStatus session) {
		if(br.hasErrors()) {
			model.addAttribute("title", "Client form");
			return "form";
		}
		service.save(client);
		session.setComplete();
		return "redirect:list";
	}
	
	@GetMapping("/form/{id}")
	public String edit(@PathVariable(value="id") Long id, Map<String, Object> model) {
		Client cli = null;
		if(id > 0) {
			cli = service.findById(id);
		}else {
			return "redirect:list";
		}
		model.put("title", "Client form");
		model.put("client", cli);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		service.delete(id);
		return "redirect:/list";
	}
}
