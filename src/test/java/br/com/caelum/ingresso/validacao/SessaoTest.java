package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import junit.framework.Assert;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

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
}
