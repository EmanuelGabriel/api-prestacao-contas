package br.com.emanuelgabriel.servidoresapi.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.emanuelgabriel.servidoresapi.domain.entity.ItemPrestacaoContasCSV;
import br.com.emanuelgabriel.servidoresapi.domain.mapper.response.ItemPrestacacaoContasCSVResponseDTO;

/**
 * 
 * @author emanuel.sousa
 * @see 20/01/2022
 * @serial 1.0
 *
 */

@Component
public class ItemPrestacacaoContasCSVMapper implements EntityMapper<ItemPrestacacaoContasCSVResponseDTO, ItemPrestacaoContasCSV> {

	@Autowired
	private ModelMapper mapper;

	@Override
	public ItemPrestacaoContasCSV toEntity(ItemPrestacacaoContasCSVResponseDTO dto) {
		return mapper.map(dto, ItemPrestacaoContasCSV.class);
	}

	@Override
	public ItemPrestacacaoContasCSVResponseDTO toDto(ItemPrestacaoContasCSV entity) {
		return mapper.map(entity, ItemPrestacacaoContasCSVResponseDTO.class);
	}

	@Override
	public List<ItemPrestacaoContasCSV> toEntity(List<ItemPrestacacaoContasCSVResponseDTO> dtoList) {
		return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public List<ItemPrestacacaoContasCSVResponseDTO> toDto(List<ItemPrestacaoContasCSV> entityList) {
		return entityList.stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public Page<ItemPrestacacaoContasCSVResponseDTO> mapEntityPageToDTO(Pageable pageable, Page<ItemPrestacaoContasCSV> pageEntity) {
		var listDto = toDto(pageEntity.getContent());
		return new PageImpl<>(listDto, pageable, pageEntity.getTotalElements());
	}

}
