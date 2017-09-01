package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.descontos.DescontoDeTrintaPorCentoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoEstudante;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public class DescontoTest {
	
@Test
public void DeveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos(){
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI",
			new BigDecimal("12"));
	Sala sala = new Sala("", new BigDecimal("20.5"));
	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	Ingresso ingresso = new Ingresso(sessao, new DescontoDeTrintaPorCentoParaBancos());
	BigDecimal precoEsperado = new BigDecimal("22.75");
	Assert.assertEquals(precoEsperado, ingresso.getPreco());
}
@Test
public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante(){
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI",
			new BigDecimal("12"));
	Sala sala = new Sala("", new BigDecimal("20.5"));
	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	Ingresso ingresso = new Ingresso(sessao, new DescontoEstudante());
	BigDecimal precoEsperado = new BigDecimal("16.25");
	Assert.assertEquals(precoEsperado, ingresso.getPreco());
}
@Test
public void naoDeveConcederDescontoParaIngressoNormal(){
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI",
			new BigDecimal("12"));
	Sala sala = new Sala("", new BigDecimal("20.5"));
	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
	BigDecimal precoEsperado = new BigDecimal("32.5");
	Assert.assertEquals(precoEsperado, ingresso.getPreco());
}

}
