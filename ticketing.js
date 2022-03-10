

const activeLocation = function(e){
    let i, location_content, locations, loc;
  
    location_content = document.querySelectorAll(".depth2");
    for (i = 0; i < location_content.length; i++) {
      location_content[i].style.display = "none";
    }
  
    locations = document.querySelectorAll(".depth1");
    for (i = 0; i < location_content.length; i++) {
      locations[i].className = locations[i].className.replace(" active", "");
    }
  
    
    e.currentTarget.className += " active";
    loc = document.querySelector(".depth1.active > .depth2");
    loc.style.display = "block";
}
// 지역(서울, 대전 등) 버튼들의 active 활성화
const depth1s = document.querySelectorAll(".depth1");
depth1s.forEach((item)=>{
    item.addEventListener("click",activeLocation); 
});
////////////////////////////////////////////////////////////////////////////////

const activeArea = function(e){
    let i,  areas;
  
    areas = document.querySelectorAll(".depth2 > ul > li");
    for (i = 0; i < areas.length; i++) {
      areas[i].className = areas[i].className.replace("active", "");
    }

    e.currentTarget.className += "active";
}
const areas = document.querySelectorAll(".depth2 > ul > li");
areas.forEach((item)=>{
    item.addEventListener("click",activeArea);
});

////////////////////////////////////////////////////////////////////////////////
// 영화관 선택
const activeCinema = function(e){
  const cinemas = document.querySelectorAll(".cinema_select_wrap ul li");
  
  for (i = 0; i < cinemas.length; i++) {
    cinemas[i].classList.remove("active");
  }

  e.currentTarget.classList.add("active");
}
const cinemas = document.querySelectorAll(".cinema_select_wrap ul li");
cinemas.forEach((item)=>{
  item.addEventListener("click",activeCinema);
})



////////////////////////////////////////////////////////////////////////////////
// 날짜 출력

const init={
  monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  dayList: ['일', '월', '화', '수', '목', '금', '토'],
  today : new Date()
};

const createDate = function(mon, date, day){
  const owl_item = document.createElement("div");
  const li = document.createElement("li");
  const span = document.createElement("span");
  const label = document.createElement("label");
  const input = document.createElement("input");
  const strong = document.createElement("strong");
  const em = document.createElement("em");

  span.appendChild(label);
  label.appendChild(input);
  label.appendChild(strong);
  label.appendChild(em);
  owl_item.appendChild(li);

  owl_item.className = "owl-item"
  li.className = "item";
  span.className = "date";
  input.type = "radio";
  input.name = "radioDate1";
  strong.textContent = date;
  em.textContent = init.dayList[day];
  owl_item.style.width = "52.5px";

  // 오늘 일자에 월과 오늘 표시
  if(init.today.getDate()===date)
  {
    em.textContent = "오늘";
    const month = document.createElement("strong");
    month.textContent = (init.today.getMonth()+1) + "월";
    month.className += " month";
    li.appendChild(month);
  }
  else if(init.today.getMonth()!==mon && date==1)
  {
    const month = document.createElement("strong");
    month.textContent = (mon+1) + "월";
    month.className += " month";
    li.appendChild(month);
  }
  li.appendChild(span);
  

  // 주말에 색상 설정
  if(init.dayList[day]==="토")
  {
    span.className += " sat";
  }
  else if(init.dayList[day]==="일")
  {
    span.className += " sun";
  }

  return owl_item;
}

const createCalendar = function(){
  const owl_stage = document.querySelector(".owl-stage");

  let date = new Date();
  // 오늘 일자를 기준으로 한달후까지 출력
  for(let i=0;i<30;i++)
  {
    owl_stage.appendChild(createDate(date.getMonth(),date.getDate(),date.getDay()));
    date.setDate(date.getDate()+1);
  }

  const owl_items = document.querySelectorAll(".owl-item");
  for(let i=0;i<8;i++)
  {
    owl_items[i].className += " active";
  }
}

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
  console.log("first : " + first + " last : " + last);
  for(let i=first;i<=last;i++)
  {
    if(i+8<items.length)
    {
      items[i].classList.remove("active");
      items[i+8].classList.add("active");      
    }
  }
}

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
    console.log("first : " + first + " last : " + last);
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

const nextWeekBtn = document.querySelector(".owl-next");
const prevWeekBtn = document.querySelector(".owl-prev");

nextWeekBtn.addEventListener("click",()=>{nextWeek()});
prevWeekBtn.addEventListener("click",()=>{prevWeek()});

createCalendar();

////////////////////////////////////////////////////////////////////////////////