package com.example.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/*
安全框架的配置类 3个bean
 */
@Configuration
public class ShiroConfig {
    /*
1.realm
 */
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        //myRealm.setCacheManager();
        return myRealm;
    }
/*
2.securityManager
 */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        return defaultWebSecurityManager;

    }
    /*
    3.shiroFilterFactorybean
       安全过滤器
    认证过滤器的分类
    anon:无需认证
    authc:必须认证
    user:使用remember me的时候
    perms:访问的资源需要某个权限才能到达
    roles:访问的资源需要某个角色才能到达
    */

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());

        Map<String,String> map = new LinkedHashMap<>();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        map.put("/login","anon");//放行登录页面
        map.put("/*","authc"); //对所有的请求进行认证
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return shiroFilterFactoryBean;
    }
}
