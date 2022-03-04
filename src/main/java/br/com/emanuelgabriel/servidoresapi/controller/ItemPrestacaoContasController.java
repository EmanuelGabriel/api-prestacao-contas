package br.com.emanuelgabriel.servidoresapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanuelgabriel.servidoresapi.domain.mapper.response.ItemPrestacacaoContasCSVResponseDTO;
import br.com.emanuelgabriel.servidoresapi.service.ItemPrestacaoContasCSVService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Slf4j
@RestController
@RequestMapping(value = "/v1/item-prestacao-contas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemPrestacaoContasController {

	@Autowired
	private ItemPrestacaoContasCSVService service;

	@GetMapping(value = "quantidade")
	public ResponseEntity<Long> buscarQuantidadeItemPrestacaoContas() {
		log.info("GET /v1/item-prestacao-contas/quantidade");
		var qtd = service.qtdItemPrestacaoContas();
		return qtd != null ? ResponseEntity.ok().body(qtd) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<ItemPrestacacaoContasCSVResponseDTO>> buscarTodosPaginado(
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
		log.info("GET /v1/item-prestacao-contas -> PageNumber: {};PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
		var itensPaginado = service.buscarTodosPaginado(pageable);
		return itensPaginado != null ? ResponseEntity.ok().body(itensPaginado) : ResponseEntity.ok().build();
	}
	
	
	@GetMapping(value = "teste/{renavam}/{cnpjCpf}")
	public ResponseEntity<Page<ItemPrestacacaoContasCSVResponseDTO>> findAllTESTE(
			@PathVariable String renavam, 
			@PathVariable String cnpjCpf, 
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
		log.info("GET /v1/item-prestacao-contas/teste/{}/{}", renavam, cnpjCpf);
		var lista = service.findAllMongoTemplateTESTE(renavam, cnpjCpf, pageable);
		return lista != null ? ResponseEntity.ok().body(lista) : ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/nome-unidade-gestora")
	public ResponseEntity<Page<ItemPrestacacaoContasCSVResponseDTO>> buscarUnidadeGestoraPorNome(
			@RequestParam(value = "nome") String nome, 
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
		log.info("GET /v1/item-prestacao-contas/nome-unidade-gestora -> {};{};{}", nome, pageable.getPageNumber(), pageable.getPageSize());
		var pageLista = service.buscarPorNomeUnidadeGestora(nome, pageable);
		return pageLista != null ? ResponseEntity.ok().body(pageLista) : ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/filtrar-por")
	public ResponseEntity<Page<ItemPrestacacaoContasCSVResponseDTO>> buscarPor(
			@RequestParam(value = "renavam", required = false) String renavam, 
			@RequestParam(value = "idItemPrestacaoContas", required = false) Integer idItemPrestacaoContas, 
			@RequestParam(value = "referencia", required = false) String referencia, 
			@RequestParam(value = "exercicio", required = false) Integer exercicio, 
			@RequestParam(value = "ano", required = false) Long ano,
			@RequestParam(value = "modelo", required = false) String modelo,
			@RequestParam(value = "placa", required = false) String placa,
			@RequestParam(value = "esfera", required = false) String esfera,
			@RequestParam(value = "nomeUnidadeGestora", required = false) String nomeUnidadeGestora,
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
		log.info("GET /v1/item-prestacao-contas/teste/filtrar-por -> {};{};{};{};{};{};{};{}", renavam, idItemPrestacaoContas, referencia, exercicio, modelo, placa, ano, esfera, nomeUnidadeGestora, pageable.getPageNumber(), pageable.getPageSize());
		var pageLista = service.buscarPor(renavam, idItemPrestacaoContas, referencia, exercicio, modelo, placa, ano, esfera, nomeUnidadeGestora, pageable);
		return pageLista != null ? ResponseEntity.ok().body(pageLista) : ResponseEntity.ok().build();
	}

}
