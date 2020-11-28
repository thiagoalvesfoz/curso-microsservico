package com.course.mspayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.course.mspayroll.entities.Worker;

@Component
@FeignClient(name="ms-worker", url="localhost:8001", path = "/workers")
public interface WorkerFeignClient  {

	@GetMapping("/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
	
}
