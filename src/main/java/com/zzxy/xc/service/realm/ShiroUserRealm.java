package com.zzxy.xc.service.realm;

import com.zzxy.xc.dao.MenuDao;
import com.zzxy.xc.dao.RoleMenuDao;
import com.zzxy.xc.dao.UserDao;
import com.zzxy.xc.dao.UserRoleDao;
import com.zzxy.xc.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Autowired
	private MenuDao menuDao;
	
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		//设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}

	//重写授权必要的方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	//重写认证方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//向下造型
		//UsernamePasswordToken封装的是浏览器传过来的用户数据
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		User user = userDao.findUserByName(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (user.getValid() == 0) {
			throw new LockedAccountException();
		}
		//处理盐变成ByteSource对象
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user, //身份认真, 保证唯一 
				user.getPassword(), //密码
				credentialsSalt, //盐, 变成ByteSource
				getName());	//realm的名字
		return info;
	}
	
}
