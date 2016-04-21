package com.pebusney.user.view;

import com.pebusney.common.domain.NapiRespDTO;
import com.pebusney.common.domain.NapiStatus;
import com.pebusney.user.domain.Admin;
import com.pebusney.user.domain.Company;
import com.pebusney.user.domain.Student;
import com.pebusney.user.repository.AdminRepository;
import com.pebusney.user.repository.CompanyRepository;
import com.pebusney.user.repository.RecruitmentRepository;
import com.pebusney.user.repository.StudentRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mark
 * @since 2016-04-20 18:35.
 */
@RestController
@RequestMapping("napi")
public class LoginController {

  @Resource
  private AdminRepository adminRepository;
  @Resource
  private StudentRepository studentRepository;
  @Resource
  private CompanyRepository companyRepository;

  @RequestMapping(value = "login/", method = RequestMethod.POST)
  public NapiRespDTO login(
      @RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "password", required = true) String password,
      @RequestParam(value = "type", required = true) int type
  ) {

    Long id = 0L;
    switch (type) {
      case 0:
        Admin admin = adminRepository.findByName(username);
        if (!admin.getPassword().equals(password)) {
          return new NapiRespDTO(NapiStatus.INVALID_PARAM, "帐号密码不正确");
        }
        id = admin.getId();
        break;
      case 1:
        Student student = studentRepository.findByname(username);
        if (!student.getPassword().equals(password)) {
          return new NapiRespDTO(NapiStatus.INVALID_PARAM, "帐号密码不正确");
        }
        id = student.getId();
        break;
      case 2:
        Company company = companyRepository.findByName(username);
        if (!company.getPassword().equals(password)) {
          return new NapiRespDTO(NapiStatus.INVALID_PARAM, "帐号密码不正确");
        }
        id = company.getId();
        break;
      default:
        break;
    }

    return new NapiRespDTO(NapiStatus.SUCCESS, id);
  }
}
