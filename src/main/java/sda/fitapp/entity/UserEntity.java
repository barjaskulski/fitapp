package sda.fitapp.entity;

import lombok.*;
import sda.fitapp.ENUM.LifeStyle;
import sda.fitapp.ENUM.ServiceRoles;
import sda.fitapp.ENUM.UserSex;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;            //--- to be automatically generated
    private String userEmail;                               //--- login
    private String userPassword;                            //--- password
    private ServiceRoles serviceRoles;                      //--- to be assigned by admin after acc and payment verification
    private String firstName;                               //--- user defined after acc creation
    private String lastName;                                //--- user defined after acc creation
    private UserSex userSex;                                //--- user defined after acc creation
    private String userPhoneNumber;                         //--- user defined after acc creation
    private int userAge;                                    //--- user defined after acc creation
    private Double userHeight;                              //--- user defined after acc creation
    private Double userWeight;                              //--- user defined after acc creation
    private Double userCaloricDemand;                       //--- to be automatically calculated based on age/weight/lifestyle
    private Double userCaloricDeficit;                      //--- to be set by coach
    private LifeStyle lifeStyle;                            //--- user defined after acc creation
    private int userMealCount;                              //--- to be set by coach
    private boolean showQuestionnaire;

    public UserEntity(long userId, String userEmail, String userPassword, String firstName, String lastName, boolean showQuestionnaire) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.showQuestionnaire = showQuestionnaire;
    }

//    forTest
    public UserEntity(int i, String gmail, String s, ServiceRoles subscribedUser, String łukasz, String kozłowski, UserSex male, String s1, int i1, int i2, double v, int i3, LifeStyle middle) {

    }
}
