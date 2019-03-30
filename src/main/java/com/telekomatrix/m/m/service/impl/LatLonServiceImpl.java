package com.telekomatrix.m.m.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telekomatrix.m.m.model.LatLon;
import com.telekomatrix.m.m.model.LiidAndCin;
import com.telekomatrix.m.m.repo.LatLonRepo;
import com.telekomatrix.m.m.service.LatLonService;
import com.telekomatrix.m.m.service.api.request.LatLonVO;

@Service
public class LatLonServiceImpl implements LatLonService{
	
	private LatLonRepo latLonRepo;
	
	@Autowired
	public LatLonServiceImpl(LatLonRepo latLonRepo) {
		this.latLonRepo = latLonRepo;
	}

	@Override
	public void create(LatLonVO latLonVO) {
		
		System.out.println(latLonVO.getLat());
		System.out.println(latLonVO.getLon());
		System.out.println(latLonVO.getLiid());
		System.out.println(latLonVO.getCin());
		System.out.println(latLonVO.getTimestamp());
		
		LiidAndCin liidAndCin = new LiidAndCin();
		liidAndCin.setCin(latLonVO.getCin());
		liidAndCin.setLiid(latLonVO.getLiid());
		
		LatLon latLon = new LatLon();
		latLon.setLat(Double.valueOf(latLonVO.getLat()));
		latLon.setLon(Double.valueOf(latLonVO.getLon()));
		latLon.setTimestamp(Long.valueOf(latLonVO.getTimestamp()));
		
		liidAndCin.addLatLon(latLon);
		
		latLonRepo.save(liidAndCin);

		
	}

}
