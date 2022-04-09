package br.com.senai.manutencaosenaiapi.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Peca {

	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "A descrição é obrigatoria")
	private String descricao;
	
	private String especificacoes;
	
	@NotNull(message = "A Quantidade é obrigatoria")
	@Min(value = 0, message = "A Quantidade não")
	private Integer qtdeEmEstoque;
	
}
