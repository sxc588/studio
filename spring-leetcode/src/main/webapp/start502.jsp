<%@page import="com.github.support.utils.PtResoult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.github.support.utils.*"%>
<!doctype html>
<html>
<head>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<title>Document</title>
<style>
.star-rating {
  font-family: ´FontAwesome´;
  margin: 50px auto;
}
.star-rating > fieldset {
  border: none;
  display: inline-block;
}
.star-rating > fieldset:not(:checked) > input {
  position: absolute;
  top: -9999px;
  clip: rect(0, 0, 0, 0);
}
.star-rating > fieldset:not(:checked) > label {
  float: right;
  width: 1em;
  padding: 0 .05em;
  overflow: hidden;
  white-space: nowrap;
  cursor: pointer;
  font-size: 200%;
  color: #16a085;
}
.star-rating > fieldset:not(:checked) > label:before {
  content: ´f006  ´;
}
.star-rating > fieldset:not(:checked) > label:hover,
.star-rating > fieldset:not(:checked) > label:hover ~ label {
  color: #1abc9c;
  text-shadow: 0 0 3px #1abc9c;
}
.star-rating > fieldset:not(:checked) > label:hover:before,
.star-rating > fieldset:not(:checked) > label:hover ~ label:before {
  content: ´f005  ´;
}
.star-rating > fieldset > input:checked ~ label:before {
  content: ´f005  ´;
}
.star-rating > fieldset > label:active {
  position: relative;
  top: 2px;
}
body {
  background: #262829;
  color: #95a5a6;
  font-family: ´Raleway´;
  text-align: center;
}
body p {
  font-size: 1.6em;
  margin: auto;
  width: 80%;
}
body a {
  color: #16a085;
}
</style>
</head>
<body>
<div class="star-rating">
    <fieldset>
        <input type="radio" id="star5" name="rating" value="5" /><label for="star5" title="Outstanding">5 stars</label>
        <input type="radio" id="star4" name="rating" value="4" /><label for="star4" title="Very Good">4 stars</label>
        <input type="radio" id="star3" name="rating" value="3" /><label for="star3" title="Good">3 stars</label>
        <input type="radio" id="star2" name="rating" value="2" /><label for="star2" title="Poor">2 stars</label>
        <input type="radio" id="star1" name="rating" value="1" /><label for="star1" title="Very Poor">1 star</label>
    </fieldset>
</div>
</body>
</html>