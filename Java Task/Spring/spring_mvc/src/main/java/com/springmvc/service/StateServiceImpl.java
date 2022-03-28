package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.StateDao;
import com.springmvc.vo.State;

@Service
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired(required = true)
	private StateDao stateDao;

	public void doInsert(State state) {
		this.stateDao.save(state);

	}

	public List<State> doSearch() {

		List<State> stateList = (List<State>) this.stateDao.findAll();
		return stateList;
	}

}
