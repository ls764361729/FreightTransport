<template>
	<div class="amap-page-container">
		<Form ref="formValidate" :model="orderInfo" :label-width="80" style="margin-top:10px">
			<Row>
				<Col span="8">
				<FormItem label="车辆类型" prop="olType">
					<Select v-model="orderInfo.olType" filterable>
						<Option v-for="item in vehicleType" :value="item.tId" :key="item.vName">{{ item.vName }}</Option>
					</Select>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="联系电话" prop="oContacts">
					<Input v-model="orderInfo.oContacts" :maxlength=11 placeholder="请输入联系人电话"></Input>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="预约时间" prop="oStartDate">
					<DatePicker lType="datetime" format="yyyy-MM-dd HH:mm:ss" @on-change="datesa()" placeholder="请选择预约时间" v-model="orderInfo.oStartDate"
					 style="width: 200px"></DatePicker>
				</FormItem>
				</Col>
			</Row>
			<Row>
				<FormItem label="发货地址" prop="oShippingAddress">
					<Col span="3">
					<Input v-model="fhcs" :maxlength=5 placeholder="请输入发货城市"></Input>
					</Col>
					<Col span="6">
					<Select v-model="fh" filterable remote :remote-method="remoteMethod1" :loading="loading1">
						<Option v-for="(option, index) in options1" :value="option.name" :key="option.index">{{option.name}}</Option>
					</Select>
					</Col>
					<Col span="2">
					<span>高德发货地址</span>
					</Col>
					<Col span="6">
					<Input v-model="orderInfo.oShippingAddress" :maxlength=30 placeholder="发货地址"></Input>
					</Col>
				</FormItem>
			</Row>
			<FormItem label="收货地址" prop="oReceivingAddress">
				<Col span="3">
				<Input v-model="shcs" :maxlength=5 placeholder="请输入收货城市"></Input>
				</Col>
				<Col span="6">
				<Select v-model="sh" filterable remote :remote-method="remoteMethod2" :loading="loading1">
					<Option v-for="(option, index) in options2" :value="option.name" :key="option.index">{{option.name}}</Option>
				</Select>
				</Col>
				<Col span="2">
				<span>高德收货地址</span>
				</Col>
				<Col span="6">
				<Input v-model="orderInfo.oReceivingAddress" :maxlength=30 placeholder="收货地址"></Input>
				</Col>
			</FormItem>
			<Row>
				<Col span="8">
				<FormItem label="路程/公里" prop="olType">
					<Input v-model="lc" disabled placeholder="自动计算"></Input>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="时间/分钟" prop="oContacts">
					<Input v-model="sj" disabled placeholder="自动计算"></Input>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="订单价格" prop="oPrice">
					<Input v-model="orderInfo.oPrice" :maxlength=18 disabled placeholder="自动计算"></Input>
				</FormItem>
				</Col>
			</Row>

			<Row>
				<FormItem label="订单备注" prop="sId">
					<Input v-model="orderInfo.oRemarks" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="备注"></Input>
				</FormItem>
			</Row>
			<Button type="success" style="width:100%" onclick="return false" @click="ljyy()">立即预约</Button>
		</Form>
	</div>
</template>

