package wu.mapper;

import java.util.List;

import wu.model.User;

/**
 *���ߣ�Wu
 *���ڣ�2018-3-25
 **/
public interface UserMapper {
	User selectUser(Integer uid);
	List<User> selectAllUser();
}
