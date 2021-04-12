package es.senda.preguntas.model;


public class PreguntaForSaving {

	private Long idPregunta = null;
	private String comentarios = "";
	private String rutaImagen = "";
	
	public PreguntaForSaving() {
		super();
	}
	public Long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	

	

}
