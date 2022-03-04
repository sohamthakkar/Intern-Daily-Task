package com.springmvc.service;

import java.util.List;

import com.springmvc.vo.State;

public interface StateService {

	public void doInsert(State state);

	public List<State> doSearch();

	

}
