package br.com.emanuelgabriel.servidoresapi.domain.repository.customers;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.PageImpl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @author emanuel.sousa
 * @since 25/02/2022
 *
 */

@JsonComponent
public class PageJson {

	public static class PageSerializer extends JsonSerializer<PageImpl<?>> {

		@Override
		public void serialize(PageImpl<?> page, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {

			jsonGenerator.writeStartObject();

			// FAZ A CUSTOMIZAÇÃO DO PAGE
			jsonGenerator.writeObjectField("itens", page.getContent()); // RETORNA O CONTÉUDO DA PÁGINA COMO LISTA/LIST
			jsonGenerator.writeNumberField("totalPaginas", page.getTotalPages()); // RETORNA O NÚMERODO TOTAL DE PÁGINAS
			jsonGenerator.writeNumberField("numeroDaPagina", page.getPageable().getPageNumber()); // NÚMERO DA PÁGINA
			jsonGenerator.writeNumberField("quantidadePorPagina", page.getSize()); // RETORNA O TAMANHO DE ITENS DO PAGE - QUANTIDADE POR PÁGINA
			jsonGenerator.writeObjectField("totalElementos", page.getTotalElements()); // RETORNA O TOTAL DE ELEMENTOS

			jsonGenerator.writeEndObject();

		}

	}

}
