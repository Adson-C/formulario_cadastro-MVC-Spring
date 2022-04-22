package com.ads.dev.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario; // para saralario bigdecimal
	
	@Column(name = "data_entrada" , nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
 
	@Column(name = "data_saida" , columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	@OneToOne(cascade = CascadeType.ALL) // um para um 
	@JoinColumn(name = "endereco_id_fk") // nomear a classe estrangeira na tabela
	private Endereco endereco;

	@ManyToOne // um Cargo vai ter muitos Funcionarios
	@JoinColumn(name = "cargo_id_fk") // chave estrangeira
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
}
