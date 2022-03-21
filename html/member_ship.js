const activeTab = (e)=>{
    const step1 = ()=>{
        return new Promise((resolve, reject)=>{
            const tab_items = document.querySelectorAll(".ship_content .tab_item");
          
            // 모든 영화관 선택 해제
            tab_items.forEach((tab_item)=>{tab_item.classList.remove("active")});
            resolve();
        });
    };
    
    const step2 = ()=>{
        return new Promise((resolve, reject)=>{
            const selectedTabItem = e.currentTarget;
        
            // 선택된 영화관 선택 활성화
            selectedTabItem.classList.add("active");
            resolve();
        });
    }

    step1().then(step2);
}

const init = ()=>{
    const tab_items = document.querySelectorAll(".ship_content .tab_item");
    tab_items.forEach((tab_item)=>{
        tab_item.addEventListener("click",(e)=>{
            activeTab(e);
        });
    });
};

init();