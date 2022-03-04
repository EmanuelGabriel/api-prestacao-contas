package br.com.emanuelgabriel.servidoresapi.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Data
@Document(collection = "unidade_gestora")
public class UnidadeGestoraCSV {

	@Id
	private String id;

	@Field(name = "id_unidade_gestora")
	private long idUnidadeGestora;

	@Field(name = "nome")
	private String nome;

	@Field(name = "esfera")
	private String esfera;

}
