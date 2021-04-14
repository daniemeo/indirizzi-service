package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.SvildepDto;
import it.sogei.svildep.indirizziservice.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public interface EntityToDtoMapper<E extends BaseEntity, D extends SvildepDto> {

    D mapEntityToDtoImpl(E entity);

    default D mapEntityToDto(E entity) {
        if (entity == null) return null;
        D dto = mapEntityToDtoImpl(entity);
      /*  dto.setUtenteAggiornamentoId(String.valueOf(entity.getIdUtenteAggiornamento()));
        dto.setUtenteInserimentoId(String.valueOf(entity.getIdUtenteInserimento()));
        dto.setTimestampAggiornamento(String.valueOf(entity.getTimestampAggiornamento()));
        dto.setTimestampInserimento(String.valueOf(entity.getTimestampInserimento()));*/
        return dto;
    }

    default List<D> mapEntityToDto(List<E> entities) {
        if (entities == null) return null;
        List<D> dtos = new ArrayList<>();
        for (E entity : entities) dtos.add(mapEntityToDto(entity));
        return dtos;
    }

}