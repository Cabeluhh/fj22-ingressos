package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import junit.framework.Assert;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class SessaoTest {
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI",
				new BigDecimal("13.0"));
		Sala sala = new Sala("", new BigDecimal("25.5"));
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco()); 
		Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
	}
	@Test
	public void garanteQueOLugarA1EstaOcupadoEosLugaresA2EA3Disponiveis(){
		Lugar a1 = new Lugar("A",1);
		Lugar a2 = new Lugar("A",2);
		Lugar a3 = new Lugar("A",3);
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI",
				new BigDecimal("13.0"));
		Sala eldorado7 = new Sala("Eldorado 7", new BigDecimal("25.5"));
		Sessao sessao = new Sessao(LocalTime.now(), filme, eldorado7);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, a1);
		Set<Ingresso> ingressos = Stream.of(ingresso).collect(Collectors.toSet());
		sessao.setIngressos(ingressos);
		Assert.assertFalse(sessao.isDisponivel(a1));
		Assert.assertTrue(sessao.isDisponivel(a2));
		Assert.assertTrue(sessao.isDisponivel(a3));
	
	}
}
