package com.springmvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.vo.State;

@Repository
public interface StateDao extends CrudRepository<State, Integer> {



}
