package com.pebusney.user.view;

import com.pebusney.common.domain.NapiRespDTO;
import com.pebusney.common.domain.NapiStatus;
import com.pebusney.user.domain.Admin;
import com.pebusney.user.repository.AdminRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mark
 * @since 2016-04-03 16:28.
 */
@RestController
@RequestMapping("napi")
public class AdminController {

  @Resource
  private AdminRepository adminRepository;

  @RequestMapping(value = "admin/by_id/", method = RequestMethod.GET)
  public NapiRespDTO findById(
      @RequestParam(value = "id", required = true) Long id
  ) {
    Admin admin = adminRepository.findById(id);

    return new NapiRespDTO(NapiStatus.SUCCESS, admin);
  }
}
