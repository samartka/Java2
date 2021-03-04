package boot.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import boot.entity.AppUserJoined;

public interface AppUserJoinedRepository extends CrudRepository<AppUserJoined, Long>  {
    @Query(
        value = "SELECT app_user.user_id as user_id, user_name, firstname, lastname, email, birth_date, gender, role_name FROM app_user "+
        "INNER JOIN user_role ON app_user.user_id = user_role.user_id " + // ระวังอย่าลืมเว้นวรรคก่อนปิด Double Quote 
        "INNER JOIN app_role ON user_role.role_id = app_role.role_id " +  // ระวังอย่าลืมเว้นวรรคก่อนปิด Double Quote 
        "WHERE app_user.user_id = ?1", 
        nativeQuery = true)
        public Collection<AppUserJoined> findByUserId(Long id);
    
}