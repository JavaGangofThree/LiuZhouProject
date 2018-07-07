<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="pagerForm" method="post" action="producted_list_page.action">
	<input type="hidden" name="pageNum" value="${ pageNum }" />
	<input type="hidden" name="numPerPage" value="${ pageRow }" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						我的客户：<input type="text" name="keyword" />
					</td>
					<td>
						<select class="combox" name="province">
							<option value="">所有省市</option>
							<option value="北京">北京</option>
							<option value="上海">上海</option>
							<option value="天津">天津</option>
							<option value="重庆">重庆</option>
							<option value="广东">广东</option>
						</select>
					</td>
					<td>
						建档日期：<input type="text" class="date" readonly="true" />
					</td>
					<td>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="producted_add_page.action" target="dialog" rel="productAddPage" width="600" height="400"><span>添加</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab"><span>修改</span></a></li>
			<li><a class="delete" href="producted_delete.action?pid={pid}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="60%" layoutH="110">
		<thead>
			<tr>
				<th width="25%">产品名称</th>
				<th width="25%">品牌</th>
				<th width="25%">功率</th>
				<th width="25%">类型</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ productList }" var="pro">
				<tr target="pid" rel="${ pro.id }">
					<td>${ pro.name }</td>
					<td>${ pro.brand }</td>
					<td>${ pro.power }</td>
					<td>${ pro.tName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalRow}条</span>
		</div>
		<!--totalCount:总数据条数, numPerPage:每页显示多少条   currentPage:当前第几页-->
		<div class="pagination" targetType="navTab" totalCount="${totalRow}" numPerPage="${ pageRow }" pageNumShown="10" currentPage="${ pageNum }"></div>

	</div>
</div>

