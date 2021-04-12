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
@Table(name = "tema")
@EntityListeners(AuditingEntityListener.class)
public class Tema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tema")
	private Long idTema;

	@ManyToOne
	@JoinColumn(name = "id_convocatoria")
	private Convocatoria convocatoria;

	@Column(name = "descripcion")
	private String enunciado;

	@Column(name = "numero")
	private int numero;

	@Column(name = "parte")
	private String parte;

    @ManyToMany
    @JoinColumn(name="id_tema")
	private List<Pregunta> preguntas;
    
    @Transient
    private boolean embed=false;
    
	public Tema() {
		super();
	}

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long id) {
		this.idTema = id;
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

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
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
		Tema other = (Tema) obj;
		if (idTema == null) {
			if (other.idTema != null)
				return false;
		} else if (!idTema.equals(other.idTema))
			return false;
		return true;
	}
}
