package com.pebusney.user.view;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.pebusney.common.domain.NapiListRespDTO;
import com.pebusney.common.domain.NapiRespDTO;
import com.pebusney.common.domain.NapiStatus;
import com.pebusney.user.domain.User;
import com.pebusney.user.repository.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

  static final int REMEMBER_COOKIE_AGE = 14 * 24 * 60 * 60;

  @Resource
  private UserRepository userRepository;

  @RequestMapping(value = "login/", method = RequestMethod.POST)
  public NapiRespDTO login(
      @RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "password", required = true) String password,
      HttpServletResponse response
  ) {

    User user = userRepository.findByName(username);
    if (!user.getPassword().equals(password)) {
      return new NapiRespDTO(NapiStatus.INVALID_PARAM, "帐号密码不正确");
    }
    response.addCookie(
        mkCookie(REMEMBER_COOKIE_AGE, "_auth_user_id", String.valueOf(user.getId())));

    return new NapiRespDTO(NapiStatus.SUCCESS, user);
  }

  private Cookie mkCookie(int age, String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setDomain("pebusney.iilib.com");
    cookie.setPath("/");
    cookie.setMaxAge(age);
    return cookie;
  }
}
