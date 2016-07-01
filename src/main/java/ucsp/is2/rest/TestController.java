package ucsp.is2.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ucsp.is2.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value="/test/get/json", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map testGetJson() {
		Map response = new HashMap();
		Map message = new HashMap<>();

		String result = testService.test();
		message.put("message", result);
		response.put("test", message);
		return response;
	}
}
