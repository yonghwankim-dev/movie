<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/plugins/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/board.css">

<script src="<%=request.getContextPath() %>/js/plugins/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/ckeditor_basic/ckeditor.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/payment.js"></script>
<script>
let currentPage = 1;

let boardNum = "";
let vidx = "";

let brdModiCont = "";
let repModiCont = "";

listServer(1);
</script>
</head>
<body>
<div id="brdModiForm">
  <textarea rows="5" cols="103"></textarea>
  <div class="bttn">
    <input type="button" id="ok_b" value="확인" class="btn btn-default btn-xs">
    <input type="button" id="cancel_b" value="취소" class="btn btn-default btn-xs">
  </div>
</div>

<div id="repModiForm">
  <textarea rows="3" cols="103"></textarea>
  <div  class="bttn">
    <input type="button" id="ok_r" value="확인">
    <input type="button" id="cancel_r" value="취소">
  </div>
</div>

<div class="box" id="box1">
  <h3>결제 문의</h3>

  <div>
    <input type="button" value="글쓰기" id="wrt" class="btn btn-basic">
  </div>

  <div id="paymentList"></div>
  <br>
  
  <div id="pagelist"></div>
</div>

<div id="wModal" class="modal fade" role="dialog">
  <div class="modal-dialog" role="document">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label class="control-label col-sm-2">회원코드(선택)</label>
            <div class="col-sm-4">
              <input type="text" class="txt form-control" name="mem_cd" id="memCd">
            </div>
            <label class="control-label col-sm-2">비회원코드(선택)</label>
            <div class="col-sm-4">
              <input type="password" class="txt form-control" name="nmem_cd" id="nmemCd"><br>
            </div>
          </div>
          
          <div class="form-group">
            <label class="control-label col-sm-2">작성자</label>
            <div class="col-sm-10">
              <input type="text" class="txt form-control" name="pay_sc_wri" id="memWrt"><br>
            </div>
          </div>
          
          <div class="form-group">
            <label class="control-label col-sm-2">글제목</label>
            <div class="col-sm-10">
              <input type="text" class="txt form-control" name="pay_sc_tit" id="textNm"><br>
            </div>
          </div>
          
          <div class="form-group">
            <label class="control-label col-sm-2">글내용</label>
            <div class="col-sm-10">
              <textarea class="txt form-control" rows="5" cols="50" name="pay_sc_con" id="tta"></textarea><br>
            </div>
          </div>
	      
          <input type="button" class="btn btn-success" value="전송" id="send">
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>