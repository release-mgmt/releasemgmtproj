package com.evaluation.rest.controller;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.Dao.ReleaseDao;
import com.evaluation.pojo.ProjectInfo;
import com.evaluation.pojo.ReleaseInfo;
import com.evaluation.rest.service.ReleaseService;

@RestController
@RequestMapping("/release")
public class ReleaseController {
	public  final Logger logger = Logger.getLogger(ReleaseDao.class.getName());	
	
	@Autowired
	private ReleaseService  relServ;
	
	
	
	@RequestMapping(value = "/releaseList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  List getReleaseDetails() {
		
        //ReleaseInfo details=rs.getReleaseDetails();
		List details=relServ.getAllReleaseDetails();
		for (Object object : details) {
			ReleaseInfo r= (ReleaseInfo)object;
		}
        
		return details;
    }
	
	@RequestMapping(value = "/projectReleaseList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  List getProjReleaseList(){
        List projRelease=relServ.getProjReleaselist();
        return projRelease;
    }
	
	@RequestMapping(value = "/insertRelease", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String insertRelease() throws ParseException{
        relServ.insertProjRelease();
        return "new release added";
    }

	@RequestMapping(value = "/deleteRelease", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRelease(){
        relServ.deleteRelease(11);
        return "new release deleted";
    }
	
	

}
