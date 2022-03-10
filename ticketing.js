

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

