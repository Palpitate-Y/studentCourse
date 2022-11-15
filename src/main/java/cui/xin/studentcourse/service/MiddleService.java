package cui.xin.studentcourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.dto.MiddleDto;

import java.util.List;

/**
 * <p>
 * 中间信息表 服务类
 * </p>
 *
 * @author palpitate_yzr
 * @since 2022-11-08
 */
public interface MiddleService extends IService<MiddleDto> {
    //查询历年（全部）成绩
    List<MiddleDto> showAllGrade(Long studentId);
    //根据搜索条件查询成绩
    List<MiddleDto> showGradeByCondition( Long studentId, Course course);
    //查询未通过的成绩
    List<MiddleDto> showNoPassGrade(Long studentId);
    //查询已通过的成绩
    List<MiddleDto> showPassGrade(Long studentId);;
}
