package code.chapter15.abstractfactory1;

public class SqlserverUser {
    //新增一个用户
    public void insert(User user){
        System.out.println("在SQL Server中给User表增加一条记录");     
    }

    //获取一个用户信息
    public User getUser(int id){
        System.out.println("在SQL Server中根据用户ID得到User表一条记录");   
        return null;  
    }
}

