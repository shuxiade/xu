<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学习jQuery</title>
</head>
<body>
	<form>
		<div class="msg">
			<div class="msg_caption">
				<button type="button" class="bigger" id="bigger">放大</button>
				<button type="button" class="smaller">缩小</button>
				<button type="button" class="up">向上</button>
				<button type="button" class="down">向下</button>
			</div>
			<textarea id="comment" rows="8" cols="20">
				多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。
				多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。
				多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。
				多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。多行文本框高度变化。
			</textarea>
			<span><%= request.getContextPath() %></span>
		</div>
	</form>
	<script type="text/javascript"
		src="<%= request.getContextPath() %>/static/jquery-3.4.0.js"></script>
	<%-- <script type="text/javascript" src="${ pageContext.request.contextPath }/static/jquery-3.4.0.js"></script> --%>
	<script type="text/javascript">
		var $comment = $('#comment');
		$('.bigger').click(function(){
			if(!$comment.is(":animated")){
				if($comment.height()<500){
					$comment.animate({height:"+=50"},400);
				}
			}
		}); 
		$('.smaller').click(function(){
			if(!$comment.is(":animated")){
				if($comment.height()>50){
					$comment.animate({height:"-=50"},400);
				}
			}
		})
		$('.up').click(function(){
			if(!$comment.is(":animated")){
				$comment.animate({scrollTop:"-=50"},400);
			}
		}) 
		$(".down").click(function(){
			if(!$comment.is(":animated")){
				$comment.animate({scrollTop:"+=50"},400)
			}
		})
</script>
</body>
</html>