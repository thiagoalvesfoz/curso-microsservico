package com.course.mspayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mspayroll.entities.Payment;
import com.course.mspayroll.entities.Worker;
import com.course.mspayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();				
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
