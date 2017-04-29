(function(a){a.fn.extend({x_autocomplete:function(b,c){var d=typeof b=="string";
c=a.extend({},a.Autocompleter.defaults,{url:d?b:null,data:d?null:b,delay:d?a.Autocompleter.defaults.delay:10,max:c&&!c.scroll?10:150,maxdisplay:c&&c.maxDisplayChars>=c.minChars?c.maxDisplayChars:c.minChars},c);
c.highlight=c.highlight||function(e){return e
};
c.formatMatch=c.formatMatch||c.formatItem;
return this.each(function(){new a.Autocompleter(this,c)
})
},result:function(b){return this.bind("result",b)
},search:function(b){return this.trigger("search",[b])
},flushCache:function(){return this.trigger("flushCache")
},setOptions:function(b){return this.trigger("setOptions",[b])
},unautocomplete:function(){return this.trigger("unautocomplete")
}});
a.Autocompleter=function(m,h){var c={UP:38,DOWN:40,DEL:46,TAB:9,RETURN:13,ESC:27,COMMA:188,PAGEUP:33,PAGEDOWN:34,BACKSPACE:8};
var b=a(m).attr("autocomplete","off").addClass(h.inputClass);
var k;
var r="";
var n=a.Autocompleter.Cache(h);
var f=0;
var v;
var z={mouseDownOnSelect:false};
var s=a.Autocompleter.Select(h,m,e,z);
window.onresize=function(){setTimeout(x,50);
setTimeout(d,50)
};
if(navigator.userAgent.indexOf("MSIE")>0){window.onresize=function(){setTimeout(x,50);
setTimeout(d,50)
}
}function x(){}function d(){s.hide()
}var y;
a.browser.opera&&a(m.form).bind("submit.autocomplete",function(){if(y){y=false;
return false
}});
b.bind((a.browser.opera?"keypress":"keydown")+".autocomplete",function(A){A=A||window.event;
v=A.keyCode;
switch(A.keyCode){case c.UP:A.preventDefault();
if(s.visible()){s.prev(s)
}else{u(0,true)
}break;
case c.DOWN:A.preventDefault();
if(s.visible()){s.next(s)
}else{u(0,true)
}break;
case c.PAGEUP:A.preventDefault();
if(s.visible()){s.pageUp()
}else{u(0,true)
}break;
case c.PAGEDOWN:A.preventDefault();
if(s.visible()){s.pageDown()
}else{u(0,true)
}break;
case h.multiple&&a.trim(h.multipleSeparator)==","&&c.COMMA:case c.TAB:case c.RETURN:if(e()){A.preventDefault();
y=true;
return false
}s.hide();
break;
case c.ESC:s.hide();
break;
default:clearTimeout(k);
k=setTimeout(u,h.delay);
break
}}).focus(function(){f++
}).blur(function(){f=0;
if(!z.mouseDownOnSelect){t()
}}).click(function(){if(f++>1&&!s.visible()){u(0,true)
}}).bind("search",function(){var A=(arguments.length>1)?arguments[1]:null;
function B(F,E){var C;
if(E&&E.length){for(var D=0;
D<E.length;
D++){if(E[D].result.toLowerCase()==F.toLowerCase()){C=E[D];
break
}}}if(typeof A=="function"){A(C)
}else{b.trigger("result",C&&[C.data,C.value])
}}a.each(i(b.val()),function(C,D){g(D,B,B)
})
}).bind("flushCache",function(){n.flush()
}).bind("setOptions",function(){a.extend(h,arguments[1]);
if("data" in arguments[1]){n.populate()
}}).bind("unautocomplete",function(){s.unbind();
b.unbind();
a(m.form).unbind(".autocomplete")
}).bind("input",function(){u(0,true)
}).bind("unautocompleteHide",function(){s.emptyList();
s.hide()
});
function e(){var B=s.selected();
if(!B){return false
}var A=B.result;
r=A;
if(h.multiple){var C=i(b.val());
if(C.length>1){A=C.slice(0,C.length-1).join(h.multipleSeparator)+h.multipleSeparator+A
}A+=h.multipleSeparator
}b.val(A);
w();
b.trigger("result",[B.data,B.value]);
return true
}function u(C,B){if(v==c.DEL){s.hide();
return
}var A=b.val();
if(!B&&A==r){return
}r=A;
A=j(A);
if(A.length>=h.minChars){b.addClass(h.loadingClass);
if(!h.matchCase){A=A.toLowerCase()
}g(A,l,w)
}else{o();
s.hide()
}}function i(B){if(!B){return[""]
}var C=B.split(h.multipleSeparator);
var A=[];
a.each(C,function(D,E){if(a.trim(E)){A[D]=a.trim(E)
}});
return A
}function j(A){if(!h.multiple){return A
}var B=i(A);
return B[B.length-1]
}function q(A,B){if(h.autoFill&&(j(b.val()).toLowerCase()==A.toLowerCase())&&v!=c.BACKSPACE){b.val(b.val()+B.substring(j(r).length));
a.Autocompleter.Selection(m,r.length,r.length+B.length)
}}function t(){clearTimeout(k);
k=setTimeout(w,200)
}function w(){var A=s.visible();
s.hide();
clearTimeout(k);
o();
if(h.mustMatch){b.search(function(B){if(!B){if(h.multiple){var C=i(b.val()).slice(0,-1);
b.val(C.join(h.multipleSeparator)+(C.length?h.multipleSeparator:""))
}else{b.val("")
}}})
}if(A){a.Autocompleter.Selection(m,m.value.length,m.value.length)
}}function l(B,A){if(A&&A.length&&f){o();
s.display(A,B);
q(B,A[0].value);
s.show()
}else{w()
}}function g(B,D,A){B=a.trim(B);
if(!h.matchCase){B=B.toLowerCase()
}var C=null;
if(C&&C.length){D(B,C)
}else{if((typeof h.url=="string")&&(h.url.length>0)){var E={};
a.each(h.extraParams,function(F,G){E[F]=typeof G=="function"?G():G
});
a.ajax({mode:"abort",port:"autocomplete"+m.name,dataType:h.dataType,url:h.url,data:a.extend({"sp.keyword":j(B),"sp.type":a("#searchType_input_id").val()},E),success:function(G){if(G.sp.keyword!==j(b.val())){return
}var F=h.parse&&h.parse(G)||p(G);
D(B,F)
},error:function(F){}})
}else{s.emptyList();
A(B)
}}}function p(D){var A=[];
var C=D.split("\n");
for(var B=0;
B<C.length;
B++){var E=a.trim(C[B]);
if(E){E=E.split("|");
A[A.length]={data:E,value:E[0],result:h.formatResult&&h.formatResult(E,E[0])||E[0]}
}}return A
}function o(){b.removeClass(h.loadingClass)
}};
a.Autocompleter.defaults={marginLeft:"6px",inputClass:"ac_input",resultsClass:"ac_results",loadingClass:"ac_loading",maxdisplay:4,englishChinaChars:2,minChars:1,maxDisplayChars:4,delay:400,matchCase:false,matchSubset:true,matchContains:false,cacheLength:10,max:100,mustMatch:false,extraParams:{},selectFirst:true,minDisplayChars:3,formatItem:function(b){return b[0]
},formatMatch:null,autoFill:false,width:0,multiple:false,multipleSeparator:", ",autoCompleteTop:0,highlight:function(c,b){return c.replace(new RegExp("(?![^&;]+;)(?!<[^<>]*)("+b.replace(/([\^\$\(\)\[\]\{\}\*\.\+\?\|\\])/gi,"\\$1")+")(?![^<>]*>)(?![^&;]+;)","gi"),"<strong>$1</strong>")
},scroll:true,scrollHeight:180};
a.Autocompleter.Cache=function(c){var f={};
var d=0;
function h(l,k){if(!c.matchCase){l=l.toLowerCase()
}var j=l.indexOf(k);
if(j==-1){return false
}return j==0||c.matchContains
}function g(j,i){if(d>c.cacheLength){b()
}if(!f[j]){d++
}f[j]=i
}function e(){if(!c.data){return false
}var k={},j=0;
if(!c.url){c.cacheLength=1
}k[""]=[];
for(var m=0,l=c.data.length;
m<l;
m++){var p=c.data[m];
p=(typeof p=="string")?[p]:p;
var o=c.formatMatch(p,m+1,c.data.length);
if(o===false){continue
}var n=o.charAt(0).toLowerCase();
if(!k[n]){k[n]=[]
}var q={value:o,data:p,result:c.formatResult&&c.formatResult(p)||o};
k[n].push(q);
if(j++<c.max){k[""].push(q)
}}a.each(k,function(r,s){c.cacheLength++;
g(r,s)
})
}setTimeout(e,25);
function b(){f={};
d=0
}return{flush:b,add:g,populate:e,load:function(n){if(!c.cacheLength||!d){return null
}if(!c.url&&c.matchContains){var m=[];
for(var j in f){if(j.length>0){var o=f[j];
a.each(o,function(p,k){if(h(k.value,n)){m.push(k)
}})
}}return m
}else{if(f[n]){return f[n]
}else{if(c.matchSubset){for(var l=n.length-1;
l>=c.minChars;
l--){var o=f[n.substr(0,l)];
if(o){var m=[];
a.each(o,function(p,k){if(h(k.value,n)){m[m.length]=k
}});
return m
}}}}}return null
}}
};
a.Autocompleter.Select=function(f,n,p,u){var x=[];
var e=[];
var m={ACTIVE:"ac_over"};
var o,i=-1,w,q="",y=true,c,s,j="";
function r(){if(!y){return
}c=a("<div/>").hide().addClass(f.resultsClass).css("position","absolute").css("zIndex",999).css("margin-left",f.marginLeft).appendTo(document.body);
s=a("<ul/>").appendTo(c).mouseover(function(C){var D=a(v(C)).text();
if(v(C).nodeName&&v(C).nodeName.toUpperCase()=="LI"){i=a("li",s).removeClass(m.ACTIVE).index(v(C));
a(v(C)).addClass(m.ACTIVE)
}if(o&&D.indexOf("...")&&x.length>0){for(var B=0;
B<o.length;
B++){if(B!=i){o.slice(B,B+1).html(f.highlight(e[B],q))
}else{a(v(C)).html(f.highlight(x[i],q))
}}}}).click(function(B){if(j){j="";
a(v(B)).addClass(m.ACTIVE);
p();
return false
}}).mousedown(function(){u.mouseDownOnSelect=true
}).mouseup(function(B){u.mouseDownOnSelect=false;
if(h()!="Firefox"){a(v(B)).addClass(m.ACTIVE);
p();
return false
}else{j="Firefox";
s.click()
}});
if(h()=="MSIE"){var z=a("<iframe scrolling='no' frameborder='0' style='width:397px; height:202px; position:absolute;visibility:inherit; top:0px; left:0px;'></iframe>");
var A=a("div > ul").css("zIndex")=="auto"?0:a("div > ul").css("zIndex");
z.css("zIndex",A-1);
z.appendTo(c)
}if(f.width>0){c.css("width",f.width)
}y=false
}function h(){var z="";
if(navigator.userAgent.indexOf("MSIE")>0){return"MSIE"
}if(j=navigator.userAgent.indexOf("Firefox")>0){return"Firefox"
}if(isChrome=navigator.userAgent.indexOf("Chrome")>0){return"Chrome"
}if(isSafari=navigator.userAgent.indexOf("Safari")>0){return"Safari"
}if(isCamino=navigator.userAgent.indexOf("Camino")>0){return"Camino"
}if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){return"Gecko"
}}function v(A){var z=A.target;
while(z&&z.tagName!="LI"){z=z.parentNode
}if(!z){return[]
}return z
}function l(z){o.slice(i,i+1).removeClass(m.ACTIVE);
k(z);
var B=o.slice(i,i+1).addClass(m.ACTIVE);
if(f.scroll){var A=0;
o.slice(0,i).each(function(){A+=this.offsetHeight
});
if((A+B[0].offsetHeight-s.scrollTop())>s[0].clientHeight){s.scrollTop(A+B[0].offsetHeight-s.innerHeight())
}else{if(A<s.scrollTop()){s.scrollTop(A)
}}}}function k(z){i+=z;
if(i<0){i=o.size()-1
}else{if(i>=o.size()){i=0
}}}function b(z){return f.max&&f.max<z?f.max:z
}function g(F,z){var E=F.replace(/[^\x00-\xff]/g,"aa").length;
var D=F.length;
if(E==D&&D>z){return F.substring(0,z)
}else{if(E!=D&&E>z){var G=F.split("");
var C=0;
var B=F;
for(var A=0;
A<G.length;
A++){if(C>=z){B=F.substring(0,A);
break
}if(G[A].replace(/[^\x00-\xff]/g,"aa").length==2){C+=2
}else{C+=1
}}if(C>z){B=F.substring(0,A-1)
}return B
}else{return F
}}}function t(B,z){var A=B.replace(/[^\x00-\xff]/g,"aa").length;
if(A>z){return true
}else{return false
}}function d(){s.empty();
var A=b(w.length);
x=new Array(A);
e=new Array(A);
var C=f.maxdisplay+f.englishChinaChars;
for(var B=0;
B<q.length;
B++){if(q&&q.charCodeAt(B)>128){C=f.maxdisplay;
break
}}for(var B=0;
B<A;
B++){if(!w[B]){continue
}var D=f.formatItem(w[B].data,B+1,A,w[B].value,q);
D=a.trim(D);
x[B]=D;
if(t(D,C)==true){D=g(D,C)+"..."
}e[B]=D;
if(D===false){continue
}var z=a("<li/>").html(f.highlight(D,q)).addClass(B%2==0?"ac_even":"ac_odd").appendTo(s)[0];
a.data(z,"ac_data",w[B])
}o=s.find("li");
if(f.selectFirst){o.slice(0,1).addClass(m.ACTIVE);
i=0
}if(a.fn.bgiframe){s.bgiframe()
}}return{display:function(A,z){r();
w=A;
q=z;
d()
},next:function(C){l(1);
var B=C.selected();
var z=B.data.CLASS1_NAME==null||B.data.CLASS1_NAME==""||B.data.CLASS1_NAME=="null"?B.data.PRODUCT_NAME:B.data.CLASS1_NAME;
o.slice(i,i+1).addClass(m.ACTIVE);
if(o){for(var A=0;
A<o.length;
A++){if(A!=i){o.slice(A,A+1).html(f.highlight(e[A],q))
}else{o.slice(i,i+1).html(f.highlight(x[i],q))
}}}},prev:function(C){l(-1);
var B=C.selected();
var z=B.data.CLASS1_NAME==null||B.data.CLASS1_NAME==""||B.data.CLASS1_NAME=="null"?B.data.PRODUCT_NAME:B.data.CLASS1_NAME;
o.slice(i,i+1).addClass(m.ACTIVE);
if(o){for(var A=0;
A<o.length;
A++){if(A!=i){o.slice(A,A+1).html(f.highlight(e[A],q))
}else{o.slice(i,i+1).html(f.highlight(x[i],q))
}}}},pageUp:function(){if(i!=0&&i-8<0){l(-i)
}else{l(-8)
}},pageDown:function(){if(i!=o.size()-1&&i+8>o.size()){l(o.size()-1-i)
}else{l(8)
}},hide:function(){c&&c.hide();
o&&o.removeClass(m.ACTIVE);
i=-1
},visible:function(){return c&&c.is(":visible")
},current:function(){return this.visible()&&(o.filter("."+m.ACTIVE)[0]||f.selectFirst&&o[0])
},show:function(){var D=a(n).offset();
var C=(document.documentElement.scrollTop!=undefined&&document.documentElement.scrollTop>document.body.scrollTop)?document.documentElement.scrollTop:document.body.scrollTop;
var B=D.top-C+c.height()+n.offsetHeight+5-document.documentElement.clientHeight;
c.css({width:typeof f.width=="string"||f.width>0?f.width:a(n).width(),top:B<0?(D.top+n.offsetHeight+f.autoCompleteTop):(D.top-c.height()-f.autoCompleteTop),left:D.left-6}).show();
if(f.scroll){s.scrollTop(0);
s.css({maxHeight:f.scrollHeight,overflow:"auto"});
if(a.browser.msie&&typeof document.body.style.maxHeight==="undefined"){var z=0;
o.each(function(){z+=this.offsetHeight
});
var A=z>f.scrollHeight;
s.css("height",A?f.scrollHeight:z);
if(!A){o.width(s.width()-parseInt(o.css("padding-left"))-parseInt(o.css("padding-right")))
}}}},selected:function(){var z=o&&o.filter("."+m.ACTIVE).removeClass(m.ACTIVE);
return z&&z.length&&a.data(z[0],"ac_data")
},emptyList:function(){s&&s.empty()
},unbind:function(){c&&c.remove()
}}
};
a.Autocompleter.Selection=function(d,e,c){if(d.createTextRange){var b=d.createTextRange();
b.collapse(true);
b.moveStart("character",e);
b.moveEnd("character",c);
b.select()
}else{if(d.setSelectionRange){d.setSelectionRange(e,c)
}else{if(d.selectionStart){d.selectionStart=e;
d.selectionEnd=c
}}}}
})(jQuery);