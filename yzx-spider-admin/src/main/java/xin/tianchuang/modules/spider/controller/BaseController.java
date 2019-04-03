package xin.tianchuang.modules.spider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;

@Controller
public class BaseController {

	@Autowired
	protected EjbDozerGenerator ejbGenerator;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

}
