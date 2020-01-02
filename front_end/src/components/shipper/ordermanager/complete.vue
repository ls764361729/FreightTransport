<style>
	.ivu-table td, .ivu-table-border td{
		height: 41px;
	}
</style>
<template>
	<div>
		<div class="rigtop">
			<Form ref="shipperInfo" inline>
				<FormItem>
					<Row>
						<Col span="8" style="text-align: center;">
						<Checkbox v-model="ddbhs">订单编号</Checkbox>
						</Col>
						<Col span="16">
						<Input height="20" v-model="orderInfo.oId" placeholder="模糊查询订单编号"></Input>
						</Col>
					</Row>
				</FormItem>
				<FormItem>
					<Row>
						<Col span="8" style="text-align: center;">
						<Checkbox v-model="lxhms">联系号码</Checkbox>
						</Col>
						<Col span="16">
						<Input height="20" v-model="orderInfo.oContacts" placeholder="模糊查询联系人手机号码"></Input>
						</Col>
					</Row>
				</FormItem>
				<FormItem style="position: relative;left: 10px">
					<Button @click="changePage(1)">
						<Icon type="ios-sync" />快速查询
					</Button>
				</FormItem>
				<FormItem style="position: absolute;right: 30px">
					<Button @click="exportData()">
						<Icon type="ios-download-outline" />数据导出
					</Button>
				</FormItem>
			</Form>
		</div>

		<Table border :columns="columns7" :data="data6" height="450" :loading="loading" stripe size='default' ref="table"></Table>
		<div style="margin: 10px;overflow: hidden">
			<div style="float: right;">
				<Page :total="count" :current="1" @on-change="changePage($event)"></Page>
			</div>
		</div>
		
		
		<Modal v-model="modal14" :loading="modal14loading" scrollable :title="title" @on-ok="addok">
			<Form ref="formValidate" :model="evaluationInfo" :label-width="80">
				<FormItem label="货主名字" style="display: none;" prop="sName">
					<Row>
						<Col span="13">
						<Select v-model="evaluationInfo.sId" @on-change="sNameadd($event)" filterable>
							<Option v-for="item in shipperInfo" :value="item.sId" :key="item.sName">{{ item.sName }}</Option>
						</Select>
						</Col>
						<Col span="4">货主编号：</Col>
						<Col span="7">
						<Input disabled="disabled" :value="evaluationInfo.sId" />
						</Col>
					</Row>
				</FormItem>
				<FormItem label="司机名字" style="display: none;"  prop="dName">
					<Row>
						<Col span="13">
						<Select v-model="evaluationInfo.dId" @on-change="dNameadd($event)" filterable>
							<Option v-for="item in driverInfo" :value="item.dId" :key="item.dName">{{ item.dName }}</Option>
						</Select>
						</Col>
						<Col span="4">司机编号：</Col>
						<Col span="7">
						<Input disabled="disabled" :value="evaluationInfo.dId" />
						</Col>
					</Row>
				</FormItem>
				<FormItem label="评价分数" prop="fraction">
					<Rate show-text allow-half v-model="evaluationInfo.fraction">
						<span style="color: #f5a623">{{ evaluationInfo.fraction }}</span>
					</Rate>
				</FormItem>
				<FormItem label="订单编号" style="display: none;"  prop="fraction">
					<Input v-model="evaluationInfo.oId" placeholder="请输入订单编号"></Input>
				</FormItem>
				<FormItem label="评价内容" prop="eContent">
					<Input v-model="evaluationInfo.eContent" type="textarea" :autosize="{minRows: 6,maxRows: 8}" placeholder="内容"></Input>
				</FormItem>
			</Form>
		</Modal>
		
		
		<Modal v-model="modal13" :title="title" >
			<Form ref="formValidate" :model="evaluationInfo" :label-width="80">
				<FormItem label="评价分数" prop="fraction">
					<Rate disabled show-text allow-half v-model="evaluationInfo.fraction">
						<span style="color: #f5a623">{{ evaluationInfo.fraction }}</span>
					</Rate>
				</FormItem>
				<FormItem label="评价内容" prop="eContent">
					<Input v-model="evaluationInfo.eContent" disabled="disabled" type="textarea" :autosize="{minRows: 6,maxRows: 8}" placeholder="内容"></Input>
				</FormItem>
			</Form>
		</Modal>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				modal14: false,
				loading: true,
				modal13:false,
				modal14loading: true,
				title: '添加订单',
				vehicleType: "",
				vehicleInfo: "",
				ddbhs: false,
				lxhms: false,
				fs: [{
						id: 1,
						value: "0-1分"
					},
					{
						id: 2,
						value: "1-2分"
					},
					{
						id: 3,
						value: "2-3分"
					},
					{
						id: 4,
						value: "3-4分"
					},
					{
						id: 5,
						value: "5分"
					}
				],
				url: "http://localhost:8080",
				count: 10,
				driverInfo: '',
				shipperInfo: '',
				evaluationInfo: {
					eId: 0,
					dId: 0,
					oId: 0,
					sId: 0,
					fraction: 5,
					eContent: "",
					sName: "",
					dName: ""
				},
				columns7: [{
						title: '订单编号',
						key: 'oId',
						align: 'center',
						width: 100
					},
					{
						title: '联系人手机',
						key: 'oContacts',
						align: 'center',
						tooltip: true
					},
					{
						title: '预约时间',
						key: 'oStartDate',
						align: 'center'
					},
					{
						title: '完成时间',
						key: 'oEndDate',
						align: 'center',
					}, {
						title: '订单价格',
						key: 'oPrice',
						tooltip: true,
						align: 'center'
					}, {
						title: '发货地址',
						key: 'oShippingAddress',
						tooltip: true,
						align: 'center'
					}, {
						title: '收货地址',
						key: 'oReceivingAddress',
						tooltip: true,
						align: 'center'
					}, {
						title: '司机编号',
						key: 'dId',
						tooltip: true,
						align: 'center'
					}, {
						title: '订单状态',
						key: 'oState',
						tooltip: true,
						align: 'center'
					},
					{
						title: '操作',
						key: 'action',
						width: 150,
						align: 'center',
						render: (h, params) => {
							if(params.row.oState == "已完成"){
								return h('div', [
									h('Button', {
										props: {
											type: 'primary',
											size: 'small'
										},
										style: {
											marginRight: '5px'
										},
										on: {
											click: () => {
												this.show(params.row)
											}
										}
									}, '评价')
								]);
							}else{
								return h('div', [
									h('Button', {
										props: {
											type: 'success',
											size: 'small'
										},
										style: {
											marginRight: '5px'
										},
										on: {
											click: () => {
												this.shows(params.row.oId);
											}
										}
									}, '查看评价')
								]);
							}
							
						}
					}
				],
				data6: [],
				orderInfo: {
					oId: 0,
					oType: "",
					oContacts: "",
					oRemarks: "",
					oStartDate: "",
					oEndDate: "",
					oPrice: "",
					oShippingAddress: "",
					oReceivingAddress: "",
					sId: 0,
					dId: 0,
					oState: "待运输",
				}
			}
		},
		methods: {
			//时间
			getStartTime(starTime) {
				this.orderInfo.oStartDate = starTime;
			},
			//时间
			getStartTimeend(starTime) {
				this.orderInfo.oEndDate = starTime;
			},
			
			//弹出添加保存
			addok() {
				const th = this;
				axios.get(th.url + '/orderInfo/updateSet', {
					params: {
						oId: th.evaluationInfo.oId,
						oState:"已评价",
						oEndDate:1
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("评价成功！");
						th.modal14 = false;
							th.changePage(1);
						axios.post(th.url + '/evaluationInfo/insert', th.evaluationInfo, {
							headers: {
								"Content-Type": "application/json;charset=utf-8"
							}
						}).then(function(res) {
							
						})
					}else{
							th.$Message.error("评价失败！");
							th.modal14show();
					}
				})

			},
			shows(oid){
				this.title = "评价信息";
				var th = this;
				axios.get(th.url + '/evaluationInfo/selectoId', {
					params: {
						oId: oid
					}
				}).then(function(res) {
					console.log(res);
					if(res.data.code == 200){
						th.evaluationInfo.fraction = res.data.data.fraction;
						th.evaluationInfo.eContent = res.data.data.eContent;
						th.modal13 = true;
					}else{
						th.$Message.error("评价已被删除！");
					}
				})
				
			},
			show(data){
				this.title = "评价";
				for(var i = 0; i<this.driverInfo.length; i++){
					if(this.driverInfo[i].dId == data.dId){
						this.evaluationInfo.dName = this.driverInfo[i].dName;
						this.evaluationInfo.dId = this.driverInfo[i].dId;
					}
				}
				for(var i = 0; i<this.shipperInfo.length; i++){
					if(this.shipperInfo[i].sId == data.sId){
						this.evaluationInfo.sName = this.shipperInfo[i].sName;
						this.evaluationInfo.sId = this.shipperInfo[i].sId;
					}
				}
				this.evaluationInfo.oId = data.oId;
				this.modal14 = true;
			},
			modal14show() {
				this.modal14 = false;
				setTimeout(() => {
					this.modal14 = true;
				}, 1);
			},
			//导出数据
			exportData() {
				this.$refs.table.exportCsv({
					filename: '待运输信息表'
				});
			},
			//查询
			changePage(page) {
				const th = this;
				if (!th.ddbhs) {
					th.orderInfo.oId = '';
				}
				if (!th.lxhms) {
					th.orderInfo.oContacts = '';
				}
				axios.get(th.url + '/orderInfo/selectStart', {
					params: {
						page: page,
						oId: th.orderInfo.oId,
						oStart: '已完成',
						oContacts: th.orderInfo.oContacts,
						sId:localStorage.getItem("mUser")
					}
				}).then(function(res) {
					th.data6 = res.data.data;
					th.count = res.data.count;

				})
				th.loading = false;
			},
		},
		created() {
			var th = this;
			axios.get(th.url + '/driverInfo/selectAll').then(function(res) {
				th.driverInfo = res.data.data;
			})
			axios.get(th.url + '/shipperInfo/selectAll').then(function(res) {
				th.shipperInfo = res.data.data;
			})
			axios.get(th.url + '/vehicleType/selectGroup').then(function(res) {
				th.vehicleType = res.data.data;
			})
			axios.get(th.url + '/vehicleInfo/selectAll').then(function(res) {
				th.vehicleInfo = res.data.data;
			})
			this.changePage(1);
		}
	}
</script>
