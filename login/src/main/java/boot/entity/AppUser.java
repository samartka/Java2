package boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "app_user", uniqueConstraints = { @UniqueConstraint(name = "app_user_uk", columnNames = "user_name")})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "user_name", length = 36, nullable = false)
    private String userName;
    @Column(name = "encrypted_password", length = 128, nullable = false)
    private String encryptedPassword;
    @Column(name = "firstname", length = 255, nullable = true)
    private String firstName;
    @Column(name = "lastname", length = 255, nullable = true)
    private String lastName;
    @Column(name = "email", length = 255, nullable = true)
    private String email;
    @Column(name = "birth_date", length = 255, nullable = true)
    private String birthDate;
    @Column(name = "gender", length = 255, nullable = true)
    private String gender;
    @Column(name = "enabled", length = 1, nullable = false)
    @JsonIgnore
    private boolean enabled;

    public AppUser() {
    
    }

    public AppUser(String userName, String encryptedPassword, String firstName, String lastName, String email, String birthDate, String gender ) {
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.enabled = true;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @JsonIgnore
    public String getEncrytedPassword() {
        return encryptedPassword;
    }
    public void setEncrytedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}