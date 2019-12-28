<template>
	<div class="amap-page-container">
		<Form ref="formValidate" :model="orderInformation" :label-width="80" style="margin-top:10px">
			<Row>
				<Col span="8">
				<FormItem label="车辆类型" prop="oType">
					<Select v-model="orderInformation.oType" filterable>
						<Option v-for="item in vehicleType" :value="item.tId" :key="item.vName">{{ item.vName }}</Option>
					</Select>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="联系人电话" prop="contacts">
					<Input v-model="orderInformation.contacts" :maxlength=11 placeholder="请输入联系人电话"></Input>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="预约时间" prop="startDate">
					<DatePicker type="datetime" format="yyyy-MM-dd HH:mm:ss" @on-change="datesa()" placeholder="请选择预约时间" v-model="orderInformation.startDate"
					 style="width: 200px"></DatePicker>
				</FormItem>
				</Col>
			</Row>
			<Row>
				<FormItem label="发货地址" prop="shippingAddress">
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
					<Input v-model="orderInformation.shippingAddress" :maxlength=30 placeholder="发货地址"></Input>
					</Col>
				</FormItem>
			</Row>
			<FormItem label="收货地址" prop="receivingAddress">
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
				<Input v-model="orderInformation.receivingAddress" :maxlength=30 placeholder="收货地址"></Input>
				</Col>
			</FormItem>
			<Row>
				<Col span="8">
				<FormItem label="路程/公里" prop="oType">
					<Input v-model="lc" disabled placeholder="自动计算"></Input>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="时间/分钟" prop="contacts">
					<Input v-model="sj" disabled placeholder="自动计算"></Input>
				</FormItem>
				</Col>
				<Col span="8">
				<FormItem label="订单价格" prop="price">
					<Input v-model="orderInformation.price" :maxlength=18 disabled placeholder="自动计算"></Input>
				</FormItem>
				</Col>
			</Row>

			<Row>
				<FormItem label="订单备注" prop="sId">
					<Input v-model="orderInformation.oRemarks" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="备注"></Input>
				</FormItem>
			</Row>
			<Button type="success" style="width:100%" onclick="return false" @click="ljyy()">立即预约</Button>
		</Form>
	</div>
</template>

<script>
	
	export default {
		data: function() {
			return {
				lc: '',
				sj: '',
				url: "http://localhost:8080",
				vehicleType: "",
				collectionFee: '',
				model13: '',
				fhcs: '',
				collectionFees: {
					cId: 0,
					cDate: '',
					mileage: '',
					cStarting: 12,
					remarks: '',
					cType: ''
				},
				shcs: '',
				sh: '',
				fh: '',
				fhlocation: '',
				shlocation: '',
				loading1: false,
				options1: [],
				options2: [],
				locations: {
					id: 0,
					addName: "",
					addIp: "",
					endIp: "",
					endName: "",
					price: 12,
					type: 5,
					peiYong: "",
					peiYongs: ""
				},
				orderInformation: {
					oId: 0,
					oType: "",
					contacts: "",
					oRemarks: "",
					startDate: new Date(),
					price: "",
					shippingAddress: "",
					receivingAddress: "",
					sId: 1,
					oState: "待运输",
					eId: 0
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
					axios.get('https://restapi.amap.com/v3/assistant/inputtips?key=894fb9d68503edc13aabaf040605f538&keywords=' + query +
						'&type=&location=&city=' + th.fhcs + '&datatype=all',
						function(res) {
							if (res.tips.length > 0) {
								th.loading1 = true;
								setTimeout(() => {
									th.loading1 = false;
									th.options1 = res.tips;
									th.orderInformation.shippingAddress = th.options1[0].district + query;
									th.fhlocation = th.options1[0].location;
									console.log("发货："+th.options1[0].location);
									if (th.orderInformation.receivingAddress.length > 1 && th.orderInformation.shippingAddress.length > 1) {
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
					axios.get('https://restapi.amap.com/v3/assistant/inputtips?key=894fb9d68503edc13aabaf040605f538&keywords=' + query +
						'&type=&location=&city=' + th.fhcs + '&datatype=all',
						function(res) {
							if (res.tips.length > 0) {
								th.loading1 = true;
								setTimeout(() => {
									th.loading1 = false;
									th.options2 = res.tips;
									th.orderInformation.receivingAddress = th.options2[0].district + query;
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
				if (this.orderInformation.receivingAddress.length > 1 && this.orderInformation.shippingAddress.length > 1) {
					this.locations.endName = this.orderInformation.receivingAddress;
					this.locations.addName = this.orderInformation.shippingAddress;
					this.locations.endIp = this.shlocation;
					this.locations.addIp = this.fhlocation;
					this.addss();
				}
			},
			addss() {
				var th = this;
				axios.get(
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
				th.orderInformation.sId = localStorage.getItem("mUser");
				axios.post(th.url + '/orderInformation/insert', th.orderInformation, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("预约成功");
						th.locations.peiYong = res.data.message;
						axios.post(th.url + '/image/locations/insert', th.locations, {
							headers: {
								"Content-Type": "application/json;charset=utf-8"
							}
						}).then(function(res) {
							if (res.data.code === 200) {
								th.$Message.success("导入地图成功！");
							} else {
								th.$Message.error("导入地图失败");
							}
						})
						window.location.href = "#/khindex";
					} else {
						th.$Message.error(res.data.message);
					}
				})
			},
			setdates() {
				var th = this;
				var now = this.orderInformation.startDate,
					hour = now.getHours();
				if (hour > 6 && hour < 22) {
					th.cDate = 1.2;
					th.mileage = 1.0;

				} else {
					th.cDate = 1.5;
					th.mileage = 1.2;
				}
				th.orderInformation.price = th.accAdd(th.accMul(th.lc,th.mileage),th.accMul(th.cDate,th.sj));
				if (th.orderInformation.price < 12) {
					th.orderInformation.price = 12;
				}
				th.locations.price = th.orderInformation.price;
			},
		},
		created() {
			var th = this;
			axios.get(th.url + '/vehicleType/selectGroup').then(function(res) {
				th.vehicleType = res.data.data;
			})
			axios.get(th.url + '/collectionFee/selectAll').then(function(res) {
				th.collectionFee = res.data.data;
			})
		}
	};
</script>
