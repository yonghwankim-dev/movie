// 날짜 출력
const date_info={
    monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayList: ['일', '월', '화', '수', '목', '금', '토'],
    today : new Date()
  };

  const createDate = (date, checked)=>{
    // 월 표시 설정
    const getMonth = ()=>{
        let month = "";
        if(date_info.today.getDate() === date.getDate())
        {
            month = "<strong class='month'>3월</strong>";
        }
        else if(date_info.today.getMonth()!==date.getMonth() && date.getDate()==1)
        {
            month = "<strong class='month'>"+(date.getMonth()+1)+"월</strong>";
        }
        return month;
    }

    // 토/일 색상 설정
    const getWeekend = ()=>{
        let weekend = "";
        
        if(date_info.dayList[date.getDay()]==="토")
        {
            weekend = " sat";
        }
        else if(date_info.dayList[date.getDay()]==="일")
        {
            weekend = " sun";
        }
        return weekend;
    }
	
    const owl_item = document.createElement("div");
    const today = date_info.today.getDate() === date.getDate() ? "오늘" : date_info.dayList[date.getDay()];
    const month = getMonth();	
    const weekend = getWeekend();
	const screen_date = date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate();
    const dateItem = "<li class='item'>" +
                        month +
                        "<span class='date"+ weekend +"'>" +
                        "<label>" +
                       		"<input type='radio' class='screen_date' name='screen_date' value='"+screen_date+"'"+checked+">" +
                            "<strong>"+date.getDate()+"</strong>" +
                            "<em>"+today+"</em>" +
                        "</label>" +
                        "</span>" +
                    "</li>";
    
    owl_item.classList.add(["owl-item"]);
    owl_item.innerHTML = dateItem;
    return owl_item;
  };
    
  // 오늘을 기준으로 14일 달력 생성
  const create14Calendar = function(){
    const owl_stage = document.querySelector(".owl-stage");
    const date = new Date();
	const input_selected_date = document.querySelector(".input_selected_date");	// 선택한 라디오 버튼
	const selected_date = new Date(input_selected_date.value);
	let checked = "";
		
    // 오늘 일자를 기준으로 2주후까지 출력
    for(let i=0;i<14;i++)
    {
	  if(selected_date.getDate()==date.getDate())
	  {
		checked = "checked";	
	  }	  
	  else
	  {
		checked = "";
	  }
      owl_stage.appendChild(createDate(date, checked));
      date.setDate(date.getDate()+1);
    }
  
    // 첫 일주일은 출력
    const owl_items = document.querySelectorAll(".owl-item");
    for(let i=0;i<8;i++)
    {
      owl_items[i].className += " active";
    }
  }
  
  // 다음주 버튼
  const nextWeek = function(){
    const items = document.querySelectorAll(".owl-item");
    let first = 0;
    let last = 7;
  
    // active class가 처음 시작된 일자를 탐색
    for(let i=0;i<items.length;i++)
    {
      if(items[i].classList.contains("active"))
      {
        first = i;
        break;
      }
    }
  
    if(first===items.length-8)
    {
      return;
    }
  
    // 다음주의 일자들의 class에 active를 추가
    last = first + 7;
    for(let i=first;i<=last;i++)
    {
      if(i+8<items.length)
      {
        items[i].classList.remove("active");
        items[i+8].classList.add("active");      
      }
    }
  }
  
  // 저번주 버튼
  const prevWeek = function(){
    const items = document.querySelectorAll(".owl-item");
    let first = 0;
    let last = 7;
    // active class가 처음 시작된 일자를 탐색
    for(let i=0;i<items.length;i++)
    {
      if(items[i].classList.contains("active"))
      {
        first = i;
        break;
      }
    }
    
    if(first==0)
    {
      return;
    }
    else
    {
      last = first+7;
      for(let i=first;i<=last;i++)
      {
        if(i-8>=0)
        {
          items[i].classList.remove("active");
          items[i-8].classList.add("active");
        }
      }
      
    }
  }

  // 날짜 라디오 버튼 클릭
  const change_screen_date = (e)=>{
	document.querySelector("#change_screen_date").submit();
  };

  
  const init_calendar = function(){
	
    const nextWeekBtn = document.querySelector(".owl-next");
    const prevWeekBtn = document.querySelector(".owl-prev");

	const step1 = ()=>{
		return new Promise((resolve, reject)=>{
			nextWeekBtn.addEventListener("click",()=>{nextWeek()});
    		prevWeekBtn.addEventListener("click",()=>{prevWeek()});
			resolve();
		});
	};
	
	const step2 = ()=>{
		return new Promise((resolve, reject)=>{
			create14Calendar();
			resolve();
		});
	};
  
  	const step3 = ()=>{
		return new Promise((resolve, reject)=>{
			// 날짜 라디오 버튼 클릭 이벤트 등록
			const screens_dates = document.querySelectorAll(".screen_date");
			screens_dates.forEach((screen_date)=>{
				screen_date.addEventListener("click",(e)=>{
					change_screen_date(e);
				});
			 });
			resolve();			
		});
	};  
	
	step1().then(step2)
		   .then(step3);	  
  }

export default init_calendar;