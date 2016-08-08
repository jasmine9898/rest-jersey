<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Spring3 RESTful</title>
    <SCRIPT TYPE="text/javascript">
            function go(value){
                var url = "/SpringREST/simple/"+value+"/";
                var request =  new XMLHttpRequest();
                request.open("GET", url, true);
                request.setRequestHeader("Content-Type","application/x-javascript;");
                request.onreadystatechange = function() {
                    if (request.readyState == 4) {
                        if (request.status == 200){
                            if (request.responseText) {
                                document.getElementById("text").innerHTML = request.responseText;
                            }
                        }
                    }
                };
                request.send(null);
            }
        </SCRIPT>
  </head>
  
  <body>
    ${message}
    <br>
    Input the id of you will access object:<input id="id" type="text" size="7"><input type="button" value="Go" onclick="go(document.getElementById('id').value)">
  	<div id="text"></div>
  </body>
</html>