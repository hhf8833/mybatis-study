import com.hhf.dao.StudentMapper;
import com.hhf.dao.TeacherMapper;
import com.hhf.pojo.Student;
import com.hhf.pojo.Teacher;
import com.hhf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Mytest {
    static Logger logger = Logger.getLogger(Mytest.class);
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {

            System.out.println(student);
        }
        sqlSession.close();
    }
}
