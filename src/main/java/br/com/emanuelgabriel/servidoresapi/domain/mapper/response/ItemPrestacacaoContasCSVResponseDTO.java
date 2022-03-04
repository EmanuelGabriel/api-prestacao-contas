package br.com.emanuelgabriel.servidoresapi.domain.mapper.response;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPrestacacaoContasCSVResponseDTO {

	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dataCarga;
	private UnidadeGestoraCSVResponseDTO unidadeGestora;
	private int idItemPrestacaoContas;
	private String referencia;
	private int exercicio;
	private String modelo;
	private String usuario;
	private Integer ano;
	private String cnpjCpf;
	private String nomeLocador;
	private String localizacao;
	private String placa;
	private String renavam;
	private String tipoCombustivel;

}
