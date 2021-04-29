package br.com.thiagocavalieri.forum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {

	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private String category;

}
