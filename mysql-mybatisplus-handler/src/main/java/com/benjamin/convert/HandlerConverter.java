package com.benjamin.convert;

import com.benjamin.entities.Student;
import com.benjamin.request.StudentForm;
import com.benjamin.vo.StudentVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface HandlerConverter {

    /**
     * StudentForm => Student
     *
     * @param studentForm
     * @return
     */
    Student studentForm2Student(StudentForm studentForm);

    /**
     * Student => StudentVo
     *
     * @param student
     * @return
     */
    StudentVo student2StudentVo(Student student);
    List<StudentVo> studentList2StudentVoList(List<Student> list);
}
