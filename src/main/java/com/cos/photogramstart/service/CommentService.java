package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.comment.Comment;
import com.cos.photogramstart.domain.comment.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	@Transactional
	public Comment saveComment() { // 댓글쓰기 
		return null;
	}
	
	@Transactional
	public Comment deleteComment() { // 댓글삭제
		return null;		
	}
}
