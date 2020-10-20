package sda.fitapp.entity;


import lombok.*;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    TagsType tagsType;
}
