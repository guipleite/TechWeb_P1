package br.insper.noteblock;

import java.util.Calendar;

public class Notas {
	
	
	private Integer id;
	private String nome;
	private Calendar data;
	private String descri;
	
	
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

}
