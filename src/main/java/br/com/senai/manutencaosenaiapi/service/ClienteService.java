package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Cliente;

@Service
@Validated
public class ClienteService {

	final int IDADE_MINIMA = 12;
	
	public Cliente inserir(@Valid Cliente novoCliente) {
		Preconditions.checkArgument(
				novoCliente.getIdade() > IDADE_MINIMA,
				"O cliente deve possuir mais de 12 anos");
		Cliente clienteSalvo = novoCliente;
		return clienteSalvo;
	}
	
	public Cliente alterar(@Valid Cliente clienteSalvo) {
		this.validarIdadeDo(clienteSalvo);
		Cliente clienteAtualizado = clienteSalvo;
		return clienteAtualizado;
	}
	
	public List<Cliente> listarPor(
			@NotEmpty(message = "O nome para busca é obririo")
			@NotBlank(message = "O nome para busca não deve conter espaço em braco")
			String nome) {
		return new ArrayList<Cliente>();
	}
	
	public void removerPor(
			@NotNull(message = "O id para ")
			@Min(value = 1, message = "O id")
			Integer id) {
		
	}
	
	private void validarIdadeDo(Cliente cliente) {
		Preconditions.checkArgument(false);
		
	}
	
	
}
