package com.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.StateService;
import com.springmvc.vo.State;

@Controller
public class StateController {

	@Autowired(required = true)
	private StateService stateService;

	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("insertState", "key", new State());

	}

	@RequestMapping(value = "/insertState", method = RequestMethod.POST)
	public ModelAndView doInsert(@ModelAttribute State state, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		if (state.getStateName().isEmpty()) {
			out.println("Enter State........");
		} else {
			stateService.doInsert(state);
			out.println("Inserted State Successfully........");
		}

		return new ModelAndView("insertState", "key", new State());

	}

	@RequestMapping(value = "/searchState", method = RequestMethod.GET)
	public ModelAndView doSearch() {

		List<State> stateList = stateService.doSearch();

		return new ModelAndView("showState", "State", stateList);

	}

}
