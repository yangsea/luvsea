package com.luvsea.wechat.common.token.server;

import com.luvsea.wechat.common.token.Token;

public class CustomerAccessTokenServer extends CustomerServer{

/* (non-Javadoc)
 * @see org.sword.wechat4j.token.DbAccessTokenServer#find()
 */
@Override
public String find() {
    String accessToken = null;
    //执行数据库操作
//      String sql = "select cfgValue from cfg where cfg.cfgKey = 'access_token'";
//      accessToken = DBUtil.query(sql);
    return accessToken;
}

/* (non-Javadoc)
 * @see org.sword.wechat4j.token.DbAccessTokenServer#save()
 */
@Override
public boolean save(Token accessToken) {
    //如果没有需要插入，如果有的就更新，假设已经有了数据库配置项
//      String sql = "update cfg set cfg.cfgValue=" + accessToken.getToken() + 
//              " where cfg.cfgKey= 'access_token'";
//      DBUtil.execute(sql);
    //在这里自定义存入文件、redis、数据库等存储便于分布式
    return true;
}
}