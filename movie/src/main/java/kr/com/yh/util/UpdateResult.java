package kr.com.yh.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class UpdateResult {
	public Map<String, Object> resMap;
	public Gson gson;
	public String jsonData;
	public PrintWriter out;
	
	public UpdateResult(HttpServletResponse resp) throws IOException {
		resMap = new HashMap<String, Object>();
		gson = new Gson();
		jsonData = null;
		out = resp.getWriter();
	}
	
	/**
	 * 해시맵에 key-value 추가
	 * @param var key의 이름
	 * @param msg value의 내용
	 */
	public void addToResMap(String var, Object msg) {
		resMap.put(var, msg);
	}
	
	/**
	 * 해시맵에 있는 정보를 json 형태로 변환하고 출력하는 기능
	 */
	public void write() {
		jsonData = gson.toJson(resMap);	// map을 json형식으로 변환
		out.write(jsonData);			// jsonData를 작성
		out.flush();					// 출력
	}
}
