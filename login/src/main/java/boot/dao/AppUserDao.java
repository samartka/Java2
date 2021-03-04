package boot.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import boot.entity.AppUser;
@Repository
@Transactional
public class AppUserDao {
    @Autowired
    private EntityManager entityManager;
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "select e from AppUser e where e.userName = :userName";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
            return (AppUser)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    // public int insertUser(String userName, String encryptedPassword) {
    //     try {
    //         String sql = "UPDATE " + AppUser.class.getName() + " e SET e.userName = :userName, e.encryptedPassword = :encryptedPassword, e.enabled = :enabled";
    //         Query query = entityManager.createQuery(sql);
    //         query.setParameter("userName", userName);
    //         query.setParameter("encryptedPassword", encryptedPassword);
    //         query.setParameter("enabled", true);
    //         int result = query.executeUpdate();
    //         return result;
    //     } catch (NoResultException e) {
    //         return 0;
    //     }
    // }
 }
 