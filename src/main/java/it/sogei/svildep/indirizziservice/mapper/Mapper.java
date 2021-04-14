package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.SvildepDto;
import it.sogei.svildep.indirizziservice.model.BaseEntity;

public interface Mapper<E extends BaseEntity, D extends SvildepDto> extends EntityToDtoMapper<E, D>, DtoToEntityMapper<E, D> {

}
