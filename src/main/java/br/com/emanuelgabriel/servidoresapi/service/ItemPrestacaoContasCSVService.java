package br.com.emanuelgabriel.servidoresapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import br.com.emanuelgabriel.servidoresapi.domain.entity.ItemPrestacaoContasCSV;
import br.com.emanuelgabriel.servidoresapi.domain.mapper.ItemPrestacacaoContasCSVMapper;
import br.com.emanuelgabriel.servidoresapi.domain.mapper.response.ItemPrestacacaoContasCSVResponseDTO;
import br.com.emanuelgabriel.servidoresapi.domain.repository.ItemPrestacaoContasCSVRepository;
import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author emanuel.sousa
 *
 */

@Slf4j
@Service
public class ItemPrestacaoContasCSVService {

	@Autowired
	private ItemPrestacacaoContasCSVMapper mapper;
	
	@Autowired
	private ItemPrestacaoContasCSVRepository repository;
	
	@Autowired
	private MongoTemplate mt;
	
	public Page<ItemPrestacacaoContasCSVResponseDTO> buscarTodosPaginado(Pageable pageable){
		log.info("Buscar todos os dados paginados -> PageNumber: {}; PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
		var pageItemPrestacaoContasCSV = repository.findAll(pageable);
		return mapper.mapEntityPageToDTO(pageable, pageItemPrestacaoContasCSV);
	}
	
	
	public Long qtdItemPrestacaoContas() {
		var quantidade = repository.count();
		log.info("Quantidade de item de prestação de contas CSV {}", quantidade);
		return quantidade;
	}
	
	public Page<ItemPrestacacaoContasCSVResponseDTO> findAllMongoTemplateTESTE(String renavam, String cnpjCpf, Pageable pageable) {
		log.info("Buscar por Renavam: {}; CPF ou CNPJ: {};", renavam, cnpjCpf);
		
		Query query = new Query().addCriteria(Criteria.where("renavam").is(renavam).andOperator(Criteria.where("cnpjCpf").is(cnpjCpf)));
		
		var totalRegistro = mt.count(query.skip(0).limit(0), ItemPrestacaoContasCSV.class);
		
		var dadosQuery = mt.find(query, ItemPrestacaoContasCSV.class);
				
		var pageRetorno = PageableExecutionUtils.getPage(dadosQuery, pageable, () -> totalRegistro);
		
		return mapper.mapEntityPageToDTO(pageable, pageRetorno);
	}
	

	public Page<ItemPrestacacaoContasCSVResponseDTO> buscarPorNomeUnidadeGestora(String nome, Pageable pageable) {
		
		log.info("Buscar por nome da unidade gestora: {}; {};{}", nome, pageable.getPageNumber(), pageable.getPageSize());

		var query = new Query().addCriteria(Criteria.where("unidade_gestora.nome").is(nome)).with(pageable);
		
		var totalRegistro = mt.count(query.skip(0).limit(0), ItemPrestacaoContasCSV.class);
		
		var dadosQuery = mt.find(query.with(pageable), ItemPrestacaoContasCSV.class);
		
		var pageRetorno = PageableExecutionUtils.getPage(dadosQuery, pageable, () -> totalRegistro);
		
	    return mapper.mapEntityPageToDTO(pageable, pageRetorno);
	}
	
	/**
	 * @author emanuel.sousa
	 * @param renavam
	 * @param idItemPrestacaoContas
	 * @param referencia
	 * @param exercicio
	 * @param ano
	 * @return Page -> ItemPrestacacaoContasCSVResponseDTO
	 */
	public Page<ItemPrestacacaoContasCSVResponseDTO> buscarPor(String renavam, Integer idItemPrestacaoContas, String referencia, Integer exercicio, String modelo, String placa, Long ano, String esfera, String nomeUnidadeGestora, Pageable pageable){
		log.info("Buscar por Renavam:{}; IdItemPrestacaoContas:{}; Referencia: {}; Exercicio: {}; Modelo: {}; Placa: {}; Ano: {}: Esfera: {}", renavam, idItemPrestacaoContas, referencia, exercicio, modelo, placa, ano, esfera);

		var query = new Query().with(pageable);

		if (renavam != null) {
			query.addCriteria(Criteria.where("renavam").is(renavam));
		}

		if (idItemPrestacaoContas != null) {
			query.addCriteria(Criteria.where("idItemPrestacaoContas").is(idItemPrestacaoContas));
		}

		if (referencia != null) {
			query.addCriteria(Criteria.where("referencia").is(referencia));
		}

		if (exercicio != null) {
			query.addCriteria(Criteria.where("exercicio").is(exercicio));
		}

		if (modelo != null) {
			query.addCriteria(Criteria.where("modelo").is(modelo));
		}

		if (placa != null) {
			query.addCriteria(Criteria.where("placa").is(placa));
		}

		if (ano != null) {
			query.addCriteria(Criteria.where("ano").is(ano));
		}

		if (esfera != null) {
			query.addCriteria(Criteria.where("unidade_gestora.esfera").is(esfera));
		}

		if (nomeUnidadeGestora != null) {
			query.addCriteria(Criteria.where("unidade_gestora.nome").is(nomeUnidadeGestora));
		}

		var totalRegistro = mt.count(query.skip(0).limit(0), ItemPrestacaoContasCSV.class);

		var dadosQuery = mt.find(query.with(pageable), ItemPrestacaoContasCSV.class);

		var pageRetorno = PageableExecutionUtils.getPage(dadosQuery, pageable, () -> totalRegistro);

		return mapper.mapEntityPageToDTO(pageable, pageRetorno);
	}

}
