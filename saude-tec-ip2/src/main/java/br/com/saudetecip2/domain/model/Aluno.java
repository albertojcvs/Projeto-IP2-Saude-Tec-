package br.com.saudetecip2.domain.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;

@Entity
public class Aluno extends Pessoa {

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno;

	@NotNull
	private String senha;

	public Aluno() {
	}

	public Aluno(String id, StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno, String nome, String cpf,
			LocalDate dataDeNascimento, String senha) {
		super(id,nome, cpf, dataDeNascimento);
		this.senha = senha;
		this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
	}
	public Aluno(StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno, String nome, String cpf,
			LocalDate dataDeNascimento, String senha) {
		super(nome, cpf, dataDeNascimento);
		this.senha = senha;
		this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
	}

	public StatusDaMensalidadeDoAluno getStatusDaMensalidade() {
		return statusDaMensalidadeDoAluno;
	}

	public void setStatusDaMensalidade(StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno) {
		this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Aluno) {
			Aluno alunoParametro = (Aluno) obj;

			return alunoParametro.getCpf() == this.getCpf();
		}
		return false;
	}

}
