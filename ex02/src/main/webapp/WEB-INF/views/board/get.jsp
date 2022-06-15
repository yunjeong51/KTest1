<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	게시글 읽기
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                      	
                      	<label>제목</label>
                      	<input class="form-control" type="text" name="title" readonly value="${board.title}" >
                      	
                      	<br>
                      	<label>내용</label>
                      	<textarea class="form-control" name="content" readonly rows="10" >${board.content} </textarea>
                      	
                      	<br>
                      	<label>작성자</label>
                      	<input class="form-control"  type="text" name="writer" value="${board.writer }"readonly>
                      	
                      	<br>
                      	
                      	<button class="btn btn-warning" onclick="location.href='/board/modify?bno=${board.bno}'">변경하기</button>
                      	<button class="btn btn-info" onclick="location.href='/board/list'">목록보기</button>
						                      
                      	
                  
                          </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

 

</body>

</html>
