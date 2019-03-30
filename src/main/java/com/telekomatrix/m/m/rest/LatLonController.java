package com.telekomatrix.m.m.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telekomatrix.m.m.service.LatLonService;
import com.telekomatrix.m.m.service.api.request.LatLonVO;

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

}
