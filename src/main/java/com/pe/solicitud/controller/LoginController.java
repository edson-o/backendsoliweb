package com.pe.solicitud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.solicitud.entity.Account;
import com.pe.solicitud.repository.AccountRepo;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AccountRepo accountRepo;

	@PostMapping("/enter")
	public List<Account> Login(@RequestBody Account account) {

		List<Account> list = accountRepo.login(account.getUsuario(), account.getPassword());

		return list;
	}

}
