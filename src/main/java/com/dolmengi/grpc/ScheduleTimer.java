package com.dolmengi.grpc;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dolmengi.grpc.service.GreeterGrpcClient;

@Component
public class ScheduleTimer {

	@Resource
	GreeterGrpcClient greeterGrpcClient;

	@Scheduled(fixedRate = 2000)
	public void Timer() {
		greeterGrpcClient.test();
	}

}
