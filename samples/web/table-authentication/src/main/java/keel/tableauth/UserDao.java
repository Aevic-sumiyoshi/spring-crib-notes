package keel.tableauth;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

// example-start
@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    Optional<UserEntity> loadUserByUserName(String username);

    @Select
    List<String> loadUserRoles(String username);

}
// example-end
