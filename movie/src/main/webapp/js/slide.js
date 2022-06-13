/**
 * 영화 예매 페이지에서 달력 부분을 제어 
 */

let start = 1;
let end   = 8;
showSlides(start, end);

// Next/previous controls
function plusSlides(n) {
  showSlides(start+=n, end +=n);
}

function showSlides(start, end) {
  let i;
  let slides = document.querySelectorAll(".mySlides");
  
  if(start > slides.length || end < 1){
    return;
  }

  if (end > slides.length) {end = slides.length}

  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for(i = start; i <= end; i++){
    slides[i-1].style.display = "inline-block";
  }
}
