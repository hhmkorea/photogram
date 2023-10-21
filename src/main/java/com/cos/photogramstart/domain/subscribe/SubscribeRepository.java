package com.cos.photogramstart.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer>{

	@Modifying // INSERT, DELETE, UPDATE를 Native Query로 작성하려면 해당 anotation 필요!!
	@Query(value = "INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES (:fromUserId, :toUserId, now())", nativeQuery = true)  
	void mSubscribe(int fromUserId, int toUserId); // 1 : 1건 성공, -1 : 실패, 0 : 변경된 행이 없음.
	// void로 테스트, result 값을 던질수 있으나 깔끔하게 Handler에서 try catch 문으로 처리
	
	@Modifying
	@Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery = true)  
	void mUnSubscribe(int fromUserId, int toUserId);
}
