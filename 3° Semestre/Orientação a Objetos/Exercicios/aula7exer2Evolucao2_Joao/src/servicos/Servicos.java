package servicos;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import validacao.Validacao;

public class Servicos {
	public static void registraPintor (Galeria galeria) {
		galeria.setPintor(new Pintor(
			Validacao.validaNome("Determine o nome do Pintor:", "Registra Pintor"), 
			Validacao.validaCodigoPessoal(galeria, "Determine o codigo do Pintor:", "Registra Pintor"), 
			Validacao.validaAno("Determine o ano de nascimento do pintor:", "Registra Pintor")
		));
	}
	
	public static void registraQuadro (Galeria galeria) {
		Pintor pintor = galeria.getListaPintores(Validacao.validaCodigoPintor(galeria, "Determine o codigo do Pintor responsavel pelo quadro:", "Registra Quadro"));
		pintor.setListaQuadros((new Quadro(
			Validacao.validaCodigoQuadro(galeria, "Determine o codigo do Quadro:", "Registra Quadro"), 
			Validacao.validaPreco("Determine o preco do quadro: [0 caso tenha sido doado]", "Registra Quadro"), 
			Validacao.validaAnoCompra("Determine o ano da compra do quadro:", "Registra Quadro", pintor)
		)));
	}
}
