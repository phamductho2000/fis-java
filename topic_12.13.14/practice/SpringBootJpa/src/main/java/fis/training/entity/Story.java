package fis.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int storyId;

	@Column(name = "story_name")
	private String storyName;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "book_id")
//	@JsonBackReference
//	private Book book;

}
