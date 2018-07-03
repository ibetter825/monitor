package com.monitor.core.service.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.entity.UserInfo;
import com.monitor.core.dao.UserDao;
import com.monitor.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User getUser(Integer id) {
		return userDao.get(id, false);
	}
	@Override
	@Transactional
	public void saveOrUpdate(User user, UserInfo info) {
		user.setUserInfo(info);
		info.setUser(user);
		if(user.getUserId() == null){
			userDao.save(user);
		}else{
			userDao.update(user);
		}
	}
	@Override
	public int delete(Integer[] arr) {
		Map<String, Integer[]> map = Maps.newHashMap();
		map.put("arr", arr);
		return userDao.batchExecute("update User u set u.userStatus = -1 where u.userId in (:arr)", map);
	}
}