<script>
	import $ from 'jquery'
	export default {
		data: function() {
			return {
				lc: '',
				sj: '',
				url: "http://localhost:8080",
				vehicleType: "",
				model13: '',
				fhcs: '',
				collectionFees: {
					cId: 0,
					cDate: '',
					mileage: '',
					cStarting: 12,
					remarks: '',
					clType: ''
				},
				shcs: '',
				sh: '',
				fh: '',
				fhlocation: '',
				shlocation: '',
				loading1: false,
				options1: [],
				options2: [],
				locateInfo: {
					lId: 0,
					lAddName: "",
					lAddIp: "",
					lEndIp: "",
					lEndName: "",
					lPrice: 12,
					lType: 5,
					lPeiYong: "",
					lPeiYongs: ""
				},
				orderInfo: {
					oId: 0,
					olType: "",
					oContacts: "",
					oRemarks: "",
					oStartDate: new Date(),
					oPrice: "",
					oShippingAddress: "",
					oReceivingAddress: "",
					sId: 1,
					oState: "待运输"
				}
			};
		},

		methods: {
			remoteMethod1(query) {
				var th = this;
				if (th.fhcs.length == 0) {
					return;
				}
				if (query.length > 0) {
					$.get('https://restapi.amap.com/v3/assistant/inputtips?key=894fb9d68503edc13aabaf040605f538&keywords=' + query +
						'&lType=&location=&city=' + th.fhcs + '&datalType=all',
						function(res) {
							if (res.tips.length > 0) {
								th.loading1 = true;
								setTimeout(() => {
									th.loading1 = false;
									th.options1 = res.tips;
									th.orderInfo.oShippingAddress = th.options1[0].district + query;
									th.fhlocation = th.options1[0].location;
									console.log("发货："+th.options1[0].location);
									if (th.orderInfo.oReceivingAddress.length > 1 && th.orderInfo.oShippingAddress.length > 1) {
										th.datesa();
									}
								}, 50);
							}
						});
				}
			},
			remoteMethod2(query) {
				var th = this;
				if (th.shcs.length == 0) {
					return;
				}
				if (query.length > 0) {
					$.get('https://restapi.amap.com/v3/assistant/inputtips?key=894fb9d68503edc13aabaf040605f538&keywords=' + query +
						'&lType=&location=&city=' + th.fhcs + '&datalType=all',
						function(res) {
							if (res.tips.length > 0) {
								th.loading1 = true;
								setTimeout(() => {
									th.loading1 = false;
									th.options2 = res.tips;
									th.orderInfo.oReceivingAddress = th.options2[0].district + query;
									th.shlocation = th.options2[0].location;
									console.log("收货："+th.options2[0].location);
									th.datesa();
								}, 100);
							}
						})
				}
			},

			//除法函数，用来得到精确的除法结果
			//说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
			//调用：accDiv(arg1,arg2)
			//返回值：arg1除以arg2的精确结果
			accDiv(arg1, arg2) {
				var t1 = 0,
					t2 = 0,
					r1, r2;
				try {
					t1 = arg1.toString().split(".")[1].length
				} catch (e) {}
				try {
					t2 = arg2.toString().split(".")[1].length
				} catch (e) {}
					r1 = Number(arg1.toString().replace(".", ""));
					r2 = Number(arg2.toString().replace(".", ""));
				return (r1 / r2) * Math.pow(10, t2 - t1);
			},
			//乘法函数，用来得到精确的乘法结果
			//说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
			//调用：accMul(arg1,arg2)
			//返回值：arg1乘以arg2的精确结果
			accMul(arg1, arg2) {
				var m = 0,
					s1 = arg1.toString(),
					s2 = arg2.toString();
				try {
					m += s1.split(".")[1].length
				} catch (e) {}
				try {
					m += s2.split(".")[1].length
				} catch (e) {}
				return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
			},
			//加法函数，用来得到精确的加法结果
			//说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
			//调用：accAdd(arg1,arg2)
			//返回值：arg1加上arg2的精确结果
			accAdd(arg1, arg2) {
				var r1, r2, m;
				try {
					r1 = arg1.toString().split(".")[1].length;
				} catch (e) {
					r1 = 0;
				}
				try {
					r2 = arg2.toString().split(".")[1].length;
				} catch (e) {
					r2 = 0;
				}
				m = Math.pow(10, Math.max(r1, r2));
				return (arg1 * m + arg2 * m) / m;
			},
			//减法函数
			accSub(arg1, arg2) {
				var r1, r2, m, n;
				try {
					r1 = arg1.toString().split(".")[1].length;
				} catch (e) {
					r1 = 0;
				}
				try {
					r2 = arg2.toString().split(".")[1].length;
				} catch (e) {
					r2 = 0;
				}
				m = Math.pow(10, Math.max(r1, r2));
				//last modify by deeka
				//动态控制精度长度
				n = (r1 >= r2) ? r1 : r2;
				return ((arg2 * m - arg1 * m) / m).toFixed(n);
			},
			datesa() {
				if (this.orderInfo.oReceivingAddress.length > 1 && this.orderInfo.oShippingAddress.length > 1) {
					this.locateInfo.lEndName = this.orderInfo.oReceivingAddress;
					this.locateInfo.lAddName = this.orderInfo.oShippingAddress;
					this.locateInfo.lEndIp = this.shlocation;
					this.locateInfo.lAddIp = this.fhlocation;
					this.addss();
				}
			},
			addss() {
				var th = this;
				$.get(
					'//restapi.amap.com/v3/distance?key=894fb9d68503edc13aabaf040605f538&origins=' + th.fhlocation + '&destination=' +
					th.shlocation + '&type=1',
					function(res) {
						//路径距离，单位：公里 
						th.lc = th.accDiv(res.results[0].distance,1000);
						//预计行驶时间，单位：分钟 
						th.sj = th.accDiv(res.results[0].duration,60);
						th.setdates();
					})
			},
			ljyy() {
				var th = this;
				th.orderInfo.sId = localStorage.getItem("mUser");
				axios.post(th.url + '/orderInfo/insert', th.orderInfo, {
					headers: {
						"Content-type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("预约成功");
						th.locateInfo.lPeiYong = res.data.message;
						axios.post(th.url + '/image/locateInfo/insert', th.locateInfo, {
							headers: {
								"Content-type": "application/json;charset=utf-8"
							}
						}).then(function(res) {
							if (res.data.code === 200) {
								th.$Message.success("导入地图成功！");
							} else {
								th.$Message.error("导入地图失败");
							}
						})
						window.location.href = "#/shipper";
					} else {
						th.$Message.error(res.data.message);
					}
				})
			},
			setdates() {
				var th = this;
				var now = this.orderInfo.oStartDate,
					hour = now.getHours();
				if (hour > 6 && hour < 22) {
					th.cDate = 1.2;
					th.mileage = 1.0;

				} else {
					th.cDate = 1.5;
					th.mileage = 1.2;
				}
				th.orderInfo.oPrice = th.accAdd(th.accMul(th.lc,th.mileage),th.accMul(th.cDate,th.sj));
				if (th.orderInfo.oPrice < 12) {
					th.orderInfo.oPrice = 12;
				}
				th.locateInfo.lPrice = th.orderInfo.oPrice;
			},
		},
		created() {
			var th = this;
			axios.get(th.url + '/vehicleType/selectGroup').then(function(res) {
				th.vehicleType = res.data.data;
			})
		}
	};
</script>
