package cui.xin.studentcourse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.dto.MiddleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 中建信息表 Mapper 接口
 * </p>
 *
 * @author palpitate_yzr
 * @since 2022-11-08
 */
@Mapper
public interface MiddleMapper extends BaseMapper<MiddleDto> {
    //查询历年（全部）成绩
    List<MiddleDto> showAllGrade(Long studentId);
    //根据搜索条件查询成绩
    List<MiddleDto> showGradeByCondition(@Param("studentId") Long studentId, @Param("Course") Course course);
    //查询未通过的成绩
    List<MiddleDto> showNoPassGrade(Long studentId);
    //查询已通过的成绩
    List<MiddleDto> showPassGrade(Long studentId);;
}
