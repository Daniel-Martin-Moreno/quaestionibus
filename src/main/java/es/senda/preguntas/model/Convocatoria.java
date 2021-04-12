package es.senda.preguntas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "convocatoria")
@EntityListeners(AuditingEntityListener.class)
public class Convocatoria implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_convocatoria")
    private Long idConvocatoria;
    
    @Column(name="tipo")
    private String tipo;
    
    @Column(name="anyo_oep")
    private int anyoOep;
    
    @Column(name="anyo_examen")
    private int anyoExamen;
    
    @Column(name="origen")
    private String origen;
    
    @Column(name="num_plazas")
    private int numPlazas;
    
    @Column(name="url")
    private String url;
    
    @Column(name="modalidad")
    private String modalidad;
    
    @OneToMany(mappedBy="convocatoria")
    private List<Pregunta> preguntas;
    
    @OneToMany(mappedBy="convocatoria")
    private List<Tema> temas;

	public Convocatoria() {
		super();
	}

	public Long getIdConvocatoria() {
		return idConvocatoria;
	}

	public void setIdConvocatoria(Long id) {
		this.idConvocatoria = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAnyoOep() {
		return anyoOep;
	}

	public void setAnyoOep(int anyoOep) {
		this.anyoOep = anyoOep;
	}

	public int getAnyoExamen() {
		return anyoExamen;
	}

	public void setAnyoExamen(int anyoExamen) {
		this.anyoExamen = anyoExamen;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convocatoria other = (Convocatoria) obj;
		if (idConvocatoria == null) {
			if (other.idConvocatoria != null)
				return false;
		} else if (!idConvocatoria.equals(other.idConvocatoria))
			return false;
		return true;
	}
	
	
}
