package com.esh.react.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping(value = "/main.do")
	public String mainPage() {
		return "hello, Main Page!!";
	}
}
