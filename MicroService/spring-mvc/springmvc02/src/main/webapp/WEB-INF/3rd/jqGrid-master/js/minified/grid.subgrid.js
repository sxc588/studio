/**
*
* @license Guriddo jqGrid JS - v5.1.0 
* Copyright(c) 2008, Tony Tomov, tony@trirand.com
* 
* License: http://guriddo.net/?page_id=103334
*/
!function(a){"use strict";"function"==typeof define&&define.amd?define(["jquery","./grid.base"],a):a(jQuery)}(function(a){"use strict";a.jgrid.extend({setSubGrid:function(){return this.each(function(){var b,c,d=this,e=a.jgrid.styleUI[d.p.styleUI||"jQueryUI"].subgrid,f={plusicon:e.icon_plus,minusicon:e.icon_minus,openicon:e.icon_open,expandOnLoad:!1,delayOnLoad:50,selectOnExpand:!1,selectOnCollapse:!1,reloadOnExpand:!0};if(d.p.subGridOptions=a.extend(f,d.p.subGridOptions||{}),d.p.colNames.unshift(""),d.p.colModel.unshift({name:"subgrid",width:a.jgrid.cell_width?d.p.subGridWidth+d.p.cellLayout:d.p.subGridWidth,sortable:!1,resizable:!1,hidedlg:!0,search:!1,fixed:!0}),b=d.p.subGridModel,b[0])for(b[0].align=a.extend([],b[0].align||[]),c=0;c<b[0].name.length;c++)b[0].align[c]=b[0].align[c]||"left"})},addSubGridCell:function(b,c){var d,e,f,g="";return this.each(function(){g=this.formatCol(b,c),e=this.p.id,d=this.p.subGridOptions.plusicon,f=a.jgrid.styleUI[this.p.styleUI||"jQueryUI"].common}),'<td role="gridcell" aria-describedby="'+e+'_subgrid" class="ui-sgcollapsed sgcollapsed" '+g+"><a style='cursor:pointer;' class='ui-sghref'><span class='"+f.icon_base+" "+d+"'></span></a></td>"},addSubGrid:function(b,c){return this.each(function(){var d=this;if(d.grid){var e,f,g,h,i,j=a.jgrid.styleUI[d.p.styleUI||"jQueryUI"].base,k=a.jgrid.styleUI[d.p.styleUI||"jQueryUI"].common,l=function(b,c,e){var f=a("<td align='"+d.p.subGridModel[0].align[e]+"'></td>").html(c);a(b).append(f)},m=function(b,c){var e,f,g,h=a("<table class='"+j.rowTable+" ui-common-table'><tbody></tbody></table>"),i=a("<tr></tr>");for(f=0;f<d.p.subGridModel[0].name.length;f++)e=a("<th class='"+j.headerBox+" ui-th-subgrid ui-th-column ui-th-"+d.p.direction+"'></th>"),a(e).html(d.p.subGridModel[0].name[f]),a(e).width(d.p.subGridModel[0].width[f]),a(i).append(e);a(h).append(i),b&&(g=d.p.xmlReader.subgrid,a(g.root+" "+g.row,b).each(function(){if(i=a("<tr class='"+k.content+" ui-subtblcell'></tr>"),g.repeatitems===!0)a(g.cell,this).each(function(b){l(i,a(this).text()||"&#160;",b)});else{var b=d.p.subGridModel[0].mapping||d.p.subGridModel[0].name;if(b)for(f=0;f<b.length;f++)l(i,a(b[f],this).text()||"&#160;",f)}a(h).append(i)}));var m=a("table:first",d.grid.bDiv).attr("id")+"_";return a("#"+a.jgrid.jqID(m+c)).append(h),d.grid.hDiv.loading=!1,a("#load_"+a.jgrid.jqID(d.p.id)).hide(),!1},n=function(b,c){var e,f,g,h,i,m,n=a("<table class='"+j.rowTable+" ui-common-table'><tbody></tbody></table>"),o=a("<tr></tr>");for(g=0;g<d.p.subGridModel[0].name.length;g++)e=a("<th class='"+j.headerBox+" ui-th-subgrid ui-th-column ui-th-"+d.p.direction+"'></th>"),a(e).html(d.p.subGridModel[0].name[g]),a(e).width(d.p.subGridModel[0].width[g]),a(o).append(e);if(a(n).append(o),b&&(i=d.p.jsonReader.subgrid,f=a.jgrid.getAccessor(b,i.root),void 0!==f))for(g=0;g<f.length;g++){if(h=f[g],o=a("<tr class='"+k.content+" ui-subtblcell'></tr>"),i.repeatitems===!0)for(i.cell&&(h=h[i.cell]),m=0;m<h.length;m++)l(o,h[m]||"&#160;",m);else{var p=d.p.subGridModel[0].mapping||d.p.subGridModel[0].name;if(p.length)for(m=0;m<p.length;m++)l(o,h[p[m]]||"&#160;",m)}a(n).append(o)}var q=a("table:first",d.grid.bDiv).attr("id")+"_";return a("#"+a.jgrid.jqID(q+c)).append(n),d.grid.hDiv.loading=!1,a("#load_"+a.jgrid.jqID(d.p.id)).hide(),!1},o=function(b){var c,e,f,g;if(c=a(b).attr("id"),e={nd_:(new Date).getTime()},e[d.p.prmNames.subgridid]=c,!d.p.subGridModel[0])return!1;if(d.p.subGridModel[0].params)for(g=0;g<d.p.subGridModel[0].params.length;g++)for(f=0;f<d.p.colModel.length;f++)d.p.colModel[f].name===d.p.subGridModel[0].params[g]&&(e[d.p.colModel[f].name]=a("td:eq("+f+")",b).text().replace(/\&#160\;/gi,""));if(!d.grid.hDiv.loading)switch(d.grid.hDiv.loading=!0,a("#load_"+a.jgrid.jqID(d.p.id)).show(),d.p.subgridtype||(d.p.subgridtype=d.p.datatype),a.isFunction(d.p.subgridtype)?d.p.subgridtype.call(d,e):d.p.subgridtype=d.p.subgridtype.toLowerCase(),d.p.subgridtype){case"xml":case"json":a.ajax(a.extend({type:d.p.mtype,url:a.isFunction(d.p.subGridUrl)?d.p.subGridUrl.call(d,e):d.p.subGridUrl,dataType:d.p.subgridtype,data:a.isFunction(d.p.serializeSubGridData)?d.p.serializeSubGridData.call(d,e):e,complete:function(b){"xml"===d.p.subgridtype?m(b.responseXML,c):n(a.jgrid.parse(b.responseText),c),b=null}},a.jgrid.ajaxOptions,d.p.ajaxSubgridOptions||{}))}return!1},p=0;a.each(d.p.colModel,function(){(this.hidden===!0||"rn"===this.name||"cb"===this.name)&&p++});var q,r=d.rows.length,s=1,t=a.isFunction(d.p.isHasSubGrid);for(void 0!==c&&c>0&&(s=c,r=c+1);r>s;){if(a(d.rows[s]).hasClass("jqgrow")){if(d.p.scroll&&a(d.rows[s].cells[b]).unbind("click"),q=null,t)var q=d.p.isHasSubGrid.call(d,d.rows[s].id);q===!1?d.rows[s].cells[b].innerHTML="":a(d.rows[s].cells[b]).bind("click",function(){var c=a(this).parent("tr")[0];if(f=d.p.id,e=c.id,i=a("#"+f+"_"+e+"_expandedContent"),a(this).hasClass("sgcollapsed")){if(h=a(d).triggerHandler("jqGridSubGridBeforeExpand",[f+"_"+e,e]),h=h===!1||"stop"===h?!1:!0,h&&a.isFunction(d.p.subGridBeforeExpand)&&(h=d.p.subGridBeforeExpand.call(d,f+"_"+e,e)),h===!1)return!1;d.p.subGridOptions.reloadOnExpand===!0||d.p.subGridOptions.reloadOnExpand===!1&&!i.hasClass("ui-subgrid")?(g=b>=1?"<td colspan='"+b+"'>&#160;</td>":"",a(c).after("<tr role='row' id='"+f+"_"+e+"_expandedContent' class='ui-subgrid ui-sg-expanded'>"+g+"<td class='"+k.content+" subgrid-cell'><span class='"+k.icon_base+" "+d.p.subGridOptions.openicon+"'></span></td><td colspan='"+parseInt(d.p.colNames.length-1-p,10)+"' class='"+k.content+" subgrid-data'><div id="+f+"_"+e+" class='tablediv'></div></td></tr>"),a(d).triggerHandler("jqGridSubGridRowExpanded",[f+"_"+e,e]),a.isFunction(d.p.subGridRowExpanded)?d.p.subGridRowExpanded.call(d,f+"_"+e,e):o(c)):i.show().removeClass("ui-sg-collapsed").addClass("ui-sg-expanded"),a(this).html("<a style='cursor:pointer;' class='ui-sghref'><span class='"+k.icon_base+" "+d.p.subGridOptions.minusicon+"'></span></a>").removeClass("sgcollapsed").addClass("sgexpanded"),d.p.subGridOptions.selectOnExpand&&a(d).jqGrid("setSelection",e)}else if(a(this).hasClass("sgexpanded")){if(h=a(d).triggerHandler("jqGridSubGridRowColapsed",[f+"_"+e,e]),h=h===!1||"stop"===h?!1:!0,h&&a.isFunction(d.p.subGridRowColapsed)&&(h=d.p.subGridRowColapsed.call(d,f+"_"+e,e)),h===!1)return!1;d.p.subGridOptions.reloadOnExpand===!0?i.remove(".ui-subgrid"):i.hasClass("ui-subgrid")&&i.hide().addClass("ui-sg-collapsed").removeClass("ui-sg-expanded"),a(this).html("<a style='cursor:pointer;' class='ui-sghref'><span class='"+k.icon_base+" "+d.p.subGridOptions.plusicon+"'></span></a>").removeClass("sgexpanded").addClass("sgcollapsed"),d.p.subGridOptions.selectOnCollapse&&a(d).jqGrid("setSelection",e)}return!1})}s++}d.p.subGridOptions.expandOnLoad===!0&&a(d.rows).filter(".jqgrow").each(function(b,c){a(c.cells[0]).click()}),d.subGridXml=function(a,b){m(a,b)},d.subGridJson=function(a,b){n(a,b)}}})},expandSubGridRow:function(b){return this.each(function(){var c=this;if((c.grid||b)&&c.p.subGrid===!0){var d=a(this).jqGrid("getInd",b,!0);if(d){var e=a("td.sgcollapsed",d)[0];e&&a(e).trigger("click")}}})},collapseSubGridRow:function(b){return this.each(function(){var c=this;if((c.grid||b)&&c.p.subGrid===!0){var d=a(this).jqGrid("getInd",b,!0);if(d){var e=a("td.sgexpanded",d)[0];e&&a(e).trigger("click")}}})},toggleSubGridRow:function(b){return this.each(function(){var c=this;if((c.grid||b)&&c.p.subGrid===!0){var d=a(this).jqGrid("getInd",b,!0);if(d){var e=a("td.sgcollapsed",d)[0];e?a(e).trigger("click"):(e=a("td.sgexpanded",d)[0],e&&a(e).trigger("click"))}}})}})});