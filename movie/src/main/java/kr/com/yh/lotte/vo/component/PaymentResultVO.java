package kr.com.yh.lotte.vo.component;

import kr.com.yh.lotte.vo.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * title : 결제 결과를 저장하는 VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResultVO {
    private BookVO book;
    private ScreenSchVO screenSch;
    private CinemaVO cinema;
    private TheaterVO theater;
    private List<SeatVO> seats;
}
