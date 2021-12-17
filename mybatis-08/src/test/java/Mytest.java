import com.hhf.dao.BlogMapper;
import com.hhf.pojo.Blog;
import com.hhf.utils.IDUtils;
import com.hhf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }
    @Test
    public void queryBlogIF(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","狂神说");
//        map.put("title","Mybatis如此简单");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("views",9999);
        //map.put("author","狂神说");
        map.put("title","Mybatis如此简单");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
    @Test
    public void updateBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","狂神说");
        map.put("title","Mybatis如此简单2");
        map.put("id","de94c2e9f89448148e5b23bee14f6d74");
        mapper.updateBlog(map);

        session.close();
    }
    @Test
    public void queryBlogForeach(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<>();
        map.put("ids",ids);
        ids.add("de94c2e9f89448148e5b23bee14f6d74");
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
}