package br.com.emanuelgabriel.servidoresapi.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.emanuelgabriel.servidoresapi.domain.entity.UnidadeGestoraCSV;
import br.com.emanuelgabriel.servidoresapi.domain.mapper.response.UnidadeGestoraCSVResponseDTO;

@Component
public class UnidadeGestoraCSVMapper implements EntityMapper<UnidadeGestoraCSVResponseDTO, UnidadeGestoraCSV> {

	@Autowired
	private ModelMapper mapper;

	@Override
	public UnidadeGestoraCSV toEntity(UnidadeGestoraCSVResponseDTO dto) {
		return mapper.map(dto, UnidadeGestoraCSV.class);
	}

	@Override
	public UnidadeGestoraCSVResponseDTO toDto(UnidadeGestoraCSV entity) {
		return mapper.map(entity, UnidadeGestoraCSVResponseDTO.class);
	}

	@Override
	public List<UnidadeGestoraCSV> toEntity(List<UnidadeGestoraCSVResponseDTO> dtoList) {
		return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public List<UnidadeGestoraCSVResponseDTO> toDto(List<UnidadeGestoraCSV> entityList) {
		return entityList.stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public Page<UnidadeGestoraCSVResponseDTO> mapEntityPageToDTO(Pageable pageable,
			Page<UnidadeGestoraCSV> pageEntity) {
		var listDto = toDto(pageEntity.getContent());
		return new PageImpl<>(listDto, pageable, pageEntity.getTotalElements());
	}

}
