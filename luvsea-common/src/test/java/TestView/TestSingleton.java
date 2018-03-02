package TestView;

public class TestSingleton {

    public static void main(String[] args) {

//        System.out.println(SingletonHungry.getSingleton().name);
        System.out.println(SingletonLazy.getSingletonLazy().name);
    }
    
    static class SingletonHungry{ //因为是内部类，所以需要 是静态的！
        
        String name;
        private  SingletonHungry(String name){
            this.name = name;
        }
        
        private static SingletonHungry singleton = new SingletonHungry("i'm sea");
        
        public static SingletonHungry getSingleton(){
            
            return singleton;
        }
    }
    
    static class SingletonLazy{
        
        String name ;
        private SingletonLazy(String name){
            this.name = name;
        }
        
        private static SingletonLazy singletonLazy = null;
        
        public static synchronized SingletonLazy getSingletonLazy(){ //synchronized 避免高并发下的资源抢占！ 同时，可以提高效率
            if(null==singletonLazy){
                singletonLazy = new SingletonLazy("im ocean");
            }
            return singletonLazy;
        }
    }

}
