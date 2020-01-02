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
						title: '货主编号',
						key: 'sId',
						tooltip: true,
						align: 'center'
					}, {
						title: '订单状态',
						key: 'oState',
						tooltip: true,
						align: 'center'
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
					oState:"待运输"
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
			//导出数据
			exportData() {
				this.$refs.table.exportCsv({
					filename: '订单信息表'
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
						oContacts:th.orderInfo.oContacts,
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
