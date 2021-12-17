import com.hhf.dao.UserMapper;
import com.hhf.pojo.User;
import com.hhf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Mytest {

    static Logger logger = Logger.getLogger(Mytest.class);

    @Test
    public  void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        //清理一级缓存，清完之后查询同一条数据就需要进入数据库两次
        sqlSession.clearCache();
        User userById2 = mapper.getUserById(1);
        System.out.println(userById2);
        sqlSession.close();
    }
    @Test
    public  void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User userById2 = mapper2.getUserById(1);
        System.out.println(userById2);
        sqlSession2.close();
    }
}
