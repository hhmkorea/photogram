package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscribeService {

	private final SubscribeRepository subscribeRepository;
	
	@Transactional
	public void subscribe(int fromUserId, int toUserId) {	// void로 테스트, result 값을 던질수 있으나 깔끔하게 Handler에서 try catch 문으로 처리
		subscribeRepository.mSubscribe(fromUserId, toUserId);
	}
	
	@Transactional
	public void unSubscribe(int fromUserId, int toUserId) {
		subscribeRepository.mUnSubscribe(fromUserId, toUserId);
	}
}
