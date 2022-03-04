package br.com.emanuelgabriel.servidoresapi.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.emanuelgabriel.servidoresapi.domain.entity.ItemPrestacaoContasCSV;

/**
 * 
 * @author emanuel.sousa
 *
 */

public interface ItemPrestacaoContasCSVRepository extends MongoRepository<ItemPrestacaoContasCSV, String> {

	Page<ItemPrestacaoContasCSV> findAll(Pageable pageable);

	Page<ItemPrestacaoContasCSV> findByRenavamOrCnpjCpf(String renavam, String cnpjCpf, Pageable pageable);
	

}