package br.com.thiagocavalieri.forum.mapper;

import br.com.thiagocavalieri.forum.dto.AnswerDTO;
import br.com.thiagocavalieri.forum.model.Answer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface AnswerMapper {

    @Mappings({
            @Mapping(source = "user.name", target = "userName")
    })
    AnswerDTO answerModelToDTO(Answer answer);

    @IterableMapping(elementTargetType = AnswerMapper.class)
    List<AnswerDTO> answerModelListToListDTO(List<Answer> listAnswer);

}
