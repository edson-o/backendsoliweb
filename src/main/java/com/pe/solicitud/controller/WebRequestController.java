package com.pe.solicitud.controller;

import java.util.ArrayList;
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
	public List<WebRequest> list(@RequestParam("idaccount") Integer idaccount, @RequestParam("flag") Integer flag) {
		List<WebRequest> lista = new ArrayList<>();

		Account account = accountRepo.getById(idaccount);
		lista = webRequestRepo.list(account, flag);
		return lista;

	}

	@PostMapping("/save")
	public String save(@RequestBody WebRequest webRequest) {
		String msg = "";

		if (webRequest != null) {
			msg = "Action => Successfull";
			webRequestRepo.save(webRequest);
		} else {
			msg = "Error";
		}

		return msg;
	}

	@PostMapping("/update")
	public String update(@RequestBody WebRequest webRequest) {
		String msg = "";
		WebRequest obj = webRequestRepo.getById(webRequest.getId());
		if (obj != null) {
			msg = "Action => Upadte";
			webRequestRepo.update(webRequest);
		} else {
			msg = "Error";
		}

		return msg;
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		String msg = "";

		WebRequest obj = webRequestRepo.getById(id);

		if (obj != null) {
			msg = "Action => Deleted";
			obj.setFlag(0);
			webRequestRepo.delete(obj);
		} else {
			msg = "Error";
		}

		return msg;
	}

}
