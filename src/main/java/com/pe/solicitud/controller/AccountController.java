package com.pe.solicitud.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.solicitud.entity.Account;
import com.pe.solicitud.repository.AccountRepo;
import com.pe.solicitud.util.DateFormat;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	DateFormat dateFormat;

	private String msg = "";

	@GetMapping(value = "/getId", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Account getById(@RequestParam("id") Integer id) {

		if (id != null) {
			Account account = accountRepo.getById(id);

			if (account != null) {
				return account;
			} else {
				return new Account();
			}

		} else {
			return new Account();
		}

	}

	@GetMapping("/list")
	public List<Account> list() {
		return accountRepo.list();
	}

	@PostMapping("/save")
	public String save(@RequestBody Account account) {

		List<Account> list = accountRepo.list();

		list.stream().forEach(item -> {
			if (item.getUsuario().equals(account.getUsuario())) {
				msg = "ERROR";
			}
		});

		if (account != null) {

			if (!msg.equals("ERROR")) {
				msg = "OK";
				account.setCreation(dateFormat.dateActual());
				account.setFlag(1);
				accountRepo.save(account);
			} else {
				msg = "Duplicidad de Usuario";
			}

		} else {
			msg = "NULL";
		}

		return msg;
	}

	@PostMapping("/update")
	public String update(@RequestBody Account account) {

		Account getaccount = accountRepo.getById(account.getId());
		System.out.println("getaccount: " + getaccount);
		if (getaccount != null) {
			msg = "OK";
			Date date = getaccount.getCreation();
			account.setCreation(date);
			account.setModified(dateFormat.dateActual());
			account.setFlag(1);
			accountRepo.update(account);
		} else {
			msg = "NULL";
		}

		return msg;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id) {

		if (id != null) {
			Account account = accountRepo.getById(id);
			if (account != null) {
				msg = "OK";
				account.setFlag(0);
				accountRepo.delete(account);
			} else {
				msg = "NULL";
			}
		} else {
			msg = "NULL";
		}

		return msg;
	}

}
