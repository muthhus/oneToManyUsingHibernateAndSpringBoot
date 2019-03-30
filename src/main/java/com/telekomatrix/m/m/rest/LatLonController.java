package com.telekomatrix.m.m.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.telekomatrix.m.m.service.LatLonService;
import com.telekomatrix.m.m.service.api.request.LatLonVO;
import com.telekomatrix.m.m.service.api.request.StellerVO;
import com.telekomatrix.m.m.service.api.response.LatLonDTO;

@RestController
@RequestMapping("/v1/post")
public class LatLonController {
	
	private LatLonService latLonService;
	
	@Autowired
	public LatLonController(LatLonService latLonService) {
		this.latLonService = latLonService;
	}
	
	@PostMapping
	public ResponseEntity<LatLonVO> create(@RequestBody LatLonVO latLonVO) {
		latLonService.create(latLonVO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<LatLonDTO> getLatLon(StellerVO stellerVO) throws JsonProcessingException{
		LatLonDTO latLonDTO = latLonService.getLatLon(stellerVO);
		
		return latLonDTO != null ? new ResponseEntity<>(latLonDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
