package kr.com.yh.lotte.vo.component;

import java.util.List;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.TheaterVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaTheaterVO {
	private CinemaVO cinema;
	private List<TheaterVO> theaters;	
}
