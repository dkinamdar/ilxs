package com.ilxs.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.ilxs.utils.RespMsgUtil;
import com.ilxs.messages.ResponseMessage;
import com.ilxs.services.SampleService;

@Controller
@RequestMapping("/api/sample")
public class SampleController {
	@Autowired
	SampleService sampleService;
	
	@PostMapping("/sampleApi")
	  @ApiOperation(produces = "application/json", value = "Description - One liner", 
	  notes = "Brief description of what the API does. Any layman should understand how to fire the API after reading this."
	  		+ "Any other highlights and flags to be posted."
	  		+ "Any behavior specifics related to the request parameters and request body."
	  		+ "")
	  @ApiResponses(value = {
			  @ApiResponse(code = 200, message = RespMsgUtil.sample_200),
			  @ApiResponse(code = 400, message = RespMsgUtil.sample_400),
			  @ApiResponse(code = 404, message = RespMsgUtil.sample_404),
			  @ApiResponse(code = 409, message = RespMsgUtil.sample_409),
			  @ApiResponse(code = 500, message = RespMsgUtil.sample_500)
	  })
	  public ResponseEntity<ResponseMessage> addStandardRelay(
			  @ApiParam(value = "Number 1", required = true) @RequestParam("num1") int num1,
			  @ApiParam(value = "Number 2", required = true) @RequestParam("num2") int num2) {
	    
	      try {
	    	  return sampleService.addTwoNumbers(num1, num2);
	      } catch (Exception e) {
	          e.printStackTrace();
		      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(RespMsgUtil.sample_500));
	      }
	  }
}
