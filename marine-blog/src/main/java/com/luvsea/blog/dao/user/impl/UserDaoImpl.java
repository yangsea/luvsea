package com.luvsea.blog.dao.user.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.luvsea.blog.common.BaseHibernateTemplate;
import com.luvsea.blog.dao.user.UserDao;
import com.luvsea.blog.entity.MenuRole;
import com.luvsea.blog.entity.Test;
import com.luvsea.blog.entity.User;

@Repository
public class UserDaoImpl extends BaseHibernateTemplate  implements UserDao  {

//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    
//    private  Configuration cfg = new Configuration().configure();  
//    private  SessionFactory fac = cfg.buildSessionFactory();  
//    private  Session session = fac.openSession();  
//    Query query = session.createQuery("select * from user");
    @SuppressWarnings("unchecked")
    public List<User> findUserList() {
        
//      List<T> aaa = new ArrayList<T>();
      List<User> userList = new ArrayList<User>();
//        List<User> userList = this.getHibernateTemplate().find("from User");
        List<MenuRole> menuRoleList = this.getHibernateTemplate().find("from MenuRole");
        System.out.println(menuRoleList);
        return userList;
    }
    
    /**
     * 原生语句查询方式
    * @Description  
    * @return
    * @author yhy@goujiawang.com   
    * @date 2015年11月26日 下午9:31:59
     */
    @SuppressWarnings("unchecked")
    public List<HashMap<Object, Object>> findListByProtocal(){
        
        List<HashMap<Object, Object>> userList = new  ArrayList<HashMap<Object, Object>>();
        userList = this.getHibernateTemplate().execute(new HibernateCallback() {

        public Object doInHibernate(org.hibernate.Session session)
                throws HibernateException, SQLException {
            // TODO Auto-generated method stub
            SQLQuery query = session.createSQLQuery("select * from menuRole");
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            return query.list();
        }
        });
        return userList;
    }
    @SuppressWarnings("unchecked")
    public int testAdd(Test test) {
        
        Test test1 = (Test) this.getHibernateTemplate().get(Test.class, 63);
        test1.setName("杨海洋1ddddd2");
//        test1.setId(43);

        this.getHibernateTemplate().update(test1);
        
//        int flag = this.getHibernateTemplate().execute(new HibernateCallback() {
//            public Object doInHibernate(org.hibernate.Session session)
//                      throws HibernateException, SQLException {
//                  // TODO Auto-generated method stub
//                  Query query = session.createSQLQuery("update test set name = '很烦2' where id = '63'");
////                          createQuery("insert into test(name) values ('测试事务333')");
//                  int flag = query.executeUpdate();
//                  return flag;
//              }
//          });

        //        this.getHibernateTemplate().save(test);
        test.setName("这是临时测试1");
        int flag = (Integer) this.getHibernateTemplate().save(test);
//        int flag = 0;
        return flag;
    }
    
//    测试事务
    @SuppressWarnings("unchecked")
    public int addMenuRole(){
        
      int flag = this.getHibernateTemplate().execute(new HibernateCallback() {
          public Object doInHibernate(org.hibernate.Session session)
                    throws HibernateException, SQLException {
                // TODO Auto-generated method stub
                Query query = session.createQuery("insert into menu(menuName) values('测试事务')");
                int flag = query.executeUpdate();
                return flag;
            }
        });
        String a = null; a.toString();
        if(flag>0){
            Test test = new Test();
            test.setName("测试事务");
           flag = (Integer) this.getHibernateTemplate().save(test);
        }
        return flag;
    }

    public User findUserBySelected(User user) {
        
//        User retUser = this.getHibernateTemplate().get(User.class, id);
        Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from User u where u.userName =:userName and u.passWord=:passWord");
        query.setParameter("userName", user.getUserName());
        query.setParameter("passWord", user.getPassWord());
        User retUser = query!=null&&query.list().size()>0?(User) query.list().get(0):null;
        return retUser;
    }

}
