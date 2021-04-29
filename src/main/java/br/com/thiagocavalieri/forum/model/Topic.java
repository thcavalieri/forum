package br.com.thiagocavalieri.forum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Topic {

	@EqualsAndHashCode.Include
	private Long id;
	private String title;
	private String message;
	private LocalDateTime dtCreation = LocalDateTime.now();
	private TopicStatus status = TopicStatus.NOT_ANSWERED;
	private User author;
	private Course course;
	private List<Answer> answers = new ArrayList<>();

}
