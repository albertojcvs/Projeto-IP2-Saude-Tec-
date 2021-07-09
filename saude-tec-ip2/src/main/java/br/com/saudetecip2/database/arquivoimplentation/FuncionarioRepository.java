package br.com.saudetecip2.database.arquivoimplentation;

import java.util.ArrayList;
import java.util.List;

import br.com.saudetecip2.database.Repository;
import br.com.saudetecip2.database.databasearquivo.ArquivoFuncionario;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;

public class FuncionarioRepository implements Repository<Funcionario> {
	ArquivoFuncionario arquivoTexto = new ArquivoFuncionario();

	public void deleteById(String id) {
		List<Funcionario> funcionarios = arquivoTexto.lerDados();
		int index = 0;
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId().equals(id)) {
				funcionarios.remove(index);
				break;
			}

			index++;
			continue;
		}

		arquivoTexto.gravarDados(funcionarios);

	}

	public List<Funcionario> findAll() {
		return arquivoTexto.lerDados();
	}

	public Funcionario findById(String id) {
		List<Funcionario> funcionarios = arquivoTexto.lerDados();
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId().equals(id)) {
				return funcionario;
			}
		}

		return null;
	}

	public void save(Funcionario funcionario) {
		List<Funcionario> funcionarios = arquivoTexto.lerDados();

		int ultimoIndex = funcionarios.size() - 1;
		Funcionario ultimoFuncionarioNoArray =  ultimoIndex < 0 ? null:funcionarios.get(ultimoIndex);
		String id = funcionarios.size() == 0? String.valueOf(1):String.valueOf(Integer.valueOf(ultimoFuncionarioNoArray.getId()) + 1);
		funcionario.setId(id);
		arquivoTexto.gravarDado(funcionario);
	}

	public void update(Funcionario funcionarioParametro) {
		List<Funcionario> funcionarios = arquivoTexto.lerDados();
		int index = 0;
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(funcionarioParametro.getCpf())) {
				funcionarios.set(index, funcionarioParametro);
				arquivoTexto.gravarDados(funcionarios);
				break;
			}
			index++;
			continue;
		}

	}

	public Funcionario findByCpf(String cpf) {
		List<Funcionario> funcionarios = arquivoTexto.lerDados();
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf)) {
				return funcionario;
			}
		}

		return null;
	}

	public List<Funcionario> findAllByCargo(CargoFuncionario cargo) {
		List<Funcionario> todosFuncionarios = arquivoTexto.lerDados();
		List<Funcionario> funcionariosNoCargo = new ArrayList<Funcionario>();
		for (Funcionario funcionario : todosFuncionarios) {
			if (funcionario.getCargo().equals(cargo)) {
			funcionariosNoCargo.add(funcionario);
			}
		}
		return funcionariosNoCargo;
	}
	
	public Funcionario findByCpfAndSenha(String cpf, String senha) {
		
		List<Funcionario> funcionarios = arquivoTexto.lerDados();
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf) && funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}
		return null;
	}
}
