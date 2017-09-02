package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;
@Entity
public class Ingresso {
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
@Id
@GeneratedValue
private Integer id;
@ManyToOne
private Sessao sessao;
private BigDecimal preco;
@ManyToOne
private Lugar lugar;
@Enumerated(EnumType.STRING)
private TipoDeIngresso tipoDeIngresso;

public Sessao getSessao() {
	return sessao;
}
public BigDecimal getPreco() {
	return preco;
}
public Ingresso(){
	
}

public Lugar getLugar() {
	return lugar;
}
public void setLugar(Lugar lugar) {
	this.lugar = lugar;
}
public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
	this.sessao = sessao;
	this.setTipoDeIngresso(tipoDeIngresso);
	this.lugar = lugar;
	this.preco = this.getTipoDeIngresso().aplicaDesconto(sessao.getPreco());
}
public TipoDeIngresso getTipoDeIngresso() {
	return tipoDeIngresso;
}
public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
	this.tipoDeIngresso = tipoDeIngresso;
}

}
