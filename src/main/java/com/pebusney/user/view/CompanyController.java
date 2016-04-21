package com.pebusney.user.view;

import com.pebusney.common.domain.NapiRespDTO;
import com.pebusney.common.domain.NapiStatus;
import com.pebusney.user.domain.Company;
import com.pebusney.user.repository.CompanyRepository;

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
public class CompanyController {

  @Resource
  private CompanyRepository companyRepository;

  @RequestMapping(value = "company/all/", method = RequestMethod.GET)
  public NapiRespDTO queryAll() {
    List<Company> companies = companyRepository.findAll();

    return new NapiRespDTO(NapiStatus.SUCCESS, companies);
  }

  @RequestMapping(value = "company/by_id/", method = RequestMethod.GET)
  public NapiRespDTO findById(
      @RequestParam(value = "id", required = true) Long id
  ) {
    Company companie = companyRepository.findById(id);

    return new NapiRespDTO(NapiStatus.SUCCESS, companie);
  }

  @RequestMapping(value = "company/by_name/", method = RequestMethod.GET)
  public NapiRespDTO findByName(
      @RequestParam(value = "name", required = true) String name
  ) {
    Company companie = companyRepository.findByName(name);

    return new NapiRespDTO(NapiStatus.SUCCESS, companie);
  }

  @RequestMapping(value = "company/save/", method = RequestMethod.POST)
  public NapiRespDTO save(
      @ModelAttribute("company") Company company
  ) {
    Company company1 = companyRepository.save(company);

    return new NapiRespDTO(NapiStatus.SUCCESS);
  }

  @RequestMapping(value = "company/delete/", method = RequestMethod.POST)
  public NapiRespDTO delte(
      @RequestParam(value = "id", required = true) Long id
  ) {
    companyRepository.delete(id);

    return new NapiRespDTO(NapiStatus.SUCCESS);
  }
}
