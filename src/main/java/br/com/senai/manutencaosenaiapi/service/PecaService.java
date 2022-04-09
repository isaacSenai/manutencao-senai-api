package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.Peca;

@Service
@Validated
public class PecaService {

	public Peca inserir(@Valid Peca novaPeca) {
		Peca pecaSalva = novaPeca;
		return pecaSalva;
	}
	
	public Peca alterar(@Valid Peca pecaSalva) {
		Peca pecaAtualizada = pecaSalva;
		return pecaAtualizada;
	}
	
	public List<Peca> listarPor(
			@NotEmpty(message = "A descrição ")
			String descricao) {
		return new ArrayList<Peca>();
	}
	
	
}
