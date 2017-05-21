package com.luvsea.common.util.redis;
//package com.youchang.common.util.redis;
//
//public class Snippet {
//    private static string[] ReadWriteHosts = System.Configuration.ConfigurationSettings.AppSettings["readWriteHosts"].Split(new char[] { ';' });
//            private static string[] ReadOnlyHosts = System.Configuration.ConfigurationSettings.AppSettings["readOnlyHosts"].Split(new char[] { ';' });
//    
//            #region -- 连接信息 --
//            public static PooledRedisClientManager prcm = CreateManager(ReadWriteHosts, ReadOnlyHosts);
//    
//            private static PooledRedisClientManager CreateManager(string[] readWriteHosts, string[] readOnlyHosts)
//            {
//                // 支持读写分离，均衡负载  
//                return new PooledRedisClientManager(readWriteHosts, readOnlyHosts, new RedisClientManagerConfig
//                {
//                    MaxWritePoolSize = 5, // “写”链接池链接数  
//                    MaxReadPoolSize = 5, // “读”链接池链接数  
//                    AutoStart = true,
//                });
//            }
//}
//
