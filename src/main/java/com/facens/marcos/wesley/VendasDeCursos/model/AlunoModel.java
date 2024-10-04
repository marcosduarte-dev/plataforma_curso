package com.facens.marcos.wesley.VendasDeCursos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
	
	public List<CursosModel> cursos = new ArrayList<>();

	private int id;
	private String nome;
	private String RA;
	private LocalDate dataRenovacao = LocalDate.now();
	private float mensalidade;
	private boolean logado;
	private List<Integer> cursosAdicionais;
	
	public AlunoModel(int id, String nome, String ra, 
			LocalDate dataRenovacao, float mensalidade, boolean logado,
			List<Integer> cursosAdicionais) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataRenovacao = dataRenovacao;
		this.mensalidade = mensalidade;
		this.logado = logado;
		this.cursosAdicionais = cursosAdicionais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public LocalDate getDataRenovacao() {
		return dataRenovacao;
	}
	public void setDataRenovacao(LocalDate dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}
	public float getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}
	public boolean getLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public List<Integer> getCursosAdicionais() {
		return cursosAdicionais;
	}
	public void setCursosAdicionais(List<Integer> cursosAdicionais) {
		this.cursosAdicionais = cursosAdicionais;
	}
	
	public AlunoModel pagar() {
		if(this.getDataRenovacao().isBefore(LocalDate.now())) {
			this.setDataRenovacao(LocalDate.now().plusDays(30));
		} else {
			this.setDataRenovacao(this.getDataRenovacao().plusDays(30));
		}
		return this;
	}
	
	public AlunoModel logar() {
		this.setLogado(true);
		return this;
	}
	
	public List<CursosModel> getMeusCursosByAluno() throws Exception {
		List<CursosModel> retorno = new ArrayList<CursosModel>();
		
		if(this.getDataRenovacao().isBefore(LocalDate.now())) {
			throw new Exception("Sem acesso, por favor realize a renovacao da sua assinatura");
		}
		
		for (CursosModel curso : cursos) {
		    if (curso.isBasico()) {
		        retorno.add(curso);
		    } else if(this.getCursosAdicionais().contains(curso.getId())) {
		    	retorno.add(curso);
		    }
		}
		
		return retorno;
	}
	
	public boolean comprarCurso(int cursoId) {
		CursosModel curso = cursos.get(cursoId);
		
		this.getCursosAdicionais().add(cursoId);
		this.setMensalidade(this.getMensalidade() + curso.getPreco());
		
		return true;
	}
}
