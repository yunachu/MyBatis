package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.vo.MDBoardVo;

public class MDBoardDao extends SqlMapConfig {
	private String namespace = "multi.";

	// 게시판 목록
	public List<MDBoardVo> selectAll() {
		SqlSession session = null;
		List<MDBoardVo> res = null;

		try {

			session = getSqlSessionFactory().openSession(true);
			res = session.selectList(namespace + "selectAll");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public MDBoardVo selectOne(int seq) {
		SqlSession session = null;
		MDBoardVo res = null;

		session = getSqlSessionFactory().openSession(true);// session 준비

		res = session.selectOne(namespace + "selectOne", seq);// selectOne에 매개변수 seq보내서 돌려받은 값 res에 담아주기

		session.close();

		return res;

	}

	public int insert(MDBoardVo vo) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "insert", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public int update(MDBoardVo vo) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "update", vo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;

	}

	public int delete(int seq) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace + "delete", seq);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int multiDelete(String[] seq) {

		int count = 0;
		Map<String, String[]> map = new HashMap<>();
		map.put("seq", seq);

		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession(false); //1. 오토커밋 FALSE해두고
			count = session.delete(namespace + "muldel", map);
			if (count == seq.length) {
				session.commit(); //2. 잘 삭제 된 다음 커밋
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}

		return count;

	}

}