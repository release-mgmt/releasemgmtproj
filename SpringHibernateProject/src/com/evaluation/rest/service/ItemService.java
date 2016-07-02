package com.evaluation.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.Dao.ItemsDao;

@Service
public class ItemService {

	@Autowired
	private ItemsDao itemDao;
	
	public List getAllItems(){
		List items=itemDao.itemList();
		return items;
	}
	
	public List getIterationItemList(){
		List IterationsItems=itemDao.iterationItemList(1);//you have to take the iteration id form the angular js
		return IterationsItems;
	}

	public int insertProjItem(int iteration_id)  {
		
		int itemId=itemDao.insertItem(iteration_id);
		return itemId;
	}
	
	public void deleteItem(int item_id){
		itemDao.deletinItem(item_id);
	}
}
