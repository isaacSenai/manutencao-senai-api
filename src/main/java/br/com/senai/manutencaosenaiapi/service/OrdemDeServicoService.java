package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;

@Service
@Validated
public class OrdemDeServicoService {

	public OrdemDeServico inserir(
			@Valid 
			@NotNull(message = "A nova ordem é obrigatoria")
			OrdemDeServico novaOrdem) {
		this.validar(novaOrdem);
		OrdemDeServico ordemSalva = novaOrdem;
		return ordemSalva;	
	}
	
	public OrdemDeServico alterar(
			@Valid 
			@NotNull(message = "A ordem salva é obrigatoria")
			OrdemDeServico ordemSalva) {
		this.validar(ordemSalva);
		OrdemDeServico ordemAtualizada = ordemSalva;
		return ordemAtualizada;
		
	}
	
	public OrdemDeServico fechar(
			@Valid
			@NotNull(message = "A ordem é obrigatoria")
			OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDataDeEncerrmanto() != null,
				"A data de encerramento é obrigatoria");
		Preconditions.checkArgument(
				ordem.getDescricaoDoReparo() != null,
				"A descrição do reparo é obrigatória");
		
		boolean isOisterior = ordem.getDataDeEncerrmanto()
				.isAfter(ordem.getDataDeAbertura());
		
		Preconditions.checkArgument(isOisterior,
				"A data de encerramento deve ser posterior "
				+ "a data de abertura");
		OrdemDeServico orderAtualizada = ordem;
		return orderAtualizada;
		
	}
	
	private void validar(OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDescricaoDoReparo() == null,
				"A descrição do reparo não deve ser informada na abert");
		
		Preconditions.checkArgument(ordem.getDataDeEncerrmanto() == null,
				"weqewf");
	}
	
	public List<OrdemDeServico> listarPor(
			@NotNull(message = "O id do cliente é obrigatoria")
			@Min(value = 1, message = "O id deve ser maior  que zero")
			Integer idDoCliente){
		return new ArrayList<OrdemDeServico>();
		
	}
	
	
	
}
