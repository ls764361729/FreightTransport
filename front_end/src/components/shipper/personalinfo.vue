
<template>
	<div class="amap-page-container" >
		<div class="rigtop" style="text-align: center;font-size: 18px;border: 0px;">
			<marquee style="width: 100%;">
				如信息有问题请拨打400-1000-0001电话联系客服进行修改信息，感谢您对我们工作的支持，谢谢！
			</marquee>
			</MenuItem>
		</div>
			<Form ref="formValidate" :model="shipperInfo" :label-width="80" style="position:relative;left: 110px;">
				<Row>
					<Col span="8">
					<FormItem label="编号" prop="contacts">
						<Input v-model="shipperInfo.sId" disabled  ></Input>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="姓名" prop="contacts">
						<Input v-model="shipperInfo.sName" disabled   ></Input>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="8">
					<FormItem label="手机号码" prop="startDate">
						<Input v-model="shipperInfo.sPhone" disabled   ></Input>
					</FormItem>
					</Col>
			
					<Col span="8">
					<FormItem label="身份证" prop="contacts">
						<Input v-model="shipperInfo.sUuid" disabled   ></Input>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="8">
					<FormItem label="余额" prop="contacts">
						<Input v-model="shipperInfo.sBalance" disabled   ></Input>
					</FormItem>
					</Col>
					<Col span="8">
					<FormItem label="注册时间" prop="startDate">
						<Input v-model="shipperInfo.sRegisterDate" disabled   ></Input>
					</FormItem>
					</Col>
				</Row>
			</Form>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				url: "http://localhost:8080",
				shipperInfo: {
					sId: 0,
					sName: '',
					sSex: '',
					sUuid: '',
					sPhone: '',
					sPassword: '',
					sBalance: 0,
					sRegisterDate: ''
				},
			}
		},
		methods: {
			
		},
		created() {
			var th = this;
			axios.get(th.url + '/shipperInfo/selectByPrimaryKey', {
				params: {
					id:localStorage.getItem("mUser")
				}
			}).then(function(res) {
				th.shipperInfo = res.data.data;
				
			})
		}
	}
</script>
