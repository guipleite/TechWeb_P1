package br.insper.noteblock;

import java.util.Calendar;

public class Notas implements java.lang.Comparable<Notas>{
	
	private Integer iduser;
	private Integer id;
	private String nome;
	private Calendar data;
	private String descri;
	private String tipo;
	
	
	public Integer getIduser() {
		return this.iduser;
		}
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
		}
	public Integer getId() {
		return this.id;
		}
	public void setId(Integer id) {
		this.id = id;
		}
	public String getNome() {
		return this.nome;
		}
	public void setNome(String nome) {
		this.nome = nome;
		}
	public Calendar getData() {
		return this.data;
		}
	public void setData(Calendar data) {
		this.data = data;
		}
	public String getDescri() {
		return this.descri;
		}
	public void setDescri(String descri) {
		this.descri = descri;
		}
	public String getTipo() {
		return this.tipo;
		}
	public void setTipo(String tipo) {
		this.tipo = tipo;
		}
	
	// Para ordenar notas criar um método de comparação
	  @Override
	  public int compareTo(Notas nota) {
		    return getData().compareTo(nota.getData());
		  }
	  

}
