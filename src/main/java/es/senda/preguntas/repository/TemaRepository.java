package es.senda.preguntas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.senda.preguntas.model.Convocatoria;
import es.senda.preguntas.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	Tema findByConvocatoriaAndNumeroAndParte(Convocatoria convocatoria, int numero, String parte);

}