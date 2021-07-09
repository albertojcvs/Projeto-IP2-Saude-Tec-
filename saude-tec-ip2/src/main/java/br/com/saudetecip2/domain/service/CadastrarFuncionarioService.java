package br.com.saudetecip2.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saudetecip2.database.arquivoimplentation.FuncionarioRepository;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.exceptions.FuncionarioJaExisteException;
import br.com.saudetecip2.exceptions.FuncionarioNaoExisteException;


public class CadastrarFuncionarioService {

	
	FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

	public void cadastrarFucionario(Funcionario funcionario) throws FuncionarioJaExisteException {
		Funcionario funcionarioExistente = funcionarioRepository.findByCpf(funcionario.getCpf());

		if (funcionarioExistente != null) {
			throw new FuncionarioJaExisteException();
		}
		funcionarioRepository.save(funcionario);

	}



	public void removerFuncionario(String id) throws FuncionarioNaoExisteException {
		Funcionario funcionarioParaRemover = funcionarioRepository.findById(id);

		if (funcionarioParaRemover == null) {
			throw new FuncionarioNaoExisteException();
		}

		funcionarioRepository.deleteById(id);

	}

	public void atualizarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
		Funcionario funcionarioParaAtualizar = funcionarioRepository.findById(funcionario.getId());

		if (funcionarioParaAtualizar == null) {
			throw new FuncionarioNaoExisteException();
		}

		funcionarioParaAtualizar = funcionario;
		funcionarioRepository.update(funcionarioParaAtualizar);
	}

	public List<Funcionario> buscarFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public List<Funcionario> buscarPorCargo(CargoFuncionario cargo) {
		return funcionarioRepository.findAllByCargo(cargo);
	}

}
