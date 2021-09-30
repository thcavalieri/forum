package br.com.thiagocavalieri.forum.mapper;

import br.com.thiagocavalieri.forum.dto.TopicCreateDTO;
import br.com.thiagocavalieri.forum.dto.TopicDTO;
import br.com.thiagocavalieri.forum.dto.TopicDetailDTO;
import br.com.thiagocavalieri.forum.model.Topic;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {AnswerMapper.class})
public interface TopicMapper {
    TopicMapper MAPPER = Mappers.getMapper(TopicMapper.class);

    TopicDTO topicModelToDTO(Topic topic);

    @Mappings({
            @Mapping(source = "user.name", target = "userName")
    })
    TopicDetailDTO topicModelToTopicDetailDTO(Topic topic);

    @IterableMapping(elementTargetType = TopicMapper.class)
    List<TopicDTO> topicModelListToListDTO(List<Topic> topic);

    Topic topicRequestDTOToModel(TopicCreateDTO requestDTO);
}
