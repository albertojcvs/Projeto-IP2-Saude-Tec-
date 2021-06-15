package br.com.saudetecip2.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.exceptions.AlunoJaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoEstaMarcadoNaAulaException;

public class Aula {

	private Long id;
	private LocalDateTime data;
	private TipoDeTreino tipoDeTreino;
	private TipoDeAula tipoDeAula;
	private Funcionario professor;
	private ArrayList<Aluno> alunos;

	public Aula(LocalDateTime data, TipoDeAula tipoDeAula, TipoDeTreino tipoDeTreino, Funcionario professor,
			ArrayList<Aluno> alunos) {
		this.data = data;
		this.tipoDeAula = tipoDeAula;
		this.tipoDeTreino = tipoDeTreino;
		this.professor = professor;
		this.alunos = alunos;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void adicionarAluno(Aluno aluno) throws AlunoJaMarcadoNaAulaException {

		if (this.alunos.contains(aluno)) {
			throw new AlunoJaMarcadoNaAulaException();
		}
		this.alunos.add(aluno);
	}

	public void removerAluno(Aluno aluno) throws AlunoNaoEstaMarcadoNaAulaException {
		if (!this.alunos.contains(aluno)) {
			throw new AlunoNaoEstaMarcadoNaAulaException(aluno);
		}
		this.alunos.remove(aluno);

	}

	public Funcionario getProfessor() {
		return professor;
	}

	public void setProfessor(Funcionario professor) {
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public TipoDeTreino getTipoDeTreino() {
		return tipoDeTreino;
	}

	public void setTipoDeTreino(TipoDeTreino tipoDeTreino) {
		this.tipoDeTreino = tipoDeTreino;
	}

	public TipoDeAula getTipoDeAula() {
		return tipoDeAula;
	}

	public void setTipoDeAula(TipoDeAula tipoDeAula) {
		this.tipoDeAula = tipoDeAula;
	}
}
