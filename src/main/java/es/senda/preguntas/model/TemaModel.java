package es.senda.preguntas.model;

import java.util.ArrayList;
import java.util.List;

public class TemaModel {

	public final Long idTema;
	public final Long idConvocatoria;
	public final String enunciado;
	public final int numero;
	public final String parte;

	public TemaModel (final Tema tema) {
		
		this.idTema = tema.getIdTema();
		this.idConvocatoria = tema.getConvocatoria().getIdConvocatoria();
		this.enunciado = tema.getEnunciado();
		this.numero = tema.getNumero();
		this.parte = tema.getParte();
	}
	
	public static List<TemaModel> toModel(List<Tema> temas){
		List<TemaModel> temasModel = new ArrayList<TemaModel>();
		for (Tema tema:temas) {
			temasModel.add(new TemaModel(tema));
		}
		return temasModel;
	}

}
