package sda.fitapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
//@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name = "id")
    @Setter(AccessLevel.NONE)private int userId;            //--- to be automatically generated
    private String userEmail;                               //--- login
    private String userPassword;                            //--- password
    private ServiceRoles serviceRoles;                      //--- to be assigned by admin after acc and payment verification
    private String userName;                                //--- user defined after acc creation
    private String userSurname;                             //--- user defined after acc creation
    private UserSex userSex;                                //--- user defined after acc creation
    private String userPhoneNumber;                         //--- user defined after acc creation
    private int userAge;                                    //--- user defined after acc creation
    private long userHeight;                              //--- user defined after acc creation
    private Double userWeight;                              //--- user defined after acc creation
    private long userCaloricDeficit;                      //--- to be set by coach
    private LifeStyle lifeStyle;                            //--- user defined after acc creation


    public User() {
    }

    public User(int userId, String userEmail, String userPassword) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

}
