package es.senda.preguntas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.senda.preguntas.model.Pregunta;
import es.senda.preguntas.model.PreguntaModel;
import es.senda.preguntas.model.Tema;
import es.senda.preguntas.model.TemaModel;
import es.senda.preguntas.repository.PreguntaRepository;
import es.senda.preguntas.repository.TemaRepository;

@RestController()
public class TemaController {

	@Autowired
	TemaRepository temaRepository;

	@Autowired
	PreguntaRepository preguntaRepository;

	@GetMapping("/temas")
	public ResponseEntity getTemas() {
		List<Tema> temas = temaRepository.findAll();
		return new ResponseEntity(TemaModel.toModel(temas), HttpStatus.OK);
	}

	@GetMapping("/temas/{id}")
	public ResponseEntity getTema(@PathVariable(value = "id") Long id, @RequestParam(value = "embed", defaultValue = "false") String embed) {

		Tema tema = temaRepository.findOne(id);
		if (embed!=null&&embed.equals("true"))
			tema.setEmbed(true);
		return new ResponseEntity<TemaModel>(
				new TemaModel(tema), HttpStatus.OK);
	}
	
	@GetMapping("/temas/{id}/preguntas")
	public ResponseEntity getPreguntasDeTema(@PathVariable(value = "id") Long id) {
		Tema tema = temaRepository.getOne(id);
		List<Pregunta> preguntas = tema.getPreguntas();
		return new ResponseEntity(PreguntaModel.toModel(preguntas), HttpStatus.OK);
	}
	
	
	
}
