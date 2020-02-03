package dh.study.springbootstudyshiro.realm;

import dh.study.springbootstudyshiro.entity.SysPermission;
import dh.study.springbootstudyshiro.entity.SysRole;
import dh.study.springbootstudyshiro.entity.UserInfo;
import dh.study.springbootstudyshiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for(SysRole sysRole: userInfo.getRoles()){
            simpleAuthorizationInfo.addRole(sysRole.getName());
            for(SysPermission sysPermission: sysRole.getPermissions()){
                simpleAuthorizationInfo.addStringPermission(sysPermission.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getPrincipal());
        UserInfo userInfo = userInfoService.findByUsername(username);
        if(null == userInfo){
            return null;
        }
        return new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getSalt()), // salt=username+salt
                getName()                                  // realm
        );
    }
}
