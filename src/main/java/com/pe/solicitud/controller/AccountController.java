package com.pe.solicitud.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountRepo accountRepo;

	@GetMapping(value = "/getId", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Account getById(@RequestParam("id") Integer id) {
		System.out.println("id: " + id);
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
		String msg = "";

		try {
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String sdate = date.format(format);

			SimpleDateFormat dts = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			Date datess = dts.parse(sdate);
			if (account != null) {
				msg = "OK";
				account.setCreation(datess);
				account.setFlag(1);
				accountRepo.save(account);
			} else {
				msg = "NULL";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

	@PostMapping("/update")
	public String update(@RequestBody Account account) {
		String msg = "";
		Account getaccount = accountRepo.getById(account.getId());
		if (getaccount != null) {
			msg = "Action => Upadte";
			accountRepo.update(account);
		} else {
			msg = "Error";
		}

		return msg;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		String msg = "";
		Account account = accountRepo.getById(id);

		if (account != null) {
			msg = "Action => Deleted";
			account.setFlag(0);
			accountRepo.delete(account);
		} else {
			msg = "Error";
		}

		return msg;
	}

}
