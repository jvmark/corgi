package com.pebusney.user.view;

import com.pebusney.common.domain.NapiRespDTO;
import com.pebusney.common.domain.NapiStatus;
import com.pebusney.user.domain.Student;
import com.pebusney.user.repository.StudentRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author mark
 * @since 2016-04-21 20:27.
 */
@RestController
@RequestMapping("napi")
public class StudentController {

  @Resource
  private StudentRepository studentRepository;

  @RequestMapping(value = "student/all/", method = RequestMethod.GET)
  public NapiRespDTO queryAll() {
    List<Student> students = studentRepository.findAll();

    return new NapiRespDTO(NapiStatus.SUCCESS, students);
  }

  @RequestMapping(value = "student/by_id/", method = RequestMethod.GET)
  public NapiRespDTO findById(
      @RequestParam(value = "id", required = true) Long id
  ) {
    Student student = studentRepository.findById(id);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "student/by_name/", method = RequestMethod.GET)
  public NapiRespDTO findByName(
      @RequestParam(value = "name", required = true) String name
  ) {
    Student student = studentRepository.findByname(name);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "student/by_sno/", method = RequestMethod.GET)
  public NapiRespDTO findBySno(
      @RequestParam(value = "sno", required = true) String sno
  ) {
    Student student = studentRepository.findBySno(sno);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "student/by_classname", method = RequestMethod.GET)
  public NapiRespDTO findByClasName(
      @RequestParam(value = "class_name", required = true) String className
  ) {
    List<Student> student = studentRepository.findByClassName(className);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "student/by_major/", method = RequestMethod.GET)
  public NapiRespDTO findByMajor(
      @RequestParam(value = "major", required = true) String major
  ) {
    List<Student> student = studentRepository.findByMajor(major);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "student/save/", method = RequestMethod.POST)
  public NapiRespDTO save(
      @ModelAttribute("student") Student student
  ) {
    Student save = studentRepository.save(student);

    return new NapiRespDTO(NapiStatus.SUCCESS);
  }

  @RequestMapping(value = "student/delete/", method = RequestMethod.POST)
  public NapiRespDTO delte(
      @RequestParam(value = "id", required = true) Long id
  ) {
    studentRepository.delete(id);

    return new NapiRespDTO(NapiStatus.SUCCESS);
  }
}
