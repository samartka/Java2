package boot.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import boot.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long>  {
    public AppUser findByUserName(String userName);

    @Query(
    value = "SELECT * FROM app_user", 
    nativeQuery = true)
    public Collection<AppUser> myFindAll();

    @Query(
    value = "SELECT * FROM app_user WHERE gender = ?1", 
    nativeQuery = true)
    public Collection<AppUser> findByGender(String gender);

    @Query(
    value = "SELECT * FROM app_user WHERE email= ?1", 
    nativeQuery = true)
    public AppUser findByEmail(String email);

    @Query(
    value = "SELECT * FROM app_user WHERE user_id = ?1", 
    nativeQuery = true)
    public AppUser findByMyId(Long id);

    @Query(
    value = "SELECT * FROM app_user WHERE firstname = ?1 AND lastname = ?2", 
    nativeQuery = true)
    public AppUser findByFullName(String firstName, String lastName);

    @Transactional
    @Modifying
    @Query(
    value = "UPDATE app_user SET firstname = ?2, lastname = ?3, email = ?4, gender = ?5 WHERE user_id = ?1", 
    nativeQuery = true)
	public int updateProfile(Long userId, String firstname, String lastname, String email, String gender);

    
}