<%--
  Created by IntelliJ IDEA.
  User: qkdlf
  Date: 2022-07-26 026
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 회원 추가 Modal -->
<div id="memAddModal" class="modal fade" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="max-width : 600px;">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">회원 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="/view/sub/signUp/signUp.jsp"/>
            </div>
        </div>
    </div>
</div>