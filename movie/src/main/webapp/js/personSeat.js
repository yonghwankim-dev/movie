let current_person = 0;	// 현재 선택한 사람수
let activated_seat = 0; // 선택한 좌석수

const seats = document.querySelectorAll("#showMapTableBody tr td.seat");
const seats_td = document.querySelectorAll("#showMapTableBody td");
const actived_seat_input = document.querySelectorAll("#showMapTableBody tr td.seat.active input");
const person_10_num = document.querySelector("#person_10 .txt_num");    // 청소년 인원 * 10,000
const person_20_num = document.querySelector("#person_20 .txt_num");    // 성인 인원 * 14,000
const person_12_num = document.querySelector("#person_12 .txt_num");    // 노약자 인원 * 7,000
const total_price = document.querySelector(".total_price dd strong");	// 좌석값 전체합계
const input_price = document.querySelector("#input_price");				
const input_seat =document.querySelector("#input_seat");

const input_person_10 = document.querySelector("#input_person_10"); // 청소년 input 태그
const input_person_20 = document.querySelector("#input_person_20"); // 성인 input 태그
const input_person_12 = document.querySelector("#input_person_12"); // 노약자 input 태그

// 청소년/성인/노약자 플러스-마이너스 버튼
const person10_plus_btn = document.querySelector("#person_10 .btn_plus");
const person10_mins_btn = document.querySelector("#person_10 .btn_mins");
const person20_plus_btn = document.querySelector("#person_20 .btn_plus");
const person20_mins_btn = document.querySelector("#person_20 .btn_mins");
const person12_plus_btn = document.querySelector("#person_12 .btn_plus");
const person12_mins_btn = document.querySelector("#person_12 .btn_mins");

// 인원 증가 
const increasePerson = function(){
	current_person++;
}
// 인원 감소
const decreasePerson = function(){
	current_person--;
}

// 좌석 상태(선택/선택불가)초기화
const resetSeatStatus = function(){
    seats.forEach((seat)=>{
        if(seat.classList
               .contains("no_select")){
            seat.classList.remove("no_select");
        }
		if(seat.classList.contains("active")){
			seat.classList.remove("active");
		}
    });

	activated_seat = 0;
	total_price.textContent = input_price.value 
                            = input_price.textContent
							= 0;	
}

// 좌석 선택 완료
const completeSelect = function(){		
    let sum = 0;

	const step1 = ()=>{
		return new Promise((resolve, reject)=>{
			seats.forEach((seat)=>{
		        if(!seat.classList.contains("active"))
		        {
		            seat.classList.add("no_select");
		        }
		    });	
			resolve();		
		});
	};

	const step2 = ()=>{
		return new Promise((resolve, reject)=>{
			actived_seat_input.forEach((input)=>{
				input_seat.value += (input.value+" ");
			});
			input_seat.value = input_seat.value.trim();
			resolve();		
		});
	};    
	
	step1().then(step2);
	
    // 영화 요금 합계
    sum = Number(person_10_num.value)*10000 
		+ Number(person_20_num.value)*14000
		+ Number(person_12_num.value)*7000;
		
    total_price.textContent = input_price.value 
                            = input_price.textContent 
                            = sum;
}

// 선택 완료 해제
const clearSelect = function(){
    const total_price = document.querySelector(".total_price dd strong");

    seats.forEach((seat)=>{
        if(seat.classList
               .contains("no_select")){
            seat.classList.remove("no_select");
        }
    });
	
    total_price.textContent = 0;
}

// 좌석 선택
const activeSeat = function(e){
    
    if(current_person===0 
    || e.currentTarget.classList.contains("reserved") 
    || e.currentTarget.classList.contains("no_select")){
        return;
    }
    
    if(e.currentTarget
        .classList
        .contains("active")){
        e.currentTarget.classList.remove("active");
        activated_seat--;

		clearSelect();
    }
    else{
        e.currentTarget.classList.add("active");
        activated_seat++;

        if(current_person===activated_seat){
            completeSelect();
            return;
        }
    }
};

////////////////////////////////////////////////////////////////////////////

// 청소년 플러스(+) 버튼 클릭 이벤트
const person10_plus_click = function(){    
    const plus_num = Number(person_10_num.value) + 1;

    person_10_num.value = input_person_10.value = plus_num;
	increasePerson();
	
	if(activated_seat >= 1){
		resetSeatStatus();	
	}
}

// 청소년 마이너스(-) 버튼 클릭 이벤트
const person10_mins_click = function(){
    const mins_num = Number(person_10_num.value) -1;

    if(person_10_num.value==='0'){
        return;
    }
    
    person_10_num.value = input_person_10.value = mins_num;
	decreasePerson();
	
	if(activated_seat >= 1){
		resetSeatStatus();	
	}
}

// 성인 플러스(+) 버튼 클릭 이벤트
const person20_plus_click = function(){	
    const plus_num = Number(person_20_num.value) + 1;
    
    person_20_num.value= input_person_20.value = plus_num;
    increasePerson();

	if(activated_seat >= 1){
		resetSeatStatus();	
	}
}
// 성인 마이너스(-) 버튼 클릭 이벤트
const person20_mins_click = function(){
	const minus_num = Number(person_20_num.value) - 1;
	
    if(person_20_num.value==='0'){
        return;
    }
    
    person_20_num.value = input_person_20.value = minus_num;
	decreasePerson();
	
	if(activated_seat >= 1){
		resetSeatStatus();	
	}
}

// 시니어 플러스(+) 버튼 클릭 이벤트
const person12_plus_click = function(){
    const plus_num = Number(person_12_num.value) + 1;

    person_12_num.value = input_person_12.value = plus_num;
	increasePerson();
	
	if(activated_seat >= 1){
		resetSeatStatus();	
	}
}

// 시니어 마이너스(-) 버튼 클릭 이벤트
const person12_mins_click = function(){
	const minus_num = Number(person_12_num.value) - 1;
	
    if(person_12_num.value==='0')
    {
        return;
    }
    
    person_12_num.value= input_person_12.value = minus_num;
	
	decreasePerson();
	
	if(activated_seat >= 1){
		resetSeatStatus();	
	}
}

////////////////////////////////////////////////////////////////////////////////

// 좌석 클릭 이벤트 등록
seats_td.forEach((item)=>{
    item.addEventListener("click",activeSeat);
});

// 청소년/성인/노약자 플러스-마이너스 버튼, 이벤트 등록 
person10_plus_btn.addEventListener("click",person10_plus_click);
person10_mins_btn.addEventListener("click",person10_mins_click);
person20_plus_btn.addEventListener("click",person20_plus_click);
person20_mins_btn.addEventListener("click",person20_mins_click);
person12_plus_btn.addEventListener("click",person12_plus_click);
person12_mins_btn.addEventListener("click",person12_mins_click);

////////////////////////////////////////////////////////////////////////////////







