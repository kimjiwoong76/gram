<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<div class="sub-layout">
    <div class="sub-visual">
        <div class="sub-visual-txt">
            <h2>My Life Style</h2>
        </div>
    </div>
    <div class="sub-content">
        <div class="container">
            <div class="row">
                <div class="sub-tit">
                    <p>COMMUNITY</p>
                    <h3>고객센터</h3>
                </div>
                
				 <div class="board-opt">
				 		<a href="/board/write">글쓰기</a>
				 </div>
				 
                <ul class="board board-list-default">

			        <li class="board-items">
			            <div class="title">
			                <a href=""></a>
			                
			                <div class="count">
				                <span class="count-comment">
				                	<em></em>
				                </span>
			                </div>
			                
			            </div>
			            <div class="info">
			                <span class="writer"></span>
			                <span class="date">
			                	
			                </span>
			                <span class="hit"></span>
			            </div>
			        </li>
               </ul>
               
               <%@ include file="/WEB-INF/views/inc/paging.jsp"%>
            </div>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/inc/footer.jsp"%>