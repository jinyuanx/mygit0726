package com.it.service;

import java.util.List;

import com.it.bean.Users;

/**
 * 
 * Title:
 * Description:com.it.service.IUsers.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */

public interface IUsers {
	//��
	public boolean addUsers(Users users);
	//ɾ
	public boolean delUsers(Users users);
	//��
	public boolean updUsers(Users users);
	//��
	public List<Users> queryAllUsers(Users users);
	//��
	public Users findUsersById(Users users);
	//��¼
	public boolean login(Users users);

}
