package com.telekomatrix.m.m.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telekomatrix.m.m.model.LatLon;

@Repository
public interface LatLonDetail extends JpaRepository<LatLon, String>, JpaSpecificationExecutor<LatLon> {
	
	@Query(value = "select lc.id, lc.cin, lc.liid, ll.lat, ll.id, ll.lon, ll.timestamp, ll.liid_cin_id \n" + 
			" from liid_and_cin lc \n" + 
			" inner join lat_lon ll \n" + 
			" on lc.id = ll.liid_cin_id \n" + 
			"and \n" + 
			"lc.liid= :liid \n" + 
			"and \n" + 
			"lc.cin = :cin \n" + 
			"and\n" + 
			"ll.timestamp <= :timestamp \n" + 
			"order by \n" + 
			"ll.timestamp limit 1", nativeQuery = true)
	LatLon getLatLon(@Param("liid") String liid, @Param("cin") String cin, @Param("timestamp") String timestamp);
}
