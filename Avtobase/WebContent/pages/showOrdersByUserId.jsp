<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${showOrdersByUserId_title}</title>
</head>
<body>
	<%@include file="../fragments/header.jspf"  %>
in show ordersbyid
	<%@include file="../fragments/footer.jspf" %>
<!-- <table class="table table-hover">
  		<thead>
      		<tr>
        		<th>id</th>
        		<th>Name</th>
        		<th>Part of series</th>
         		<th>Price</th>
        		<th>Date release</th>
        		<th>Genre</th>
   	<th>Site</th> 
        		<th>Status</th>   
        		<th>Action</th>		
      		</tr>
    	</thead>
		<c:forEach items="${sessionScope.game_list}" var = "game" >   
  			<tbody>
   				<tr>
		        	<td>${game.id}</td>
		        	<td>${game.name}</td>
		        	<td>${game.partOfseries}</td>
		      		<td>${game.price}$</td>
 		        	<td>${game.dataRelease}</td> 
		        	<td>${game.ganre}</td>
		        	<td>
		   				<c:if test="${game.status == true }">
		   					Active
		   				</c:if>
		   				
		   				<c:if test="${game.status ==  false}">
		   					Not active
		   				</c:if>
		   		 	</td>
		       
		        	<td>
		        		<div class = "row"> 		        	
			        		<form action="Controller" method="get">
			        			<input type="hidden" name="command" value="edit_game"/>
			        			<a data-toggle="tooltip" title="Edit game" data-placement="bottom"><button type="submit" name="game_id" value="${game.id}" class="btn btn-default"><span class="glyphicon glyphicon-edit"></span></button></a>  
			        		</form>
			        		
			        		<form action="Controller" method="get"> 
			        			<input type="hidden" name="command" value="remove_game"/>
				   				<a data-toggle="tooltip" title="Active/Not active" data-placement="bottom"><button type="submit" name="game_id"  value="${game.id}" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></button></a>
				    		</form>
		        		
		        		</div>

			    	</td>
      			</tr>
    		</tbody>
		</c:forEach>
  	</table> -->
</body>
</html>