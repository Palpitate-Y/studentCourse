package cui.xin.studentcourse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    public List<Course> selectTop10();

    public List<Course> selectSex();
}
