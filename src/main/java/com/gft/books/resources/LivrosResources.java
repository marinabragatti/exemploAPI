package com.gft.books.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.books.domain.Comentario;
import com.gft.books.domain.Livro;
import com.gft.books.service.LivrosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Livros")
@RestController
@RequestMapping("/livros")
public class LivrosResources {

	@Autowired
	private LivrosService livrosService;
	
	@ApiOperation("Lista os livros")
	@RequestMapping
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
	}
	
	@ApiOperation("Salva um novo livro")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Livro livro) {
		livro = livrosService.salvar(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Busca um livro pelo ID")
	@RequestMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable ("id") Long id) {
		Livro livro = livrosService.buscar(id);
		CacheControl cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livro);
	}
	
	@ApiOperation("Deleta um livro pelo ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable ("id") Long id) {
		livrosService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Atualiza um livro pelo ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable ("id") Long id) {
		livro.setId(id);
		livrosService.atualizar(livro);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Adiciona um comentário")
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
	public ResponseEntity<Void> addComentario(@PathVariable ("id") Long livroId, @RequestBody Comentario comentario) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//comentario.setUsuario(auth.getName());
		livrosService.salvarComentario(livroId, comentario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Lista os comentários")
	@RequestMapping("/{id}/comentarios")
	public ResponseEntity<List<Comentario>> listarComentario(@PathVariable ("id") Long livroId){
		List<Comentario> comentarios = livrosService.listarComentario(livroId);
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
}
