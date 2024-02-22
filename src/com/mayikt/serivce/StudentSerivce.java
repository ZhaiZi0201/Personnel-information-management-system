package com.mayikt.serivce;

import com.mayikt.dao.StudentDao;
import com.mayikt.entity.StudentEntity;

import java.util.ArrayList;
public class StudentSerivce {
    /**
     * new 学生对象dao层
     */
    private StudentDao studentDao = new StudentDao();

    /**
     * 查询所有的学生信息
     *
     */
    public ArrayList<StudentEntity> allStudent() {
        // 在通过业务逻辑层调用dao层代码
        ArrayList<StudentEntity> studententities = studentDao.allStudent();
        return studententities;
    }

    public StudentEntity getByIdStudent(Long stuId) {

        return studentDao.getByIdStudent(stuId);
    }
    //
    public int insertStudent(StudentEntity stu) {
        return studentDao.insertStudent(stu);
    }
    //
public int updateStudent(StudentEntity stu){
        return  studentDao.updateStudent(stu);
}
//
public int delStudent(Long id) {
    return studentDao.delStudent(id);
}
}
