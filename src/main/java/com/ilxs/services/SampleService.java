package com.ilxs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ilxs.impl.SampleImpl;
import com.ilxs.messages.ResponseMessage;

@Service
public class SampleService {
	@Autowired
	SampleImpl sampleImpl;
	public ResponseEntity<ResponseMessage> addTwoNumbers(int num1, int num2) {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(String.valueOf(sampleImpl.addTwoNumbers(num1, num2))));
	}
}
