package br.com.emanuelgabriel.servidoresapi.domain.mapper.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPrestacacaoContasCSVRequestDTO {

	private String nome;
	private String cpf;
	private String dataNascimento;
}
