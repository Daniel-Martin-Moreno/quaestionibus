package es.senda.preguntas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.senda.preguntas.model.Convocatoria;
import es.senda.preguntas.model.Pregunta;
import es.senda.preguntas.model.Tema;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

	List<Pregunta> findByConvocatoria(Convocatoria convocatoria);

	Pregunta findByConvocatoriaAndNumero(Convocatoria convocatoria, int numero);

	@Query(value = "SELECT p.* FROM pregunta p inner join pregunta_tema pt on p.id_pregunta = pt.id_pregunta inner join tema t on pt.id_tema=t.id_tema where t.id_convocatoria = :idConvocatoria and t.numero = :numeroTema and t.parte = :parte order by t.id_convocatoria, p.numero", nativeQuery = true)
	List<Pregunta> findByIdConvocatoriaAndNumeroTemaAndParte(@Param("idConvocatoria") long idConvocatoria,
			@Param("numeroTema") int numeroTema, @Param("parte") String parte);

}