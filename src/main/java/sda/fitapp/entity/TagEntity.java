package sda.fitapp.entity;


import lombok.*;
import sda.fitapp.ENUM.TagsType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@SequenceGenerator(name = "tag_id")
public class TagEntity {
    @Id
    @GeneratedValue
    long id;
    String name;
    @Enumerated(EnumType.STRING)
    TagsType tagsType;
}
