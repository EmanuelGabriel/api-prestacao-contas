package br.com.emanuelgabriel.servidoresapi.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Data
@Document(collection = "item_prestacao_contas_csv")
public class ItemPrestacaoContasCSV {

	@Id
	private String id;

	@Field(name = "data_carga")
	private String dataCarga;

	@Field(name = "unidade_gestora")
	@DBRef
	private UnidadeGestoraCSV unidadeGestora;

	@Field(name = "id_item_prestacao_contas")
	private Integer idItemPrestacaoContas;

	@Field(name = "referencia")
	private String referencia;

	@Field(name = "exercicio")
	private int exercicio;

	@Field(name = "usuario")
	private String usuario;

	@Field(name = "modelo")
	private String modelo;

	@Field(name = "placa")
	private String placa;

	@Field(name = "renavam")
	private String renavam;

	@Field(name = "ano")
	private Long ano;

	@Field(name = "tipo_combustivel")
	private String tipoCombustivel;

	@Field(name = "cnpj_cpf")
	private String cnpjCpf;

	@Field(name = "nome_locador")
	private String nomeLocador;

	@Field(name = "localizacao")
	private String localizacao;

}
