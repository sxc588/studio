package sy.service;

import java.util.List;
import com.github.support.entitement.mybatis.model.User;


public interface UserServiceI {

	User getUserById(String id);

	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();

}
