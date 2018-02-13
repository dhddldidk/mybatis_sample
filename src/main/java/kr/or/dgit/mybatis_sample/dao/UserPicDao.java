package kr.or.dgit.mybatis_sample.dao;

import kr.or.dgit.mybatis_sample.dto.UserPic;

public interface UserPicDao {
	int insertUserPic(UserPic userPic);
	UserPic getUserPic(int id);
}
