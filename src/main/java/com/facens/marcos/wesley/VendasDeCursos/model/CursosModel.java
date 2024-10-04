package com.facens.marcos.wesley.VendasDeCursos.model;

public class CursosModel {

	private int id;
	private String titulo;
	private int qtdeAulas;
	private boolean isBasico;
	private float preco;
	
	public CursosModel() {
	}
	
	public CursosModel(int id, String titulo, int qtdeAulas, boolean isBasico, float preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.qtdeAulas = qtdeAulas;
		this.isBasico = isBasico;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getQtdeAulas() {
		return qtdeAulas;
	}
	public void setQtdeAulas(int qtdeAulas) {
		this.qtdeAulas = qtdeAulas;
	}
	
	public boolean isBasico() {
		return isBasico;
	}
	public void setBasico(boolean isBasico) {
		this.isBasico = isBasico;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
