// 날짜 출력
const date_info={
    monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayList: ['일', '월', '화', '수', '목', '금', '토'],
    today : new Date()
  };

  const createDate = (mon,date,day)=>{
    // 월 표시 설정
    const getMonth = ()=>{
        let month = "";
        if(date_info.today.getDate() === date)
        {
            month = "<strong class='month'>3월</strong>";
        }
        else if(date_info.today.getMonth()!==mon && date==1)
        {
            month = "<strong class='month'>"+(mon+1)+"월</strong>";
        }
        return month;
    }

    // 토/일 색상 설정
    const getWeekend = ()=>{
        let weekend = "";
        
        if(date_info.dayList[day]==="토")
        {
            weekend = " sat";
        }
        else if(date_info.dayList[day]==="일")
        {
            weekend = " sun";
        }
        return weekend;
    }
	
    const owl_item = document.createElement("div");
    const today = date_info.today.getDate() === date ? "오늘" : date_info.dayList[day];
    const checked = date_info.today.getDate() === date ? "checked" : "";
    const month = getMonth();
    const weekend = getWeekend();
    const dateItem = "<li class='item'>" +
                        month +
                        "<span class='date"+ weekend +"'>" +
                        "<label>" +
                            "<input type='radio' name='radioDate1'"+checked+">" +
                            "<strong>"+date+"</strong>" +
                            "<em>"+today+"</em>" +
                        "</label>" +
                        "</span>" +
                    "</li>";
    
    owl_item.classList.add(["owl-item"]);
    owl_item.innerHTML = dateItem;
    return owl_item;
  };
    
  // 오늘을 기준으로 30일 달력 생성
  const create30Calendar = function(){
    const owl_stage = document.querySelector(".owl-stage");
    const date = new Date();
    // 오늘 일자를 기준으로 한달후까지 출력
    for(let i=0;i<30;i++)
    {
      owl_stage.appendChild(createDate(date.getMonth(),date.getDate(),date.getDay()));
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
  
  const init_calendar = function(){
    const nextWeekBtn = document.querySelector(".owl-next");
    const prevWeekBtn = document.querySelector(".owl-prev");
  
    nextWeekBtn.addEventListener("click",()=>{nextWeek()});
    prevWeekBtn.addEventListener("click",()=>{prevWeek()});
  
    create30Calendar();  
  }

export default init_calendar;