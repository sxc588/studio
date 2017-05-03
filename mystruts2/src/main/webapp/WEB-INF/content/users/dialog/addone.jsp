<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Add to ${stage}</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">【${stage}】请添加服务的URL
					${request.getContextPath()}</h4>
			</div>
			<form role="form" action="${request.getContextPath()}/addone"  method ='get'>
				<div class="modal-body">
					<div class="form-group">
						<label for="urls">Alpha</label> <input type="text" class="form-control" id="urls" name="urls" placeholder="请输入url">
						<label for="urls">Alpha</label> <input type="text" class="form-control" id="urls" name="urls" placeholder="请输入url">
						<label for="urls">Beta</label> <input type="text" class="form-control" id="urls" name="urls" placeholder="请输入url">
						<label for="urls">Beta</label> <input type="text" class="form-control" id="urls" name="urls" placeholder="请输入url">
						<label for="urls">Prod</label> <input type="text" class="form-control" id="urls" name="urls" placeholder="请输入url">
						<label for="urls">Prod</label> <input type="text" class="form-control" id="urls" name="urls" placeholder="请输入url">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-default">提交</button>
					<button type="button" class="btn btn-primary">预览</button>
				</div>
			</form>
		</div>
	</div>
</div>
