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
						<Checkbox v-model="ddbhs" >订单编号</Checkbox>
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

	<Modal v-model="modal14" :loading="modal14loading" fullscreen  :title="title" @on-ok="addok">
			<Form ref="formValidate" :model="orderInfo" :label-width="80">
				<Row>
					<Col span="8">
					<FormItem label="订单编号" prop="oId">
						<Input v-model="orderInfo.oId" :maxlength=18 placeholder="自动录入"></Input>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="车辆类型" prop="oType" >
						<Select v-model="orderInfo.oType"   filterable>
						<Option v-for="item in vehicleType" :value="item.tId" :key="item.vName">{{ item.vName }}</Option>
					</Select>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="联系人电话" prop="oContacts">
						<Input v-model="orderInfo.oContacts" :maxlength=18 placeholder="请输入联系人电话"></Input>
					</FormItem>
					</Col>
				</Row>
				<Row>
						<Col span="8">
						<FormItem label="发货地址"  prop="oShippingAddress">
							<Input  v-model="orderInfo.oShippingAddress"  placeholder="请输入发货地址"></Input>
						</FormItem>
						</Col>
						<Col span="8">
						<FormItem label="收货地址" prop="oReceivingAddress">
							<Input  v-model="orderInfo.oReceivingAddress"  placeholder="请输入收货地址"></Input>
						</FormItem>
						</Col>
					<Col span="8">
					<FormItem label="订单价格" prop="oPrice">
						<Input v-model="orderInfo.oPrice" :maxlength=18 placeholder="请输入订单价格"></Input>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="8">
					<FormItem label="运输车牌号" prop="dId">
						<Select v-model="orderInfo.dId"   filterable>
							<Option v-for="item in vehicleInfo" :value="item.dId" :key="item.dId">{{ item.vLicense }}</Option>
						</Select>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="货主名字" prop="sId">
						<Select v-model="orderInfo.sId"  filterable>
								<Option v-for="item in shipperInfo" :value="item.sId" :key="item.sId">{{ item.sName }}</Option>
							</Select>
					</FormItem>
					</Col>
				</Row>
				
				<Row>
					<Col span="8">
					<FormItem label="预约时间">
						<DatePicker type="date" placeholder="预约时间" @on-change="getStartTime" v-model="orderInfo.oStartDate"></DatePicker>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="完成时间">
						<DatePicker type="date" placeholder="请选择完成时间" @on-change="getStartTimeend" v-model="orderInfo.oEndDate"></DatePicker>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="状态">
						<RadioGroup v-model="orderInfo.oState">
							<Radio label="待运输">
								<Icon type="ios-eye" />
								<span>待运输</span>
							</Radio>
							<Radio label="运输中">
								<Icon type="ios-eye-off" />
								<span>运输中</span>
							</Radio>
							<Radio label="已完成">
								<Icon type="ios-football-outline" />
								<span>已完成</span>
							</Radio>
						</RadioGroup>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="24">
					<FormItem label="订单备注" prop="sId">
						<Input v-model="orderInfo.oRemarks" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="备注"></Input>
					</FormItem>
					</Col>
				</Row>
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
				modal14loading: true,
				title:'添加订单',
				vehicleType:"",
				vehicleInfo:"",
				ddbhs:false,
				lxhms:false,
				url: "http://localhost:8080",
				count: 10,
				shipperInfo:"",
				columns7: [{
						title: '订单编号',
						key: 'oId',
						align: 'center',
						width: 100
					},
					{
						title: '联系号码',
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
						title: '货主编号',
						key: 'sId',
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
								}, '编辑'),
								h('Button', {
									props: {
										type: 'error',
										size: 'small'
									},
									on: {
										click: () => {
										this.remove(params.row.oId)
										}
									}
								}, '移除')
							]);
						}
					}
				],
				data6: [],
				orderInfo:{
					oId:0,
					oType:"",
					oContacts:"",
					oRemarks:"",
					oStartDate:"",
					oEndDate:"",
					oPrice:"",
					oShippingAddress:"",
					oReceivingAddress:"",
					sId:0,
					dId:0,
					oState:"待运输",
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
			//单击添加
			add() {
				this.title = "添加订单";
				this.modal14 = true;
			},
			//弹出添加保存
			addok(){
				const th = this;
				var urls = "updateByPrimaryKey";
				axios.post(th.url + '/orderInfo/' + urls, th.orderInfo, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success(res.data.message);
						th.modal14 = false;
						th.changePage(1);
					} else {
						th.modal14show();
						th.$Message.error(res.data.message);
					}
				})
				
			},
			//单击编辑
			show(data){
				this.title = "编辑订单";
				this.orderInfo.oId=data.oId;
				this.orderInfo.oType=data.oType;
				this.orderInfo.oContacts=data.oContacts;
				this.orderInfo.oRemarks=data.oRemarks;
				this.orderInfo.oStartDate=data.oStartDate;
				this.orderInfo.oEndDate=data.oEndDate;
				this.orderInfo.oPrice=data.oPrice;
				this.orderInfo.oShippingAddress=data.oShippingAddress;
				this.orderInfo.oReceivingAddress=data.oReceivingAddress;
				this.orderInfo.sId=data.sId;
				this.orderInfo.dId=data.dId;
				this.orderInfo.oState=data.oState;
				this.modal14 = true;
			},
			modal14show() {
				this.modal14 = false;
				setTimeout(() => {
					this.modal14 = true;
				}, 0);
			},
			//删除操作
			remove(id){
				this.$Modal.confirm({
					title: '删除提示',
					content: '<p>移除后不可恢复，确定继续？</p>',
					onOk: () => {
						const th = this;
						axios.get(th.url + '/orderInfo/deleteByPrimaryKey', {
							params: {
								id: id
							}
						}).then(function(res) {
							if (res.data.code === 200) {
								th.$Message.success(res.data.message);
								th.changePage(1);
							} else {
								th.$Message.error(res.data.message);
							}
						})
					}
				});
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
				if(!th.ddbhs){
					th.orderInfo.oId = '';
				}
				if(!th.lxhms){
					th.orderInfo.oContacts = '';
				}
				axios.get(th.url + '/orderInfo/selectStart', {
					params: {
						page: page,
						oId:th.orderInfo.oId,
						oStart:'已完成',
						oContacts:th.orderInfo.oContacts
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
			axios.get(th.url + '/shipperInfo/selectAll').then(function(res) {
				th.shipperInfo = res.data.data;
			})
			axios.get(th.url + '/vehicleType/selectGroup').then(function(res) {
					console.log(res.data.data)
				th.vehicleType = res.data.data;
			})
			axios.get(th.url + '/vehicleInfo/selectAll').then(function(res) {
				th.vehicleInfo = res.data.data;
			})
			this.changePage(1);
		}
	}
</script>
