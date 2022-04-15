package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class OrdemDeServico {

	private Integer id;
	
	@NotNull(message = "O cliente da ordem não pode ser nulo")
	private Cliente cliente;
	
	@NotNull(message = "O técnico ordem não pode ser nulo")
	private Tecnico tecnico;
	
	@NotNull(message = "A data de arbetura é obrigatorio")
	@PastOrPresent(message = "A data de abetura não pode "
			+ "ser posterior a data atual")
	private LocalDate dataDeAbertura;
	
	@PastOrPresent(message = "A data de encerramento não "
			+ "pode ser posterior a data atual")
	private LocalDate dataDeEncerrmanto;
	
	@NotEmpty(message = "A descrição do problema é obigatoria")
	@NotBlank(message = "A descrição do problema não foi informada")
	private String descricaoDoProbelma;
	
	private String descricaoDoReparo;
	
	@NotEmpty(message = "Deve haver")
	private List<Peca> pecasDoReparos;
	
}
