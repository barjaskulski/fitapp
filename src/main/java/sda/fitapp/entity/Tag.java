package sda.fitapp.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@SequenceGenerator(name = "tag_id")
public class Tag {
    @Id
    @GeneratedValue
    long id;
    String name;
    TagsType tagsType;
}
