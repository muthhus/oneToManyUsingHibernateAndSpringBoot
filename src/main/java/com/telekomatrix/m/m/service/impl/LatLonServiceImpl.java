package com.telekomatrix.m.m.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telekomatrix.m.m.model.LatLon;
import com.telekomatrix.m.m.model.LiidAndCin;
import com.telekomatrix.m.m.repo.LatLonDetail;
import com.telekomatrix.m.m.repo.LatLonRepo;
import com.telekomatrix.m.m.service.LatLonService;
import com.telekomatrix.m.m.service.api.request.LatLonVO;
import com.telekomatrix.m.m.service.api.request.StellerVO;
import com.telekomatrix.m.m.service.api.response.LatLonDTO;

@Service
public class LatLonServiceImpl implements LatLonService{
	
	private LatLonRepo latLonRepo;
	
	private LatLonDetail latLonDetail;
	
	@Autowired
	public LatLonServiceImpl(LatLonRepo latLonRepo, LatLonDetail latLonDetail) {
		this.latLonRepo = latLonRepo;
		this.latLonDetail = latLonDetail;
	}

	@Override
	public void create(LatLonVO latLonVO) {
		LatLon latLon = null;
		LiidAndCin liidAndCin = null;
		System.out.println(latLonVO.getLat());
		System.out.println(latLonVO.getLon());
		System.out.println(latLonVO.getLiid());
		System.out.println(latLonVO.getCin());
		System.out.println(latLonVO.getTimestamp());
		
		liidAndCin = latLonRepo.findByLiidAndCin(latLonVO.getLiid(), latLonVO.getCin());
		if(liidAndCin != null) {
			latLon = new LatLon();
			latLon.setLat(Double.valueOf(latLonVO.getLat()));
			latLon.setLon(Double.valueOf(latLonVO.getLon()));
			latLon.setTimestamp(Long.valueOf(latLonVO.getTimestamp()));
			liidAndCin.addLatLon(latLon);
		} else {
				
		liidAndCin = new LiidAndCin();
		liidAndCin.setCin(latLonVO.getCin());
		liidAndCin.setLiid(latLonVO.getLiid());
		
		latLon = new LatLon();
		latLon.setLat(Double.valueOf(latLonVO.getLat()));
		latLon.setLon(Double.valueOf(latLonVO.getLon()));
		latLon.setTimestamp(Long.valueOf(latLonVO.getTimestamp()));
		liidAndCin.addLatLon(latLon);
			
		}
		
		
		
		latLonRepo.save(liidAndCin);

		
	}

	@Override
	public LatLonDTO getLatLon(StellerVO stellerVO) throws JsonProcessingException {
		LatLon latLonTime = latLonDetail.getLatLon(stellerVO.getLiid(), stellerVO.getCin(), stellerVO.getTimestamp());
		
		LatLonDTO dto = new LatLonDTO();
		
		dto.setLat(String.valueOf(latLonTime.getLat()));
		dto.setLon(String.valueOf(latLonTime.getLon()));
		dto.setTimestamp(String.valueOf(latLonTime.getTimestamp()));
		
		
		return dto;
	}

}
