package br.com.thiagocavalieri.forum.mapper;

import br.com.thiagocavalieri.forum.dto.TopicDTO;
import br.com.thiagocavalieri.forum.dto.TopicRequestDTO;
import br.com.thiagocavalieri.forum.model.Topic;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TopicMapper {
    TopicMapper MAPPER = Mappers.getMapper(TopicMapper.class);

    TopicDTO topicModelToDTO(Topic topic);

    @IterableMapping(elementTargetType = TopicMapper.class)
    List<TopicDTO> topicModelListToListDTO(List<Topic> topic);

    Topic topicRequestDTOToModel(TopicRequestDTO requestDTO);
}
