package com.pe.solicitud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.solicitud.entity.Account;
import com.pe.solicitud.entity.WebRequest;
import com.pe.solicitud.repository.AccountRepo;
import com.pe.solicitud.repository.WebRequestRepo;
import com.pe.solicitud.util.DateFormat;

@RestController
@RequestMapping("/webrequest")
public class WebRequestController {

	@Autowired
	WebRequestRepo webRequestRepo;

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	DateFormat dateFormat;

	@GetMapping("/list")
	public List<WebRequest> list(@RequestParam("idaccount") Integer idaccount) {
		List<WebRequest> lista = new ArrayList<>();

		if (idaccount != null) {
			Account account = accountRepo.getById(idaccount);
			lista = webRequestRepo.list(account);
		} else {
			return null;
		}
		return lista;

	}

	@GetMapping("/getid")
	public WebRequest GetId(@RequestParam("id") Integer id) {
		WebRequest webRequest = new WebRequest();

		if (id != null) {
			webRequest = webRequestRepo.getById(id);
			if (webRequest != null) {
				return webRequest;
			} else {
				return new WebRequest();
			}

		} else {
			return new WebRequest();
		}

	}

	@PostMapping("/save")
	public String save(@RequestBody WebRequest webRequest) {
		String msg = "";

		if (webRequest != null) {
			msg = "OK";
			webRequest.setCreated(dateFormat.dateActual());
			webRequest.setFlag(1);
			webRequestRepo.save(webRequest);
		} else {
			msg = "NULL";
		}

		return msg;
	}

	@PostMapping("/update")
	public String update(@RequestBody WebRequest webRequest) {
		String msg = "";
		WebRequest obj = webRequestRepo.getById(webRequest.getId());

		if (obj != null) {
			msg = "OK";
			Date created = obj.getCreated();
			webRequest.setCreated(created);
			webRequest.setModified(dateFormat.dateActual());
			webRequest.setFlag(1);
			webRequestRepo.update(webRequest);
		} else {
			msg = "NULL";
		}

		return msg;
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("id") Integer id) {
		String msg = "";

		if (id != null) {
			WebRequest obj = webRequestRepo.getById(id);
			if (obj != null) {
				msg = "OK";
				obj.setFlag(0);
				webRequestRepo.delete(obj);
			} else {
				msg = "NULL";
			}
		} else {
			msg = "NULL";
		}

		return msg;
	}

}
