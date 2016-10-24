<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>home</title>
</head>
<body>

<h3>Jaxb2RootElementHttpMessageConverter</h3>  
        <ul>  
       <li>  
              <form id="readXml" action="<c:url value="/messageconverters/xml" />" method="post">  
                   <input id="readXmlSubmit" type="submit" value="Read XML" />         
              </form>  
             </li>  
             <li>  
                <a id="writeXml" href="<c:url value="/messageconverters/xml" />">Write XML</a>  
             </li>  
           </ul>  


</body>
</html>