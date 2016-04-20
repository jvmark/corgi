package com.pebusney.user.view;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.pebusney.common.domain.NapiListRespDTO;
import com.pebusney.user.domain.User;
import com.pebusney.user.repository.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author mark
 * @since 2016-04-03 16:28.
 */
@RestController
@RequestMapping("napi")
public class UserController {

  @Resource
  private UserRepository userRepository;

  @RequestMapping(value = "people/profile/", method = RequestMethod.GET)
  public NapiListRespDTO getAllUser() {
    List<User> users = userRepository.findAll();
    return new NapiListRespDTO(true, 24, Lists.newArrayList(Iterables.filter(users,
        Object.class)));
  }
}
