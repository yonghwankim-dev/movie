let current_person = 0;
let activated_seat = 0;

// 좌석 생성
const createSeatMap = function(){
    const seat_row = [null,"A","B","C","D","E","F","G","I"];
    const tbody = document.querySelector("#showMapTableBody");

    for(let i=1;i<=8;i++)
    {
        const tr = document.createElement("tr");

        const alpabat = document.createElement("td");
        alpabat.textContent = seat_row[i];
        tr.appendChild(alpabat);
        for(let j=1;j<=17;j++)
        {
            const td = document.createElement("td");
            const a = document.createElement("a");

            td.className = "seat";

            a.href = "#seat/"+seat_row[i]+j;
            a.textContent = j;

            td.appendChild(a);
            tr.appendChild(td);    
        }

        tbody.appendChild(tr);
    }
}

// 선택 완료
const completeSelect = function(){
    const seats = document.querySelectorAll("#showMapTableBody tr td.seat");
    const person_10_num = document.querySelector("#person_10 .txt_num");    // 청소년 인원 * 10,000
    const person_20_num = document.querySelector("#person_20 .txt_num");    // 성인 인원 * 14,000
    const person_12_num = document.querySelector("#person_12 .txt_num");    // 노약자 인원 * 7,000
    const total_price = document.querySelector(".total_price dd strong");
    let sum = 0;

    seats.forEach((seat)=>{
        if(!seat.classList.contains("active"))
        {
            seat.classList.add("no_select");
        }
    });

    // 영화 요금 합계
    sum = Number(person_10_num.textContent)*10000 + Number(person_20_num.textContent)*14000 + Number(person_12_num.textContent)*7000;
    total_price.textContent = sum;
}

// 선택 완료 해제
const clearSelect = function(){
    const seats = document.querySelectorAll("#showMapTableBody tr td.seat");
    const total_price = document.querySelector(".total_price dd strong");

    seats.forEach((seat)=>{
        if(seat.classList.contains("no_select"))
        {
            seat.classList.remove("no_select");
        }
    });

    total_price.textContent = 0;
}

// 좌석 선택
const activeSeat = function(e){
    
    if(current_person===0 || e.currentTarget.classList.contains("reserved") || e.currentTarget.classList.contains("no_select"))
    {
        return;
    }
    
    if(e.currentTarget.classList.contains("active"))
    {
        e.currentTarget.classList.remove("active");
        activated_seat -= 1;
        clearSelect();
    }
    else
    {
        e.currentTarget.classList.add("active");
        activated_seat += 1;

        if(current_person===activated_seat)
        {
            completeSelect();
            return;
        }
    }
};

createSeatMap();

const seats = document.querySelectorAll("#showMapTableBody td");
seats.forEach((item)=>{
    item.addEventListener("click",activeSeat);
});





////////////////////////////////////////////////////////////////////////////
// 청소년 +/-버튼 클릭
const person10_plus_click = function(){
    const txt_num = document.querySelector("#person_10 .txt_num");
    const plus_num = Number(txt_num.textContent) + 1;

    current_person += 1;
    txt_num.textContent = plus_num;
}
const person10_mins_click = function(){
    const txt_num = document.querySelector("#person_10 .txt_num");
    if(txt_num.textContent==='0')
    {
        return;
    }
    const mins_num = Number(txt_num.textContent) -1;
    current_person -= 1;
    txt_num.textContent = mins_num;
}

// 성인 +/- 버튼 클릭
const person20_plus_click = function(){
    const txt_num = document.querySelector("#person_20 .txt_num");
    const plus_num = Number(txt_num.textContent) + 1;

    current_person += 1;
    txt_num.textContent = plus_num;
}
const person20_mins_click = function(){
    const txt_num = document.querySelector("#person_20 .txt_num");
    if(txt_num.textContent==='0')
    {
        return;
    }

    const minus_num = Number(txt_num.textContent) - 1;
    current_person -= 1;
    txt_num.textContent = minus_num;
}

// 시니어 +/- 버튼 클릭
const person12_plus_click = function(){
    const txt_num = document.querySelector("#person_12 .txt_num");
    const plus_num = Number(txt_num.textContent) + 1;

    current_person += 1;
    txt_num.textContent = plus_num;
}
const person12_mins_click = function(){
    const txt_num = document.querySelector("#person_12 .txt_num");
    if(txt_num.textContent==='0')
    {
        return;
    }
    const minus_num = Number(txt_num.textContent) - 1;
    current_person -= 1;
    txt_num.textContent = minus_num;
}

const person10_plus = document.querySelector("#person_10 .btn_plus");
const person10_mins = document.querySelector("#person_10 .btn_mins");
const person20_plus = document.querySelector("#person_20 .btn_plus");
const person20_mins = document.querySelector("#person_20 .btn_mins");
const person12_plus = document.querySelector("#person_12 .btn_plus");
const person12_mins = document.querySelector("#person_12 .btn_mins");
person10_plus.addEventListener("click",person10_plus_click);
person10_mins.addEventListener("click",person10_mins_click);
person20_plus.addEventListener("click",person20_plus_click);
person20_mins.addEventListener("click",person20_mins_click);
person12_plus.addEventListener("click",person12_plus_click);
person12_mins.addEventListener("click",person12_mins_click);

////////////////////////////////////////////////////////////////////////////////







