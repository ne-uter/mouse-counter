package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BabyMiceEntity;
import com.example.demo.repository.BabyMiceMapper;
@Service
public class BabyMiceService {

	private Set<Integer> weaningSet = new LinkedHashSet<Integer>();
	
	@Autowired
	BabyMiceMapper babyMiceMapper;
	
	public Set<Integer> getWeaningSet() {
		return weaningSet;
	}
	
	public void setWeaningSet(int id) {
		this.weaningSet.remove(id);
	}
	
	public void deleteHopper(int id) {
		babyMiceMapper.deleteHopper(id);
	}
	
	public List<BabyMiceEntity> selectAll() {
		return babyMiceMapper.selectAll();
	}
	
	public Map<String, Integer> babiesTotal() {
		List<BabyMiceEntity> list = babyMiceMapper.selectAll();
		Map<String, Integer> babiesTotal = new LinkedHashMap<String, Integer>();
		babiesTotal.put("ホッパー", 0);
		babiesTotal.put("ファジー", 0);
		babiesTotal.put("ピンク", 0);
		for (BabyMiceEntity l : list) {
			if (l.getSize().equals("hopper")) {
				babiesTotal.put("ホッパー", babiesTotal.get("ホッパー") + l.getLitters());
			}else if (l.getSize().equals("fuzzy")) {
				babiesTotal.put("ファジー", babiesTotal.get("ファジー") + l.getLitters());
			}else if (l.getSize().equals("pink")) {
				babiesTotal.put("ピンク", babiesTotal.get("ピンク") + l.getLitters());
			}
		}
		return babiesTotal;
	}
	
	public void babyRegister(BabyMiceEntity babyMiceEntity) {
		babyMiceMapper.insert(babyMiceEntity);
	}
	
	
	//毎日0時に判定を行い、一週間ごとに自動で成長させる
	@Scheduled(cron = "0 0 0 * * *")
	public void growth() {
		List<BabyMiceEntity> list = babyMiceMapper.selectAll();
		Calendar pink = Calendar.getInstance();
		pink.add(Calendar.DATE, -7);
		Calendar fuzzy = Calendar.getInstance();
		fuzzy.add(Calendar.DATE, -14);
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		
		for (BabyMiceEntity l : list) {
			if (l.getBirthday().equals(sdf.format(pink.getTime()))) {
				l.setSize("fuzzy");
				babyMiceMapper.autoUpdate(l);
			}else if (l.getBirthday().equals(sdf.format(fuzzy.getTime()))) {
				l.setSize("hopper");
				babyMiceMapper.autoUpdate(l);
			}
			if (l.getSize().equals("hopper")) {
				this.weaningSet.add(l.getId());
			}
		}
	}
}
