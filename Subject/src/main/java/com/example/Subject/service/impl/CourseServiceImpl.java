package com.example.Subject.service.impl;


import com.example.Subject.dao.CourseDao;
import com.example.Subject.dao.impl.CourseDaoImpl;
import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.dto.response.StudentInfoResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public CourseResponse create(CourseRequest courseRequest) {
        CourseResponse courseResponse = new CourseResponse();
        courseDao.createCourse(courseRequest.getId(), courseRequest.getNameCourse());
        courseResponse.setCourseName(courseRequest.getNameCourse());
        return courseResponse;
    }

    @Override
    public List<CourseResponse> getAll() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        List<Course> courseList = courseDao.getListCourse();
        CourseResponse courseResponse = new CourseResponse();
        for (Course course : courseList) {
            courseResponse.setCourseName(course.getNameCourse());
            courseResponseList.add(courseResponse);
        }
        return courseResponseList;
    }

    @Override
    public Boolean delete(int id) {
        Course course = courseDao.findById(id);
        if (Objects.nonNull(course)) {
            courseDao.deleteCourse(id);
            return true;
        }
        return false;
    }

    @Override
    public CourseResponse update( int id, CourseRequest courseRequest) {
        Course course = courseDao.findById(id);
        if (Objects.nonNull(course)) {
            courseDao.deleteCourse(id);
            CourseResponse courseResponse = new CourseResponse();
            courseDao.createCourse(courseRequest.getId(), courseRequest.getNameCourse());
            courseResponse.setCourseName(courseRequest.getNameCourse());
            return courseResponse;
        }
        return null;
    }


}
