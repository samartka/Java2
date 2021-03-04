package boot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.entity.AppUser;
import boot.entity.AppUserJoined;
import boot.entity.UserRole;
import boot.entity.AppRole;
import boot.repository.AppUserRepository;
import boot.repository.AppRoleRepository;
import boot.repository.AppUserJoinedRepository;
import boot.repository.UserRoleRepository;
import boot.util.PasswordUtil;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserJoinedRepository appUserJoinedRepository;

    public String registerAndValidation(String username, String password, String confirmPassword, String firstname, String lastname, String email, String confirmEmail, String birthDay, String birthMonth, String birthYear, String gender) {
        String errorMessage = "";

        if ( !password.equals(confirmPassword) )
            errorMessage += "Password mismatched!<br>";
        
        if ( !email.equals(confirmEmail) )
            errorMessage += "Email mismatched!<br>";

        String birthDayDatabaseFormat = birthYear + "-" + birthMonth + "-" + birthDay;
        if (errorMessage.equals("")) { // no error
            try {
                String encryptedPassword = PasswordUtil.encryptPassword(password);
                createUser(username, encryptedPassword, firstname, lastname, email, birthDayDatabaseFormat, gender);
            } catch (Exception ex) {
                errorMessage += ex.getMessage();
            }
        }

        return errorMessage;
    }
    public void createUser(String username, String encryptedPassword, String firstname, String lastname, String email, String birthDate, String gender) {
        AppUser user = new AppUser(username, encryptedPassword, firstname, lastname, email, birthDate, gender);
        AppRole role = appRoleRepository.findByRoleName("ROLE_USER");
        UserRole userRole = new UserRole(user, role);

        appUserRepository.save(user);
        userRoleRepository.save(userRole);
    }
    public AppUser findByUserName(String userName) {
        AppUser appUser = appUserRepository.findByUserName(userName);
        return appUser;
    }
    public AppUser findById(Long userId) {
        // .get() เพื่อเปลี่ยน Optional เป็น AppUser
        AppUser appUser = appUserRepository.findById(userId).get();
        return appUser;
    }
    public Iterable<AppUser> findAll() {
        Iterable<AppUser> allUser = appUserRepository.findAll();
        // ตัวอย่างการวนลูป
        for (AppUser user : allUser) {
            System.out.println(user.getFirstName());
        }
        return allUser;
    }
    public AppUser findByMyId(Long userId) {
        return appUserRepository.findByMyId(userId);
    }
    public Collection<AppUser> findByGender(String gender) {
        Collection<AppUser> allUser = appUserRepository.findByGender(gender);
        // ตัวอย่างการวนลูป
        for (AppUser user : allUser) {
            System.out.println(user.getFirstName());
        }

        return allUser;
    }
    public AppUser findByEmail(String email) {
        AppUser user = appUserRepository.findByEmail(email);
        return user;
    }
    public AppUser findByFullName(String firstName, String lastName) {
        return appUserRepository.findByFullName(firstName, lastName);
    }
	public int updateProfile(Long userId, String firstname, String lastname, String email, String gender) {
        return appUserRepository.updateProfile(userId, firstname, lastname, email, gender);
    }
    public Collection<AppUserJoined> findByUserIdAll(Long id) {
        return appUserJoinedRepository.findByUserId(id);
    }
}