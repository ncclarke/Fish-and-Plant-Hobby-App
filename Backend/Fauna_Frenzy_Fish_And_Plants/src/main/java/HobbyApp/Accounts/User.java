package HobbyApp.Accounts;

import org.hibernate.annotations.NaturalId;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    //@ApiModelProperty(notes = "user id ", name = "id", required = true, value = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    @Column(name = "userName")
    private String userName;

    private String email;

    private boolean isActive;

    private int age;

    private String firstName;

    private String lastName;

    private String password;

    private String screenName;

    private boolean isAdmin;

    private boolean isBanned;

    private boolean isVerifiedUser;

    private boolean isExpert;

    private String profileDescription;

    private int numFishSpeciesOwned;

    private int numPlantSpeciesOwned;

    private int numFishSpeciesBreed;

    private int numPlantSpeciesPropagated;

    //basic signup
    public User(String firstName, String lastName, String userName, String password, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;

        this.screenName = userName;
        this.profileDescription = "";
        this.age = age;

        this.isActive = true;
        this.isAdmin = false;
        this.isBanned = false;
        this.isVerifiedUser = false;
        this.isExpert = false;

        this.numFishSpeciesOwned = 0;
        this.numFishSpeciesBreed = 0;
        this.numPlantSpeciesOwned = 0;
        this.numPlantSpeciesPropagated = 0;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean isVerifiedUser() {
        return isVerifiedUser;
    }

    public void setVerifiedUser(boolean verifiedUser) {
        isVerifiedUser = verifiedUser;
    }

    public boolean isExpert() {
        return isExpert;
    }

    public void setExpert(boolean expert) {
        isExpert = expert;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public int getNumFishSpeciesOwned() {
        return numFishSpeciesOwned;
    }

    public void setNumFishSpeciesOwned(int numFishSpeciesOwned) {
        this.numFishSpeciesOwned = numFishSpeciesOwned;
    }

    public int getNumPlantSpeciesOwned() {
        return numPlantSpeciesOwned;
    }

    public void setNumPlantSpeciesOwned(int numPlantSpeciesOwned) {
        this.numPlantSpeciesOwned = numPlantSpeciesOwned;
    }

    public int getNumFishSpeciesBreed() {
        return numFishSpeciesBreed;
    }

    public void setNumFishSpeciesBreed(int numFishSpeciesBreed) {
        this.numFishSpeciesBreed = numFishSpeciesBreed;
    }

    public int getNumPlantSpeciesPropagated() {
        return numPlantSpeciesPropagated;
    }

    public void setNumPlantSpeciesPropagated(int numPlantSpeciesPropagated) {
        this.numPlantSpeciesPropagated = numPlantSpeciesPropagated;
    }
}
