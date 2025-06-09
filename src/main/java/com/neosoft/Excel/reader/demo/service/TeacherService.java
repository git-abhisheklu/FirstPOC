package com.neosoft.Excel.reader.demo.service;

import com.neosoft.Excel.reader.demo.entity.Teacher;
import com.neosoft.Excel.reader.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher t) {
        teacherRepository.save(t);
    }

    public Optional<Teacher> getTeacherByID( Long id ) {
        return teacherRepository.findById(id);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Boolean updateTeacherById( Long id, Teacher t)
    {
        Optional<Teacher> oldTeacherId = teacherRepository.findById(id);

        if(oldTeacherId.isPresent()) {
            Teacher updatedTeacher = oldTeacherId.get();
            updatedTeacher.setName(t.getName());
            updatedTeacher.setEmail(t.getEmail());
            teacherRepository.save(updatedTeacher);
            return true;
        }
        return false;
    }

    public void deleteTeacher( Long id ) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if( teacher.isPresent() ) {
            teacherRepository.deleteById(id);
        }
    }
}
