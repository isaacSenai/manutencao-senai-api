package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
	
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "O nome não pode ser nulo")
	private String nome;
	
	@NotEmpty(message = "O sobrenome não pode ser nulo")
	private String sobrenome;
	
	@NotEmpty(message = "O cpf não pode ser nulo")
	@Pattern(regexp = "NNN.NNN.NNN-NN")
	private String cpf;
	
	@NotNull(message = "O sexo não pode ser nulo")
	private Sexo sexo;
	
	@NotEmpty(message = "O endereço não pode ser nulo")
	private String endereco;
	
	@NotNull(message = "A data de nacimento é pbrigatorio")
	@Past(message = "A data de nacimento deve ser  anterior a hoje")
	private LocalDate dataDeNacimento;

	public Integer getIdade() {
		int idade = LocalDate.now().getYear()
				- getDataDeNacimento().getYear();
		
		return 0;
	}
	
}
