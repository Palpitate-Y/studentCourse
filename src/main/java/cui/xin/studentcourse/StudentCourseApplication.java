package cui.xin.studentcourse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cui.xin.studentcourse.mapper")
public class StudentCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseApplication.class, args);
    }

}
