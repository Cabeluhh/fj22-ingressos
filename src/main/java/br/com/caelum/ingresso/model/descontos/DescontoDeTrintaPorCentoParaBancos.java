package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoDeTrintaPorCentoParaBancos implements Desconto {
 private BigDecimal desconto = new BigDecimal("0.3");
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal.subtract(precoOriginal.multiply(desconto));
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Desconto Banco";
	}

}
