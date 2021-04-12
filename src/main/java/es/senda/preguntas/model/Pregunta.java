package es.senda.preguntas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pregunta")
@EntityListeners(AuditingEntityListener.class)
public class Pregunta implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_pregunta")
    private Long idPregunta;
    
    @ManyToOne
    @JoinColumn(name="id_convocatoria")
    private Convocatoria convocatoria;
    
    @Column(name="enunciado")
    private String enunciado;

    @Column(name="respuesta1")
    private String respuesta1;

    @Column(name="respuesta2")
    private String respuesta2;

    @Column(name="respuesta3")
    private String respuesta3;

    @Column(name="respuesta4")
    private String respuesta4;

    @Column(name="comentarios")
    private String comentarios;

    @Column(name="solucion")
    private int solucion;

    @Column(name="anulada", columnDefinition = "TINYINT(1)")
    private boolean anulada;
    
    @OneToOne
    @JoinColumn(name="id_pregunta_ref")
    private Pregunta preguntaRef;
    
    @OneToOne(mappedBy="preguntaRef")
    private Pregunta preguntaWithRef;

    @Column(name="numero")
    private int numero;

    @Column(name="parte")
    private String parte;
    
    @Column(name="ruta_imagen")
    private String rutaImagen;
    
    @ManyToMany
	@JoinTable(name = "pregunta_tema", joinColumns = { @JoinColumn(name = "id_pregunta") }, inverseJoinColumns = {
			@JoinColumn(name = "id_tema") })
    private List<Tema> temas;
    
    @Transient
    private boolean embed=false;

	public Pregunta() {
		super();
	}

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long id) {
		this.idPregunta = id;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public String getRespuesta4() {
		return respuesta4;
	}

	public void setRespuesta4(String respuesta4) {
		this.respuesta4 = respuesta4;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public int getSolucion() {
		return solucion;
	}

	public void setSolucion(int solucion) {
		this.solucion = solucion;
	}

	public boolean isAnulada() {
		return anulada;
	}

	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}

	public Pregunta getPreguntaRef() {
		return preguntaRef;
	}

	public void preguntaRef(Pregunta preguntaRef) {
		this.preguntaRef = preguntaRef;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getParte() {
		return parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public Pregunta getPreguntaWithRef() {
		return preguntaWithRef;
	}

	public void setPreguntaWithRef(Pregunta preguntaWithRef) {
		this.preguntaWithRef = preguntaWithRef;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public boolean isEmbed() {
		return embed;
	}

	@Transient
	public void setEmbed(boolean embed) {
		this.embed = embed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pregunta other = (Pregunta) obj;
		if (idPregunta == null) {
			if (other.idPregunta != null)
				return false;
		} else if (!idPregunta.equals(other.idPregunta))
			return false;
		return true;
	}

}
