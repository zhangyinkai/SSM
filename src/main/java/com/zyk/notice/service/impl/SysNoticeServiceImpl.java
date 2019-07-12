package com.zyk.notice.service.impl;


import com.zyk.notice.dao.SysNoticeMapper;
import com.zyk.notice.entity.SysNotice;
import com.zyk.notice.service.SysNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;


@Service
@Slf4j
public class SysNoticeServiceImpl implements SysNoticeService {
	@Autowired
	private SysNoticeMapper sysNoticeMapper;

	@Override
	public int insert(SysNotice record) {
		return sysNoticeMapper.insert(record);
	}

	@Override
	@Cacheable(value = "sysNotice",key = "'notice-id-'+#noticeId")
	public SysNotice selectByPrimaryKey(Long noticeId) {
		log.info(" >>> fetch db notice...");
		return sysNoticeMapper.selectByPrimaryKey(noticeId);
	}

	@Override
	@CachePut(value = "sysNotice",key = "'notice-id-'+#record.getNoticeId()")
	public SysNotice updateByPrimaryKeySelective(SysNotice record) {
		log.info(" >>> update db notice...");
		sysNoticeMapper.updateByPrimaryKeySelective(record);
		return sysNoticeMapper.selectByPrimaryKey(record.getNoticeId());
	}


	@Override
	@CacheEvict(value = "sysNotice",allEntries=true ,beforeInvocation = true)
	public void cleanAllCache() {

	}

	@Override //测试
	public SysNotice getSysNoticeById(Long noticeId){
		return this.selectByPrimaryKey(noticeId);
	}

	@Override
	public int addNotice() {//声明式事务回滚
		Date date = new Date();
		String dateStr = DateUtils.format(date,"yyyy-MM-dd HH:mm:ss",Locale.getDefault());
		SysNotice sysNotice = new SysNotice();
		sysNotice.setNoticeTitle("test");
		sysNotice.setNoticeContent("test");
		sysNotice.setBeginTime(dateStr);
		sysNotice.setCreatedTime(dateStr);
		sysNotice.setOverTime(dateStr);
		sysNotice.setStatus(0);
		insert(sysNotice);

		int[] arr = new int[2];

		int z = arr[3];
		insert(sysNotice);
		return 0;
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	public int createNotice() {//编程式事务回滚
		Date date = new Date();
		String dateStr = DateUtils.format(date,"yyyy-MM-dd HH:mm:ss",Locale.getDefault());
		SysNotice sysNotice = new SysNotice();
		sysNotice.setNoticeTitle("test2");
		sysNotice.setNoticeContent("test");
		sysNotice.setBeginTime(dateStr);
		sysNotice.setCreatedTime(dateStr);
		sysNotice.setOverTime(dateStr);
		sysNotice.setStatus(0);
		insert(sysNotice);

		int[] arr = new int[2];

		int z = arr[3];
		sysNotice.setNoticeTitle("test3");
		insert(sysNotice);
		return 0;
	}
}