package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.ProducerRequest;
import by.pvt.musicproject.dto.ProducerResponse;
import by.pvt.musicproject.entity.Producer;
import org.mapstruct.Mapper;

@Mapper
public interface ProducerMapping {
    ProducerResponse toResponse(Producer producer);
    Producer toEntity(ProducerRequest producerRequest);

}
