package br.com.thiagocavalieri.forum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Answer {

	@EqualsAndHashCode.Include
	private Long id;
	private String message;
	private Topic topic;
	private LocalDateTime dtCreation = LocalDateTime.now();
	private User author;
	private Boolean isSolution = false;

}
