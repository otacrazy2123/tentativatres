package br.com.desafiozup.tentativatres.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table( name = "pessoa")
@JsonIgnoreProperties({"sorteio"})
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpessoa")
	private long id;
	
	@Column(name = "nome" , nullable = false)
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "email" , nullable = false , unique = true)
	private String email;
	
	@JsonProperty("sorteio")
	@OneToMany( mappedBy =  "pessoa" , cascade = CascadeType.ALL )	
	private List<Sorteio> sorteio;
	
}
