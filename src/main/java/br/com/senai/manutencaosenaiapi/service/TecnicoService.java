package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.repository.TecnicosRepository;

@Service
@Validated
public class TecnicoService {

	@Autowired
	private TecnicosRepository repository;
	
	public Tecnico inserir(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico novoTecnico) {			
		Preconditions.checkArgument(novoTecnico.isNovo(),
				"O técnico já foi salvo");
		Tecnico tecnicoSalvo = novoTecnico;	
		return tecnicoSalvo;				
	}
	
	public Tecnico alterar(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico tecnicoSalvo) {
		Preconditions.checkArgument(!tecnicoSalvo.isNovo(), 
				"O técnico ainda não foi inserido");
		Tecnico tecnicoAtualizado = tecnicoSalvo;
		return tecnicoAtualizado;
	}
	
	public List<Tecnico> listarPro(
			@NotEmpty(message = "O nome para busca não pode ser nilo")
			String nome) {
		return repository.listarPor("%" + nome + "%");
	}
	
	public void remoVerPor(
			@NotNull(message = "o id de exclusão não pode ser nulo")
			@Min(value = 1, message = "O ID não pode ser nulo")
			Integer id) {
		this.repository.deleteById(id);
	}
	
	
}
