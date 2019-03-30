package com.telekomatrix.m.m.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.telekomatrix.m.m.service.api.request.LatLonVO;
import com.telekomatrix.m.m.service.api.request.StellerVO;
import com.telekomatrix.m.m.service.api.response.LatLonDTO;

public interface LatLonService {
  void create(LatLonVO latLonVO);
  LatLonDTO getLatLon(StellerVO stellarVO) throws JsonProcessingException;
  
}
