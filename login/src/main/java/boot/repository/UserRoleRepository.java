package boot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import boot.entity.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>  {

}