package com.nelioalves.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.dto.CategoriaDTO;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria categoria = categoriaService.find(id);
		return ResponseEntity.ok().body(categoria);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO dto) {
		Categoria categoria = categoriaService.fromDTO(dto);
		categoria = categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO dto, @PathVariable Integer id){
		Categoria categoria = categoriaService.fromDTO(dto);
		categoria.setId(id);
		categoria = categoriaService.update(categoria);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> categorias = categoriaService.findAll();
		List<CategoriaDTO> categoriasDTO = categorias.stream()
				.map(CategoriaDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriasDTO);	
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome" )String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Categoria> categorias = categoriaService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> categoriasDTO = categorias.map(CategoriaDTO::new);
		return ResponseEntity.ok().body(categoriasDTO);	
	}
}
