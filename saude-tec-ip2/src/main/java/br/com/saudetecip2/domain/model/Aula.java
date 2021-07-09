package br.com.saudetecip2.domain.model;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.exceptions.AlunoJaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoEstaMarcadoNaAulaException;
import java.util.ArrayList;

@Entity
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@NotNull
	private LocalDateTime data;
	
	@NotNull
  	@Enumerated(EnumType.STRING)
	private TipoDeTreino tipoDeTreino;
	
	@NotNull
  	@Enumerated(EnumType.STRING)
	private TipoDeAula tipoDeAula;
	
	@NotNull
	private String professor_id;
	
	private ArrayList<Aluno> alunos;
	
	public Aula(String id,LocalDateTime data, TipoDeAula tipoDeAula, TipoDeTreino tipoDeTreino, String professor_id,
			ArrayList<Aluno> alunos) {
		this.data = data;
		this.tipoDeAula = tipoDeAula;
		this.tipoDeTreino = tipoDeTreino;
		this.professor_id = professor_id;
		this.alunos = alunos;
		this.id = id;
	}

	
	public Aula(LocalDateTime data, TipoDeAula tipoDeAula, TipoDeTreino tipoDeTreino, String professor_id,
			ArrayList<Aluno> alunos) {
		this.data = data;
		this.tipoDeAula = tipoDeAula;
		this.tipoDeTreino = tipoDeTreino;
		this.professor_id = professor_id;
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

	public String getProfessor() {
		return professor_id;
	}

	public void setProfessor(String professor_id) {
		this.professor_id = professor_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Aula) {
			Aula aulaParametro  = (Aula) obj;
			return this.data.compareTo(aulaParametro.getData() ) == 0 && this.professor_id.equals(aulaParametro.getProfessor());
		}
		return  false;
	}
}
