package com.pe.solicitud.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "webrequest", schema = "body")
public class WebRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String businessname; // Nombre del Negocio;
	private String businesselement; // Cual es el rubro del negocio a que se dedica;
	private int web; // 1:Si ; 2:No', //tienes sitio web
	private String questionfourteen; // pregunta 14
	private String questionthirteen; // pregunta 13
	private String questiontwelve; // pregunta 12;
	private String questioneleve; // pregunta 11;
	private String questionten; // pregunta dies;
	private String questionnine; // pregunta nueve;
	private String questioneight; // questioneight;
	private String questionseven; // questionseven;
	private String questionsix; // preguntasix;
	private String questionfive; // pregunta cinco;
	private String questionfour; // questionfour;
	private String questionthree; // questionthree;
	private String questiontwo; // pregunta dos;
	private String questionone; // pregunta uno;
	private double budget; // presupuesto
	private int currency; // '1:Soles;2:Dolares' //moneda

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date created; // creado

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date modified; // modificado

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Date dateend; // Fecha en que termina el formulario;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Date datestart; // Fecha en que inicia el Formulario;

	private int Flag;

	@NotNull
	@ManyToOne
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBusinesselement() {
		return businesselement;
	}

	public void setBusinesselement(String businesselement) {
		this.businesselement = businesselement;
	}

	public int getWeb() {
		return web;
	}

	public void setWeb(int web) {
		this.web = web;
	}

	public String getQuestionfourteen() {
		return questionfourteen;
	}

	public void setQuestionfourteen(String questionfourteen) {
		this.questionfourteen = questionfourteen;
	}

	public String getQuestionthirteen() {
		return questionthirteen;
	}

	public void setQuestionthirteen(String questionthirteen) {
		this.questionthirteen = questionthirteen;
	}

	public String getQuestiontwelve() {
		return questiontwelve;
	}

	public void setQuestiontwelve(String questiontwelve) {
		this.questiontwelve = questiontwelve;
	}

	public String getQuestioneleve() {
		return questioneleve;
	}

	public void setQuestioneleve(String questioneleve) {
		this.questioneleve = questioneleve;
	}

	public String getQuestionten() {
		return questionten;
	}

	public void setQuestionten(String questionten) {
		this.questionten = questionten;
	}

	public String getQuestionnine() {
		return questionnine;
	}

	public void setQuestionnine(String questionnine) {
		this.questionnine = questionnine;
	}

	public String getQuestioneight() {
		return questioneight;
	}

	public void setQuestioneight(String questioneight) {
		this.questioneight = questioneight;
	}

	public String getQuestionseven() {
		return questionseven;
	}

	public void setQuestionseven(String questionseven) {
		this.questionseven = questionseven;
	}

	public String getQuestionsix() {
		return questionsix;
	}

	public void setQuestionsix(String questionsix) {
		this.questionsix = questionsix;
	}

	public String getQuestionfive() {
		return questionfive;
	}

	public void setQuestionfive(String questionfive) {
		this.questionfive = questionfive;
	}

	public String getQuestionfour() {
		return questionfour;
	}

	public void setQuestionfour(String questionfour) {
		this.questionfour = questionfour;
	}

	public String getQuestionthree() {
		return questionthree;
	}

	public void setQuestionthree(String questionthree) {
		this.questionthree = questionthree;
	}

	public String getQuestiontwo() {
		return questiontwo;
	}

	public void setQuestiontwo(String questiontwo) {
		this.questiontwo = questiontwo;
	}

	public String getQuestionone() {
		return questionone;
	}

	public void setQuestionone(String questionone) {
		this.questionone = questionone;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getDateend() {
		return dateend;
	}

	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}

	public Date getDatestart() {
		return datestart;
	}

	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}

	public int getFlag() {
		return Flag;
	}

	public void setFlag(int flag) {
		Flag = flag;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
