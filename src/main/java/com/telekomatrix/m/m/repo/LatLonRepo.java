package com.telekomatrix.m.m.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.telekomatrix.m.m.model.LiidAndCin;

@Repository
public interface LatLonRepo extends JpaRepository<LiidAndCin, String>, JpaSpecificationExecutor<LiidAndCin> {

}
