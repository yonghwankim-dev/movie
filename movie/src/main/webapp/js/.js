/**
 * 
 */
let tpNum = "";

listServer = function(page){
	$.ajax({
		url : '/LotteCgvBox/RefundList',
		type : 'post',
		data : {'page' : page},
		success : function(res){
			
			tpNum = res.tp;
			
			code = '<div class="panel-group" id="accordion">';
			
			$.each(res.datas, function(i,v){
				
				code += '<div class="panel panel-default">';
				code += '  <div class="panel-heading">';
				code += '    <h4 class="panel-title">';    
				code += '      <a idx="' + v.num + '" class="list" data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num + '">';
				code += 		v.subject + '</a>';      
				code += '    </h4>';
				code += '  </div>';
				code += '  <div id="collapse' + v.num + '" class="panel-collapse collapse">';
				code += '    <div class="panel-body pbody">';
				code += '		<div class="p1">작성자 : ' + v.writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '									조회수 : ' + v.hit + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '									날짜 : ' + v.wdate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '		</div>';
				code += '		<div class="p2">';
				code += '  			<input idx="' + v.num + '" type="button" name="modify" value="수정" class="action btn btn-warning btn-sm">';
				code += '			<input idx="' + v.num + '" type="button" name="delete" value="삭제" class="action btn btn-danger btn-sm">';
				code += '		</div>';
				code += '		<div class="p3">' + v.cont + '</div>';
				
				code += '		<hr>';
				code += '		<p class="p4">';
				code += '		  <textarea cols="90"></textarea>';
				code += '		  <input idx="' + v.num + '" type="button" value="등록" name="reply" class="action btn btn-primary">';
				code += '		</p>';
				
				code += '    </div>';
				code += '  </div>';
				code += '</div>';
			});
		    code += '</div>';
		    $('#list').html(code);
		    
		    pager = '<div class="container">';
		    if(res.sp >= 1){
		    	pager += '<ul class="pager">';
		    	pager += '<li><a class="prev" href="#">Prev</a></li></ul>';
		    }
		    pager += '<ul class="pagination pager">';
		    for(i=res.sp; i<=res.ep; i++){
		    	if(currentPage == i){
		    		pager += '<li class="active"><a class="paging" href="#">' + i + '</a></li>';
		    	}else{
		    		pager += '<li><a class="paging" href="#">' + i + '</a></li>';
		    	}
		    }
		    pager += '</ul>';
		    if(res.ep <= res.tp){
		    	pager += '<ul class="pager">';
		    	pager += '<li><a class="next" href="#">Next</a></li></ul>';
		    }
		    pager += '</div>';
		    $('#pagelist').html(pager);
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	});
};

$(function(){
	$('#pagelist').on('click', '.paging', function(){
		currentPage = $(this).text();
		listServer(currentPage);
	});
	
	$('#pagelist').on('click','.prev', function(){
		let vprev = $('.paging').first().text();
		
		if(vprev == 1){
		  currentPage = vprev;
		}else{
		  currentPage = vprev - 1;
		}
		listServer(currentPage);
	});
	
	$('#pagelist').on('click','.next', function(){
		let vnext = $('.paging').last().text();

		if(vnext == tpNum){
		  currentPage = vnext;	
		}else{
		  currentPage = parseInt(vnext) + 1;
		}
		listServer(currentPage);
	});
	
	$('#wrt').on('click', function(){
		$('#wModal').modal({backdrop : 'static'});
	});
	
	$('#send').on('click', function(){
		if($('#wrtNm').val() == ""){
			alert("이름을 입력하세요");
		}else if($('#wrtPw').val() == ""){
			alert("비밀번호를 입력하세요");
		}else if($('#wrtSj').val() == "")
			alert("제목을 입력하세요");
		else{
			writeServer();
		}
	});
	
	$('#list').on('click','.action', function(){
		
		let vname = $(this).attr('name');
		vidx = $(this).attr('idx');
		
		if(vname == 'reply'){
			
			vname1 = String.fromCharCode( Math.random() * 26 + 65 );	//대문자
			vname2 = String.fromCharCode( Math.random() * 26 + 97 );	//소문자
			vname3 = parseInt( Math.random() * 100 + 1 );	//숫자
			
			vcont = $(this).prev().val();
			$(this).prev().val("");
			
			reply={};
			reply.bonum = vidx;
			reply.name = vname1 + vname2 + vname3;
			reply.cont = vcont;
			replyServer(this);
		}else if(vname == 'delete'){
			let conf = confirm("정말 삭제합니까?");
			if(!conf){
				return false;
			}else{
			  deleteServer();
			}	
		}else if(vname == 'modify'){
			if($('#brdModiForm').css('display') != 'none') modiReset();
		
			brdModiCont = $(this).parents('.pbody').find('.p3').html();
			brdModiCont = brdModiCont.replace(/<br>/g, "\n");
			$('#brdModiForm textarea').val(brdModiCont);
			$(this).parents('.pbody').find('.p3').empty().append($('#brdModiForm'));
			$('#brdModiForm').show();	
		}else if(vname == 'r_modify'){
			
 			if($('#repModiForm').css('display') != "none") replyReset();
			
			repModiCont = $(this).parents('.rep').find('.cont').html();
			repModiCont = repModiCont.replace(/<br>/g, "\n");
			$('#repModiForm textarea').val(repModiCont);
			$(this).parents('.rep').find('.cont').empty().append($('#repModiForm'));
			$('#repModiForm').show();
				
		}else if(vname == 'r_delete'){
			$(this).parents('.rep').remove();			
			replyDelete();
		}
	});
	
	modiReset = function(){
		let pbodyp3 = $('#brdModiForm').parent();
		$('#brdModiForm').appendTo('body');
 		$('#brdModiForm').hide();
		brdModiCont = brdModiCont.replace(/\n/g, "<br>");
		$(pbodyp3).html(brdModiCont);
	}
	replyReset = function(){
		let contp3 = $('#repModiForm').parent();
		$('#repModiForm').appendTo('body');
		$('#repModiForm').hide();
		repModiCont = repModiCont.replace(/\n/g, "<br>");
		$(contp3).html(repModiCont);
	}

	$('#list').on('click', '.list', function(){
		boardNum = $(this).attr('idx');
		replyListServer(this);
	});
	
	$('#ok_b').on('click',function(){
		brdModiCont = $('#brdModiForm textarea').val();
		let pbodyp3 = $('#brdModiForm').parent();
		$('body').append($('#brdModiForm'));
		$('#brdModiForm').hide();
		let modi = brdModiCont.replace(/\r/g, "").replace(/\n/g, "<br>");
		$(pbodyp3).html(modi);
		modf = {};
		modf.bonum = vidx;
		modf.cont = brdModiCont;
		updateServer();
	});
	
	$('#cancel_b').on('click',function(){
		modiReset();
	});
	
	$('#ok_r').on('click',function(){
		repModiCont = $('#repModiForm textarea').val();	
		let contp3 = $('#repModiForm').parent();
		$('body').append($('#repModiForm'));
		$('#repModiForm').hide();
		let modi = repModiCont.replace(/\r/g, "").replace(/\n/g, "<br>");
		$(contp3).html(modi);
		reply = {};
		reply.renum = vidx;
		reply.cont = repModiCont;
		
		replyUpdate();
	});
	
	$('#cancel_r').on('click',function(){
		replyReset();
	});
});

/* ----------------------------------------------------------- */

/*게시글 저장*/
writeServer = function(){
	$.ajax({
		url : '/LotteCgvBox/Write',
		method : 'post',
		data : $('form').serialize(),
		success : function(res){
			if(res.sw == 'ok'){
				alert("게시글이 등록되었습니다");
				$('#wModal').modal('hide');
				$('.txt').val("");
			}else{
				alert("게시글 등록에 실패하였습니다");
				$('#wModal').modal('hide');
			}
			listServer(1);
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	});
};

/* ----------------------------------------------------------- */

/*게시글 삭제*/
deleteServer = function(){
	$.ajax({
		url : '/LotteCgvBox/Delete',
		type : 'post',
		data : {"vidx" : vidx},
		success : function(a){
			if(a.data == 1){
				alert("삭제되었습니다");
				listServer($('.active .paging').text());	
			}
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	});
}

/* ----------------------------------------------------------- */

/*게시글 수정*/
updateServer = function(){
	$.ajax({
		url : '/LotteCgvBox/Update',
		type : 'post',
		data : modf,
		success : function(){},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	});
}
