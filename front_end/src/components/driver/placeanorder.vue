<style>
	.ivu-table td, .ivu-table-border td{
		height: 41px;
	}
</style>
<template>
	<div>
		<div id="container"></div>
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
				vehicleType: "",
				vehicleInfo: "",
				ddbhs: false,
				lxhms: false,
				url: "http://localhost:8080",
				count: 10,
				shipperInfo: "",
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
						title: '货主编号',
						key: 'sId',
						tooltip: true,
						align: 'center'
					}, {
						title: '订单状态',
						key: 'oState',
						tooltip: true,
						align: 'center'
					}, {
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
											this.add(params.row.oId,params.row.oShippingAddress, params.row.oReceivingAddress);
										}
									}
								}, '接单导航')
							]);
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
					eId: 0,
				}
			}
		},
		methods: {
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
						oStart: '待运输',
						oContacts: th.orderInfo.oContacts
					}
				}).then(function(res) {
					th.data6 = res.data.data;
					th.count = res.data.count;
				})
				th.loading = false;
			},
			add(oId,start, end) {
				var th = this;
				this.loading = true;
				axios.get(th.url + '/orderInfo/updateSet', {
					params: {
						oId: oId,
						dId: localStorage.getItem("mUser"),
						oState: "运输中"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("接单成功，正在调转导航！");
						th.changePage(1);
						var map = new AMap.Map("container", {
							resizeEnable: true,
							zoom: 20 //这里设置没有用，create()函数里面new maker时会把zoom改成默认值
						})
						AMap.plugin(["AMap.Driving"], function() {
							var drivingOption = {
								policy: AMap.DrivingPolicy.LEAST_TIME,
								map: map
							};
							var driving = new AMap.Driving(drivingOption); //构造驾车导航类
							//根据起终点坐标规划驾车路线
							driving.search([{
								keyword: start
							}, {
								keyword: end
							}], function(status, result) {
								th.loading = false;
								driving.searchOnAMAP({
									origin: result.origin,
									destination: result.destination
								});
							});
						
						});
						map.addControl(new AMap.ToolBar());
						}else{
							th.loading = false;
							th.changePage(1);
							th.$Message.error("接单失败！");
						}
				})
			}
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
