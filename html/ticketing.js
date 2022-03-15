import init_calendar from "./calendar.js"


// 지역 선택
const activeLocation = function(e){

    const step1 = ()=>{
      return new Promise((resolve, reject)=>{
        const depth2 = document.querySelectorAll(".depth2");

        // 모든 구 선택 해제
        depth2.forEach((d)=>{d.classList.remove("active")});
        resolve();
      });
    }

    const step2 = ()=>{
      return new Promise((resolve, reject)=>{
        const depth1 = document.querySelectorAll(".depth1");

        // 모든 지역 선택 해제
        depth1.forEach((d)=>{d.classList.remove("active")});
        resolve();
      });
      
    }

    const step3 = ()=>{
      return new Promise((resolve, reject)=>{
        const selectedLocation = e.currentTarget;

        // 선택된 지역 선택 활성화
        selectedLocation.classList.add("active");
        resolve();
      });
    }

    const step4 = ()=>{
      return new Promise((resolve, reject)=>{
        const activatedDepth2 = document.querySelector(".depth1.active > .depth2");

        // 선택된 지역에 존재하는 영화관 활성화
        activatedDepth2.classList.add("active");
        resolve();
      });
    }

    step1().then(step2)
           .then(step3)
           .then(step4);
}
// 영화관 선택
const activeCinema = function(e){
  const step1 = ()=>{
    return new Promise((resolve, reject)=>{
      const cinemas = document.querySelectorAll(".depth2 > ul > li");
      
      // 모든 영화관 선택 해제
      cinemas.forEach((cinema)=>{cinema.classList.remove("active")});
      resolve();
    });
  }

  const step2 = ()=>{
    return new Promise((resolve, reject)=>{
      const selectedMovie = e.currentTarget;

      // 선택된 영화관 선택 활성화
      selectedMovie.classList.add("active");
      resolve();
    });
  }

  const step3 = ()=>{
    return new Promise((resolve, reject)=>{
      const title = document.querySelector(".article.article_cinema .group_top .tit");

      // 영화관 제목에 선택된 영화제목 출력
      title.textContent = e.currentTarget.innerText;
      resolve();
    });
  }
  
  step1().then(step2)
         .then(step3);
}

// 영화선택
const activeMovie = function(e, movieName){
  const title = document.querySelector(".article.article_movie .group_top .tit");
  const selectedMovie = e.currentTarget;
  const movies = document.querySelectorAll(".movie_select_wrap ul li");
  const times = document.querySelectorAll(".tab_wrap.outer li .tab_con");

  // 모든 영화 선택 해제
  const step1 = ()=>{
    return new Promise((resolve, reject)=>{
      movies.forEach((movie)=>{movie.classList.remove("active")});
      resolve();
    });
  };

  // 클릭한 영화 선택 활성화
  const step2 = ()=>{
    return new Promise((resolve, reject)=>{
      selectedMovie.classList.add("active");    
      resolve();
    });
  };

  // 선택한 영화를 제목에 출력
  const step3 = ()=>{
    return new Promise((resolve, reject)=>{
      title.textContent = selectedMovie.innerText;    
      resolve();
    });
  };

  // 영화에 맞는 상영날짜 활성화
  const step4 = ()=>{
    return new Promise((resolve, reject)=>{
      times.forEach((time)=>{
        if(time.id===movieName)
        {
          time.classList.add("active");
        }
        else
        {
          time.classList.remove("active");
        }
      });    
      resolve();
    });
  };

  step1().then(step2)
         .then(step3)
         .then(step4);
}

// 초기화
const init = ()=>{
  // 지역 버튼 클릭시 해당 지역의 영화관 리스트 활성화 이벤트 등록
  const depth1 = document.querySelectorAll(".depth1");
  depth1.forEach((d)=>{d.addEventListener("click",activeLocation);});

  // 영화관 클릭 이벤트 등록
  const cinemas = document.querySelectorAll(".depth2 > ul > li");
  cinemas.forEach((cinema)=>{cinema.addEventListener("click",activeCinema);});

  // 영화 선택 이벤트 등록
  const movies = document.querySelectorAll(".movie_select_wrap ul li");
  movies.forEach((movie)=>{movie.addEventListener("click",(e)=>{activeMovie(e,e.currentTarget.textContent.trim());});});
};
init();
init_calendar();
