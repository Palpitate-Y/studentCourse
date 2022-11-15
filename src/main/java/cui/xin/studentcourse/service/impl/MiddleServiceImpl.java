package cui.xin.studentcourse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.dto.MiddleDto;
import cui.xin.studentcourse.mapper.MiddleMapper;
import cui.xin.studentcourse.service.MiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 中间信息表 服务实现类
 * </p>
 *
 * @author palpitate_yzr
 * @since 2022年11月9日10:01:22
 */
@Service
public class MiddleServiceImpl extends ServiceImpl<MiddleMapper, MiddleDto> implements MiddleService {

    @Autowired
    private MiddleMapper middleMapper;


    /**
     * 查询历年（全部）成绩
     * @param studentId
     * @return
     */
    @Override
    public List<MiddleDto> showAllGrade(Long studentId) {
        return middleMapper.showAllGrade(studentId);
    }


    /**
     * 根据搜索条件查询成绩
     * @param studentId
     * @param course
     * @return
     */
    @Override
    public List<MiddleDto> showGradeByCondition(Long studentId, Course course) {
        return middleMapper.showGradeByCondition(studentId, course);
    }

    /**
     * 查询未通过的成绩
     * @param studentId
     * @return
     */
    @Override
    public List<MiddleDto> showNoPassGrade(Long studentId) {
        return middleMapper.showNoPassGrade(studentId);
    }

    /**
     * 查询已通过的成绩
     * @param studentId
     * @return
     */
    @Override
    public List<MiddleDto> showPassGrade(Long studentId) {
        return middleMapper.showPassGrade(studentId);
    }
}
