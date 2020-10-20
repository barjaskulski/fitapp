package sda.fitapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

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

    public User(long userId, String userEmail, String userPassword, String firstName, String lastName, boolean showQuestionnaire) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.showQuestionnaire = showQuestionnaire;
    }
}
