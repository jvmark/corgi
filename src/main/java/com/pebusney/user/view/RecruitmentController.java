package com.pebusney.user.view;

import com.pebusney.common.domain.NapiRespDTO;
import com.pebusney.common.domain.NapiStatus;
import com.pebusney.user.domain.Recruitment;
import com.pebusney.user.repository.RecruitmentRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author mark
 * @since 2016-04-21 20:28.
 */
@RestController
@RequestMapping("napi")
public class RecruitmentController {

  @Resource
  private RecruitmentRepository recruitmentRepository;

  @RequestMapping(value = "recruitment/all/", method = RequestMethod.GET)
  public NapiRespDTO queryAll() {
    List<Recruitment> recruitments = recruitmentRepository.findAll();

    return new NapiRespDTO(NapiStatus.SUCCESS, recruitments);
  }

  @RequestMapping(value = "recruitment/by_id/", method = RequestMethod.GET)
  public NapiRespDTO findById(
      @RequestParam(value = "id", required = true) Long id
  ) {
    Recruitment student = recruitmentRepository.findById(id);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "recruitment/by_city/", method = RequestMethod.GET)
  public NapiRespDTO findByCity(
      @RequestParam(value = "city", required = true) String city
  ) {
    Recruitment student = recruitmentRepository.findByCity(city);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }

  @RequestMapping(value = "recruitment/by_companyid/", method = RequestMethod.GET)
  public NapiRespDTO findBycompanyid(
      @RequestParam(value = "companyid", required = true) Long companyid
  ) {
    Recruitment student = recruitmentRepository.findByCompanyId(companyid);

    return new NapiRespDTO(NapiStatus.SUCCESS, student);
  }


  @RequestMapping(value = "recruitment/save/", method = RequestMethod.POST)
  public NapiRespDTO save(
      @ModelAttribute("recruitment") Recruitment recruitment
  ) {
    Recruitment recruitment1 = recruitmentRepository.save(recruitment);

    return new NapiRespDTO(NapiStatus.SUCCESS);
  }

  @RequestMapping(value = "recruitment/delete/", method = RequestMethod.POST)
  public NapiRespDTO delte(
      @RequestParam(value = "id", required = true) Long id
  ) {
    recruitmentRepository.delete(id);

    return new NapiRespDTO(NapiStatus.SUCCESS);
  }
}
