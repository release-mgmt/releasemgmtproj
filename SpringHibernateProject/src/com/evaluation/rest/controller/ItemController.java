package com.evaluation.rest.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.rest.service.ItemService;
import com.evaluation.rest.service.IterationService;

@RestController
@RequestMapping("/project")
public class ItemController {

	@Autowired
	private ItemService itemServ;
	

	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getAllItems(){
		
        List itemList=itemServ.getAllItems();
        return itemList;
    }
	
	@RequestMapping(value = "/getIterationItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getIterationItems(){
        List iterationItemList=itemServ.getIterationItemList();
        return iterationItemList;
    }
	
	@RequestMapping(value = "/insertItem", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String insertItem() throws ParseException{
        itemServ.insertProjItem();
        return "new item added";
    }
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteItem() throws ParseException{
        itemServ.deleteItem(14);
        return "new item deleted";
    }
}
