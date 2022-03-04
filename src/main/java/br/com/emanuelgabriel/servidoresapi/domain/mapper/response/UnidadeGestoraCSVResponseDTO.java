package br.com.emanuelgabriel.servidoresapi.domain.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeGestoraCSVResponseDTO {

	private long idUnidadeGestora;
	private String nome;
	private String esfera;
}
